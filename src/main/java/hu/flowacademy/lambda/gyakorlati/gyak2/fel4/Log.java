package hu.flowacademy.lambda.gyakorlati.gyak2.fel4;

import hu.flowacademy.lambda.gyakorlati.gyak2.fel2.model.HullData;
import hu.flowacademy.lambda.gyakorlati.gyak2.fel3.GenomRequest;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@AllArgsConstructor
@Data
public class Log {
    private HullData hullData;
    private GenomRequest genomRequest;
    private Instant instant;
    private long timestamp;
}
