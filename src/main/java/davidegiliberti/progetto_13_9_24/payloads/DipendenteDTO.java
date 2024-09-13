package davidegiliberti.progetto_13_9_24.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record DipendenteDTO(
        @NotEmpty(message = "username obbligatorio")
        @Size(min = 2, max = 15, message = "inserire da 2 a massimo 15 caratteri")
        String username,
        @NotEmpty(message = "nome obbligatorio")
        @Size(min = 3, max = 20, message = "inserire da 3 a massimo 20 caratteri")
        String nome,
        @NotEmpty(message = "cognome obbligatorio")
        @Size(min = 3, max = 20, message = "inserire da 5 a massimo 15 caratteri")
        String cognome,
        @NotEmpty(message = "e-mail obbligatoria")
        @Email(message = "e-mail non valida")
        String email,
        String avatar
) {
}
