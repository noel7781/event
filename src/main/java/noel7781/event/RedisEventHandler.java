package noel7781.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.RedisKeyExpiredEvent;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RedisEventHandler {

    private final RedisTemplate redisTemplate;

    @EventListener
    public void redisExpiredEventHandler(RedisKeyExpiredEvent event) {
        log.info("redis key expired, {}", event);
        log.info("keySpace = {}, ID = {}, value = {}, channel = {}, source = {}", event.getKeyspace(), event.getId(), event.getValue(), event.getChannel(), event.getSource());
        redisTemplate.opsForSet().pop(event.getSource());
    }
}
