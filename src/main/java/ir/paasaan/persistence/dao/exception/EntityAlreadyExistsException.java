package ir.paasaan.persistence.dao.exception;

/**
 * @author Boshra Taheri
 * @since 11/26/2015
 */
public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
