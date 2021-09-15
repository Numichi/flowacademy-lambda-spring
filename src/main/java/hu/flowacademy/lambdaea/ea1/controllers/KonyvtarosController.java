package hu.flowacademy.lambdaea.ea1.controllers;

import hu.flowacademy.lambdaea.ea1.models.KonyvModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ea1/api/comp")
public class KonyvtarosController {

    private KonyvModel konyvtarComponent;
    private KonyvModel konyvtarComponentPeldaBean;

    KonyvtarosController(
        @Qualifier("customBeanName") KonyvModel konyvtarComponent,
        @Qualifier("peldaBean") KonyvModel konyvtarComponentPeldaBean
    ) {
        this.konyvtarComponent = konyvtarComponent;
        this.konyvtarComponentPeldaBean = konyvtarComponentPeldaBean;
    }

    @GetMapping("customBeanName")
    public KonyvModel valami() {
        return konyvtarComponent;
    }

    @GetMapping("peldaBean")
    public KonyvModel valami1() {
        return konyvtarComponentPeldaBean;
    }
}
