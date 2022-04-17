/**
 * Codebase source:
 * https://www.homeandlearn.co.uk/java/java.html
 * Section 10: Java Calculator Project
 * IntelliJ Version guide found here:
 * https://youtube.com/playlist?list=PLVebSvXY44hFyJMAXmpzp9sTyupgCUaAn
 */

package calculator;

import behavioural.*;
import creational.*;
import structural.HttpsDecorator;
import structural.Url;
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
    private final MathOperators mathOperators = new MathOperators();

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

        String url = "homeandlearn.co.uk/java/java.html";

        Url source = new Url(url);

        HttpsDecorator sourcedecorate = new HttpsDecorator(new Url(url));

        System.out.println("Source of this codebase: ");
        sourcedecorate.show();

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


