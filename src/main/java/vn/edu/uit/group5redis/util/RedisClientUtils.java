package vn.edu.uit.group5redis.util;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisClientUtils {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public <T> void setCache (String key, T value, long timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue()
                     .set(key, value, timeout, timeUnit);
    }

    public <T> T get (String key) {
        return (T) redisTemplate.opsForValue().get(key);
    }

    public void delete (String key) {
        redisTemplate.delete(key);
    }
}
