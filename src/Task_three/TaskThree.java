package Task_three;

/*Создать программу, которая будет: подсчитывать количество слов в предложении
выводить их в отсортированном виде делать первую букву каждого слова заглавной.
Предложение вводится вручную. (Разделитель пробел (“ ”)).*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TaskThree {

    private static final String INPUT_STRING = "Введите строку для подсчета слов";
    private static final String WORD_COUNT = "Количество слов в предложении: %s";
    private static final String EMPTY_INPUT = "Вы ввели пустую строку";
    private static final String SORTED_WORDS = "Отсортированные слова с первой заглавной буквой: %s";
    private static String input;
    private static List<String> words = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(INPUT_STRING);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            input = reader.readLine().trim();
            if (input.isEmpty()) {
                System.out.println(EMPTY_INPUT);
                return;
            }
            words = Arrays.asList(input.split(" "));
            System.out.println(String.format(WORD_COUNT, words.size()));
            System.out.println(String.format(SORTED_WORDS, wordsFirstLetterToUpperCase(sortList(words))));
        } catch (IOException e) {
            System.err.println(EMPTY_INPUT);
        }
    }

    /**
     * Method is used for list items sorting and transforming text to lowercase
     */
    public static List<String> sortList(List<String> words) {
        return words.stream()
                .map(String::toLowerCase)
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Method is used for transforming word's first letters to uppercase
     */
    public static List<String> wordsFirstLetterToUpperCase(List<String> words) {
        return words.stream()
                .map(TaskThree::firstLetterToUpperCase)
                .collect(Collectors.toList());
    }

    /**
     * Modify the word's first letter to uppercase
     */
    public static String firstLetterToUpperCase (String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
