/**
 * @author Jude Kallista-Fitzpatrick
 * @Date 12/4/2017
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class CalcBorder extends JFrame {

    private JTextField [] textFields = new JTextField[4];
    private JLabel label;

    public CalcBorder() {
        textFields[0] = new JTextField(10);
        label = new JLabel(" 0.0");
        textFields[1] = new JTextField(10);
        JButton button = new JButton("Sum");
        textFields[2] = new JTextField(10);
        textFields[3] = new JTextField(10);
        button.addActionListener(new CalculateHandle());

        BorderLayout layout = new BorderLayout();
        JPanel panel = new JPanel(layout);

        panel.add(textFields[0],BorderLayout.LINE_START);
        panel.add(textFields[1],BorderLayout.CENTER);
        panel.add(button,BorderLayout.LINE_END);
        panel.add(label,BorderLayout.PAGE_START);
        setContentPane(panel);

    }
    public static void main(String [] args) {
        CalcBorder calculator = new CalcBorder();
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
            double result = input1+input2;
            DecimalFormat format = new DecimalFormat("####.00");
            label.setText(String.valueOf(format.format(result)));

            System.out.println("You have just clicked the Calculate button!" + input1 + " " + input2 + " " + result);
        }
    }

}
