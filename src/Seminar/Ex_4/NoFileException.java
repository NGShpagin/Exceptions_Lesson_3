package Seminar.Ex_4;

import java.io.FileNotFoundException;

public class NoFileException extends FileNotFoundException {

    public NoFileException(String message) {
        super(message);
    }


}
