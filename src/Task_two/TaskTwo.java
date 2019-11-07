package Task_two;

/*Создать программу, которая будет вычислять и выводить на экран НОК (наименьшее общее кратное)
и НОД (наибольший общий делитель) двух целых чисел, введенных пользователем.
Если пользователь некорректно введёт хотя бы одно из чисел, то сообщать об ошибке.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskTwo {
    public static void main(String[] args) throws IOException {

        System.out.println("Введите два целых числа для подсчета НОД и НОК");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int one = Integer.parseInt(reader.readLine());
            int two = Integer.parseInt(reader.readLine());
            if (one == 0 || two == 0)
                throw new Exception();

            String nodValue = String.format("Наибольший общий делитель, введенных чисел %s и %s равен %s", one, two, nod(one, two));
            String nokValue = String.format("Наименьшее общее кратное, введенных чисел %s и %s равно %s", one, two, nok(one, two));

            System.out.println(nodValue);
            System.out.println(nokValue);

        } catch (Exception e) {
            System.out.println("Введены некорректные данные");
        }

        reader.close();
    }

    // Расчет НОД и НОК рекурсивным способом
    public static int nod(int a, int b) {
        if (b == 0)
            return Math.abs(a);
        return nod(b, a % b);
    }

    public static int nok(int a, int b) {
        return (a * b) / nod(a, b);
    }
}
