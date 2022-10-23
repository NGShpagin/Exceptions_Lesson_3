package Seminar.Ex_5;

/*
Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
В методе main() вызвать полученный метод,обработать возможные исключения MyArraySizeException и MyArrayDataException
и вывести результат расчета (сумму элементов, при условии что подали на вход корректный массив).
 */

public class Ex_5 {
    public static void main(String[] args) {
        String[][] str = new String[][]{{"2", "3", "6", "s"}, {"3", "32", "2", "2"},
                {"2", "3", "6", "6"}, {"3", "32", "2", "2"}};
        try {
            System.out.println(sumMassive(str));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static int sumMassive(String[][] str) {
        int sum = 0;
        for (int i = 0; i < str.length; i++) {
            if (str.length != str[i].length) {
                throw new MyArraySizeException("array not square");
            }
            for (int j = 0; j < str[i].length; j++) {
                try {
                    sum += Integer.parseInt(str[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("Can't pasrse element %s (%d, %d)", str[i][j], i, j));
                }

            }
        }
        return sum;
    }

}
