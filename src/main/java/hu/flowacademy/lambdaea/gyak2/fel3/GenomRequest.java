package hu.flowacademy.lambdaea.gyak2.fel3;

import hu.flowacademy.lambdaea.gyak2.fel3.validation.Almafa;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class GenomRequest {

    @NotNull
    @Min(0)
    private Integer a;
    private int b;

    @Almafa(nullable = true)
    private String type;
}
