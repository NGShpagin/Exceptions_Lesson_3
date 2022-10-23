package Seminar.Ex_4;

import java.util.Date;

public class DivideByZeroException extends ArithmeticException {

    public DivideByZeroException(String message) {
        super(message);
    }

    public DivideByZeroException(String message, Throwable cause) {
        super();
    }

}

