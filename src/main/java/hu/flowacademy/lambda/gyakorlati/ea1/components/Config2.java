package hu.flowacademy.lambda.gyakorlati.ea1.components;

import hu.flowacademy.lambda.gyakorlati.ea1.models.KonyvModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config2 {

    @Bean
    public KonyvModel peldaBean() {
        return new KonyvModel();
    }
}
