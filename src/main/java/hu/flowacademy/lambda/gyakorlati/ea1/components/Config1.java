package hu.flowacademy.lambda.gyakorlati.ea1.components;

import hu.flowacademy.lambda.gyakorlati.ea1.models.KonyvModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config1 {

    @Bean("customBeanName")
    public KonyvModel peldaBean() {
        var konyv = new KonyvModel();
        konyv.setNeve("customBeanName");
        return konyv;
    }
}
