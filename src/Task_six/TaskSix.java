package Task_six;
/*Имеется набор вещей, которые необходимо поместить в рюкзак. Рюкзак обладает заданной грузоподъемностью.
Вещи в свою очередь обладают двумя параметрами — весом и стоимостью.
Цель задачи заполнить рюкзак не превысив его грузоподъемность и максимизировать суммарную ценность груза.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TaskSix {

    private static final String BAGPACK_WEIGHT = "Введите максимальный вес рюкзака";
    private static final String EMPTY_INPUT = "Вы ввели пустое значение";
    private static final String ERROR_MESSAGE = "Вы ввели некорректное значение";
    private static final int ZERO_VALUE = 0;
    private static final String MAX_WEIGHT = "Максимально допустимый вес рюкзака: %s";
    private static final String ITEM_INPUT = "Введите данные о вещи в формате: вес ценность";
    private static List<Integer> itemInputData = new ArrayList<>();
    private static List<Item> inputItems = new ArrayList<>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(BAGPACK_WEIGHT);
        try {
            int maxWeight = Integer.parseInt(reader.readLine());
            if (maxWeight == ZERO_VALUE) {
                System.out.println(EMPTY_INPUT);
                return;
            }
            Bagpack bagpack = new Bagpack(maxWeight);
            //System.out.println(ITEM_INPUT);

            inputItems.add(new Item(15, 16));
            inputItems.add(new Item(20, 21));
            inputItems.add(new Item(10, 11));
            inputItems.add(new Item(5, 12));
            inputItems.add(new Item(2, 4));
            inputItems.add(new Item(3, 8));
            //System.out.println(inputItems);

            for (int weight = 1; weight <= bagpack.getWeight(); weight++) {
                for (int i = 1; i < inputItems.size(); i++ ) {
                    if (inputItems.get(i).getWeight() > maxWeight) {

                    }
                }
            }

        } catch (IOException e) {
            System.err.println(ERROR_MESSAGE);
        }
    }
}
