package github.magyarzoli.app.swing;

import javax.swing.*;
import java.awt.*;

/**
 * GuiLabel class is intended to create custom label components that share consistent properties like appearance and
 * behavior across your graphical user interface.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public class GuiLabel
extends JLabel {

    /**
     * {@code GuiLabel} that extends the {@link javax.swing.JLabel JLabel} class. This custom class provides a
     * constructor to initialize and configure instances of this custom label with specific properties.
     * <ul>
     *     <li>The constructor definition for your {@code GuiLabel} class. It takes an int parameter named
     *     {@code fontSize}.</li>
     *     <li>Makes the label not focusable, meaning it won't receive focus when the user interacts with it.</li>
     *     <li>Prevents the label from automatically requesting focus when the window it's in gains focus.</li>
     *     <li>Sets an empty border for the label, effectively removing any visible borders.</li>
     *     <li>Sets the horizontal alignment of the label's text to centered.</li>
     *     <li>Sets the text color of the label to the value defined in the {@code GuiColor} class under the
     *     {@code FONT_FOREGROUND} constant.</li>
     *     <li>Sets the background color of the label to the value defined in the {@code GuiColor} class under the
     *     {@code FONT_BACKGROUND} constant.</li>
     *     <li>Sets the font of the label's text to "OCR A Extended", with a bold style and the specified
     *     {@code fontSize}.</li>
     * </ul>
     * @param       fontSize specified font size.
     */
    GuiLabel(int fontSize) {
        this.setFocusable(false);
        this.requestFocusInWindow(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setForeground(GuiColor.FONT_FOREGROUND);
        this.setBackground(GuiColor.FONT_BACKGROUND);
        this.setFont(new Font("OCR A Extended", Font.BOLD, fontSize));
    }
}