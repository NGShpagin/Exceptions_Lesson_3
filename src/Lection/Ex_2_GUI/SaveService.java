package Lection.Ex_2_GUI;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class SaveService {
    Date date = new Date();
    public void save() throws SavedException {
        System.out.println("Save document started...");
        try(FileWriter writer = new FileWriter("test")) {
            throw new IOException("operation failed");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new SavedException("Saved document failed", date, e);
        }
    }
}
