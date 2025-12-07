package pl.gatomek.rabbitmq.demo.producer.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfig {
    public static final String LOG_SAVING_DIAGN_FANOUT_EXCHANGE_NAME = "log-saving-diagn-fanout-exchange";

    @Bean
    FanoutExchange exchange() {
        return new FanoutExchange(LOG_SAVING_DIAGN_FANOUT_EXCHANGE_NAME);
    }
}
