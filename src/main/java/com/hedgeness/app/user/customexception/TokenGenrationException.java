package com.hedgeness.app.user.customexception;

public class TokenGenrationException extends Exception {
    /**
     * serial version id for serialization and de serialization
     */
    private static final long serialVersionUID = 9101685649295364828L;

    /**
     * Constructor for TokenGenrationException.
     */
    public TokenGenrationException() {
        //  no code to be added
    }

    /**
     * Constructor for TokenGenrationException.
     *
     * @param message the detail message
     */
    public TokenGenrationException(String message) {
        super(message);
    }
}
