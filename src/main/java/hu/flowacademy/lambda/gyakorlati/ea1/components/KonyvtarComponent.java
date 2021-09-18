package hu.flowacademy.lambda.gyakorlati.ea1.components;

import hu.flowacademy.lambda.gyakorlati.ea1.models.KonyvModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Scope(value = "prototype")
@Component
public class KonyvtarComponent {

    @Setter
    @Getter
    private List<KonyvModel> storage = new ArrayList<>();
}
