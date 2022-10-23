package Homework;

import java.io.*;
import java.util.*;

public class Ex_1 {
    public static void main(String[] args) {
        HashMap<String, String> data = getUserData();
        try {
            writeFile(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, String> getUserData() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> data = new HashMap<>();
        System.out.println("Enter FirstName, LastName, MiddleName, " +
                "BirthDate (dd.mm.yyyy), " +
                "MobTelNum (7XXXXXXXXXX), " +
                "Male (f/m)");
        sb.append(scanner.nextLine());
        String[] str = sb.toString().split(" ");
        if (str.length != 6)
            throw new MyElementQuantityException("Elements quantity must be 6. You enter " + str.length);
        for (String elem : str) {
            if (Objects.equals(elem.toLowerCase(), "f") || Objects.equals(elem.toLowerCase(), "m"))
                data.put("Male", elem.toLowerCase());
            else if (elem.contains(".")) {
                String[] date = elem.split("\\.");
                if (date[0].length() != 2 || date[1].length() != 2 || date[2].length() != 4) {
                    throw new MyDateFormatException("BirthDate format not right");
                }
                try {
                    if (Integer.parseInt(date[0]) > 31 || Integer.parseInt(date[0]) <= 0) {
                        throw new MyDateFormatException("Days in month can't be " + date[0]);
                    } else if (Integer.parseInt(date[1]) > 12 || Integer.parseInt(date[1]) <= 0) {
                        throw new MyDateFormatException("Months in year can't be " + date[1]);
                    } else if (Integer.parseInt(date[2]) > 2022) {
                        throw new MyDateFormatException("BirthYear can't be " + date[2]);
                    } else data.put("BirthDate", elem);
                } catch (NumberFormatException e) {
                    throw new MyDateFormatException("Date format must be numerical");
                }
            } else if (elem.matches("[0-9]+")) {
                if (elem.length() == 11 && elem.startsWith("7")) data.put("MobTelNum", elem);
                else throw new MyTelNumberFormatException("TelNumber format must be 7XXXXXXXXXX");
            } else if (elem.toLowerCase().endsWith("vich") || elem.toLowerCase().endsWith("vna") ||
                    elem.toLowerCase().endsWith("вич") || elem.toLowerCase().endsWith("вна"))
                data.put("MiddleName", elem);
            else if (elem.toLowerCase().endsWith("ov") || elem.toLowerCase().endsWith("ova") ||
                    elem.toLowerCase().endsWith("in") || elem.toLowerCase().endsWith("ina") ||
                    elem.toLowerCase().endsWith("ов") || elem.toLowerCase().endsWith("ова") ||
                    elem.toLowerCase().endsWith("ин") || elem.toLowerCase().endsWith("ина")) {
                data.put("LastName", elem);
            } else {
                if (data.containsKey("FirstName"))
                    throw new MyNotIdentifyElementException("Can't identify element " + elem);
                else data.put("FirstName", elem);
            }
        }
        return data;
    }

    static void writeFile(HashMap<String, String> hm) throws IOException {
        File file = new File(String.format("/Users/nikolaishpagin/Desktop/GeekBrains/Programmer_1st_quarter/Exceptions/Lesson_3/src/Homework/%s", hm.get("LastName")));
        if (file.createNewFile()){
            System.out.printf("File %s is created!\n", file.getName());
        }
        else{
            System.out.printf("File %s already exists and new contact add in it.\n", file.getName());
        }
        try (FileWriter fw = new FileWriter(String.format("/Users/nikolaishpagin/Desktop/GeekBrains/Programmer_1st_quarter/Exceptions/Lesson_3/src/Homework/%s", hm.get("LastName")), true)) {
            fw.append(String.format("LastName: %s\n", hm.get("LastName")));
            fw.append(String.format("FirstName: %s\n", hm.get("FirstName")));
            fw.append(String.format("MiddleName: %s\n", hm.get("MiddleName")));
            fw.append(String.format("BirthDate: %s\n", hm.get("BirthDate")));
            fw.append(String.format("MobTelNum: %s\n", hm.get("MobTelNum")));
            fw.append(String.format("Male: %s\n", hm.get("Male")));

//            for (Map.Entry<String, String> el : hm.entrySet()) {
//                String key = el.getKey();
//                String value = el.getValue();
//                fw.append(String.format("%s: %s\n", key, value));
//            }
            fw.append("\n");
        }
    }
}
