package noel7781.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventService {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void publishEvent() {
//        applicationEventPublisher.publishEvent();
    }
}
