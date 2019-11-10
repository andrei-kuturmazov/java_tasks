package Task_four;
/*Создать программу, которая подсчитывает сколько раз
употребляется слово в тексте (без учета регистра)
Текст и слово вводится вручную.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskFour {

    private static final String SENTENCE_INPUT = "Пожалуйста введите предложение для поиска слова";
    private static final String WORD_INPUT = "Пожалуйста введите слово для поиска в предложении";
    private static final String EMPTY_INPUT = "Вы ввели пустое значение для предложения или слова";
    private static final String REPEAT_COUNT = "Введенное вами слово \"%s\" встречает в тексте %s раз(а) без учета регистра";
    private static String sentence;
    private static String word;
    private static List<String> separatedWords = new ArrayList<>();
    private static int wordCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(SENTENCE_INPUT);
            sentence = reader.readLine().trim();
            System.out.println(WORD_INPUT);
            word = reader.readLine().trim();
            if (sentence.isEmpty() || word.isEmpty()) {
                System.out.println(EMPTY_INPUT);
                return;
            }
            System.out.println(String.format(REPEAT_COUNT, word, repeatCount(word)));
        } catch (IOException e) {
            System.out.println(EMPTY_INPUT);
        }
        reader.close();
    }

    public static int repeatCount(String string) {
        separatedWords = Arrays.asList(sentence.split(" "));
        for (String word : separatedWords) {
            if (word.toLowerCase().equals(string.toLowerCase()))
                wordCount++;
        }
        return wordCount;
    }
}
