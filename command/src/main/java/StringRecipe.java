import java.util.ArrayList;
import java.util.List;

public class StringRecipe {
    StringDrink drink = new StringDrink("AbCd-aBcD");
    List<StringTransformer> list;

    public StringRecipe(List<StringTransformer> list) {
        this.list = list;
    }

    public void mix() {
        for(int i = 0; i < list.size(); i++) {
            list.get(i).execute(drink);
        }
    }
}
