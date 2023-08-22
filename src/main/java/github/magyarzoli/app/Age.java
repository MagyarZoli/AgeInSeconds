package github.magyarzoli.app;

import github.magyarzoli.ElapsedSeconds;
import github.magyarzoli.NumberConvert;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Age class extends ElapsedSeconds and is used for displaying and converting time durations, specifically ages, into
 * textual representations. It interacts with GUI components such as text fields and labels to present the information.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public class Age
extends ElapsedSeconds {

    /**
     * An instance of the {@code NumberConvert} class used for converting numeric values into their Hungarian textual
     * representations.
     */
    private final NumberConvert numberConvert = new NumberConvert(".");

    /**
     * A component that represents the numeric value of the time duration input.
     */
    private JTextField textNumber;

    /**
     * A component that displays the textual representation of the age.
     */
    private JLabel textLabelNumber;

    /**
     * {@code Age} constructor accepts a {@link java.text.SimpleDateFormat SimpleDateFormat}, a
     * {@link javax.swing.JTextField JTextField}, and a {@link javax.swing.JLabel JLabel}. It initializes the
     * {@code textNumber} and {@code textLabelNumber} fields using the provided GUI components.
     * @param       simpleDateFormat SimpleDateFormat is a concrete class for formatting and parsing dates in a
     *              locale-sensitive manner
     * @param       textNumber provided text number.
     * @param       textLabelNumber provided text label number.
     */
    public Age(SimpleDateFormat simpleDateFormat, JTextField textNumber, JLabel textLabelNumber) {
        super(simpleDateFormat);
        this.textNumber = textNumber;
        this.textLabelNumber = textLabelNumber;
    }

    /**
     * {@code Age} constructor accepts a {@link java.text.SimpleDateFormat SimpleDateFormat}, a string representation of
     * a number, and a string for the label. It creates new GUI components using the provided values and initializes the
     * fields.
     * @param       simpleDateFormat SimpleDateFormat is a concrete class for formatting and parsing dates in a
     *              locale-sensitive manner.
     * @param       textNumber provided text number.
     * @param       textLabelNumber provided text label number.
     */
    public Age(SimpleDateFormat simpleDateFormat, String textNumber, String textLabelNumber) {
        super(simpleDateFormat);
        this.textNumber = new JTextField(textNumber);
        this.textLabelNumber = new JLabel(textLabelNumber);
    }

    /**
     * Accessors and mutators for the {@code textNumber} field.
     * @return      new JTextField set text textNumber.
     */
    public JTextField getTextNumber() {
        return textNumber;
    }

    /**
     * Accessors and mutators for the {@code textNumber} field.
     * @param       textNumber provided text number.
     */
    public void setTextNumber(JTextField textNumber) {
        this.textNumber = textNumber;
    }

    /**
     * Accessors and mutators for the {@code textLabelNumber} field.
     * @return      new JLabel set text number.
     */
    public JLabel getTextLabelNumber() {
        return textLabelNumber;
    }

    /**
     * Accessors and mutators for the {@code textLabelNumber} field.
     * @param       textLabelNumber provided text number.
     */
    public void setTextLabelNumber(JLabel textLabelNumber) {
        this.textLabelNumber = textLabelNumber;
    }

    /**
     * The {@code run} method the run method from the parent class {@code ElapsedSeconds}. It calculates the age or time
     * duration, converts it into a numeric value, updates a {@link javax.swing.JTextField JTextField} component with
     * the numeric representation, and then displays the Hungarian textual representation of the age in a
     * {@link javax.swing.JLabel JLabel} component.
     * <ul>
     *     <li>The method starts by calling the parent class's {@code run} method using {@code super.run()}. This is
     *     presumably used to calculate and obtain the result of the elapsed seconds.</li>
     *     <li>The result of the calculation is obtained as a string using the {@code getResultOut} method and then
     *     parsed into a {@code long} using {@link java.lang.Long#parseLong(String) parseLong()}.</li>
     *     <li>The {@code storingLong} variable holds the parsed numeric value.</li>
     *     <li>The {@code textNumber} component, which is a {@code JTextField}, is updated with the numeric value using
     *     the {@link javax.swing.JTextField#setText(String) setText} method. The numeric value is formatted using new
     *     {@link java.text.DecimalFormat#DecimalFormat() DecimalFormat()}.{@link java.text.NumberFormat#format(long)
     *     format}{@code (storingLong)} to add commas as thousand separators.</li>
     *     <li>The {@code numberConvert} instance's {@code conversionNumberName} method is called to get the Hungarian
     *     textual representation of the {@code storingLong} value. The result is then split using
     *     {@link java.lang.String#split(String) split}{@code ("\\.")} to separate the integral and fractional parts of
     *     the textual representation.</li>
     *     <li>The {@code splitText} method is called with the split array to format and display the Hungarian textual
     *     representation of the age in the {@code textLabelNumber} component. The method handles different cases based
     *     on the length of the split array, adding line breaks and HTML formatting as necessary.</li>
     * </ul>
     * The {@code run} method performs the following steps calculates the elapsed seconds, converts the result into a
     * numeric value, updates a {@code JTextField} with the numeric value, and displays the Hungarian textual
     * representation of the age in a {@code JLabel} component with appropriate formatting.
     * @see         github.magyarzoli.ElapsedSeconds#getResultOut() getResultOut()
     * @see         github.magyarzoli.app.Age#splitText(String[]) splitText(String[])
     * @see         github.magyarzoli.NumberConvert#conversionNumberName(long, String)
     *              conversionNumberName(long, String)
     */
    @Override
    public void run(){
        super.run();
        long storingLong = Long.parseLong(getResultOut());
        textNumber.setText(new DecimalFormat().format(storingLong));
        splitText(numberConvert.conversionNumberName(storingLong, "hu").split("\\."));
    }

    /**
     * {@code splitText} method takes an array of strings representing split parts of the textual representation of an
     * age and formats them for display in a {@link javax.swing.JLabel JLabel} component. The method adds line breaks
     * {@code <br>} between the parts to ensure proper formatting.
     * <ul>
     *     <li>The {@code switch} statement checks the length of the splitArray and performs different actions based on
     *     its length.</li>
     *     <li>The {@code textLabelNumber}'s text is set using the {@code setText} method, and the content is provided
     *     by a call to the {@code htmlText} method.</li>
     *     <li>The content of the {@code htmlText} method call includes the split parts of the age and optional
     *     {@code <br>} tags for line breaks.</li>
     *     <li>In the {@code default} case: If the {@code splitArray} contains only one element (which is the case for
     *     small numbers), the method sets the {@code textLabelNumber}'s text using the {@code htmlText} method with
     *     only the first split part.</li>
     * </ul>
     * {@code splitText} method takes the split parts of the textual representation of an age and formats them for
     * display in a {@code JLabel} component. It handles different cases based on the number of split parts and adds
     * line breaks between parts to achieve a visually appealing presentation. This method is part of the logic that
     * visually represents the converted age in the graphical user interface.
     * @param       splitArray that represents the split parts of the textual representation of an age.
     * @see         github.magyarzoli.app.Age#htmlText(String...) htmlText(String...)
     */
    private void splitText(String[] splitArray) {
        switch (splitArray.length) {
            case 2 -> textLabelNumber.setText(htmlText(
                    splitArray[0], splitArray[1]));
            case 3 -> textLabelNumber.setText(htmlText(
                    splitArray[0], splitArray[1], "<br>",
                    splitArray[2]));
            case 4 -> textLabelNumber.setText(htmlText(
                    splitArray[0], splitArray[1], "<br>",
                    splitArray[2], "<br>",
                    splitArray[3]));
            case 5 -> textLabelNumber.setText(htmlText(
                    splitArray[0], splitArray[1], "<br>",
                    splitArray[2], "<br>",
                    splitArray[3], "<br>",
                    splitArray[4]));
            default -> textLabelNumber.setText(htmlText(
                    splitArray[0]));
        }
    }

    /**
     * {@code htmlText} method is a utility method that takes an array of strings (or variable arguments) and returns
     * a single string formatted as an HTML block. This method is used to concatenate the provided text parts into a
     * single HTML-formatted string.
     * <ul>
     *     <li>The method is defined to accept an array of strings, indicated by {@code String... texts}. This means
     *     you can pass a variable number of string arguments to the method.</li>
     *     <li>The {@link java.util.Arrays Arrays}.{@link java.util.Arrays#stream(Object[]) stream}{@code (texts)} part
     *     converts the array of strings into a stream of strings. {@link java.util.stream.Collectors Collectors}
     *     .{@link  java.util.stream.Collectors#joining(CharSequence) joining()} is used to join the stream of strings
     *     into a single string, where each element of the stream is separated by a space.</li>
     *     <li>The concatenated string is then enclosed in HTML tags to format it as an HTML block. The {@code <html>}
     *     tag at the beginning and the {@code </html>} tag at the end indicate that the enclosed content should be
     *     treated as HTML.</li>
     *     <li>The final HTML-formatted string is returned by the method.</li>
     * </ul>
     * {@code htmlText} method allows you to take multiple strings, concatenate them with spaces in between, and format
     * the result as an HTML block. This is useful when you want to display multiple lines of text within a single HTML
     * element, such as a {@link javax.swing.JLabel JLabel} component in Swing or JavaFX.
     * @param       texts variable number of string arguments to the method.
     * @return      A single string formatted as an HTML block.
     */
    private String htmlText(String... texts) {
        return "<html>" + Arrays.stream(texts).collect(Collectors.joining(" ")) + "</html>";
    }
}