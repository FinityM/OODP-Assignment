package calculator;

import javax.swing.*;

/**
 * Math Operator class to handle the operators and give them easier access
 */

public class MathOperators {
    public double total1 = 0.0;
    public double total2 = 0.0;
    public char math_operator;

    public double getTotal1() {
        return total1;
    }

    public void setTotal1(double total1) {
        this.total1 = total1;
    }

    public double getTotal2() {
        return total2;
    }

    public void setTotal2(double total2) {
        this.total2 = total2;
    }

    public char getMath_operator() {
        return math_operator;
    }

    public void setMath_operator(char math_operator) {
        this.math_operator = math_operator;
    }

    public void getOperator(String btnText, JTextField textField) {
        math_operator = btnText.charAt(0);
        total1 += Double.parseDouble(textField.getText());
        textField.setText("");
    }
}
