public class StringDrink {
    String drink;

    public StringDrink(String drink) {
        this.drink = drink;
    }

    public String getText() {
        return drink;
    }

    public void setText(String s) {
        drink = drink.replace(drink, s);
    }
}
