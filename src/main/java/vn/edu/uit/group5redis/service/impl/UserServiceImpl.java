package vn.edu.uit.group5redis.service.impl;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import vn.edu.uit.group5redis.constants.CommonConstants;
import vn.edu.uit.group5redis.dto.UserCacheInfo;
import vn.edu.uit.group5redis.dto.UserDto;
import vn.edu.uit.group5redis.dto.UserRequest;
import vn.edu.uit.group5redis.entity.User;
import vn.edu.uit.group5redis.exception.BaseException;
import vn.edu.uit.group5redis.repository.UserRepository;
import vn.edu.uit.group5redis.service.UserService;
import vn.edu.uit.group5redis.util.RedisClientUtils;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisClientUtils redisClientUtils;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto getUserById (UUID userId) {
        if ( userId == null ) {
            throw new BaseException("Missing userId");
        }
        UserCacheInfo userCacheInfo = getUserCacheInfo(userId);
        if ( userCacheInfo != null ) {
            log.info("User has been got from cache with userId: " + userId);
            return UserDto.builder()
                          .userId(userCacheInfo.getUserId())
                          .userName(userCacheInfo.getUserName())
                          .phoneNumber(userCacheInfo.getPhoneNumber())
                          .status("SUCCESS")
                          .message("Got user from Redis Cache")
                          .build();
        }

        Optional<User> userOptional = userRepository.findById(userId);
        if ( userOptional.isEmpty() ) {
            throw new BaseException("The User does not exist!");
        }
        User user = userOptional.get();
        return UserDto.builder()
                      .userId(user.getId())
                      .userName(user.getUserName())
                      .phoneNumber(user.getPhoneNumber())
                      .status("SUCCESS")
                      .message("Got user from Database")
                      .build();
    }

    @Override
    public UserDto createUser (UserRequest request) {
        User   user   = userRepository.save(new User(request));
        String userId = user.getId().toString();
        log.info(
            "[USER_CREATED] Created user in database successfully id={}",
            userId
        );
        // Set user to redis cache and set expire time to 7 days
        UserCacheInfo userCacheInfo = UserCacheInfo.builder()
                                                   .userId(user.getId())
                                                   .userName(user.getUserName())
                                                   .fullName(user.getFullName())
                                                   .phoneNumber(user.getPhoneNumber())
                                                   .address(user.getAddress())
                                                   .build();
        redisClientUtils.setCache(
            String.format(CommonConstants.USER_CACHE_KEY, userId),
            userCacheInfo,
            7,
            TimeUnit.DAYS
        );
        log.info(
            "[USER_CACHE] Set User to redis cache successfully for userId={}," +
            " userName={}, phoneNumber={}",
            user.getId(),
            user.getUserName(),
            user.getPhoneNumber()
        );
        return UserDto.builder()
                      .userId(user.getId())
                      .userName(user.getUserName())
                      .phoneNumber(user.getPhoneNumber())
                      .status("CREATED")
                      .message("Created User and stored to Redis Cache")
                      .build();
    }

    private UserCacheInfo getUserCacheInfo (UUID userId) {
        UserCacheInfo cacheInfo = redisClientUtils.get(
            String.format(CommonConstants.USER_CACHE_KEY, userId));
        if ( cacheInfo == null ) {
            log.info("Cache not found for userId: " + userId);
            return null;
        }
        return cacheInfo;
    }
}
