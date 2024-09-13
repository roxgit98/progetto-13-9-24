package davidegiliberti.progetto_13_9_24.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PrenotazioneDTO(
        @NotEmpty(message = "data obbligatoria")
        @Size(min = 10, max = 10, message = "inserire massimo 10 caratteri")
        LocalDate date,
        @NotEmpty(message = "preferenza obbligatoria")
        @Size(min = 15, max = 100, message = "inserire da 15 a massimo 100 caratteri")
        String preferenze,
        @NotNull(message = "id viaggio obbligatorio")
        long viaggioId,
        @NotNull(message = "id dipendente obbligatorio")
        long dipendenteId
) {
}
