import behavioural.Command;
import creational.*;
import structural.WinAdapter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends javax.swing.JFrame {

    public JPanel JCalc;
    public JTextField textDisplay;
    private double total1 = 0.0;
    private final double total2 = 0.0;
    private char math_operator;
    private JButton btnDivide;
    private JButton btnOne;
    private JButton btnTwo;
    private JButton btnFour;
    private JButton btnSeven;
    private JButton btnZero;
    private JButton btnThree;
    private JButton btnFive;
    private JButton btnEight;
    private JButton btnPoint;
    private JButton btnPlus;
    private JButton btnSix;
    private JButton btnNine;
    private JButton btnClear;
    private JButton btnMinus;
    private JButton btnMultiply;
    private JButton btnEquals;

    public Calculator() {
        JFrame frm = this;



//        btnOne.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                executeCommand(new InputButtonCommand(frm, btnOne, textDisplay));
//            }
//        });
//
//                btnOne.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String btnOneText = textDisplay.getText() + btnOne.getText();
//                textDisplay.setText(btnOneText);
//
//            }
//        });
//        btnTwo.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String btnTwoText = textDisplay.getText() + btnTwo.getText();
//                textDisplay.setText(btnTwoText);
//
//            }
//        });
//        btnThree.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String btnThreeText = textDisplay.getText() + btnThree.getText();
//                textDisplay.setText(btnThreeText);
//
//            }
//        });
//        btnFour.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String btnFourText = textDisplay.getText() + btnFour.getText();
//                textDisplay.setText(btnFourText);
//
//            }
//        });
//        btnFive.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String btnFiveText = textDisplay.getText() + btnFive.getText();
//                textDisplay.setText(btnFiveText);
//
//            }
//        });
//        btnSix.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String btnSixText = textDisplay.getText() + btnSix.getText();
//                textDisplay.setText(btnSixText);
//
//            }
//        });
//        btnSeven.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String btnSevenText = textDisplay.getText() + btnSeven.getText();
//                textDisplay.setText(btnSevenText);
//
//            }
//        });
//        btnEight.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String btnEightText = textDisplay.getText() + btnEight.getText();
//                textDisplay.setText(btnEightText);
//
//            }
//        });
//        btnNine.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String btnNineText = textDisplay.getText() + btnNine.getText();
//                textDisplay.setText(btnNineText);
//
//            }
//        });
//        btnZero.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String btnZeroText = textDisplay.getText() + btnZero.getText();
//                textDisplay.setText(btnZeroText);
//            }
//        });
//
//        btnPoint.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (textDisplay.getText().equals("")) {
//                    textDisplay.setText("0.");
//                } else if (textDisplay.getText().contains(".")) {
//                    btnPoint.setEnabled(false);
//                } else {
//                    String btnPointText = textDisplay.getText() + btnPoint.getText();
//                    textDisplay.setText(btnPointText);
//                }
//                btnPoint.setEnabled(true);
//            }
//        });
//
//        btnPlus.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String button_text = btnPlus.getText();
//                getOperator(button_text);
//
//            }
//        });
//        btnEquals.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                switch (math_operator){
//                    case '+':
//                        total2 = total1 + Double.parseDouble(textDisplay.getText());
//                        break;
//                    case '-':
//                        total2 = total1 - Double.parseDouble(textDisplay.getText());
//                        break;
//                    case '/':
//                        total2 = total1 / Double.parseDouble(textDisplay.getText());
//                        break;
//                    case '*':
//                        total2 = total1 * Double.parseDouble(textDisplay.getText());
//                        break;
//
//                }
//
//                textDisplay.setText(Double.toString(total2));
//                total1 = 0;
//
//            }
//        });
//
//        btnClear.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                total2 = 0;
//                textDisplay.setText("");
//            }
//        });
//
//        btnMinus.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String button_text = btnMinus.getText();
//                getOperator(button_text);
//            }
//        });
//
//        btnDivide.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String button_text = btnDivide.getText();
//                getOperator(button_text);
//            }
//        });
//
//        btnMultiply.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String button_text = btnMultiply.getText();
//                getOperator(button_text);
//            }
//        });

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

    private void executeCommand(Command command) {
        // We could keep a command history in a stack here
        command.Execute();
    }

    public void getOperator(String btnText) {
        math_operator = btnText.charAt(0);
        total1 += Double.parseDouble(textDisplay.getText());
        textDisplay.setText("");

    }
}

class InputButtonCommand implements Command {
    private final JFrame parent;
    private final JButton button;
    private final JTextField textField;

    public InputButtonCommand(JFrame parent, JButton button, JTextField textField) {
        this.parent = parent;
        this.button = button;
        this.textField = textField;
    }

    @Override
    public void Execute() {
        String btnText = textField.getText() + button.getText();
        textField.setText(btnText);

    }
}

