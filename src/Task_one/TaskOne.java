package Task_one;

/*Создать программу, которая будет сообщать, является ли целое число,
введенное пользователем, чётным или нечётным, простым или составным.
Если пользователь введёт не целое число, то сообщать ему об ошибке.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskOne {
    public static void main(String[] args) throws IOException {

        System.out.println("Введите, пожалуйста, число для проверки");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String countable = "нечетным";
        String simple = "простым";

        try {
            int input = Integer.parseInt(reader.readLine());

            if (input == 0) {
                System.out.print("Ноль не может участвовать в проверке. ");
                throw new Exception();
            }

            if (isConstruct(input))
                simple = "составным";

            if (isCountable(input))
                countable = "четным";

            String output = String.format("Введенное вами число %s является %s, %s числом", input, simple, countable);
            System.out.println(output);
        }
        catch (Exception e) {
            System.out.println("Вы ввели неверное значение");
        }
        reader.close();
    }

    public static boolean isCountable (int a) {

        return a % 2 == 0 ? true : false;
    }

    public static boolean isConstruct (int a) {

        int abs = Math.abs(a);
        boolean construct = false;
        for (int i = 2; i < abs ; i++) {
            if (abs % i == 0) {
                construct = true;
                break;
            }
        }
        return construct;
    }
}
