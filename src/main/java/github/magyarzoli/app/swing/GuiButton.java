package github.magyarzoli.app.swing;

import javax.swing.*;
import java.awt.*;

/**
 * GuiButton class creates custom button components with specific properties, such as appearance, position, and
 * behavior. By extending JButton and providing a custom constructor, you're able to create buttons with a consistent
 * look and feel throughout your graphical user interface.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public class GuiButton
extends JButton {

    /**
     * {@code GuiButton} that extends the {@link javax.swing.JButton JButton} class. This class creates a custom button
     * with specific properties and
     * behaviors.
     * <ul>
     *     <li>The constructor definition for your {@code GuiButton} class. It takes an int parameter named
     *     {@code fontSize}.</li>
     *     <li>Sets the text of the button to "Start".</li>
     *     <li>Sets the bounds (position and size) of the button. It will be positioned at {@code (x=390, y=110)} with
     *     a width of <i>80</i> and a height of <i>40</i>.</li>
     *     <li>Makes the button not focusable, preventing it from receiving focus when the user interacts with it.</li>
     *     <li>Sets the background color of the button to the value defined in the {@code GuiColor} class under the
     *     {@code BUTTON_BACKGROUND} constant.</li>
     *     <li>Prevents the button from painting its border.</li>
     *     <li>Sets the font of the button's text to "OCR A Extended", with a bold style and the specified
     *     {@code fontSize}.</li>
     * </ul>
     * @param       fontSize specified font size.
     */
    GuiButton(int fontSize) {
        this.setText("Start");
        this.setBounds(390, 110, 80, 40);
        this.setFocusable(false);
        this.setBackground(GuiColor.BUTTON_BACKGROUND);
        this.setBorderPainted(false);
        this.setFont(new Font("OCR A Extended", Font.BOLD, fontSize));
    }
}