package mx.com.tiendaonline.beanconfiguration;

import mx.com.tiendaonline.cliente.adapter.kafka.KafkaConsumerAdapter;
import mx.com.tiendaonline.cliente.mapper.ClienteDtoMapper;
import mx.com.tiendaonline.cliente.port.event.ClienteCorreoBienvenida;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import mx.com.tiendaonline.cliente.model.dto.ClienteDTO;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
public class KafkaBean {



    @Bean
    public KafkaTemplate<String, ClienteDTO> kafkaTemplate(ProducerFactory<String,ClienteDTO>producerFactory){
        return new KafkaTemplate<>(producerFactory);
    }

    @Bean
    public ProducerFactory<String, ClienteDTO> producerFactory(){
        Map<String, Object> serializacion = new HashMap<>();
        serializacion.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        serializacion.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        serializacion.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        serializacion.put(JsonSerializer.ADD_TYPE_INFO_HEADERS,false);
        return new DefaultKafkaProducerFactory<>(serializacion);
    }



        @Bean
        public ConsumerFactory<String, ClienteDTO> clienteConsumerFactory() {
            Map<String, Object> props = new HashMap<>();
            props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
            props.put(ConsumerConfig.GROUP_ID_CONFIG, "my-consumer-group");
            props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
            props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

            props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
            props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, "mx.com.tiendaonline.cliente.model.dto.ClienteDTO");
            props.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false);

            return new DefaultKafkaConsumerFactory<>(
                    props, new StringDeserializer(), new JsonDeserializer<>(ClienteDTO.class, false)
            );
        }

        @Bean
        public ConcurrentKafkaListenerContainerFactory<String, ClienteDTO> clienteKafkaListenerContainerFactory() {
            ConcurrentKafkaListenerContainerFactory<String, ClienteDTO> factory =
                    new ConcurrentKafkaListenerContainerFactory<>();
            factory.setConsumerFactory(clienteConsumerFactory());
            return factory;
        }
}
