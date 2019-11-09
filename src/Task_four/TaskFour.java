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

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(SENTENCE_INPUT);
            sentence = reader.readLine();
            System.out.println(WORD_INPUT);
            word = reader.readLine();
            if (sentence.isEmpty() || word.isEmpty()) {
                throw new IOException();
            }
            System.out.println(
                    String.format(REPEAT_COUNT, word, repeatCount(word)));
        }
        catch (IOException e) {
            System.out.println(EMPTY_INPUT);
        }
    }

    public static int repeatCount(String str) {
        int count = 0;
        separatedWords = Arrays.asList(sentence.split(" "));
        for (String s : separatedWords) {
            if (s.toLowerCase().equals(str.toLowerCase()))
                count++;
        }
        return count;
    }
}
