package pt.up.fe.ldts.example1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderLine> lines;

    public Order() {
        lines = new ArrayList<>();
    }

    public double extract() {
        double total = 0;

        for (OrderLine line : lines)
            total += line.getProduct().getPrice() * line.getQuantity();

        return total;
    }

    public void add(Product product, int quantity) { lines.add(new OrderLine(product, quantity)); }
    //adds a new order to the list

    public boolean isElegibleForFreeDelivery() {
        //if price > 100 the delivery its free
        double total = extract();

        if (total > 100) return true;
        else return false;
    }

    public String printOrder() {
        //prints all the orders plus their price and the total
        StringBuffer printBuffer = new StringBuffer();

        for (OrderLine line : lines)
            printBuffer.append(line.getProduct().getName() + "(x" + line.getQuantity() + "): " + (line.getProduct().getPrice() * line.getQuantity()) + "\n");

        double total = extract();

        printBuffer.append("Total: " + total);

        return printBuffer.toString();
    }
}