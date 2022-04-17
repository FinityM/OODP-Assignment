package codebase; /**
 * Codebase source:
 * https://www.homeandlearn.co.uk/java/java.html
 * Section 10: Java Calculator Project
 */

import calculator.Calculator;
import structural.WinAdapter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorCodebase extends javax.swing.JFrame {

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

    public CalculatorCodebase() {

        btnOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnOneText = textDisplay.getText() + btnOne.getText();
                textDisplay.setText(btnOneText);

            }
        });

        btnTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnTwoText = textDisplay.getText() + btnTwo.getText();
                textDisplay.setText(btnTwoText);

            }
        });
        btnThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnThreeText = textDisplay.getText() + btnThree.getText();
                textDisplay.setText(btnThreeText);

            }
        });
        btnFour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnFourText = textDisplay.getText() + btnFour.getText();
                textDisplay.setText(btnFourText);

            }
        });
        btnFive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnFiveText = textDisplay.getText() + btnFive.getText();
                textDisplay.setText(btnFiveText);

            }
        });
        btnSix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnSixText = textDisplay.getText() + btnSix.getText();
                textDisplay.setText(btnSixText);

            }
        });
        btnSeven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnSevenText = textDisplay.getText() + btnSeven.getText();
                textDisplay.setText(btnSevenText);

            }
        });
        btnEight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnEightText = textDisplay.getText() + btnEight.getText();
                textDisplay.setText(btnEightText);

            }
        });
        btnNine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnNineText = textDisplay.getText() + btnNine.getText();
                textDisplay.setText(btnNineText);

            }
        });
        btnZero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnZeroText = textDisplay.getText() + btnZero.getText();
                textDisplay.setText(btnZeroText);
            }
        });

        btnPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String button_text = btnPlus.getText();
                getOperator(button_text);

            }
        });
        btnEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (math_operator) {
                    case '+':
                        total2 = total1 + Double.parseDouble(textDisplay.getText());
                        break;
                    case '-':
                        total2 = total1 - Double.parseDouble(textDisplay.getText());
                        break;
                    case '/':
                        total2 = total1 / Double.parseDouble(textDisplay.getText());
                        break;
                    case '*':
                        total2 = total1 * Double.parseDouble(textDisplay.getText());
                        break;

                }

                textDisplay.setText(Double.toString(total2));
                total1 = 0;

            }
        });

        btnMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String button_text = btnMinus.getText();
                getOperator(button_text);
            }
        });

        btnDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String button_text = btnDivide.getText();
                getOperator(button_text);
            }
        });

        btnMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String button_text = btnMultiply.getText();
                getOperator(button_text);
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                total2 = 0;
                textDisplay.setText("");
            }
        });

        btnPoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textDisplay.getText().equals("")) {
                    textDisplay.setText("0.");
                } else if (textDisplay.getText().contains(".")) {
                    btnPoint.setEnabled(false);
                } else {
                    String btnPointText = textDisplay.getText() + btnPoint.getText();
                    textDisplay.setText(btnPointText);
                }
                btnPoint.setEnabled(true);
            }
        });

        try {
            // set look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public static void main(String[] args) {

        WinAdapter wapp = new WinAdapter();
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().JCalc);
        frame.pack();
        frame.setVisible(true);
        frame.addWindowListener(wapp);


    }

    public void getOperator(String btnText) {

        math_operator = btnText.charAt(0);
        total1 += Double.parseDouble(textDisplay.getText());
        textDisplay.setText("");

    }

}






