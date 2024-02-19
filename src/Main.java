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

        double subTotal = 0.0;
        double tax = 0.0;
        double total = 0.0;

        displayPanel.add(currentOrder.createReceipt(subTotal, tax, total));
        mainFrame.add(displayPanel);
    }
}