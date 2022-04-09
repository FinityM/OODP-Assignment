package behavioural;

import javax.swing.*;

public class InputButtonCommand implements Command {
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
