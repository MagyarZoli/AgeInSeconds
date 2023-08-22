package github.magyarzoli.app.fx;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;

@Data
@EqualsAndHashCode(callSuper = true)
public class TimePicker
extends JPanel {

    private JSpinner timeSpinner;
    private String dateFormat;
    private String timeFormat;
    private int fontSize;

    TimePicker(String dateFormat, String timeFormat, int fontSize){
        this.dateFormat = dateFormat;
        this.timeFormat = timeFormat;
        this.fontSize = fontSize;
        this.setBounds(10, 10, 470, 40);
        this.setLayout(new BorderLayout());
        timeSpinner();
        this.add(timeSpinner);
    }

    private void timeSpinner(){
        timeSpinner = new JSpinner(new SpinnerDateModel());
        timeSpinner.setEditor(new JSpinner.DateEditor(timeSpinner, dateFormat + " " + timeFormat));
        timeSpinner.setFont(new Font("OCR A Extended", Font.BOLD, fontSize));
    }

    public String selectTime(){
        return String.valueOf(new SimpleDateFormat(
                dateFormat + " " + timeFormat)
                .format(timeSpinner.getModel().getValue()));
    }
}