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

    private static final String INPUT_STRING = "Введите число от 0 до 100 для задания верхней границы поиска";
    private static final String PALINDROME_VALUES = "Значения-палиндромы в границах от 0 до %s: %s";
    private static final String INCORRECT_INPUT = "Вы ввели некорректное значение";
    private static List<Integer> data;
    private static List<Integer> palindromeCheck;

    public static void main(String[] args) throws IOException {
        System.out.println(INPUT_STRING);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int border = Integer.parseInt(reader.readLine().trim());
            if (border > 100 || border < 0) {
                System.out.println(INCORRECT_INPUT);
                return;
            }
            System.out.println(String.format(PALINDROME_VALUES, border, palindromeValues(border)));
        } catch (NumberFormatException e) {
            System.err.println(INCORRECT_INPUT);
        }
        reader.close();
    }

    public static List<Integer> palindromeValues(int input){
        data = new ArrayList<>(input);
        for (int index = 0; index <= input; index++) {
            data.add(index);
        }
        palindromeCheck = new ArrayList<>(data);
        for (Integer valueIndex: palindromeCheck) {
            int reverseValue = 0;
            int palindrome = valueIndex;
            while(palindrome != 0) {
                int remainder = palindrome % 10;
                reverseValue = reverseValue * 10 + remainder;
                palindrome = palindrome / 10;
            }
            if (valueIndex != reverseValue)
                data.remove(valueIndex);
        }
        return data;
    }
}
