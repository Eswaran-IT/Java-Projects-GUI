package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
//initializing attributes
    JFrame frame;
    JLabel inputLabel;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Main() {
//framesetup
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
//for getting input
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setEditable(false);
        
        inputLabel = new JLabel();
        inputLabel.setBounds(50, 75, 300, 25);
        frame.add(inputLabel);
//buttons for operators and others
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("-");
//buttons into arrays
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
//to get inputs
        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            //no input from keyboard
            functionButtons[i].setFocusable(false);
        }
//for numbers
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
          //no input from keyboard
            numberButtons[i].setFocusable(false);
        }
//buttons boundaries
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);
//panel setup
        panel = new JPanel();
        panel.setBackground(Color.green);
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 5, 5));
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
//panel into frame
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
//to initiate attributes
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isNumberButton(e)) {
            handleNumberButton(e);
        } else if (e.getSource() == decButton) {
            handleDecimalButton();
        } else if (isOperatorButton(e)) {
            handleOperatorButton(e);
        } else if (e.getSource() == equButton) {
            handleEqualsButton();
        } else if (e.getSource() == clrButton) {
            clearText();
        } else if (e.getSource() == delButton) {
            deleteChar();
        } else if (e.getSource() == negButton) {
            negateValue();
        }
    }
 // to make number into negative one
    private void negateValue() {
        try {
            double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(String.valueOf(temp));
        } catch (NumberFormatException ex) {
            showError("Invalid input. Please enter a valid number.");
        }
    }
//clear the field
    private void clearText() {
        textfield.setText("");
    }
//deleting the field last value
    private void deleteChar() {
        String currentText = textfield.getText();
        if (!currentText.isEmpty()) {
            textfield.setText(currentText.substring(0, currentText.length() - 1));
        }
    }

//verify the buttons
    private boolean isNumberButton(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                return true;
            }
        }
        return false;
    }
//verify operators
    private boolean isOperatorButton(ActionEvent e) {
        return e.getSource() == addButton || e.getSource() == subButton || e.getSource() == mulButton || e.getSource() == divButton;
    }

    private void handleNumberButton(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
                break;
            }
        }
    }
    //for alerts messages
    private void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void handleDecimalButton() {
        textfield.setText(textfield.getText().concat("."));
    }

    private void handleOperatorButton(ActionEvent e) {
        try {
            num1 = Double.parseDouble(textfield.getText());
        } catch (NumberFormatException ex) {
            showError("Invalid input. Please enter a valid number.");
            return;
        }

        operator = getOperatorSymbol(e);
        textfield.setText("");
    }

    private char getOperatorSymbol(ActionEvent e) {
        if (e.getSource() == addButton) {
            return '+';
        } else if (e.getSource() == subButton) {
            return '-';
        } else if (e.getSource() == mulButton) {
            return '*';
        } else if (e.getSource() == divButton) {
            return '/';
        }
        return '\u0000'; // Default value
    }

    private void handleEqualsButton() {
        try {
            num2 = Double.parseDouble(textfield.getText());
        } catch (NumberFormatException ex) {
            showError("Invalid input. Please enter a valid number.");
            return;
        }

        switch (operator) {
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
                    showError("Cannot divide by zero!");
                    return;
                }
                break;
            default:
                showError("Invalid operator.");
                return;
        }
        

        textfield.setText(String.valueOf(result));
        inputLabel.setText(num1 + " " + operator + " " + num2 + " = " + result);
        num1 = result;
        operator = '\u0000'; 
    }}
