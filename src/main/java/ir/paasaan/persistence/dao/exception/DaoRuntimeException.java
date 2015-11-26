package ir.paasaan.persistence.dao.exception;

/**
 * @author Boshra Taheri
 * @since 11/26/2015
 */
public class DaoRuntimeException extends RuntimeException {
    public DaoRuntimeException(String message) {
        super(message);
    }
}
