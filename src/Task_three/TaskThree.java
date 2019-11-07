package Task_three;

/*Создать программу, которая будет:
подсчитывать количество слов в предложении
выводить их в отсортированном виде
делать первую букву каждого слова заглавной.
Предложение вводится вручную. (Разделитель пробел (“ ”)).
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TaskThree {

    private static String input;
    private static List<String> words = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        System.out.println("Введите строку для подсчета слов");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            input = reader.readLine();
            if (input.isEmpty())
                throw new Exception();
            System.out.println(wordsCount(input));
            System.out.println(firstToUpperCase(sentenseToList(input)));

        }
        catch (Exception e){
            System.out.println("Вы ввели пустую строку");
        }

        reader.close();
    }

    public static List<String> sentenseToList(String input) {
        words = Arrays.asList(input.split(" "));
        return words;
    }

    public static int wordsCount(String input) {
        return input.trim().split(" ").length;
    }

    public static List<String> sortList(List<String> words) {
        List<String> output = new ArrayList<>(words);
        for (String s : output) {
            s.toLowerCase();

        }
        Collections.sort(output);
        return output;
    }

    public static List<String> firstToUpperCase(List<String> words){
        List<String> inputList = new ArrayList<>(words);
        List <String> output = new ArrayList<>();

        for (String i: inputList) {
            output.add(i.substring(0, 1).toUpperCase() + i.substring(1));
        }
        return output;
    }
}
