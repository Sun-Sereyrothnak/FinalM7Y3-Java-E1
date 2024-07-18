import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculator {
    private JFrame frame;
    private JTextField firstNumberField;
    private JTextField secondNumberField;
    private JTextField resultField;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton clearButton;

    public Calculator() {
        frame = new JFrame("Calculator");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel firstNumberLabel = new JLabel("First Number:");
        firstNumberLabel.setBounds(50, 50, 100, 35);
        frame.add(firstNumberLabel);

        firstNumberField = new JTextField();
        firstNumberField.setBounds(150, 50, 200, 35);
        frame.add(firstNumberField);

        JLabel secondNumberLabel = new JLabel("Second Number:");
        secondNumberLabel.setBounds(50, 100, 100, 35);
        frame.add(secondNumberLabel);

        secondNumberField = new JTextField();
        secondNumberField.setBounds(150, 100, 200, 35);
        frame.add(secondNumberField);

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(50, 150, 100, 35);
        frame.add(resultLabel);

        resultField = new JTextField();
        resultField.setBounds(150, 150, 200, 35);
        resultField.setEditable(false);
        frame.add(resultField);

        addButton = new JButton("+");
        addButton.setBounds(50, 200, 50, 25);
        frame.add(addButton);

        subtractButton = new JButton("-");
        subtractButton.setBounds(110, 200, 50, 25);
        frame.add(subtractButton);

        multiplyButton = new JButton("*");
        multiplyButton.setBounds(170, 200, 50, 25);
        frame.add(multiplyButton);

        divideButton = new JButton("/");
        divideButton.setBounds(230, 200, 50, 25);
        frame.add(divideButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(290, 200, 70, 25);
        frame.add(clearButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation('+');
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation('-');
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation('*');
            }
        });

        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation('/');
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        frame.setVisible(true);
    }

    private void performOperation(char operation) {
        try {
            double num1 = Double.parseDouble(firstNumberField.getText());
            double num2 = Double.parseDouble(secondNumberField.getText());
            double result = 0;

            switch (operation) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        JOptionPane.showMessageDialog(frame, "Cannot divide by zero!");
                        return;
                    }
                    break;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter valid numbers!");
        }
    }

    private void clearFields() {
        firstNumberField.setText("");
        secondNumberField.setText("");
        resultField.setText("");
    }

    public static void main(String[] args) {
        new Calculator();
    }
}