package vn.edu.uit.group5redis.exception;

public class BaseException extends RuntimeException {
    private static final long serialVersionUID = -128216908108589678L;

    public BaseException(String msg) {
        super(msg);
    }

    public BaseException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
