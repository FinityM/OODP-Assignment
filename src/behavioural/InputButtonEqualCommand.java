package behavioural;

import calculator.MathOperators;

import javax.swing.*;

public class InputButtonEqualCommand implements Command {
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
                mo.total2 = mo.total1 / Double.parseDouble(textField.getText());
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
