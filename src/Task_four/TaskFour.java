package Task_four;
/*Создать программу, которая подсчитывает сколько раз
употребляется слово в тексте (без учета регистра)
Текст и слово вводится вручную.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskFour {
        private static String sentence;
        private static String word;
        private static List<String> separatedWords = new ArrayList<>();

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Пожалуйста введите предложение для поиска слова");
            sentence = reader.readLine();
            System.out.println("Пожалуйста введите слово для поиска в предложении");
            word = reader.readLine();

            if (sentence.isEmpty() || word.isEmpty())
                throw new Exception();

            System.out.println(
                    String.format("Введенное вами слово \"%s\" встречает в тексте %s раз(а) без учета регистра", word, repeatCount(word)));
        }
        catch (Exception e) {
            System.out.println("Вы ввели пустое значение для предложения или слова");
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
