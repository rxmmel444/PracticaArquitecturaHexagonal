package mx.com.tiendaonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * Hello world!
 *
 */
@SpringBootApplication

@EnableFeignClients
@EnableKafka
public class TiendaOnlineApplication
{

        public static void main(String[] args) {
        SpringApplication.run(TiendaOnlineApplication.class, args);
    }

}
