package Task_two;

/*Создать программу, которая будет вычислять и выводить на экран НОК (наименьшее общее кратное)
и НОД (наибольший общий делитель) двух целых чисел, введенных пользователем.
Если пользователь некорректно введёт хотя бы одно из чисел, то сообщать об ошибке.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskTwo {

    private static final String INPUT_STRING = "Введите два целых числа для подсчета НОД и НОК";
    private static final String ZERO_INPUT = "Введите значения отличные от нуля";
    private static final String ERROR_MESSAGE = "Введены некорректные данные";
    private static final String GCD_VALUE = "Наибольший общий делитель, введенных чисел %s и %s равен %s";
    private static final String MCM_VALUE = "Наименьшее общее кратное, введенных чисел %s и %s равно %s";
    private static final int ZERO_VALUE = 0;

    public static void main(String[] args) throws IOException {
        System.out.println(INPUT_STRING);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int one = Integer.parseInt(reader.readLine().trim());
            int two = Integer.parseInt(reader.readLine().trim());
            if (one == ZERO_VALUE || two == ZERO_VALUE) {
                System.err.println(ZERO_INPUT);
                return;
            }
            System.out.println(String.format(GCD_VALUE, one, two, greaterCommonDelimiter(one, two)));
            System.out.println(String.format(MCM_VALUE, one, two, minimumCommonMultiple(one, two)));
        } catch (NumberFormatException e) {
            System.err.println(ERROR_MESSAGE);
        }
        reader.close();
    }

    public static int greaterCommonDelimiter(int a, int b) {
        if (b == 0)
            return Math.abs(a);
        return greaterCommonDelimiter(b, a % b);
    }

    public static int minimumCommonMultiple(int a, int b) {
        return Math.abs((a * b) / greaterCommonDelimiter(a, b));
    }
}
