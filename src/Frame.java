
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame implements ActionListener {
	
	private Calculator c = new Calculator();
	
	private JFrame frame;
	
	private JPanel panel;
	
	private JButton[] buttons;
	
	private JLabel output;
	
	private final String TITLE = "Calculator";
	
	private final int WIDTH = 350;
	
	private final int HEIGHT = 350;
	
	private final Color BACKGROUND_COLOR = Color.LIGHT_GRAY;
	
	public Frame() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		panel = new JPanel();
		frame.setTitle(TITLE);
		frame.setSize(WIDTH,HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		panel.setBackground(BACKGROUND_COLOR);
		panel.setLayout(new GridLayout(7,7));
		buttons = new JButton[18];
		for(int i = 0; i < 18; i++) {
			if(i == 10) {
				buttons[i] = new JButton("+");
				buttons[i].addActionListener(this);
				panel.add(buttons[i]);
			} else if(i == 11) {
				buttons[i] = new JButton("-");
				buttons[i].addActionListener(this);
				panel.add(buttons[i]);
			} else if(i == 12) {
				buttons[i] = new JButton("*");
				buttons[i].addActionListener(this);
				panel.add(buttons[i]);
			} else if(i == 13) {
				buttons[i] = new JButton("/");
				buttons[i].addActionListener(this);
				panel.add(buttons[i]);
			} else if(i == 14) {
				buttons[i] = new JButton("√");
				buttons[i].addActionListener(this);
				panel.add(buttons[i]);
			} else if(i == 15) {
				buttons[i] = new JButton("x^2");
				buttons[i].addActionListener(this);
				panel.add(buttons[i]);
			} else if(i == 16) {
				buttons[i] = new JButton("Enter");
				buttons[i].addActionListener(this);
				panel.add(buttons[i]);
			} else if(i == 17) {
				buttons[i] = new JButton("C");
				buttons[i].addActionListener(this);
				panel.add(buttons[i]);
			} else {
				buttons[i] = new JButton(Integer.toString(i));
				buttons[i].addActionListener(this);
				panel.add(buttons[i]);
			}
		}
		output = new JLabel("result");
		panel.add(output);
		frame.add(panel);
	}
	
	public void display() {
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttons[0]) {
			if(c.isFirst()) {
				c.setFirst(0);
				output.setText(Double.toString(c.getFirst()));
				c.setFirstState(false);
			} else {
				c.setSecond(0);
				output.setText(Double.toString(c.getFirst()) + c.getOp() + Double.toString(c.getSecond()));
			}
		} else if(e.getSource() == buttons[1]) {
			if(c.isFirst()) {
				c.setFirst(1);
				output.setText(Double.toString(c.getFirst()));
				c.setFirstState(false);
			} else {
				c.setSecond(1);
				output.setText(Double.toString(c.getSecond()));
			}
		} else if(e.getSource() == buttons[2]) {
			if(c.isFirst()) {
				c.setFirst(2);
				output.setText(Double.toString(c.getFirst()));
				c.setFirstState(false);
			} else {
				c.setSecond(2);
				output.setText(Double.toString(c.getSecond()));
			}
		} else if(e.getSource() == buttons[3]) {
			if(c.isFirst()) {
				c.setFirst(3);
				output.setText(Double.toString(c.getFirst()));
				c.setFirstState(false);
			} else {
				c.setSecond(3);
				output.setText(Double.toString(c.getSecond()));
			}
		} else if(e.getSource() == buttons[4]) {
			if(c.isFirst()) {
				c.setFirst(4);
				output.setText(Double.toString(c.getFirst()));
				c.setFirstState(false);
			} else {
				c.setSecond(4);
				output.setText(Double.toString(c.getSecond()));
			}
		} else if(e.getSource() == buttons[5]) {
			if(c.isFirst()) {
				c.setFirst(5);
				output.setText(Double.toString(c.getFirst()));
				c.setFirstState(false);
			} else {
				c.setSecond(5);
				output.setText(Double.toString(c.getSecond()));
			}
		} else if(e.getSource() == buttons[6]) {
			if(c.isFirst()) {
				c.setFirst(6);
				output.setText(Double.toString(c.getFirst()));
				c.setFirstState(false);
			} else {
				c.setSecond(6);
				output.setText(Double.toString(c.getSecond()));
			}
		} else if(e.getSource() == buttons[7]) {
			if(c.isFirst()) {
				c.setFirst(7);
				output.setText(Double.toString(c.getFirst()));
				c.setFirstState(false);
			} else {
				c.setSecond(7);
				output.setText(Double.toString(c.getSecond()));
			}
		} else if(e.getSource() == buttons[8]) {
			if(c.isFirst()) {
				c.setFirst(8);
				output.setText(Double.toString(c.getFirst()));
				c.setFirstState(false);
			} else {
				c.setSecond(8);
				output.setText(Double.toString(c.getSecond()));
			}
		} else if(e.getSource() == buttons[9]) {
			if(c.isFirst()) {
				c.setFirst(9);
				output.setText(Double.toString(c.getFirst()));
				c.setFirstState(false);
			} else {
				c.setSecond(9);
				output.setText(Double.toString(c.getFirst() ));
			}
		} else if(e.getSource() == buttons[10]) {
			c.setOp("+");
			output.setText(Double.toString(c.getFirst()) + " +");
		} else if(e.getSource() == buttons[11]) {
			c.setOp("-");
			output.setText(Double.toString(c.getFirst()) + " -");
		} else if(e.getSource() == buttons[12]) {
			c.setOp("*");
			output.setText(Double.toString(c.getFirst()) + " *");
		} else if(e.getSource() == buttons[13]) {
			c.setOp("/");
			output.setText(Double.toString(c.getFirst()) + " /");
		} else if(e.getSource() == buttons[14]) {
			c.setOp("√");
			output.setText(Double.toString(c.getFirst()) + " √");
		} else if(e.getSource() == buttons[15]) {
			c.setOp("x^2");
			output.setText(Double.toString(c.getFirst()) + " x^2");
		} else if(e.getSource() == buttons[16]) {
			
				if(c.getOp().equalsIgnoreCase("+")) {
					c.add();
					output.setText(Double.toString(c.getResult()));
					c.setFirstState(true);
				} else if(c.getOp().equalsIgnoreCase("-")) {
					c.subtract();
					output.setText(Double.toString(c.getResult()));
					c.setFirstState(true);
				} else if(c.getOp().equalsIgnoreCase("*")) {
					c.multiply();
					output.setText(Double.toString(c.getResult()));
					c.setFirstState(true);
				} else if(c.getOp().equalsIgnoreCase("/")) {
					c.divide();
					output.setText(Double.toString(c.getResult()));
					c.setFirstState(true);
				} else if(c.getOp().equalsIgnoreCase("√")) {
					c.sqrt();
					output.setText(Double.toString(c.getResult()));
					c.setFirstState(true);
				} else if(c.getOp().equalsIgnoreCase("x^2")) {
					c.square();
					output.setText(Double.toString(c.getResult()));
					c.setFirstState(true);
				}

		} else if(e.getSource() == buttons[17]) {
			c.clearResult();
			output.setText(Double.toString(c.getResult()));
		}
	}
	
}
