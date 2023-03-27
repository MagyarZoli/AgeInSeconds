## Age in Seconds

## Description
Determination of elapsed seconds from the date.

## Features
Allows the user to enter a date and calculate the number of seconds that have passed or not yet passed.
Returns the number and number name of the result in `Hungarian`.
Uses two external classes: MZElapsedSeconds and MZNumberConvert.

## Image
![alt text](https://github.com/MagyarZoli/AgeInSeconds/blob/master/image/Image1.png)

Installation
To use this program, you will need to have Java installed on your computer. You can download Java from the [official Java website](https://www.java.com/en/download/).

Once you have Java installed, follow these steps to install and run the program:

Clone this repository to your local machine using the command:
```bash
git clone https://github.com/MagyarZoli/AgeInSeconds.git
```

## MZElapsedSeconds and MZNumberConvert
Please note that this project uses the following external classes:

- [MZElapsedSeconds](https://github.com/MagyarZoli/MZElapsedSeconds)
- [MZNumberConvert](https://github.com/MagyarZoli/MZNumberConvert)

For more information about these classes, please refer to their respective documentation.

## Example
The abstract method of MZElapsedSeconds,
which inherits the run method from TimerTask, is implanted into it.
It inherits this and changes its arguments to the Age class
```java
    @Override
    public void run(){
        try{
            resultout = (decimalFormt.format(dateToSeconds(simpleDateFormat.format(Calendar.getInstance().getTime()), simpleDateFormat)-dateToSeconds(resultin, simpleDateFormat)));
            runAge();
        }
        catch(ParseException e){
            e.printStackTrace();
        }
    }

    public abstract void runAge();
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
            age.resultInAdd(timePicker.selectTime());
        }
    }
```

## Authors
Magyar Zoltán

## Contact
magyarz95@gmail.com
