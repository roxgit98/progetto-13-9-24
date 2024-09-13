package davidegiliberti.progetto_13_9_24.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ViaggioDTO(
        @NotEmpty(message = "destinazione obbligatoria")
        @Size(min = 10, max = 20, message = "inserire da 10 a massimo 20 caratteri")
        String destinazione,
        @NotEmpty(message = "data obbligatoria")
        @Size(min = 10, max = 10, message = "inserire massimo 10 caratteri")
        LocalDate data,
        @NotEmpty(message = "stato del viaggio obbligatorio")
        String statoViaggio
) {
}
