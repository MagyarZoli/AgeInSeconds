### Age in Seconds

## Description
Determination of elapsed seconds from the date.

## Features
Allows the user to enter a date and calculate the number of seconds that have passed or not yet passed.
Returns the number and number name of the result in `Hungarian`.
Uses two external classes: ElapsedSeconds and NumberConvert.

## Image
![alt text](https://github.com/MagyarZoli/AgeInSeconds/blob/master/image/Image1.png)

## ElapsedSeconds and NumberConvert
Please note that this project uses the following external classes:

- [MZElapsedSeconds](https://github.com/MagyarZoli/ElapsedSeconds)
- [MZNumberConvert](https://github.com/MagyarZoli/NumberConvert)

For more information about these classes, please refer to their respective documentation.

## Example
The ElapsedSeconds method,
which inherits the run method from TimerTask.
It inherits this and changes its arguments to the Age class
```java
    @Override
    public void run(){
        try{
            resultout = (
                decimalFormt.format(
                    dateToSeconds(simpleDateFormat.format(Calendar.getInstance().getTime()), simpleDateFormat)-
                    dateToSeconds(resultin, simpleDateFormat)
                )
            );
        }
        catch(ParseException e){
            e.printStackTrace();
        }
    }
```
```java
    @Override
    public void run(){
        super.run();
        textNumber.setText(new DecimalFormat().format(Long.parseLong(getResultOut())));
        bigInteger = new BigInteger(getResultOut());
        splitArray = (numberConvert.conversionNumberName(bigInteger, "hu")).split("[.]");
        splitText(splitArray);
    }
```

TimePicker class method for selecting a date and passing the result as a argument to the Age class.
Using ActionListener which is implemented for GuiButton
```java
    private void timeSpinner(){
        SpinnerModel timeModel = new SpinnerDateModel();
        timeSpinner = new JSpinner(timeModel);
        timeSpinner.setEditor(new JSpinner.DateEditor(timeSpinner, dateform+" "+timeform));
        timeSpinner.setFont(new Font("OCR A Extended", Font.BOLD, fontSize));
    }

    public String selectTime(){
        return String.valueOf(new SimpleDateFormat(dateform+" "+timeform).format(timeSpinner.getModel().getValue()));
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==guiButton){
            age.setResultIn(timePicker.selectTime());
        }
    }
```

# Authors
Magyar Zoltán

# Contact
magyarz95@gmail.com
