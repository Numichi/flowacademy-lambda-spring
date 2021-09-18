package hu.flowacademy.lambda.elmelet.ioc.source;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExampleBeans {

    /**
     * public class Bean1 implements BeanInterface {}
     * @see Bean1
     */
    @Bean
    public Bean1 almafa() {
        return new Bean1();
    }

    /**
     * public class Bean2 implements BeanInterface {}
     * @see Bean2
     */
    @Bean
    public Bean2 kortefa() {
        return new Bean2();
    }

    /**
     * public class Bean1 implements BeanInterface {}
     * @see Bean1
     */
    @Bean
    public BeanInterface beanInterface1() {
        return new Bean1();
    }

    /**
     * public class Bean2 implements BeanInterface {}
     * @see Bean2
     */
    @Bean
    public BeanInterface beanInterface2() {
        return new Bean2();
    }

    /**
     * public class Bean3 {}
     * @see Bean2
     */
    @Bean
    public Bean3 bean3() {
        return new Bean3();
    }
}
