package Task_three;

/*Создать программу, которая будет: подсчитывать количество слов в предложении
выводить их в отсортированном виде делать первую букву каждого слова заглавной.
Предложение вводится вручную. (Разделитель пробел (“ ”)).*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TaskThree {

    private static final String INPUT_STRING = "Введите строку для подсчета слов";
    private static final String WORD_COUNT = "Количество слов в предложении: %s";
    private static final String EMPTY_INPUT = "Вы ввели пустую строку";
    private static final String SORTED_WORDS = "Отсортированные слова с первой заглавной буквой: %s";
    private static String input;
    private static List<String> words = new ArrayList<>();
    private static List<String> outputWords;
    private static List<String> sortedOutput;

    public static void main(String[] args) {
        System.out.println(INPUT_STRING);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            input = reader.readLine().trim();
            if (input.isEmpty()) {
                System.out.println(EMPTY_INPUT);
                return;
            }
            words = Arrays.asList(input.toLowerCase().split(" "));
            System.out.println(String.format(WORD_COUNT, wordsCount(words)));
            System.out.println(String.format(SORTED_WORDS, firstToUpperCase(sortList(words))));
        } catch (IOException e) {
            System.err.println(EMPTY_INPUT);
        }
    }
    // Returns the words count
    public static int wordsCount(List<String> words) {
        return words.size();
    }
    // Returns the sorted array of words in lowercase
    public static List<String> sortList(List<String> words) {
        sortedOutput = new ArrayList<>(words);
        for (String word : sortedOutput) {
            word.toLowerCase();
        }
        Collections.sort(sortedOutput, String.CASE_INSENSITIVE_ORDER);
        return sortedOutput;
    }
    //Returns the array of words with first symbol as an uppercase
    public static List<String> firstToUpperCase(List<String> words) {
        outputWords = new ArrayList<>();
        for (String word : words) {
            outputWords.add(word.substring(0, 1).toUpperCase() + word.substring(1));
        }
        return outputWords;
    }
}
