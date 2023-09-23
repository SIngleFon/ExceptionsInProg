package Lesson_2;

/**
 * Task2
 */
public class Task2 {
    public static void main(String[] args) {
        int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 100};
        try {
            double d = 0;
            if(d == 0){
                throw new ArithmeticException("/ by zero");
            }
            double catchedRes1 = intArray[5] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
         } catch (IndexOutOfBoundsException e){
            System.out.println("Catching exception: " + e);
         }
         
    }
    
}