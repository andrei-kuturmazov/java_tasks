package Task_six;

import java.util.List;

public class Bagpack {

    private static List<Item> items;
    private int weight;

    public Bagpack(int weight) {
        this.weight = weight;
    }

    public static List<Item> getItems() {
        return items;
    }

    public int getWeight() {
        return weight;
    }
}
