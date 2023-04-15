import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JTextField;

import mz.ElapsedSeconds;
import mz.NumberConvert;

/**
 * Age class inherits ElapsedSeconds date to seconds conversion.
 * Age class passes the result to the components specified in its parameters.
 */
public class Age
extends ElapsedSeconds{

    /**
     * Component for writing date values in seconds
     */
    private JTextField textNumber;

    /**
     * Date output as number name.
     */
    private JLabel textLabelNumber;

    /**
     * Variable for storing a large numerical value.
     */
    private BigInteger bigInteger;

    /**
     * Storing the split number name in an array.
     */
    private String[] splitArray;

    /**
     * Convert number distributed number "." with character.
     */
    private NumberConvert numberConvert = new NumberConvert(".");

    /**
     * Based on these components, calculate the result based on the incoming data.
     * @param simpleDateFormat
     * @param textNumber
     * @param textLabelNumber
     */
    public Age(
        SimpleDateFormat simpleDateFormat,
        JTextField textNumber,
        JLabel textLabelNumber
    ){
        super(simpleDateFormat);
        this.textNumber = textNumber;
        this.textLabelNumber = textLabelNumber;
    }

    /**
     * Override inherited method.
     * Converts incoming data into number format and then passes this to the ElapsedSeconds mentor.
     * When passed to the NumberConvert method, the number is converted to number name,
     * and the number name is divided into an array using the specified split method.
     * It is done by calling the splitText method to write out the contents of the array in components.
     * @see ElapsedSeconds#getResultOut()
     * @see NumberConvert#conversionNumberName(long, String)
     * @see Age#splitText(String[])
     * @see BigInteger
     */
    @Override
    public void run(){
        super.run();
        textNumber.setText(new DecimalFormat().format(Long.parseLong(getResultOut())));
        bigInteger = new BigInteger(getResultOut());
        splitArray = (numberConvert.conversionNumberName(bigInteger, "hu")).split("[.]");
        splitText(splitArray);
    }

    /**
     * Returns split number name with html keywords
     * @param splitArray divided number name
     */
    private void splitText(String[] splitArray){
        switch(splitArray.length){
            case 1:
            textLabelNumber.setText(
                "<html>"+
                splitArray[0]+
                "</html>"
            );
            break;
            case 2:
            textLabelNumber.setText(
                "<html>"+
                splitArray[0]+splitArray[1]+
                "</html>"
            );
            break;
            case 3:
            textLabelNumber.setText(
                "<html>"+
                splitArray[0]+splitArray[1]+"<br>"+
                splitArray[2]+
                "</html>"
            );
            break;
            case 4:
            textLabelNumber.setText(
                "<html>"+
                splitArray[0]+splitArray[1]+"<br>"+
                splitArray[2]+"<br>"+
                splitArray[3]+
                "</html>"
            );
            break;
            case 5:
            textLabelNumber.setText(
                "<html>"+
                splitArray[0]+splitArray[1]+"<br>"+
                splitArray[2]+"<br>"+
                splitArray[3]+"<br>"+
                splitArray[4]+
                "</html>"
            );
            break;
            default:
            textLabelNumber.setText(
                "<html> "
                +splitArray[0]+
                "</html>"
            );
            break;
        }
    }
}