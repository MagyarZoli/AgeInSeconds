package github.magyarzoli.app.fx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Timer;

import github.magyarzoli.app.Age;

public class AgeInSeconds
extends JFrame
implements ActionListener {

    private final short Period = 1000;
    private static String dateform = "yyyy-MM-dd";
    private static String timeform = "HH:mm:ss";
    private static GuiTextField guiTextField = new GuiTextField(50);
    private static GuiLabel textLabelNumber = new GuiLabel(25);
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateform+" "+timeform);
    private Age age = new Age(simpleDateFormat, guiTextField, textLabelNumber);
    private GuiButton guiButton = new GuiButton(14);
    private TimePicker timePicker = new TimePicker(dateform, timeform, 35);

    public AgeInSeconds(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Age in Seconds");
        this.setSize(new Dimension(500,500));
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);
        this.getContentPane().setBackground(GuiColor.COMPONENT_BACKGROUND);
        new Timer().schedule(age, 0,Period);
        textLabelNumber.setBounds(0, 160, 500, 400);
        guiButton.addActionListener(this);
        this.add(timePicker);
        this.add(guiButton);
        this.add(guiTextField);
        this.add(textLabelNumber);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==guiButton){
            age.setResultIn(timePicker.selectTime());
        }
    }
}