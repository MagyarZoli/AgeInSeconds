package github.magyarzoli.app.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Custom text field with specific properties such as edit ability, positioning, appearance, and font settings.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public class GuiTextField
extends JTextField {

    /**
     * {@code GuiTextField} this constructor is used to initialize and configure instances of this
     * {@link javax.swing.JTextField JTextField} with specific properties.
     * <ul>
     *     <li>The constructor definition for your {@code GuiTextField} class. It takes an int parameter named
     *     {@code fontSize}.</li>
     *     <li>Sets the text field as editable, allowing users to input and edit text.</li>
     *     <li>Sets the bounds (position and size) of the text field. The text field will be positioned at
     *     {@code (x=0, y=60)} with a width of <i>500</i> and a height of <i>40</i>.</li>
     *     <li>Makes the text field not focusable, which means it won't receive focus when the user interacts with it.
     *     This could be useful for display-only fields.</li>
     *     <li>Prevents the text field from automatically requesting focus when the window it's in gains focus.</li>
     *     <li>Sets an empty border for the text field, effectively removing any visible borders.</li>
     *     <li>Centers the text horizontally within the text field.</li>
     *     <li>Sets the text color of the text field to the value defined in the {@code GuiColor} class under the
     *     {@code FONT_FOREGROUND} constant.</li>
     *     <li>sets the background color of the text field to the value defined in the {@code GuiColor} class under the
     *     {@code FONT_BACKGROUND} constant.</li>
     *     <li>Sets the font of the text in the field to "OCR A Extended", with a bold style and the specified
     *     {@code fontSize}.</li>
     * </ul>
     * @param       fontSize specified font size.
     */
    GuiTextField(int fontSize) {
        this.setEditable(true);
        this.setBounds(0, 60, 500, 40);
        this.setFocusable(false);
        this.requestFocusInWindow(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setForeground(GuiColor.FONT_FOREGROUND);
        this.setBackground(GuiColor.FONT_BACKGROUND);
        this.setFont(new Font("OCR A Extended", Font.BOLD, fontSize));
    }
}