package Lesson_2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("Вы ввели корректное число: " + UserKey("Введите дробное число", "Ошибка ввода дробного числа, повторите попытку!")); 
    }

    public static float UserKey(String msg, String msgError) {
        Scanner in = new Scanner(System.in);
        // boolean flag = true;
        while(true){
            try{
                System.out.println(msg);
                float usKey = in.nextFloat();
                return usKey;
            } catch(Exception ex){
                System.out.println(msgError);
                return UserKey(msg, msgError);
            }
        }
    }
}
