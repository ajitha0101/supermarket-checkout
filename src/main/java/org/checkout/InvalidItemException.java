package org.checkout;

/**
 * InvalidItemException is a custom exception class for handling invalid items in the checkout system.
 */
public class InvalidItemException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Constructor for the InvalidItemException class.
     *
     * @param message The error message to be displayed.
     */
    public InvalidItemException(String message) {
        super(message);
    }
}
