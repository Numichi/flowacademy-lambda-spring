package hu.flowacademy.lambda.gyakorlati.ea1.models;

import lombok.Data;

import java.util.List;

@Data
public class KonyvModel {
    private String neve;
    private String isbn;
    private List<Integer> sor;
}
