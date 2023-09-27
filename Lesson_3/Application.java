package Lesson_3;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static String chectNumberInString(String text) {
        Scanner in = new Scanner(System.in, "Cp866");
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                System.out.println("Вы допустили ошибку в " + text + "! Введите корректное значение: ");
                String newText = in.nextLine();
                return chectNumberInString(newText);
            }
        }
        return text;
    }

    public static String checkData(String data) {
        String errorMsg = "Введите корректный формат даты dd.mm.yyyy: ";
        Scanner in = new Scanner(System.in, "Cp866");
        try {
            if ((data.length() == 10) & (data.charAt(2) == '.') & (data.charAt(5) == '.')) {
                String text = data.replace(".", "");
                try {
                    int tryInt = Integer.parseInt(text);
                } catch (NumberFormatException e) {
                    System.out.println("Exception: " + e + errorMsg);
                    return checkData(in.nextLine());
                }
            } else {
                System.out.println(errorMsg);
                return checkData(in.nextLine());
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception: " + e + errorMsg);
            return checkData(in.nextLine());
        }
        return data;
    }

    public static String checkNumberPhone(String number) {
        Scanner in = new Scanner(System.in, "Cp866");
        try {
            int phone = Integer.parseInt(number);
            return number;
        } catch (NumberFormatException e) {
            System.out.println("Exception: " + e + "\nВведите корректный номер телефона без знаков: ");
            return checkNumberPhone(in.nextLine());
        }

    }

    public static String checkSex(String sex) {
        Scanner in = new Scanner(System.in, "Cp866");
        if ((sex.length() != 1)) {
            System.out.println("Вводить только M or F !");
            String input = in.nextLine();
            return checkSex(input);
        }
        if (sex.toLowerCase().contains("f")) {
            return sex.toUpperCase();

        } else if (sex.toLowerCase().contains("m")) {
            return sex.toUpperCase();
        } else {
            System.out.println("Вводить только M or F !");
            String input = in.nextLine();
            return checkSex(input);
        }
    }

    public static String[] checkInfo(String[] data) {
        Scanner in = new Scanner(System.in, "Cp866");
        String[] arr = new String[6];
        for (int i = 0; i < data.length; i++) {
            if (i <= 2) {
                arr[i] = chectNumberInString(data[i]);
            }
            if (i == 3) {
                arr[i] = checkData(data[i]);
            }
            if (i == 4) {
                arr[i] = checkNumberPhone(data[i]);
            }
            if (i == 5) {
                arr[i] = checkSex(data[i]);
            }
        }
        return arr;
    }

    public static void writeData(String data, String path) {
        try (FileWriter fw = new FileWriter(path, true)) {
            fw.append(data);
            fw.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int inputNum(String msg) {
        System.out.println(msg);
        Scanner in = new Scanner(System.in, "Cp866");
        try {
            int numb = in.nextInt();
            return numb;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return -1;
    }

    public static String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(
                Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static void start() {
        boolean flag = true;
        List<String> savedLastName = new ArrayList<>();
        while (flag) {
            int ans = inputNum("Функции: \n1) Добавить данные\n2) Отобразить данные\n3) Выход");
            switch (ans) {
                case 1:
                    System.out.print("\033\143");
                    String[] data = checkInfo(Data.getInfo());
                    writeData(Arrays.toString(data), data[0]);
                    String lastName = data[0].toLowerCase();
                    if (!savedLastName.contains(lastName)) {
                        savedLastName.add(lastName);
                    }

                    break;
                case 2:
                    System.out.print("\033\143");
                    if (savedLastName.size() > 0) {
                        for (int i = 0; i < savedLastName.size(); i++) {
                            System.out.println(i + 1 + " " + savedLastName.get(i));
                        }
                        int inp = inputNum("Выберите какой документ хотите отобразить: ");
                        try {
                            System.out.println(readFileAsString(savedLastName.get(inp - 1)));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("В данный момент данных нет.\n");
                    }
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Ошибка ввода, повторите попытку!");
                    start();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.print("\033\143");
        start();
    }
}
