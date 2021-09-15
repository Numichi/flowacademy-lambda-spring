package hu.flowacademy.lambdaea.gyak2.fel2;

import hu.flowacademy.lambdaea.gyak2.fel2.model.HullData;
import hu.flowacademy.lambdaea.gyak2.fel2.model.Kocka;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gyak2")
public class FeladatController {

    @PostMapping("cube")
    public HullData kocka(@RequestBody Kocka kocka) {
        var result = new HullData();
        result.setTerfogat(kocka.getA() * kocka.getA() * kocka.getA());
        result.setFelszin(6 * (kocka.getA() * kocka.getA()));
        return result;
    }
}
