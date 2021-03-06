package behavioural;

import calculator.MathOperators;

import javax.swing.*;

public class InputButtonClearCommand implements Command {
    private final JTextField textField;
    private final MathOperators mo;

    public InputButtonClearCommand(JTextField textField, MathOperators mo) {
        this.textField = textField;
        this.mo = mo;
    }

    public void Execute() {
        mo.total2 = 0;
        textField.setText("");

    }
}
