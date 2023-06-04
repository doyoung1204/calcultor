package project9;

import java.awt.*;
import javax.swing.*;

public class Calcultor extends JFrame {

	JTextField display;
	JLabel history;
	JPanel panel;
	JButton button;
	double operand1, operand2, answer;
	String operator;

	Calcultor() {
		this.setBounds(100, 100, 300, 500);
		this.setTitle("계산기");
		this.setLayout(new BorderLayout());
		display = new JTextField(30);
		display.setText("0");
		display.setFont(new Font("궁서체", Font.BOLD, 35));
		display.setHorizontalAlignment(SwingConstants.RIGHT);

		this.add(display, BorderLayout.NORTH);
		history = new JLabel("--");
		this.add(history, BorderLayout.SOUTH);
		panel = new JPanel();
		panel.setLayout(new GridLayout(6, 4));

		button = new JButton("%");
		button.addActionListener(e -> {
			double d = Double.parseDouble(display.getText());
			display.setText(d / 100 + "");
		});
		panel.add(button);

		button = new JButton("CE");
		button.addActionListener(e -> {
			display.setText("0");
		});
		panel.add(button);
		button = new JButton("C");
		button.addActionListener(e -> {
			display.setText("0");
		});
		panel.add(button);
		button = new JButton("<-");
		button.addActionListener(e -> {
			String currentText = display.getText();
			if (currentText.length() > 1) {
				display.setText(currentText.substring(0, currentText.length() - 1));
			} else {
				display.setText("0");
			}
		});
		panel.add(button);
		button = new JButton("1/x");
		button.addActionListener(e -> {
			double d = Double.parseDouble(display.getText());
			display.setText(1.0 / d + "");
		});
		panel.add(button);
		button = new JButton("x^2");
		button.addActionListener(e -> {
			double d = Double.parseDouble(display.getText());
			display.setText(d * d + "");
		});
		panel.add(button);
		button = new JButton("Sqrt");
		button.addActionListener(e -> {
			double d = Double.parseDouble(display.getText());
			display.setText(Math.sqrt(d) + "");
		});
		panel.add(button);
		button = new JButton("/");
		button.addActionListener(e -> {
			display.setText(display.getText() + "/");
		});
		panel.add(button);

		button = new JButton("7");
		button.addActionListener(e -> {
			appendNumberToDisplay("7");
		});
		panel.add(button);

		button = new JButton("8");
		button.addActionListener(e -> {
			appendNumberToDisplay("8");
		});
		panel.add(button);

		button = new JButton("9");
		button.addActionListener(e -> {
			appendNumberToDisplay("9");
		});
		panel.add(button);

		button = new JButton("*");
		button.addActionListener(e -> {
			display.setText(display.getText() + "*");
		});
		panel.add(button);

		button = new JButton("4");
		button.addActionListener(e -> {
			appendNumberToDisplay("4");
		});
		panel.add(button);

		button = new JButton("5");
		button.addActionListener(e -> {
			appendNumberToDisplay("5");
		});
		panel.add(button);

		button = new JButton("6");
		button.addActionListener(e -> {
			appendNumberToDisplay("6");
		});
		panel.add(button);

		button = new JButton("-");
		button.addActionListener(e -> {
			display.setText(display.getText() + "-");
		});
		panel.add(button);

		button = new JButton("1");
		button.addActionListener(e -> {
			appendNumberToDisplay("1");
		});
		panel.add(button);

		button = new JButton("2");
		button.addActionListener(e -> {
			appendNumberToDisplay("2");
		});
		panel.add(button);

		button = new JButton("3");
		button.addActionListener(e -> {
			appendNumberToDisplay("3");
		});
		panel.add(button);

		button = new JButton("+");
		button.addActionListener(e -> {
			display.setText(display.getText() + "+");
		});
		panel.add(button);

		button = new JButton("+/-");
		button.addActionListener(e -> {
			String currentText = display.getText();
			if (!currentText.equals("0")) {
				if (currentText.contains("-")) {
					display.setText(currentText.substring(1));
				} else {
					display.setText("-" + currentText);
				}
			}
		});
		panel.add(button);

		button = new JButton("0");
		button.addActionListener(e -> {
			appendNumberToDisplay("0");
		});
		panel.add(button);

		button = new JButton(".");
		button.addActionListener(e -> {
			if (!display.getText().contains(".")) {
				display.setText(display.getText() + ".");
			}
		});
		panel.add(button);

		button = new JButton("=");
		button.addActionListener(e -> {
			String expression = display.getText();
			answer = evaluateExpression(expression);
			display.setText(answer + "");
		});
		panel.add(button);

		this.add(panel, BorderLayout.CENTER);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void appendNumberToDisplay(String number) {
		String currentText = display.getText();
		if (currentText.equals("0")) {
			display.setText(number);
		} else {
			display.setText(currentText + number);
		}
	}

	private double evaluateExpression(String expression) {
		String[] parts = expression.split("[+\\-*/]");
		operand1 = Double.parseDouble(parts[0]);
		operand2 = Double.parseDouble(parts[1]);
		operator = expression.substring(parts[0].length(), parts[0].length() + 1);
		switch (operator) {
			case "+":
				return operand1 + operand2;
			case "-":
				return operand1 - operand2;
			case "*":
				return operand1 * operand2;
			case "/":
				return operand1 / operand2;
			default:
				return 0;
		}
	}



	public static void main(String[] args) {
		new Calcultor();
	}

}
