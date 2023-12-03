package noel7781.event;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Point {

    private double lat;
    private double lng;

    public Point(final double lat, final double lng) {
        this.lat = lat;
        this.lng = lng;
    }
}
