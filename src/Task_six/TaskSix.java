package Task_six;
/*Имеется набор вещей, которые необходимо поместить в рюкзак. Рюкзак обладает заданной грузоподъемностью.
Вещи в свою очередь обладают двумя параметрами — весом и стоимостью.
Цель задачи заполнить рюкзак не превысив его грузоподъемность и максимизировать суммарную ценность груза.*/

import java.util.ArrayList;
import java.util.List;

public class TaskSix {

    public static void main(String[] args) {
        List<Item> inputItems = new ArrayList<>();
        Bagpack bagpack = new Bagpack();
        addItems(inputItems);
        bagpack.packItems(inputItems, 31);
        for (Item item : inputItems) {
            System.out.println(item.toString());
        }
    }
    // Add items to list for check
    public static void addItems(List<Item> inputItems) {
        inputItems.add(new Item(5, 10));
        inputItems.add(new Item(25, 80));
        inputItems.add(new Item(15, 30));
        inputItems.add(new Item(5, 20));
        inputItems.add(new Item(30, 85));
    }
}