package hu.flowacademy.lambda.gyakorlati.gyak2.fel4;

import hu.flowacademy.lambda.elmelet.ioc.ExampleDependencyInjection;
import hu.flowacademy.lambda.gyakorlati.gyak2.fel2.model.HullData;
import hu.flowacademy.lambda.gyakorlati.gyak2.fel3.GenomEnum;
import hu.flowacademy.lambda.gyakorlati.gyak2.fel3.GenomRequest;
import hu.flowacademy.lambda.gyakorlati.gyak2.fel3.services.NegyzetService;
import hu.flowacademy.lambda.gyakorlati.gyak2.fel3.services.TeglalapService;
import hu.flowacademy.lambda.gyakorlati.gyak2.fel3.services.Test;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("nap2/fel4")
public class PracticeController {

    private final List<Log> data = new ArrayList<>();
    private final NegyzetService negyzetService;
    private final TeglalapService teglalapService;
    private final ExampleDependencyInjection injection;

    public PracticeController(NegyzetService negyzetService, TeglalapService teglalapService, ExampleDependencyInjection injection) {
        this.negyzetService = negyzetService;
        this.teglalapService = teglalapService;
        this.injection = injection;
    }

    @PostMapping("hull")
    public HullData process(@RequestBody GenomRequest model) {
        var hull = new HullData();
        var logic = model.getType() == GenomEnum.NEGYZET ? negyzetService : teglalapService;
        hull.setFelszin(logic.felszin(model.getA(), model.getB()));
        hull.setTerfogat(logic.terfogat(model.getA(), model.getB()));

        data.add(new Log(hull, model, Instant.now(), Instant.now().getEpochSecond()));

        return hull;
    }

    @GetMapping("help")
    public List<Log> getAll() {
        return data;
    }

    @GetMapping("logs")
    public List<Log> getAll(@RequestHeader long start, @RequestHeader long end, @RequestParam(required = false) Integer limit) {
        return data.stream()
                .filter((var log) -> start <= log.getTimestamp() && log.getTimestamp() <= end)
                .limit(limit == null ? Integer.MAX_VALUE : limit)
                .collect(Collectors.toList());
    }

    @GetMapping("/log/{kind}")
    public List<Log> getAll(@PathVariable String kind) {
        return data.stream()
                .filter((var log) -> log.getGenomRequest().getType().name().equals(kind))
                .collect(Collectors.toList());
    }

    @GetMapping("test")
    public void test() {
        System.out.println(injection.exampe5.getClass().getCanonicalName());
    }
}
