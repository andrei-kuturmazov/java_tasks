package Task_one;

/*Создать программу, которая будет сообщать, является ли целое число,
введенное пользователем, чётным или нечётным, простым или составным.
Если пользователь введёт не целое число, то сообщать ему об ошибке.*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskOne {

    private static final String INPUT_STRING = "Введите, пожалуйста, число для проверки";
    private static final String ERROR_MESSAGE = "Вы ввели неверное значение";
    private static final String ZERO_INPUT = "Ноль и единица не могут участвовать в проверке";
    private static final String OUTPUT_STRING = "Введенное вами число %s является %s, %s числом";
    private static final int ZERO_VALUE = 0;
    private static final int ABS_ONE = 1;

    public static void main(String[] args) {
        System.out.println(INPUT_STRING);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            int input = Integer.parseInt(reader.readLine().trim());
            if (input == ZERO_VALUE || Math.abs(input) == ABS_ONE) {
                System.err.println(ZERO_INPUT);
                return;
            }
            String output = String.format(OUTPUT_STRING, input, CountableType.getParityType(input).getType(), NumberType.determineNumberType(input).getType());
            System.out.println(output);
        } catch (NumberFormatException e) {
            System.err.println(ERROR_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
