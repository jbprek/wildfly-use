package org.bagab.rs.ex.model;

/**
 * @author prekezes.
 */
@javax.ejb.ApplicationException
public class MyApplicationException extends RuntimeException {

    public MyApplicationException(String message) {
        super(message);
    }

    public MyApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
