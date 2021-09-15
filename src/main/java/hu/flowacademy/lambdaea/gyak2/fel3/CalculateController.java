package hu.flowacademy.lambdaea.gyak2.fel3;

import hu.flowacademy.lambdaea.gyak2.fel2.model.HullData;
import hu.flowacademy.lambdaea.gyak2.fel3.services.NegyzetService;
import hu.flowacademy.lambdaea.gyak2.fel3.services.TeglalapService;
import hu.flowacademy.lambdaea.gyak2.fel3.services.Test;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@RestController
public class CalculateController {

    private final NegyzetService negyzetService;
    private final TeglalapService teglalapService;

    public CalculateController(NegyzetService negyzetService, TeglalapService teglalapService) {
        this.negyzetService = negyzetService;
        this.teglalapService = teglalapService;
    }

    @PostMapping("hull")
    public HullData process(@Valid @RequestBody GenomRequest model) {
        Test logic = logic(GenomEnum.valueOf(model.getType()));
        var hull = new HullData();

        hull.setFelszin(logic.felszin(model.getA(), model.getB()));
        hull.setTerfogat(logic.terfogat(model.getA(), model.getB()));

        return hull;
    }

    private Test logic(GenomEnum e) {
        System.out.println(e.name());

        switch (e) {
            case NEGYZET: return negyzetService;
            case TEGLALAP: return teglalapService;
        }

        throw new NoSuchElementException();
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public String httpMessageNotReadableException(HttpMessageNotReadableException exception) {
        return "almafa";
    }
}
