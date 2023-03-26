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
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;

/**
 * On a graphical interface, the user can enter a date and after pressing the Start button, the number of seconds that have passed or not yet passed will be returned.
 * Plus, it also returns the track name in Hungarian.
 * Default date is the start time of the program.
 * Calling 2 external imports {@code MZElapsedSeconds}, {@code MZNumberConvert}
 * @see MZ.MZElapsedSeconds
 * @see MZ.MZNumberConvert
 * @see Age 
 * @since 1.0
 * @author <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public class GuiFrame
extends JFrame
implements ActionListener{
    private static String dateform = "yyyy-MM-dd";
    private static String timeform = "HH:mm:ss";
    private static GuiTextField guiTextField = new GuiTextField(50);
    private static GuiTextFieldNumber guiTextFieldNumber1 = new GuiTextFieldNumber(22);
    private static GuiTextFieldNumber guiTextFieldNumber2 = new GuiTextFieldNumber(22);
    private static GuiTextFieldNumber guiTextFieldNumber3 = new GuiTextFieldNumber(22);
    private static GuiTextFieldNumber guiTextFieldNumber4 = new GuiTextFieldNumber(22);
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateform+" "+timeform);
    private static Age age = new Age(simpleDateFormat, guiTextField, guiTextFieldNumber1, guiTextFieldNumber2, guiTextFieldNumber3, guiTextFieldNumber4);
    private final short Period = 1000;
    private GuiButton guiButton = new GuiButton(14);
    private TimePicker timePicker = new TimePicker(dateform, timeform, 35);

    public GuiFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("MZ Age in Seconds");
        this.setSize(new Dimension(500,500));
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);
        this.getContentPane().setBackground(GuiColor.DARK_GRAY);
        new Timer().schedule(age, 0,Period);
        guiTextFieldNumber1.setBounds(0, 160, 500, 60);
        guiTextFieldNumber2.setBounds(0, 220, 500, 60);
        guiTextFieldNumber3.setBounds(0, 280, 500, 60);
        guiTextFieldNumber4.setBounds(0, 340, 500, 60);
        guiButton.addActionListener(this);
        this.add(timePicker);
        this.add(guiButton);
        this.add(guiTextField);
        this.add(guiTextFieldNumber1);
        this.add(guiTextFieldNumber2);
        this.add(guiTextFieldNumber3);
        this.add(guiTextFieldNumber4);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==guiButton){
            age.resultInAdd(timePicker.selectTime());
        }
    }
}

class GuiButton
extends JButton{
    GuiButton(int fontSize){
        this.setText("Start");
        this.setBounds(390, 110, 80, 40);
        this.setFocusable(false);
        this.setBackground(GuiColor.LIGHT_PURPLE);
        this.setBorderPainted(false);
        this.setFont(new Font("OCR A Extended", Font.BOLD, fontSize));
    }
}

class GuiTextField
extends JTextField{
    GuiTextField(int fontSize){
        this.setEditable(true);
        this.setBounds(0, 60, 500, 40);
        this.setFocusable(false);
        this.requestFocusInWindow(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setForeground(GuiColor.ACTIVE_GRAY);
        this.setBackground(GuiColor.LIGHT_GRAY);
        this.setFont(new Font("OCR A Extended", Font.BOLD, fontSize));
    }
}

class GuiTextFieldNumber
extends JTextField{
    GuiTextFieldNumber(int fontSize){
        this.setEditable(false);
        this.setFocusable(false);
        this.requestFocusInWindow(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setForeground(GuiColor.ACTIVE_GRAY);
        this.setBackground(GuiColor.LIGHT_GRAY);
        this.setFont(new Font("OCR A Extended", Font.BOLD, fontSize));
    }
}

class TimePicker
extends JPanel{
    private JSpinner timeSpinner;
    private String dateform;
    private String timeform;
    private int fontSize;

    TimePicker(String dateform, String timeform, int fontSize){
        this.dateform=dateform;
        this.timeform=timeform;
        this.fontSize=fontSize;
        this.setBounds(10, 10, 470, 40);
        this.setLayout(new BorderLayout());
        timeSpinner();
        this.add(timeSpinner);
    }

    private void timeSpinner(){
        SpinnerModel timeModel = new SpinnerDateModel();
        timeSpinner = new JSpinner(timeModel);
        timeSpinner.setEditor(new JSpinner.DateEditor(timeSpinner, dateform+" "+timeform));
        timeSpinner.setFont(new Font("OCR A Extended", Font.BOLD, fontSize));
    }

    public String selectTime(){
        return String.valueOf(new SimpleDateFormat(dateform+" "+timeform).format(timeSpinner.getModel().getValue()));
    }
}