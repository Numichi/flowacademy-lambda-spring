package hu.flowacademy.lambda.gyakorlati.ea1.controllers;

import hu.flowacademy.lambda.gyakorlati.ea1.model.DataStoreRepository;
import hu.flowacademy.lambda.gyakorlati.ea1.model.Model;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("ea1/api/web")
public class WebTopicController {

    private final DataStoreRepository dataStoreRepository;

    WebTopicController(DataStoreRepository dataStoreRepository) {
        this.dataStoreRepository = dataStoreRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Map<Integer, String> getAll() {
        return dataStoreRepository.getDb();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String getById(@PathVariable int id) {
        return dataStoreRepository.getDb().get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Model model) {
        dataStoreRepository.indexIncrement();
        dataStoreRepository.addNewElement(model);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody Model model, @PathVariable int id) {
        if (dataStoreRepository.getDb().containsKey(id)) {
            dataStoreRepository.getDb().put(id, model.getStr());

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        dataStoreRepository.getDb().remove(id);
    }
}
