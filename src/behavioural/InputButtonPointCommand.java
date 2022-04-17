package behavioural;

import javax.swing.*;

public class InputButtonPointCommand implements Command {
    private final JButton button;
    private final JTextField textField;

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
