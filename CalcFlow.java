/**
 * @author Jude Kallista-Fitzpatrick
 * @Date 12/4/2017
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class CalcFlow extends JFrame {
    private JTextField [] textFields = new JTextField[4];
    private JLabel label;

    public CalcFlow() {
        textFields[0] = new JTextField(10);
        label = new JLabel(" 0.0");
        textFields[1] = new JTextField(10);
        JButton button = new JButton("Sum");
        textFields[2] = new JTextField(10);
        textFields[3] = new JTextField(10);
        button.addActionListener(new CalculateHandle());

        FlowLayout layout = new FlowLayout();
        JPanel panel = new JPanel(layout);

	panel.add(textFields[0]);
        panel.add(textFields[1]);
        panel.add(textFields[2]);
        panel.add(textFields[3]);
	panel.add(button);
        panel.add(label);

        setContentPane(panel);
    }
    public static void main(String [] args) {
        CalcFlow calculator = new CalcFlow();
        calculator.setSize(1000,1000);
        calculator.setTitle("Calculator");
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculator.pack();
        calculator.setVisible(true);
        System.out.println(calculator.getInsets());
    }
    private class CalculateHandle implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double input1 = Double.parseDouble(textFields[0].getText());
            double input2 = Double.parseDouble(textFields[1].getText());
            double input3 = Double.parseDouble(textFields[2].getText());
            double input4 = Double.parseDouble(textFields[3].getText());
            double result = input1+input2+input3+input4;
            DecimalFormat format = new DecimalFormat("####.00");
            label.setText(String.valueOf(format.format(result)));

            System.out.println("You have just clicked the Calculate button!" + input1 + " " + input2 + " " + input3 + " " + input4 + " " + result);
        }
    }

}