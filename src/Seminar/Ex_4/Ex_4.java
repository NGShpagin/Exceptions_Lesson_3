package Seminar.Ex_4;

/*
Создайте класс исключения, который будет выбрасываться при делении на 0.
Исключение должно отображать понятное для пользователя сообщение об ошибке.

Создайте класс исключений, которое будет возникать при обращении к пустому элементу в массиве ссылочного типа.
Исключение должно отображать понятное для пользователя сообщение об ошибке.

Создайте класс исключения, которое будет возникать при попытке открыть несуществующий файл.
Исключение должно отображать понятное для пользователя сообщение об ошибке.
 */


import java.io.File;
import java.io.IOException;

public class Ex_4 {
    public static void main(String[] args) {
        int m = 10;
        int n = 0;
//        int res = division(m, n);
//        try {
//            searchPath();
//        } catch (NoFileException e) {
//            e.printStackTrace();
//        }

        try {
            searchElement();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static int division(int m, int n) throws DivideByZeroException {
        int result;
        try {
            result = m / n;
        } catch (ArithmeticException e) {
            throw new DivideByZeroException(e.getMessage());
        }
        return result;
    }

    public static void searchPath() throws NoFileException {
        File file = new File("/423/234/23");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new NoFileException("file not found");
        }
    }

    public static void searchElement() throws EmptyElementException {
        String[] str = new String[2];
        try {
            str[0].length();
        } catch (NullPointerException e) {
            throw new EmptyElementException("Element not exist");
        }

    }
}
