package vn.edu.uit.group5redis.service;

import java.util.UUID;

import vn.edu.uit.group5redis.dto.UserDto;
import vn.edu.uit.group5redis.dto.UserRequest;

public interface UserService {
    UserDto getUserById (UUID userId);

    UserDto createUser (UserRequest request);

    UserDto updateUser (UUID uuid, UserRequest request);
}
