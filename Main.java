package gui.calculator;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author clintmccandless
 */
public class Main {

/**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLayout(new BorderLayout());
        frame.add(new GUICalculator(), BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
