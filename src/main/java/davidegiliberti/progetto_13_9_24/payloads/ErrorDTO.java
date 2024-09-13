package davidegiliberti.progetto_13_9_24.payloads;

import java.time.LocalDateTime;

public record ErrorDTO(String message, LocalDateTime timestamp) {
}
