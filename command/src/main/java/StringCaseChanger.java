public class StringCaseChanger implements StringTransformer {

    public StringCaseChanger() {}

    public void execute(StringDrink drink) {
        String ans = new String(drink.getText());
        for (int i = 0; i < ans.length(); i++) {
            if(Character.isLowerCase(ans.charAt(i))) {
                ans = ans.replace(ans.charAt(i), Character.toUpperCase(ans.charAt(i)));
            } else {
                ans = ans.replace(ans.charAt(i), Character.toLowerCase(ans.charAt(i)));
            }
        }

        drink.setText(ans);
    }
}