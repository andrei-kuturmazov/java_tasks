package Task_four;
/*Создать программу, которая подсчитывает сколько раз
употребляется слово в тексте (без учета регистра)
Текст и слово вводится вручную.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TaskFour {

    private static final String SENTENCE_INPUT = "Пожалуйста введите предложение для поиска слова";
    private static final String WORD_INPUT = "Пожалуйста введите слово для поиска в предложении";
    private static final String EMPTY_INPUT = "Вы ввели пустое значение для предложения или слова";
    private static final String REPEAT_COUNT = "Введенное вами слово \"%s\" встречаетcя в тексте %s раз(а) без учета регистра";
    private static String sentenceForSearch;
    private static String wordForSearch;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(SENTENCE_INPUT);
            sentenceForSearch = reader.readLine().trim();
            System.out.println(WORD_INPUT);
            wordForSearch = reader.readLine().trim();
            if (sentenceForSearch.isEmpty() || wordForSearch.isEmpty()) {
                System.out.println(EMPTY_INPUT);
                return;
            }
            System.out.println(String.format(REPEAT_COUNT, wordForSearch, repeatCount(wordForSearch, sentenceForSearch)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Returns the words count in sentence separated by " "
     * @param wordForSearch
     * @param sentenceForSearch
     * @return
     */
    public static long repeatCount(String wordForSearch, String sentenceForSearch) {
        return Arrays.stream(sentenceForSearch.split(" ")).filter(word -> word.toLowerCase().equals(wordForSearch.toLowerCase()))
                .count();
    }
}
