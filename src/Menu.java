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
        menuForm.append("--------------------------------------------------\n");
        menuForm.append("Ingredients:\n");
        menuForm.append("   Pepperoni                                 $8.00\n");
        menuForm.append("   Sausage                                   $8.00\n");
        menuForm.append("   Black Olives                              $8.00\n");
        menuForm.append("   Banana Peppers                            $8.00\n");
        menuForm.append("   Mushrooms                                 $8.00\n");
        menuForm.append("   Extra Cheese                              $8.00\n");
        menuForm.append("==================================================\n");
        return menuForm;
    }
}