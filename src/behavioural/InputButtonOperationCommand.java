package behavioural;

import calculator.MathOperators;

import javax.swing.*;

public class InputButtonOperationCommand implements Command {

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
