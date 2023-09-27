package Lesson_3;
import java.util.Scanner;

public class Data {
        public static String[] getInfo(){
        Scanner in = new Scanner(System.in, "Cp866");
        System.out.println("Введите через пробел, следующие данные:\n Фамилия | Имя | Отчество | ДатаРождения | НомерТелефона | Пол");
        while(true){
            String[] data = in.nextLine().split("\\s+");
            if(data.length != 6){
                System.out.println("Повторите попытку!");
            } else{
                return data;
            }
        }
    } 
}
