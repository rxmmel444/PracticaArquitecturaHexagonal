package mx.com.tiendaonline.beanconfiguration;

import org.springframework.kafka.support.serializer.JsonSerializer;

import mx.com.tiendaonline.cliente.model.dto.ClienteDTO;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

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
        return new DefaultKafkaProducerFactory<>(serializacion);
    }
}
