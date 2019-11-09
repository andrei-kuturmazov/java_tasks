package Task_one;

/*Создать программу, которая будет сообщать, является ли целое число,
введенное пользователем, чётным или нечётным, простым или составным.
Если пользователь введёт не целое число, то сообщать ему об ошибке.*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskOne {

    private static final String INPUTSTRING = "Введите, пожалуйста, число для проверки";
    private static final String ERRORMESSAGE = "Вы ввели неверное значение";
    private static final String ZEROINPUT = "Ноль не может участвовать в проверке";
    private static final String COUNTABLE = "четным";
    private static final String UNCOUNTABLE = "нечетным";
    private static final String SIMPLE = "простым";
    private static final String CONSTRUCT = "составным";
    private static final String OUTPUTSTRING = "Введенное вами число %s является %s, %s числом";

    public static void main(String[] args) throws IOException {
        System.out.println(INPUTSTRING);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int input = Integer.parseInt(reader.readLine());
            if (input == 0) {
                System.out.println(ZEROINPUT);
            }
            String output = String.format(OUTPUTSTRING, input, isCountable(input), isConstruct(input));
            System.out.println(output);

        } catch (IOException e) {
            System.err.println(ERRORMESSAGE);
        }
        reader.close();
    }

    public static String isCountable(int input) {
        return input % 2 == 0 ? COUNTABLE : UNCOUNTABLE;
    }

    public static String isConstruct(int input) {
        int absolutValue = Math.abs(input);
        String output = SIMPLE;
        for (int index = 2; index < absolutValue; index++) {
            if (absolutValue % index == 0) {
                output = CONSTRUCT;
                break;
            }
        }
        return output;
    }
}
