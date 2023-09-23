package Lesson_2;

import java.io.FileNotFoundException;

public class Task3 {
    public static void main(String[] args) throws Exception {
        try {
            int a = 90;
            int b = 5;
            System.out.println(a / b);
            printSum(23, 0);
            int[] abc = { 1, 2 };
            System.out.println(abc[1] = 9);

        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch(ArithmeticException ex){
            System.out.println("Делить на 0 нельзя!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }

}
