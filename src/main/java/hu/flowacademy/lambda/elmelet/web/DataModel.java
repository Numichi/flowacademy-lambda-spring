package hu.flowacademy.lambda.elmelet.web;

import hu.flowacademy.lambda.elmelet.web.validation.CustomString;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class DataModel {
    @NotNull
    @Email
    private String data1;

    @Min(0)
    @NotNull
    private Integer data2;

    /**
     * Ha megnézitek a @CustomString definíciót, egyértelmű lesz, hogy csak akkor valid, ha data3 "Alma" vagy "Korte".
     *
     * @see CustomString
     * @see hu.flowacademy.lambda.elmelet.web.validation.CustomValidator
     */
    @CustomString(nullable = false, acceptable = {"Alma", "Korte"})
    private String data3;

    /**
     * Alapértelmezetten az nested vagy inner class-t NEM fogja validálni. Tehát, ha itt nem szerepel a @Valid
     * akkor elfogadja az alábbi JSON-t is:
     * {
     *     "data1": "alma@korte.hu",
     *     "data2": 100,
     *     "model": {
     *         "data1": null, // ez ugye nem lehetne null
     *         "data2": null, // ahogy ez se
     *         "model": null
     *     }
     * }
     */
    @Valid
    private DataModel model;
}
