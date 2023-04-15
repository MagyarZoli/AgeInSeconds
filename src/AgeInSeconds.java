import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Timer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;

import data.GuiColor;
import mz.ElapsedSeconds;
import mz.NumberConvert;

/**
 * On a graphical interface, the user can enter a date and after pressing the Start button, the number of seconds that have passed or not yet passed will be returned.
 * Plus, it also returns the track name in Hungarian.
 * Default date is the start time of the program.
 * Calling 2 external imports {@code ElapsedSeconds}, {@code NumberConvert}
 * @see ElapsedSeconds
 * @see NumberConvert
 * @see Age 
 * @since 1.0
 * @author <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public class AgeInSeconds
extends JFrame
implements ActionListener{

    /**
     * Specify date format,
     */
    private static String dateform = "yyyy-MM-dd";

    /**
     * Specify time format,
     */
    private static String timeform = "HH:mm:ss";

    /**
     * Displays a value calculated by age class.
     */
    private static GuiTextField guiTextField = new GuiTextField(50);

    /**
     * 
     */
    private static GuiLabel textLabelNumber = new GuiLabel(25);

    /**
     * Simple Date formatting as specified date and time format.
     */
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateform+" "+timeform);

    /**
     * Calling the Age class to calculate a value by specifying parameters
     * SimpleDateFormat is a TextField in which you write a numerical value
     * and 4 TextFields in which you write the broken number name.
     */
    private Age age = new Age(simpleDateFormat, guiTextField, ((JLabel) textLabelNumber));
    
    /**
     * 1 second step.
     */
    private final short Period = 1000;

    /**
     * Button instantiation.
     */
    private GuiButton guiButton = new GuiButton(14);

    /**
     * Instantiate spinner selector by specifying date formatting
     */
    private TimePicker timePicker = new TimePicker(dateform, timeform, 35);

    /**
     * default setting:
     * <ul>
     *  <li>window close</li>
     *  <li>enter title: "Age in Seconds"</li>
     *  <li>size 500x500</li>
     *  <li>non-resizable window</li>
     *  <li>visibility</li>
     *  <li>no layout manager</li>
     *  <li>data.GuiColor final class color scheme set for background</li>
     *  <li>timer start Age class delay no in 1 second periods</li>
     *  <li>specifying components in the frame</li>
     *  <li>add Action listener</li>
     * </ul>
     */
    public AgeInSeconds(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Age in Seconds");
        this.setSize(new Dimension(500,500));
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);
        this.getContentPane().setBackground(GuiColor.COMPONTENT_BACKGROUND);
        new Timer().schedule(age, 0,Period);
        textLabelNumber.setBounds(0, 160, 500, 400);
        guiButton.addActionListener(this);
        this.add(timePicker);
        this.add(guiButton);
        this.add(guiTextField);
        this.add(textLabelNumber);
        
    }
    
    /**
     * Monitoring the button in the inherited method,
     * if it is activated, it gives the date in the spinner selector of the TimePicker class
     * to the Age class for calculation, to return the current value to the components.
     * @see Age#setResultIn(String)
     * @see TimePicker#selectTime()
     */
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==guiButton){
            age.setResultIn(timePicker.selectTime());
        }
    }
}

/**
 * Button with which the newly selected value is recalculated.
 */
class GuiButton
extends JButton{

    /**
     * default setting:
     * <ul>
     *  <li>"Start" set as button text</li>
     *  <li>cannot be focused</li>
     *  <li>location and size</li>
     *  <li>data.GuiColor final class color scheme set for background</li>
     *  <li>border is not painted</li>
     *  <li>font type ORC A Extended and bold. By specifying the font size as a parameter.</li>
     * </ul>
     * @param fontSize
     */
    GuiButton(int fontSize){
        this.setText("Start");
        this.setBounds(390, 110, 80, 40);
        this.setFocusable(false);
        this.setBackground(GuiColor.BUTTON_BACKGROUND);
        this.setBorderPainted(false);
        this.setFont(new Font("OCR A Extended", Font.BOLD, fontSize));
    }
}

/**
 * Displays a value calculated by age class.
 */
class GuiTextField
extends JTextField{

    /**
     * By default Text Field is set:
     * <ul>
     *  <li>can be edited</li>
     *  <li>cannot be focused</li>
     *  <li>not ask for focus in the window</li>
     *  <li>location and size</li>
     *  <li>empty border</li>
     *  <li>text position centered</li>
     *  <li>data.GuiColor final class color scheme set for foreground and background</li>
     *  <li>font type ORC A Extended and bold. By specifying the font size as a parameter.</li>
     * </ul>
     * @see data.GuiColor
     * @param fontSize
     */
    GuiTextField(int fontSize){
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

/**
 * Displays a value calculated by age class.
 * And uploads the split track name.
 */
class GuiLabel
extends JLabel{

    /**
     * default set:
     * <ul>
     *  <li>cannot be edited</li>
     *  <li>cannot be focused</li>
     *  <li>not ask for focus in the window</li>
     *  <li>location and size</li>
     *  <li>empty border</li>
     *  <li>text position centered</li>
     *  <li>data.GuiColor final class color scheme set for foreground and background</li>
     *  <li>font type ORC A Extended and bold. By specifying the font size as a parameter.</li>
     * </ul>
     * @param fontSize
     */
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

/**
 * Date selection using spinner model.
 */
class TimePicker
extends JPanel{

    /**
     * A single line input field that allows the user to select a date value from an ordered series in value.
     */
    private JSpinner timeSpinner;

    /**
     * parameter value storage date formatting.
     */
    private String dateform;

    /**
     * parameter value storage time formatting.
     */
    private String timeform;

    /**
     * font size value storage.
     */
    private int fontSize;

    /**
     * default setting:
     * <ul>
     *  <li>placement and size</li>
     *  <li>Layout manager: Border Layout</li>
     * </ul>
     * Add a spinner selector to the panel.
     * @param dateform
     * @param timeform
     * @param fontSize
     */
    TimePicker(String dateform, String timeform, int fontSize){
        this.dateform=dateform;
        this.timeform=timeform;
        this.fontSize=fontSize;
        this.setBounds(10, 10, 470, 40);
        this.setLayout(new BorderLayout());
        timeSpinner();
        this.add(timeSpinner);
    }

    /**
     * A single line input field that allows the user to select a date value from an ordered series.
     * @see SpinnerModel
     * @see JSpinner
     */
    private void timeSpinner(){
        SpinnerModel timeModel = new SpinnerDateModel();
        timeSpinner = new JSpinner(timeModel);
        timeSpinner.setEditor(new JSpinner.DateEditor(timeSpinner, dateform+" "+timeform));
        timeSpinner.setFont(new Font("OCR A Extended", Font.BOLD, fontSize));
    }

    /**
     * Date selection using spinner model formatting of this value based on specified date and time format.
     * @return the formatted value of the selected date in String type.
     */
    public String selectTime(){
        return String.valueOf(new SimpleDateFormat(dateform+" "+timeform).format(timeSpinner.getModel().getValue()));
    }
}