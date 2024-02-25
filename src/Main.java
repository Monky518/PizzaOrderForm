import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Arrays;

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

        final double[] subTotal = {0.00};
        final double[] tax = {0.00};
        final double[] total = {0.00};

        Receipt currentOrder = new Receipt();
        JFrame mainFrame = new Frame();
        JPanel pizzaSizeCrustPanel = new JPanel();
        JPanel ingredientPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel menuPanel = new JPanel();
        menuPanel.add(new Menu().createMenu());
        JPanel receiptPanel = new JPanel();
        JTextArea receiptText = currentOrder.createReceipt(subTotal[0], tax[0], total[0]);
        receiptPanel.add(receiptText);

        // set up button panel
        JButton orderButton = new JButton("Order");
        buttonPanel.add(orderButton);
        JButton clearButton = new JButton("Clear");
        buttonPanel.add(clearButton);
        JButton quitButton = new JButton("Quit");
        buttonPanel.add(quitButton);

        // set up frame
        mainFrame.setLayout(new GridLayout(4,1));
        mainFrame.add(menuPanel);
        mainFrame.add(pizzaSizeCrustPanel);
        mainFrame.add(ingredientPanel);
        mainFrame.add(buttonPanel);

        // select pizza size
        JComboBox pizzaSize = new JComboBox(new String[]{"Small", "Medium", "Large", "Extra Large"});
        pizzaSizeCrustPanel.add(pizzaSize);

        // select pizza crust
        ButtonGroup group = new ButtonGroup();
        JRadioButton thinCrust = new JRadioButton("Thin Crust");
        group.add(thinCrust);
        pizzaSizeCrustPanel.add(thinCrust);
        JRadioButton regularCrust = new JRadioButton("Regular Crust", true);
        group.add(regularCrust);
        pizzaSizeCrustPanel.add(regularCrust);
        JRadioButton deepDishCrust = new JRadioButton("Deep-Dish Crust");
        group.add(deepDishCrust);
        pizzaSizeCrustPanel.add(deepDishCrust);

        // add ingredients
        JCheckBox pepperoni = new JCheckBox("Pepperoni");
        ingredientPanel.add(pepperoni);
        JCheckBox sausage = new JCheckBox("Sausage");
        ingredientPanel.add(sausage);
        JCheckBox blackOlives = new JCheckBox("Black Olives");
        ingredientPanel.add(blackOlives);
        JCheckBox bananaPeppers = new JCheckBox("Banana Peppers");
        ingredientPanel.add(bananaPeppers);
        JCheckBox mushrooms = new JCheckBox("Mushrooms");
        ingredientPanel.add(mushrooms);
        JCheckBox extraCheese = new JCheckBox("Extra Cheese");
        ingredientPanel.add(extraCheese);

        // button actions
        orderButton.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    System.out.print("Checking for pizza size, ");

                    if (String.valueOf(pizzaSize.getSelectedItem()).equalsIgnoreCase("Small"))
                    {
                        currentOrder.setPizzaSize(Order.size.small);
                        subTotal[0] += 8.00;
                    }
                    else if (String.valueOf(pizzaSize.getSelectedItem()).equalsIgnoreCase("Medium"))
                    {
                        currentOrder.setPizzaSize(Order.size.medium);
                        subTotal[0] += 12.00;
                    }
                    else if (String.valueOf(pizzaSize.getSelectedItem()).equalsIgnoreCase("Large"))
                    {
                        currentOrder.setPizzaSize(Order.size.large);
                        subTotal[0] += 16.00;
                    }
                    else if (String.valueOf(pizzaSize.getSelectedItem()).equalsIgnoreCase("Extra Large"))
                    {
                        currentOrder.setPizzaSize(Order.size.extraLarge);
                        subTotal[0] += 20.00;
                    }

                    System.out.println(currentOrder.getPizzaSize().toString());
                    System.out.print("Checking for pizza crust, ");

                    if (thinCrust.isSelected())
                        currentOrder.setPizzaCrust(Order.crust.thin);
                    else if (regularCrust.isSelected())
                        currentOrder.setPizzaCrust(Order.crust.regular);
                    else if (deepDishCrust.isSelected())
                        currentOrder.setPizzaCrust(Order.crust.deepDish);

                    System.out.println(currentOrder.getPizzaCrust().toString());
                    System.out.print("Checking for ingredients ");

                    if (pepperoni.isSelected())
                    {
                        currentOrder.setOneIngredient(0, true);
                        subTotal[0] += 1.00;
                    }
                    if (sausage.isSelected())
                    {
                        currentOrder.setOneIngredient(1, true);
                        subTotal[0] += 1.00;
                    }
                    if (blackOlives.isSelected())
                    {
                        currentOrder.setOneIngredient(2, true);
                        subTotal[0] += 1.00;
                    }
                    if (bananaPeppers.isSelected())
                    {
                        currentOrder.setOneIngredient(3, true);
                        subTotal[0] += 1.00;
                    }
                    if (mushrooms.isSelected())
                    {
                        currentOrder.setOneIngredient(4, true);
                        subTotal[0] += 1.00;
                    }
                    if (extraCheese.isSelected())
                    {
                        currentOrder.setOneIngredient(5, true);
                        subTotal[0] += 1.00;
                    }

                    System.out.println(Arrays.toString(currentOrder.getIngredients()));
                    System.out.print("Checking price ");

                    tax[0] = subTotal[0] * 0.07;
                    total[0] = subTotal[0] * 1.07;

                    subTotal[0] = Double.parseDouble(new DecimalFormat("0.00").format(subTotal[0]));
                    tax[0] = Double.parseDouble(new DecimalFormat("0.00").format(tax[0]));
                    total[0] = Double.parseDouble(new DecimalFormat("0.00").format(total[0]));

                    System.out.println(subTotal[0] + " | " + tax[0] + " | " + total[0]);

                    mainFrame.remove(pizzaSizeCrustPanel);
                    mainFrame.remove(menuPanel);
                    mainFrame.remove(ingredientPanel);
                    mainFrame.remove(buttonPanel);

                    buttonPanel.remove(orderButton);
                    buttonPanel.remove(clearButton);

                    mainFrame.setLayout(new GridLayout(2,1));
                    JPanel completeReceipt = new JPanel();
                    completeReceipt.add(currentOrder.createReceipt(subTotal[0], tax[0], total[0]));
                    mainFrame.add(completeReceipt);
                    mainFrame.add(buttonPanel);

                    mainFrame.invalidate();
                    mainFrame.validate();
                    mainFrame.repaint();
                }
            }
        );

        clearButton.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    pizzaSize.setSelectedItem("Small");
                    regularCrust.setSelected(true);
                    pepperoni.setSelected(false);
                    sausage.setSelected(false);
                    blackOlives.setSelected(false);
                    bananaPeppers.setSelected(false);
                    mushrooms.setSelected(false);
                    extraCheese.setSelected(false);
                }
            }
        );

        quitButton.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    int input = JOptionPane.showConfirmDialog(null, "Sure you want to quit?");
                    // 0=yes, 1=no, 2=cancel
                    if (input == 0)
                        System.exit(0);
                }
            }
        );
    }
}