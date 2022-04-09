package calculator;

import behavioural.Command;
import creational.*;
import structural.WinAdapter;
import javax.swing.*;

public class Calculator extends javax.swing.JFrame {

    public JPanel JCalc;
    public JTextField textDisplay;
    public JButton btnDivide;
    public JButton btnOne;
    public JButton btnTwo;
    public JButton btnFour;
    public JButton btnSeven;
    public JButton btnZero;
    public JButton btnThree;
    public JButton btnFive;
    public JButton btnEight;
    public JButton btnPoint;
    public JButton btnPlus;
    public JButton btnSix;
    public JButton btnNine;
    public JButton btnClear;
    public JButton btnMinus;
    public JButton btnMultiply;
    public JButton btnEquals;
    private MathOperators mathOperators = new MathOperators();

    public Calculator() {

        btnOne.addActionListener(e -> executeCommand(new InputButtonCommand(btnOne, textDisplay)));

        btnTwo.addActionListener(e -> executeCommand(new InputButtonCommand(btnTwo, textDisplay)));

        btnThree.addActionListener(e -> executeCommand(new InputButtonCommand(btnThree, textDisplay)));

        btnFour.addActionListener(e -> executeCommand(new InputButtonCommand(btnFour, textDisplay)));

        btnFive.addActionListener(e -> executeCommand(new InputButtonCommand(btnFive, textDisplay)));

        btnSix.addActionListener(e -> executeCommand(new InputButtonCommand(btnSix, textDisplay)));

        btnSeven.addActionListener(e -> executeCommand(new InputButtonCommand(btnSeven, textDisplay)));

        btnEight.addActionListener(e -> executeCommand(new InputButtonCommand(btnEight, textDisplay)));

        btnNine.addActionListener(e -> executeCommand(new InputButtonCommand(btnNine, textDisplay)));

        btnZero.addActionListener(e -> executeCommand(new InputButtonCommand(btnZero, textDisplay)));

        btnClear.addActionListener(e -> executeCommand(new InputButtonClearCommand(textDisplay, mathOperators)));

        btnPoint.addActionListener(e -> executeCommand(new InputButtonPointCommand(btnPoint, textDisplay)));

        btnPlus.addActionListener(e -> executeCommand(new InputButtonOperationCommand(btnPlus, textDisplay, mathOperators)));

        btnMinus.addActionListener(e -> executeCommand(new InputButtonOperationCommand(btnMinus, textDisplay, mathOperators)));

        btnMultiply.addActionListener(e -> executeCommand(new InputButtonOperationCommand(btnMultiply, textDisplay, mathOperators)));

        btnDivide.addActionListener(e -> executeCommand(new InputButtonOperationCommand(btnDivide, textDisplay, mathOperators)));

        btnEquals.addActionListener(e -> executeCommand(new InputButtonEqualCommand(textDisplay, mathOperators)));

        try {
            // set look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        GUIBuilder builder = new GUIBuilder();

        AbstractWidgetFactory widgetFactory = null;

        //check what platform we're on
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            widgetFactory = new MacOSXWidgetFactory();
        } else if (System.getProperty("os.name").toLowerCase().contains("unix")) {
            widgetFactory = new UnixWindowsWidgetFactory();
        } else {
            widgetFactory = new MsWindowsWidgetFactory();
        }
        builder.buildWindow(widgetFactory, "New Window");

        WinAdapter wapp = new WinAdapter();
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().JCalc);
        frame.pack();
        frame.setVisible(true);
        frame.addWindowListener(wapp);


    }

    private void executeCommand(behavioural.Command command) {
        // We could keep a command history in a stack here
        command.Execute();
    }

}

class InputButtonCommand implements behavioural.Command {
    private JButton button;
    private JTextField textField;

    public InputButtonCommand(JButton button, JTextField textField) {
        this.button = button;
        this.textField = textField;
    }

    public void Execute() {
        String btnText = textField.getText() + button.getText();
        textField.setText(btnText);

    }
}

class InputButtonPointCommand implements behavioural.Command {
    private JButton button;
    private JTextField textField;

    public InputButtonPointCommand(JButton button, JTextField textField) {
        this.button = button;
        this.textField = textField;
    }

    public void Execute() {
        if (textField.getText().equals("")) {
            textField.setText("0.");
        } else if (textField.getText().contains(".")) {
            button.setEnabled(false);
        } else {
            String btnPointText = textField.getText() + textField.getText();
            textField.setText(btnPointText);
        }
        button.setEnabled(true);

    }
}

class InputButtonEqualCommand implements behavioural.Command {
    private JTextField textField;
    private MathOperators mo;

    public InputButtonEqualCommand(JTextField textField, MathOperators mo) {
        this.textField = textField;
        this.mo = mo;
    }

    public void Execute() {
        char math_operator = mo.getMath_operator();
        System.out.println("Current operation: " + math_operator);

        switch (math_operator) {
            case '+':
                mo.total2 = mo.total1 + Double.parseDouble(textField.getText());
                break;
            case '-':
                mo.total2 = mo.total1 - Double.parseDouble(textField.getText());
                break;
            case '/':
                mo.total2 = mo.total1  / Double.parseDouble(textField.getText());
                break;
            case '*':
                mo.total2 = mo.total1 * Double.parseDouble(textField.getText());
                break;

        }

        System.out.println("Values stored: total1 total2: " + mo.total1 + " " + mo.total2);

        textField.setText(Double.toString(mo.total2));
        mo.total1 = 0;

    }
}


class InputButtonOperationCommand implements behavioural.Command {

    private JButton button;
    private JTextField textField;
    private MathOperators mo;

    public InputButtonOperationCommand(JButton button, JTextField textField, MathOperators mo) {
        this.button = button;
        this.textField = textField;
        this.mo = mo;
    }

    public void Execute() {
        String button_text = button.getText();
        mo.getOperator(button_text, textField);
    }

}

class InputButtonClearCommand implements Command {
    private JTextField textField;
    private MathOperators mo;

    public InputButtonClearCommand(JTextField textField, MathOperators mo) {
        this.textField = textField;
        this.mo = mo;
    }

    public void Execute() {
        mo.total2 = 0;
        textField.setText("");

    }
}