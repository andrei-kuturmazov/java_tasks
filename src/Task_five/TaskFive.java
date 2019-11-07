package Task_five;

/*Создать программу, которая в последовательности от 0 до N,
находит все числа-палиндромы (зеркальное значение равно оригинальному).
Длина последовательности N вводится вручную и не должна превышать 100.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TaskFive {

    private static List<Integer> data;
    private static List<Integer> palindromeCheck;

    public static void main(String[] args) throws IOException {

        System.out.println("Введите число от 0 до 100 для задания верхней границы поиска");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int border = Integer.parseInt(reader.readLine());
            if (border > 100 || border < 0)
                throw new Exception();

            String output = String.format("Значения-палиндромы в границах от 0 до %s: %s", border, palindromeValues(border));
            System.out.println(output);

        } catch (Exception e) {
            System.out.println("Вы ввели некорректное значение");
        }
        reader.close();
    }

    public static List<Integer> palindromeValues(int a){

        data = new ArrayList<>();
        for (int i = 0; i <= a; i++)
            data.add(i);

        palindromeCheck = new ArrayList<>(data);

        for (Integer i: palindromeCheck) {
            int reverseValue = 0;
            int palindrome = i;

            while(palindrome != 0) {
                int remainder = palindrome % 10;
                reverseValue = reverseValue * 10 + remainder;
                palindrome = palindrome / 10;
            }
            if (i != reverseValue)
                data.remove(i);
        }
        return data;
    }
}
