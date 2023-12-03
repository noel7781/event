package noel7781.event;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.index.GeoIndexed;

@Getter
@NoArgsConstructor
public class Address {

    @GeoIndexed
    private Point point;

    public Address(final Point point) {
        this.point = point;
    }
}
