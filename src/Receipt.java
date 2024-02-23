import javax.swing.*;
import java.awt.*;

public class Receipt extends Order
{
    public JTextArea createReceipt(double subTotal, double tax, double total)
    {
        JTextArea orderForm = new JTextArea(13,50);
        orderForm.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        orderForm.setEditable(false);
        orderForm.append("==================================================\n");

        if (getPizzaSize() == Order.size.small)
        {
            orderForm.append("Small ");
            if (getPizzaCrust() == Order.crust.thin)
                orderForm.append("Thin Crust                        \n");
            else if (getPizzaCrust() == Order.crust.regular)
                orderForm.append("Regular Crust                     \n");
            else if (getPizzaCrust() == Order.crust.deepDish)
                orderForm.append("Deep Dish Crust                   \n");
            else
                orderForm.append("Crust Not Selected                \n");
        }
        else if (getPizzaSize() == Order.size.medium)
        {
            orderForm.append("Medium ");
            if (getPizzaCrust() == Order.crust.thin)
                orderForm.append("Thin Crust                       \n");
            else if (getPizzaCrust() == Order.crust.regular)
                orderForm.append("Regular Crust                    \n");
            else if (getPizzaCrust() == Order.crust.deepDish)
                orderForm.append("Deep Dish Crust                  \n");
            else
                orderForm.append("Crust Not Selected               \n");
        }
        else if (getPizzaSize() == Order.size.large)
        {
            orderForm.append("Large ");
            if (getPizzaCrust() == Order.crust.thin)
                orderForm.append("Thin Crust                        \n");
            else if (getPizzaCrust() == Order.crust.regular)
                orderForm.append("Regular Crust                     \n");
            else if (getPizzaCrust() == Order.crust.deepDish)
                orderForm.append("Deep Dish Crust                   \n");
            else
                orderForm.append("Crust Not Selected                \n");
        }
        else if (getPizzaSize() == Order.size.extraLarge)
        {
            orderForm.append("Extra Large ");
            if (getPizzaCrust() == Order.crust.thin)
                orderForm.append("Thin Crust                  \n");
            else if (getPizzaCrust() == Order.crust.regular)
                orderForm.append("Regular Crust               \n");
            else if (getPizzaCrust() == Order.crust.deepDish)
                orderForm.append("Deep Dish Crust             \n");
            else
                orderForm.append("Crust Not Selected          \n");
        }
        else
        {
            orderForm.append("Size Not Selected ");
            if (getPizzaCrust() == Order.crust.thin)
                orderForm.append("Thin Crust            \n");
            else if (getPizzaCrust() == Order.crust.regular)
                orderForm.append("Regular Crust         \n");
            else if (getPizzaCrust() == Order.crust.deepDish)
                orderForm.append("Deep Dish Crust       \n");
            else
                orderForm.append("| Crust Not Selected  \n");
        }

        if (getOneIngredient(0))
            orderForm.append("Pepperoni                               $1.00\n");
        else if (getOneIngredient(1))
            orderForm.append("Sausage                                 $1.00\n");
        else if (getOneIngredient(2))
            orderForm.append("Black Olives                            $1.00\n");
        else if (getOneIngredient(3))
            orderForm.append("Banana Peppers                          $1.00\n");
        else if (getOneIngredient(4))
            orderForm.append("Mushrooms                               $1.00\n");
        else if (getOneIngredient(5))
            orderForm.append("Extra Cheese                            $1.00\n");

        orderForm.append("Sub-Total                               " + subTotal + "\n");
        orderForm.append("Tax                                     " + tax + "\n");
        orderForm.append("--------------------------------------------------\n");
        orderForm.append("Total                                   " + total + "\n");
        orderForm.append("==================================================");

        return orderForm;
    }
}
