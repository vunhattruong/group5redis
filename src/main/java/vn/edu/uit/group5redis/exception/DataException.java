package vn.edu.uit.group5redis.exception;

public class DataException {

        public static class QueryException extends BaseException {
            public QueryException(String msg) {
                super(msg);
            }

            public QueryException(String msg, Throwable cause) {
                super(msg, cause);
            }
        }

        public static class ExecuteException extends BaseException {

            public ExecuteException(String msg) {
                super(msg);
            }

            public ExecuteException(String msg, Throwable cause) {
                super(msg, cause);
            }
        }

        public static class NotFoundException extends BaseException {

            public NotFoundException(String msg) {
                super(msg);
            }

            public NotFoundException(String msg, Throwable cause) {
                super(msg, cause);
            }
        }
}
