package noel7781.event;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/redis")
@RequiredArgsConstructor
public class RedisController {

    private final PersonRepository personRepository;

    private Random random = new Random();

    @PostMapping("/save-random")
    public void saveRandom() {
        final double lat = random.nextDouble() * 180;
        final double lng = random.nextDouble() * 180;
        personRepository.save(new Person(generateRandomString(), new Address(new Point(lat, lng))));
    }

    private String generateRandomString() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
