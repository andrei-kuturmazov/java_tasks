package Task_six;

import java.util.List;

public class Bagpack {

    /**
     * Method is based on Bellman's algorithm is using for most valuable items selection
     */
    public void packItems(List<Item> items, int maxWeight) {
        int[][] weightCount = new int[maxWeight + 1][items.size() + 1];
        for (int weight = 0; weight <= maxWeight; weight++) {
            for (int index = 1; index < items.size(); index++) {
                if (items.get(index).getWeight() > weight) {
                    weightCount[weight][index] = weightCount[weight][index - 1];
                    items.get(index).setTaken(false);
                } else if (weightCount[weight][index - 1] >= (weightCount[weight - items.get(index).getWeight()][index - 1] + items.get(index).getPrice())) {
                    weightCount[weight][index] = weightCount[weight][index - 1];
                    items.get(index).setTaken(false);
                } else {
                    weightCount[weight][index] = weightCount[weight - items.get(index).getWeight()][index - 1] + items.get(index).getPrice();
                    items.get(index).setTaken(true);
                }
            }
        }
    }
}
