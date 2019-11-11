package Task_six;

public class Item {

    private final int weight;
    private final int price;
    private boolean isTaken;

    public Item(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    @Override
    public String toString() {
        return "Item {" +
                "weight = " + weight +
                ", price = " + price +
                ", isTaken = " + isTaken +
                '}';
    }
}
