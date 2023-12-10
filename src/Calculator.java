import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

    private JTextField display;
    private double firstOperand;
    private String operator;
    private boolean isOperatorClicked;
    private boolean isEqualClicked;

    public Calculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);

        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);

        JPanel buttonPanel = createButtonPanel();

        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 4, 5, 5));

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C", "sqrt", "pow", "del"
        };

        for (String label : buttonLabels) {
            JButton button = createButton(label);
            panel.add(button);
        }

        return panel;
    }

    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.addActionListener(new ButtonClickListener());
        return button;
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String buttonText = source.getText();

            switch (buttonText) {
                case "=":
                    calculateResult();
                    break;
                case "C":
                    clearAll();
                    break;
                case "sqrt":
                    calculateSqrt();
                    break;
                case "pow":
                    setOperator("^");
                    break;
                case "del":
                    deleteLastDigit();
                    break;
                default:
                    handleDigitOrOperator(buttonText);
                    break;
            }
        }
    }

    private void handleDigitOrOperator(String buttonText) {
        if (Character.isDigit(buttonText.charAt(0)) || buttonText.equals(".")) {
            handleDigit(buttonText);
        } else {
            setOperator(buttonText);
        }
    }

    private void handleDigit(String digit) {
        if (isOperatorClicked || isEqualClicked) {
            display.setText(digit);
            isOperatorClicked = false;
            isEqualClicked = false;
        } else {
            display.setText(display.getText() + digit);
        }
    }

    private void setOperator(String newOperator) {
        if (!operator.isEmpty()) {
            calculateResult();
        }
        firstOperand = Double.parseDouble(display.getText());
        operator = newOperator;
        isOperatorClicked = true;
        isEqualClicked = false;
    }

    private void calculateResult() {
        if (!operator.isEmpty()) {
            double secondOperand = Double.parseDouble(display.getText());
            switch (operator) {
                case "+":
                    firstOperand += secondOperand;
                    break;
                case "-":
                    firstOperand -= secondOperand;
                    break;
                case "*":
                    firstOperand *= secondOperand;
                    break;
                case "/":
                    if (secondOperand != 0) {
                        firstOperand /= secondOperand;
                    } else {
                        display.setText("Error");
                        clearAll();
                        return;
                    }
                    break;
                case "^":
                    firstOperand = Math.pow(firstOperand, secondOperand);
                    break;
            }
            display.setText(String.valueOf(firstOperand));
            operator = "";
            isEqualClicked = true;
        }
    }

    private void calculateSqrt() {
        double operand = Double.parseDouble(display.getText());
        if (operand >= 0) {
            double result = Math.sqrt(operand);
            display.setText(String.valueOf(result));
            clearAll();
        } else {
            display.setText("Error");
            clearAll();
        }
    }

    private void deleteLastDigit() {
        String currentText = display.getText();
        if (!currentText.isEmpty()) {
            display.setText(currentText.substring(0, currentText.length() - 1));
        }
    }

    private void clearAll() {
        display.setText("");
        firstOperand = 0;
        operator = "";
        isOperatorClicked = false;
        isEqualClicked = false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculator().setVisible(true);
            }
        });
    }
}
