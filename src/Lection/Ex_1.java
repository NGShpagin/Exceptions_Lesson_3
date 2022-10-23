package Lection;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex_1 {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader(
                "/Users/nikolaishpagin/Desktop/GeekBrains/Programmer_1st_quarter/Exceptions/Lesson_3/test1");
            FileWriter writer = new FileWriter("test2")) {
            while (reader.ready()) {
                writer.write(reader.read());
            }
        } catch (RuntimeException | IOException e) {
            System.out.println("cath exception: " + e.getClass().getSimpleName());
        }

        try {
            System.out.println("test operation");
        } finally {
            System.out.println("finally operation");
        }

        System.out.println("Copy successfully");
    }
}
