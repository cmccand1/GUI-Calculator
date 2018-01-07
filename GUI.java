package calculator;


import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 *
 * @author clintmccandless
 */
public class GUI 
{
    
    private JTextArea textArea;
   
    private JButton allClearButton;
    private JButton plusMinusButton;
    private JButton percentButton;
    private JButton divisionButton;
    private JButton multiplicationButton;
    private JButton subtractionButton;
    private JButton additionButton;
    private JButton decimalButton;
    private JButton equalsButton;

    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    
    private double arg1, arg2;
    private double doubleResult;
    private String desiredOperation;
    private boolean defaultState;
    
    
   /**
    * Creates a fully functional calculator object and displays the GUI
    */
   public GUI() 
   {
        // Create the main frame and the main panel
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel(new BorderLayout());
        Font boldFont = new Font("Menlo", Font.BOLD, 18);
        
        // Create a display area for calculations
        final int ROWS = 2;
        final int COLUMS = 10;
        textArea = new JTextArea(ROWS, COLUMS);
        textArea.setEditable(false);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(boldFont);
        isDefaultState(true);
        
        // Create top panel for the text area 
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.BLACK);
        topPanel.add(textArea, BorderLayout.EAST);
        
        // Create the calculator buttons
        allClearButton = new JButton("AC");
        plusMinusButton = new JButton("+/-");
        percentButton = new JButton("%");
        divisionButton = new JButton("÷");
        multiplicationButton = new JButton("x");
        subtractionButton = new JButton("-");
        additionButton = new JButton("+");
        decimalButton = new JButton(".");
        equalsButton = new JButton("=");
        
        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        
        // Format of the buttons
        allClearButton.setBackground(Color.LIGHT_GRAY);
        allClearButton.setFont(boldFont);
        allClearButton.setOpaque(true);
        allClearButton.setBorderPainted(false);
        plusMinusButton.setBackground(Color.LIGHT_GRAY);
        plusMinusButton.setFont(boldFont);
        plusMinusButton.setOpaque(true);
        plusMinusButton.setBorderPainted(false);
        percentButton.setBackground(Color.LIGHT_GRAY);
        percentButton.setFont(boldFont);
        percentButton.setOpaque(true);
        percentButton.setBorderPainted(false);
        divisionButton.setBackground(new Color(244, 167, 66));
        divisionButton.setForeground(Color.WHITE);
        divisionButton.setFont(boldFont);
        divisionButton.setOpaque(true);
        divisionButton.setBorderPainted(false);
        multiplicationButton.setBackground(new Color(244, 167, 66));
        multiplicationButton.setForeground(Color.WHITE);
        multiplicationButton.setFont(boldFont);
        multiplicationButton.setOpaque(true);
        multiplicationButton.setBorderPainted(false);
        subtractionButton.setBackground(new Color(244, 167, 66));
        subtractionButton.setForeground(Color.WHITE);
        subtractionButton.setFont(boldFont);
        subtractionButton.setOpaque(true);
        subtractionButton.setBorderPainted(false);
        additionButton.setBackground(new Color(244, 167, 66));
        additionButton.setForeground(Color.WHITE);
        additionButton.setFont(boldFont);
        additionButton.setOpaque(true);
        additionButton.setBorderPainted(false);
        equalsButton.setBackground(new Color(244, 167, 66));
        equalsButton.setForeground(Color.WHITE);
        equalsButton.setFont(boldFont);
        equalsButton.setOpaque(true);
        equalsButton.setBorderPainted(false);
        
        
        button0.setBackground(Color.DARK_GRAY);
        button0.setForeground(Color.WHITE);
        button0.setFont(boldFont);
        button0.setOpaque(true);
        button0.setBorderPainted(false);
        button1.setBackground(Color.DARK_GRAY);
        button1.setForeground(Color.WHITE);
        button1.setFont(boldFont);
        button1.setOpaque(true);
        button1.setBorderPainted(false);
        button2.setBackground(Color.DARK_GRAY);
        button2.setForeground(Color.WHITE);
        button2.setFont(boldFont);
        button2.setOpaque(true);
        button2.setBorderPainted(false);
        button3.setBackground(Color.DARK_GRAY);
        button3.setForeground(Color.WHITE);
        button3.setFont(boldFont);
        button3.setOpaque(true);
        button3.setBorderPainted(false);
        button4.setBackground(Color.DARK_GRAY);
        button4.setForeground(Color.WHITE);
        button4.setFont(boldFont);
        button4.setOpaque(true);
        button4.setBorderPainted(false);
        button5.setBackground(Color.DARK_GRAY);
        button5.setForeground(Color.WHITE);
        button5.setFont(boldFont);
        button5.setOpaque(true);
        button5.setBorderPainted(false);
        button6.setBackground(Color.DARK_GRAY);
        button6.setForeground(Color.WHITE);
        button6.setFont(boldFont);
        button6.setOpaque(true);
        button6.setBorderPainted(false);
        button7.setBackground(Color.DARK_GRAY);
        button7.setForeground(Color.WHITE);
        button7.setFont(boldFont);
        button7.setOpaque(true);
        button7.setBorderPainted(false);
        button8.setBackground(Color.DARK_GRAY);
        button8.setForeground(Color.WHITE);
        button8.setFont(boldFont);
        button8.setOpaque(true);
        button8.setBorderPainted(false);
        button9.setBackground(Color.DARK_GRAY);
        button9.setForeground(Color.WHITE);
        button9.setFont(boldFont);
        button9.setOpaque(true);
        button9.setBorderPainted(false);
        decimalButton.setBackground(Color.DARK_GRAY);
        decimalButton.setForeground(Color.WHITE);
        decimalButton.setFont(boldFont);
        decimalButton.setOpaque(true);
        decimalButton.setBorderPainted(false);
        
        // Add the event listeners to each button
        ActionListener buttonClick = new ButtonListener();
        button0.addActionListener(buttonClick);
        button1.addActionListener(buttonClick);
        button2.addActionListener(buttonClick);
        button3.addActionListener(buttonClick);
        button4.addActionListener(buttonClick);
        button5.addActionListener(buttonClick);
        button6.addActionListener(buttonClick);
        button7.addActionListener(buttonClick);
        button8.addActionListener(buttonClick);
        button9.addActionListener(buttonClick);
        
        allClearButton.addActionListener(buttonClick);
        plusMinusButton.addActionListener(buttonClick);
        percentButton.addActionListener(buttonClick);
        divisionButton.addActionListener(buttonClick);
        multiplicationButton.addActionListener(buttonClick);
        subtractionButton.addActionListener(buttonClick);
        additionButton.addActionListener(buttonClick);
        decimalButton.addActionListener(buttonClick);
        equalsButton.addActionListener(buttonClick);
        
        
        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 4, 4));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(allClearButton);
        buttonPanel.add(plusMinusButton);
        buttonPanel.add(percentButton);
        buttonPanel.add(divisionButton);
        buttonPanel.add(button7);
        buttonPanel.add(button8);
        buttonPanel.add(button9);
        buttonPanel.add(multiplicationButton);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);
        buttonPanel.add(subtractionButton);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(additionButton);
        buttonPanel.add(button0);
        buttonPanel.add(decimalButton);
        buttonPanel.add(equalsButton);
        
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        
        frame.add(mainPanel);
        
        final int FRAME_WIDTH = 400;
        final int FRAME_HEIGHT = 500;
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Calculator");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
   } // end of constructor
   
   
   class ButtonListener implements ActionListener 
   {
       public void actionPerformed(ActionEvent e) 
       {
           if (e.getSource().equals(button0) )
           {
               if (defaultState) 
               {
                  textArea.setText("0");
                  isDefaultState(false);
               }
               else
                  textArea.append("0");   
           }
           if (e.getSource().equals(button1) )
           {
              if (defaultState) 
               {
                  textArea.setText("1");
                  isDefaultState(false);
               }
               else
                  textArea.append("1");  
           }
           if (e.getSource().equals(button2) )
           {
              if (defaultState) 
               {
                  textArea.setText("2");
                  isDefaultState(false);
               }
               else
                  textArea.append("2");  
           }
           if (e.getSource().equals(button3) )
           {
              if (defaultState) 
               {
                  textArea.setText("3");
                  isDefaultState(false);
               }
               else
                  textArea.append("3");  
           }
           if (e.getSource().equals(button4) )
           {
              if (defaultState) 
               {
                  textArea.setText("4");
                  isDefaultState(false);
               }
               else
                  textArea.append("4");  
           }
           if (e.getSource().equals(button5) )
           {
              if (defaultState) 
               {
                  textArea.setText("5");
                  isDefaultState(false);
               }
               else
                  textArea.append("5");  
           }
           if (e.getSource().equals(button6) )
           {
              if (defaultState) 
               {
                  textArea.setText("6");
                  isDefaultState(false);
               }
               else
                  textArea.append("6");  
           }
           if (e.getSource().equals(button7) )
           {
              if (defaultState) 
               {
                  textArea.setText("7");
                  isDefaultState(false);
               }
               else
                  textArea.append("7");  
           }
           if (e.getSource().equals(button8) )
           {
              if (defaultState) 
               {
                  textArea.setText("8");
                  isDefaultState(false);
               }
               else
                  textArea.append("8");  
           }
           if (e.getSource().equals(button9) )
           {
              if (defaultState) 
               {
                  textArea.setText("9");
                  isDefaultState(false);
               }
               else
                  textArea.append("9");  
           }
           if (e.getSource().equals(allClearButton))
           {
               isDefaultState(true);
               textArea.setText("0");
               setArg1(0);
               setArg2(0);
           }
           if (e.getSource().equals(plusMinusButton))
           {
               // makes a positive number negative and a negative number positive
               setArg1(convertTextToDouble());
               
               doubleResult = Operations.flipSigns(arg1);
               setDisplayArea("" + doubleResult);   
           }
           if (e.getSource().equals(percentButton))
           {
               // Calls the asPercent() method on the argument
               setArg1(convertTextToDouble());
               doubleResult = Operations.asPercent(arg1);
               setDisplayArea("" + doubleResult);
           }
           if (e.getSource().equals(divisionButton))
           {
               // Calls the division() method on the arguments
               setArg1(convertTextToDouble());
               isDefaultState(true);
               setDesiredOperation("Division"); 
           }
           if (e.getSource().equals(multiplicationButton))
           {
               // Calls the multiplication() method on the arguments
               setArg1(convertTextToDouble());
               isDefaultState(true);
               setDesiredOperation("Multiplication"); 
           }
           if (e.getSource().equals(additionButton))
           {
               // Calls the addition() method on the arguments
               setArg1(convertTextToDouble());
               isDefaultState(true);
               setDesiredOperation("Addition");
           }
           if (e.getSource().equals(subtractionButton))
           {
               // Calls the subtraction() method on the arguments
               setArg1(convertTextToDouble());
               isDefaultState(true);
               setDesiredOperation("Subtraction"); 
           }
           if (e.getSource().equals(decimalButton))
           {
               textArea.append(".");
           }
           if (e.getSource().equals(equalsButton))
           {
               if (defaultState)
               {
                    setArg1(doubleResult);

                    switch (desiredOperation)
                    {
                        case "Addition":
                            doubleResult = Operations.addition(arg1, arg2);
                            if (doubleResult == Math.floor(doubleResult))
                            {
                                setDisplayArea("" + (int) doubleResult);   
                            }
                            else
                            {
                                setDisplayArea("" + doubleResult);
                            }
                            break;
                        case "Subtraction":
                            doubleResult = Operations.subtraction(arg1, arg2);
                            if (doubleResult == Math.floor(doubleResult))
                            {
                                setDisplayArea("" + (int) doubleResult);   
                            }
                            else
                            {
                                setDisplayArea("" + doubleResult);
                            }
                            break;
                        case "Multiplication":
                            doubleResult = Operations.multiplication(arg1, arg2);
                            if (doubleResult == Math.floor(doubleResult))
                            {
                                setDisplayArea("" + (int) doubleResult);   
                            }
                            else
                            {
                                setDisplayArea("" + doubleResult);
                            }
                            break;
                        case "Division":
                            doubleResult = Operations.division(arg1, arg2);
                            if (doubleResult == Math.floor(doubleResult))
                            {
                                setDisplayArea("" + (int) doubleResult);   
                            }
                            else
                            {
                                setDisplayArea("" + doubleResult);
                            }
                            break;
                        default:
                            System.exit(-1);
                    }
                }
                else 
                {
                    setArg2(convertTextToDouble());

                    switch (desiredOperation)
                    {
                        case "Addition":
                            doubleResult = Operations.addition(arg1, arg2);
                            if (doubleResult == Math.floor(doubleResult))
                            {
                                setDisplayArea("" + (int) doubleResult);
                                isDefaultState(true);
                            }
                            else
                            {
                                setDisplayArea("" + doubleResult);
                                isDefaultState(true);
                            }
                            break;
                        case "Subtraction":
                            doubleResult = Operations.subtraction(arg1, arg2);
                            if (doubleResult == Math.floor(doubleResult))
                            {
                                setDisplayArea("" + (int) doubleResult);
                                isDefaultState(true);
                            }
                            else
                            {
                                setDisplayArea("" + doubleResult);
                                isDefaultState(true);
                            }
                            break;
                        case "Multiplication":
                            doubleResult = Operations.multiplication(arg1, arg2);
                            if (doubleResult == Math.floor(doubleResult))
                            {
                                setDisplayArea("" + (int) doubleResult);
                                isDefaultState(true);
                            }
                            else
                            {
                                setDisplayArea("" + doubleResult);
                                isDefaultState(true);
                            }
                            break;
                        case "Division":
                            doubleResult = Operations.division(arg1, arg2);
                            if (doubleResult == Math.floor(doubleResult))
                            {
                                setDisplayArea("" + (int) doubleResult);
                                isDefaultState(true);
                            }
                            else
                            {
                                setDisplayArea("" + doubleResult);
                                isDefaultState(true);
                            }
                            break;
                        default:
                            System.exit(-1);        
                    } 
                }
           }      
        }       
    } // end of buttonListener inner class
 
   
   /**
    * Sets the text of the calculator's display area
    * @param desiredText the appropriate text given the button clicked
    */
   public void setDisplayArea(String desiredText) 
   {
       textArea.setText(desiredText);
   }
   
   /**
    * Reads the display area and converts the string input to double for operations
    * @return 
    */
   public double convertTextToDouble() 
   {
       return Double.parseDouble(textArea.getText());
   }
   
   /**
    * Gets the value for the first argument/operand
    * @return arg1 the first argument 
    */
   public double getArg1() 
   {
       return arg1;
   }
   
   /**
    * Gets the value for the second argument/operand
    * @return arg2 the second argument
    */
   public double getArg2() 
   {
       return arg2;
   }
   
   /**
    * Sets the first argument/operand
    * @param argument 
    */
   public void setArg1(double argument) 
   {
       arg1 = argument;
   }
   
   /**
    * Sets the second argument/operand
    * @param argument 
    */
   public void setArg2(double argument) 
   {
       arg2 = argument;
   }
   
   /**
    * Sets the desired operation to be carried out by the equalsButton 
    * @param operation 
    */
   public void setDesiredOperation(String operation) 
   {
       desiredOperation = operation;
   }
   
   /**
    * Used to set zero as the default display number
    * @param state 
    */
   public void isDefaultState(boolean state) 
   {
       defaultState = state;
   }
   
 
} // end of class
