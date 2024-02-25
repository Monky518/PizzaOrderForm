import javax.swing.*;
import java.awt.*;

public class Menu
{
    public JTextArea createMenu()
    {
        JTextArea menuForm = new JTextArea(15,50);
        menuForm.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        menuForm.setEditable(false);
        menuForm.append("==================================================\n");
        menuForm.append("Pizza Size Pricing:\n");
        menuForm.append("   Small                                     $8.00\n");
        menuForm.append("   Medium                                   $12.00\n");
        menuForm.append("   Large                                    $16.00\n");
        menuForm.append("   Extra Large                              $20.00\n");
        menuForm.append("Ingredients $1.00 Each:\n");
        menuForm.append("   Pepperoni                Sausage               \n");
        menuForm.append("   Black Olives             Banana Peppers        \n");
        menuForm.append("   Mushrooms                Extra Cheese          \n");
        menuForm.append("==================================================\n");
        return menuForm;
    }
}