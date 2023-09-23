package Lesson_2;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "Cp866");
        System.out.println("Введите: ");
        String input = in.nextLine();
        if((input == "") | (input == null)){
            throw new NullPointerException("Вы ввели пустую строку!");
        }
        System.out.println(input);
    }
}
