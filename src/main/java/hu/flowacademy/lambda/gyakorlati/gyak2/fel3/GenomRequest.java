package hu.flowacademy.lambda.gyakorlati.gyak2.fel3;

import hu.flowacademy.lambda.gyakorlati.gyak2.fel3.validation.Almafa;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class GenomRequest {

//    @NotNull
//    @Min(0)
    private int a;
    private int b;

    private GenomEnum type;
}
