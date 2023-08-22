package github.magyarzoli.app.fx;

import javax.swing.*;
import java.awt.*;

public class GuiButton
extends JButton {

    GuiButton(int fontSize){
        this.setText("Start");
        this.setBounds(390, 110, 80, 40);
        this.setFocusable(false);
        this.setBackground(GuiColor.BUTTON_BACKGROUND);
        this.setBorderPainted(false);
        this.setFont(new Font("OCR A Extended", Font.BOLD, fontSize));
    }
}