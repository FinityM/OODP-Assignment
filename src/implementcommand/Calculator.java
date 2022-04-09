package implementcommand;

import creational.*;
import structural.WinAdapter;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends javax.swing.JFrame {

    public JPanel JCalc;
    public JTextField textDisplay;
    public double total1 = 0.0;
    public double total2 = 0.0;
    public char math_operator;
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

    public Calculator() {

        btnOne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeCommand(new InputButtonCommand(JCalc, btnOne, textDisplay));
            }
        });

        btnTwo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeCommand(new InputButtonCommand(JCalc, btnTwo, textDisplay));
            }
        });

        btnThree.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeCommand(new InputButtonCommand(JCalc, btnThree, textDisplay));
            }
        });

        btnFour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeCommand(new InputButtonCommand(JCalc, btnFour, textDisplay));
            }
        });

        btnFive.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeCommand(new InputButtonCommand(JCalc, btnFive, textDisplay));
            }
        });

        btnSix.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeCommand(new InputButtonCommand(JCalc, btnSix, textDisplay));
            }
        });

        btnSeven.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeCommand(new InputButtonCommand(JCalc, btnSeven, textDisplay));
            }
        });

        btnEight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeCommand(new InputButtonCommand(JCalc, btnEight, textDisplay));
            }
        });

        btnNine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeCommand(new InputButtonCommand(JCalc, btnNine, textDisplay));
            }
        });

        btnZero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeCommand(new InputButtonCommand(JCalc, btnZero, textDisplay));
            }
        });

        btnPoint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeCommand(new InputButtonPointCommand(JCalc, btnPoint, textDisplay));
            }
        });

        btnPlus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeCommand(new InputButtonOperationCommand(JCalc, btnPlus, textDisplay, math_operator, total1));
            }
        });

        btnMinus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeCommand(new InputButtonOperationCommand(JCalc, btnMinus, textDisplay, math_operator, total1));
            }
        });

        btnMultiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeCommand(new InputButtonOperationCommand(JCalc, btnMultiply, textDisplay, math_operator, total1));
            }
        });

        btnDivide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeCommand(new InputButtonOperationCommand(JCalc, btnDivide, textDisplay, math_operator, total1));
            }
        });


        btnEquals.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeCommand(new InputButtonEqualCommand(JCalc, btnEquals, textDisplay, math_operator, total1, total2));
            }
        });

        try {
            // set look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public void getOperator(String btnText){



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
    private JPanel parent;
    private JButton button;
    private JTextField textField;

    public InputButtonCommand(JPanel parent, JButton button, JTextField textField) {
        this.parent = parent;
        this.button = button;
        this.textField = textField;
    }

    public void Execute() {
        String btnText = textField.getText() + button.getText();
        textField.setText(btnText);

    }
}

class InputButtonPointCommand implements behavioural.Command {
    private JPanel parent;
    private JButton button;
    private JTextField textField;

    public InputButtonPointCommand(JPanel parent, JButton button, JTextField textField) {
        this.parent = parent;
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
    private JPanel parent;
    private JButton button;
    private JTextField textField;
    private char equal_math_operator;
    private double total_one;
    private double total_two;

    public InputButtonEqualCommand(JPanel parent, JButton button, JTextField textField, char equal_math_operator, double total_one, double total_two) {
        this.parent = parent;
        this.button = button;
        this.textField = textField;
        this.equal_math_operator = equal_math_operator;
        this.total_one = total_one;
        this.total_two = total_two;
    }

    public void Execute() {

        switch (equal_math_operator) {
            case '+':
                total_two = total_one + Double.parseDouble(textField.getText());
                break;
            case '-':
                total_two = total_one - Double.parseDouble(textField.getText());
                break;
            case '/':
                total_two = total_one / Double.parseDouble(textField.getText());
                break;
            case '*':
                total_two = total_one * Double.parseDouble(textField.getText());
                break;

        }

        textField.setText(Double.toString(total_two));
        total_one = 0;

    }
}


class InputButtonOperationCommand implements behavioural.Command {

    private JPanel parent;
    private JButton button;
    private JTextField textField;
    private char operation_math_operator;
    private double total_one;

    public InputButtonOperationCommand(JPanel parent, JButton button, JTextField textField, char operation_math_operator, double total_one) {
        this.parent = parent;
        this.button = button;
        this.textField = textField;
        this.operation_math_operator = operation_math_operator;
        this.total_one = total_one;
    }

    @Override
    public void Execute() {
        String button_text = button.getText();
        operation_math_operator = button_text.charAt(0);
        total_one += Double.parseDouble(textField.getText());
        textField.setText("");

    }

}