import java.util.InputMismatchException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] array = {{1,2,3}, {4,5,6}, {7,8,9}};
        outputArray(array);
        columnOutput(sc,array);

    }
    public static void  outputArray(int[][] arr){
        System.out.println("Матрица: ");

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void  columnOutput(Scanner sc,int[][] arr){
        System.out.println("Введите номер столбца для вывода: ");
        int columnNumber = 0;
        try {
            columnNumber = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Вы ввели строку вместо столбца");
            System. exit(0); // принудительно завершаем работу программы
        }

        try {
            for (int i = 0; i < arr.length; i++){
                System.out.print(arr[i][columnNumber-1] + "\t");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Нет столбца с таким номером");
        }
    }
}