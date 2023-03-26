import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;

import MZ.MZElapsedSeconds;
import MZ.MZNumberConvert;

public class Age
extends MZElapsedSeconds{
    private JTextField textNumber;
    private JTextField textNumberName1;
    private JTextField textNumberName2;
    private JTextField textNumberName3;
    private JTextField textNumberName4;
    
    private MZNumberConvert numberConvert = new MZNumberConvert(".");

    public Age(
        SimpleDateFormat simpleDateFormat,
        JTextField textNumber,
        JTextField textNumberName1,
        JTextField textNumberName2,
        JTextField textNumberName3,
        JTextField textNumberName4
    ){
        super(simpleDateFormat);
        this.textNumber=textNumber;
        this.textNumberName1=textNumberName1;
        this.textNumberName2=textNumberName2;
        this.textNumberName3=textNumberName3;
        this.textNumberName4=textNumberName4;
    }

    @Override
    public void runAge(){
        textNumber.setText(new DecimalFormat().format(Integer.parseInt(resultOut())));
        BigInteger bigInteger = new BigInteger(resultOut());
        String[] splitArray = (numberConvert.conversionNumberName(bigInteger, "hu")).split("[.]");
        splitText(splitArray);
    }

    private void splitText(String[] splitArray){
        switch(splitArray.length){
            case 1:
                textNumberName1.setText("");
                textNumberName2.setText("");
                textNumberName3.setText("");
                textNumberName4.setText(splitArray[0]);
            break;
            case 2:
                textNumberName1.setText("");
                textNumberName2.setText("");
                textNumberName3.setText("");
                textNumberName4.setText(splitArray[0]+splitArray[1]);
            break;
            case 3:
                textNumberName1.setText("");
                textNumberName2.setText("");
                textNumberName3.setText(splitArray[0]+splitArray[1]);
                textNumberName4.setText(splitArray[2]);
            break;
            case 4:
                textNumberName1.setText("");
                textNumberName2.setText(splitArray[0]+splitArray[1]);
                textNumberName3.setText(splitArray[2]);
                textNumberName4.setText(splitArray[3]);
            break;
            case 5:
                textNumberName1.setText(splitArray[0]+splitArray[1]);
                textNumberName2.setText(splitArray[2]);
                textNumberName3.setText(splitArray[3]);
                textNumberName4.setText(splitArray[4]);
            break;
            default:
                textNumberName1.setText("");
                textNumberName2.setText("");
                textNumberName3.setText("");
                textNumberName4.setText(splitArray[0]);
            break;
        }
    }
}