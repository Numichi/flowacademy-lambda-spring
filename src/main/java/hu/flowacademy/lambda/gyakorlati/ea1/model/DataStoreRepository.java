package hu.flowacademy.lambda.gyakorlati.ea1.model;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Data
public class DataStoreRepository {
    private final Map<Integer, String> db = new HashMap<>();
    private int index = 4;

    DataStoreRepository() {
        db.put(1, "1");
        db.put(2, "2");
        db.put(3, "3");
        db.put(4, "4");
    }

    public void indexIncrement() {
        index++;
    }

    public void addNewElement(Model str) {
        db.put(index, str.getStr());
    }
}
