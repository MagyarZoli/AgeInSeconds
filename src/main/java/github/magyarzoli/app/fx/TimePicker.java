package github.magyarzoli.app.fx;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;

/**
 * The TimePicker class represents a custom Swing component that provides functionality for selecting a date and time.
 * It extends the JPanel class and encapsulates the graphical user interface components required for date and time
 * selection.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TimePicker
extends JPanel {

    /**
     * A component used for selecting a date and time.
     */
    private JSpinner timeSpinner;

    /**
     * A string that holds the formatting pattern for the date.
     */
    private String dateFormat;

    /**
     * A string that holds the formatting pattern for the time.
     */
    private String timeFormat;

    /**
     * An integer that holds the font size value.
     */
    private int fontSize;

    /**
     * {@code TimePicker} This constructor initializes the properties of the {@code TimePicker} instance, sets its
     * bounds and layout, and adds the {@link javax.swing.JSpinner JSpinner} to the {@code TimePicker}.
     * <ul>
     *     <li>The constructor definition for the {@code TimePicker} class. It takes three parameters:
     *     {@code dateFormat}, {@code timeFormat}, and {@code fontSize}.</li>
     *     <li>Sets the bounds (position and size) of the {@code TimePicker} instance.</li>
     *     <li>Sets the layout manager for the {@code TimePicker} instance to {@link java.awt.BorderLayout
     *     BorderLayout}. This layout manager arranges components in five regions.</li>
     *     <li>Calls the {@code timeSpinner()} method you provided earlier. This method initializes the {@code JSpinner}
     *     with the specified properties.</li>
     *     <li>Adds the {@code JSpinner} (configured as per your requirements) to the {@code TimePicker} instance using
     *     the default {@code BorderLayout.CENTER} position.</li>
     * </ul>
     * @param       dateFormat text version of date.
     * @param       timeFormat text version of time.
     * @param       fontSize specified font size.
     * @see         github.magyarzoli.app.fx.TimePicker#timeSpinner() timeSpinner()
     */
    TimePicker(String dateFormat, String timeFormat, int fontSize){
        this.dateFormat = dateFormat;
        this.timeFormat = timeFormat;
        this.fontSize = fontSize;
        this.setBounds(10, 10, 470, 40);
        this.setLayout(new BorderLayout());
        timeSpinner();
        this.add(timeSpinner);
    }

    /**
     * {@code timeSpinner} method that creates and configures a {@link  javax.swing.JSpinner JSpinner} component to
     * display date and time values.
     * <ul>
     *     <li>This line creates a new {@code JSpinner} instance and initializes it with a
     *     {@link javax.swing.SpinnerDateModel SpinnerDateModel}. The {@code SpinnerDateModel} represents a range of
     *     dates and times that the spinner can display.</li>
     *     <li>This line sets a custom editor for the {@code JSpinner} to display both date and time. The
     *     {@link javax.swing.JSpinner.DateEditor DateEditor} class is used to format the display. The
     *     {@code dateFormat} and timeFormat are assumed to be previously defined formats for the date and time parts.
     *     The concatenated string a space is used to separate the date and time portions.</li>
     *     <li>This line sets the font for the text displayed in the {@code JSpinner} to "OCR A Extended" with a bold
     *     style and a specified font size.</li>
     * </ul>
     */
    private void timeSpinner(){
        timeSpinner = new JSpinner(new SpinnerDateModel());
        timeSpinner.setEditor(new JSpinner.DateEditor(timeSpinner, dateFormat + " " + timeFormat));
        timeSpinner.setFont(new Font("OCR A Extended", Font.BOLD, fontSize));
    }

    /**
     * {@code selectTime} method uses the {@code dateFormat} and {@code timeFormat}.
     * <ul>
     *     <li>field values to create a {@link java.text.SimpleDateFormat SimpleDateFormat} pattern and format the
     *     selected time value from the {@code timeSpinner}.</li>
     *     <li>This pattern concatenates the date and time formats with a space in between to properly format the
     *     selected date and time.</li>
     * </ul>
     * @return      As a formatted string.
     */
    public String selectTime(){
        return String.valueOf(new SimpleDateFormat(
                dateFormat + " " + timeFormat)
                .format(timeSpinner.getModel().getValue()));
    }
}