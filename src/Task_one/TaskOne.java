package Task_one;

/*Создать программу, которая будет сообщать, является ли целое число,
введенное пользователем, чётным или нечётным, простым или составным.
Если пользователь введёт не целое число, то сообщать ему об ошибке.*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskOne {

    private static String COUNTABLE = "четным";
    private static String UNCOUNTABLE = "нечетным";
    private static String SIMPLE = "простым";
    private static String CONSTRUCT = "составным";

    public static void main(String[] args) {

        System.out.println("Введите, пожалуйста, число для проверки");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int input = Integer.parseInt(reader.readLine());

            if (input == 0) {
                System.out.print("Ноль не может участвовать в проверке. ");
                throw new IOException();
            }

            String output = String.format("Введенное вами число %s является %s, %s числом", input, isCountable(input), isConstruct(input));
            System.out.println(output);
            reader.close();
        } catch (IOException e) {
            System.err.println("Вы ввели неверное значение");
        }
    }

    public static String isCountable(int a) {
        return a % 2 == 0 ? COUNTABLE : UNCOUNTABLE;
    }

    public static String isConstruct(int a) {
        int abs = Math.abs(a);
        String output = SIMPLE;
        for (int i = 2; i < abs; i++) {
            if (abs % i == 0) {
                output = CONSTRUCT;
                break;
            }
        }
        return output;
    }
}
