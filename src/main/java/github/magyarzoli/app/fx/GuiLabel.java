package github.magyarzoli.app.fx;

import javax.swing.*;
import java.awt.*;

public class GuiLabel
extends JLabel {

    GuiLabel(int fontSize){
        this.setFocusable(false);
        this.requestFocusInWindow(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setForeground(GuiColor.FONT_FOREGROUND);
        this.setBackground(GuiColor.FONT_BACKGROUND);
        this.setFont(new Font("OCR A Extended", Font.BOLD, fontSize));
    }
}