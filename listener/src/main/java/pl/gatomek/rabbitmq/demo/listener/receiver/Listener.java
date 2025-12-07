package pl.gatomek.rabbitmq.demo.listener.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Listener {
    @RabbitListener(queues = "#{autoDeleteQueue.name}")
    public void receiveMessage(String message) {
        log.info("Received <{}>", message);
    }
}
