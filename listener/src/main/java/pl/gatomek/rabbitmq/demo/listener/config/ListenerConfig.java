package pl.gatomek.rabbitmq.demo.listener.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerConfig {
    public static final String LOG_SAVING_DIAGN_FANOUT_EXCHANGE_NAME = "log-saving-diagn-fanout-exchange";

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(LOG_SAVING_DIAGN_FANOUT_EXCHANGE_NAME);
    }

    @Bean
    public Queue autoDeleteQueue() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding binding(FanoutExchange fanoutExchange, Queue queue) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setPrefetchCount(1);
        return container;
    }
}
