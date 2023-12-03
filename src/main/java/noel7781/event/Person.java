package noel7781.event;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@RedisHash(value = "people", timeToLive = 3L)
@NoArgsConstructor
public class Person {

    @Id
    private String name;
    private Address address;

    public Person(final String name, final Address address) {
        this.name = name;
        this.address = address;
    }
}
