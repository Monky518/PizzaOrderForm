import javax.swing.*;
import java.awt.*;

public class Main
{
    public static void main(String[] args)
    {
        // show items, choices, and cost
            // textArea, scrollPane
        // select food and press order button
            // checkBox, radioButton, comboBoxComponents
                // radioButton selects crust (thin, regular, deep-dish)
                // comboBox selects size (small, medium, large, super / 8, 12, 16, 20)
                // checkBox selects toppings (custom / 1 each)
                // panel shows previous items with display header (similar to receipt template)
                // panel with order, clear, and quit buttons
        // order button
            // show receipt
                // ===
                // crust and size : price
                // ingredient : price
                // sub-total : amount
                // tax : amount
                // ---
                // total : amount
                // ===
        // clear button
            // clear and reset
        // quit button
            // optionPane.confirmMessageDialog before quitting

        Receipt currentOrder = new Receipt();
        JFrame mainFrame = new Frame();
        JPanel displayPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        double subTotal = 0.0;
        double tax = 0.0;
        double total = 0.0;

        // set up button panel
        JButton orderButton = new JButton("Order");
        JButton clearButton = new JButton("Clear");
        JButton quitButton = new JButton("Quit");
        buttonPanel.add(orderButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(quitButton);

        // set up frame
        mainFrame.setLayout(new GridLayout(2,2));
        mainFrame.add(displayPanel);
        mainFrame.add(new JPanel().add(new Menu().createMenu()));
        mainFrame.add(buttonPanel);
        mainFrame.add(new JPanel().add(currentOrder.createReceipt(subTotal, tax, total)));

        // select pizza size
        JComboBox pizzaSize = new JComboBox(new String[]{"Small", "Medium", "Large", "Extra Large"});
        displayPanel.add(pizzaSize);

        // select pizza crust
        ButtonGroup group = new ButtonGroup();
        JRadioButton thinCrust = new JRadioButton("Thin Crust");
        JRadioButton regularCrust = new JRadioButton("Regular Crust");
        JRadioButton deepDishCrust = new JRadioButton("Deep-Dish Crust");
        group.add(thinCrust);
        group.add(regularCrust);
        group.add(deepDishCrust);

        displayPanel.add(thinCrust);
        displayPanel.add(regularCrust);
        displayPanel.add(deepDishCrust);

        // add ingredients
        JCheckBox pepperoni = new JCheckBox("Pepperoni");
        JCheckBox sausage = new JCheckBox("Sausage");
        JCheckBox blackOlives = new JCheckBox("Black Olives");
        JCheckBox bananaPeppers = new JCheckBox("Banana Peppers");
        JCheckBox mushrooms = new JCheckBox("Mushrooms");
        JCheckBox extraCheese = new JCheckBox("Extra Cheese");

        displayPanel.add(pepperoni);
        displayPanel.add(sausage);
        displayPanel.add(blackOlives);
        displayPanel.add(bananaPeppers);
        displayPanel.add(mushrooms);
        displayPanel.add(extraCheese);

        // set values to receipt
        if (String.valueOf(pizzaSize.getSelectedItem()).equalsIgnoreCase("Small"))
            currentOrder.setPizzaSize(Order.size.small);
        else if (String.valueOf(pizzaSize.getSelectedItem()).equalsIgnoreCase("Medium"))
            currentOrder.setPizzaSize(Order.size.medium);
        else if (String.valueOf(pizzaSize.getSelectedItem()).equalsIgnoreCase("Large"))
            currentOrder.setPizzaSize(Order.size.large);
        else if (String.valueOf(pizzaSize.getSelectedItem()).equalsIgnoreCase("Extra Large"))
            currentOrder.setPizzaSize(Order.size.extraLarge);

        if (thinCrust.isSelected())
            currentOrder.setPizzaCrust(Order.crust.thin);
        else if (regularCrust.isSelected())
            currentOrder.setPizzaCrust(Order.crust.regular);
        else if (deepDishCrust.isSelected())
            currentOrder.setPizzaCrust(Order.crust.deepDish);

        if (pepperoni.isSelected())
            currentOrder.setOneIngredient(0, true);
        else if (sausage.isSelected())
            currentOrder.setOneIngredient(1, true);
        else if (blackOlives.isSelected())
            currentOrder.setOneIngredient(2, true);
        else if (bananaPeppers.isSelected())
            currentOrder.setOneIngredient(3, true);
        else if (mushrooms.isSelected())
            currentOrder.setOneIngredient(4, true);
        else if (extraCheese.isSelected())
            currentOrder.setOneIngredient(5, true);
    }
}