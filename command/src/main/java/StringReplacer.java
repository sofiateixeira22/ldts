public class StringReplacer implements StringTransformer {
    char old, newchar;

    public StringReplacer(char a, char b){
        this.old = a;
        this.newchar = b;
    }

    public void execute(StringDrink drink) {
        String ans = new String(drink.getText());
        ans = ans.replace(old, newchar);
        drink.setText(ans);
    }
}
