public class StringCaseChanger implements StringTransformer {

    public StringCaseChanger() {}

    public void execute(StringDrink drink) {
        String ans = new String();
        for (int i = 0; i < drink.getText().length(); i++) {
            if(Character.isLowerCase(drink.getText().charAt(i))) {
                ans += Character.toUpperCase(drink.getText().charAt(i));
            } else {
                ans += Character.toLowerCase(drink.getText().charAt(i));
            }
        }
        drink.setText(ans);
    }
}