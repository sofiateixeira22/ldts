public class StringInverter implements StringTransformer {

    public StringInverter() {}

    public void execute(StringDrink drink) {
        StringBuilder ans = new StringBuilder(drink.getText());
        ans.reverse();
        drink.setText(ans.toString());
    }
}
