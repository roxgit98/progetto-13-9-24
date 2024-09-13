package davidegiliberti.progetto_13_9_24.exceptions;

public class NotFoundEx extends RuntimeException {
    public NotFoundEx(long id) {
        super("L'ID " + id + " non è presente");
    }
}
