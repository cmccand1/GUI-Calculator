package gui.calculator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author clintmccandless
 */
public class GUICalculator extends JPanel 
{
    
    public static final int WIDTH = 320;
    public static final int HEIGHT = 480;
    
    private GridBagLayout layout;
    private Font boldFont;
    
    private JButton[] numberButtons;
    private JButton[] opButtons;
    private GridBagConstraints gbc;
    
    private JTextArea textArea;
    
    private double arg1, arg2;
    private double doubleResult;
    private String desiredOperation;
    private boolean defaultState;
    
    // [0] = gridx, [1] = gridy, [2] = gridwidth, [3] = gridheight
    private int [][] numConstraints = new int[][] {
        {0, 5, 2, 1}, // 0
        {0, 4, 1, 1}, // 1
        {1, 4, 1, 1}, // 2
        {2, 4, 1, 1}, // 3
        {0, 3, 1, 1}, // 4
        {1, 3, 1, 1}, // 5
        {2, 3, 1, 1}, // 6
        {0, 2, 1, 1}, // 7
        {1, 2, 1, 1}, // 8
        {2, 2, 1, 1}, // 9
    };
    
    // [0] = gridx, [1] = gridy, [2] = gridwidth, [3] = gridheight
    private int[][] opConstraints = new int[][] {
        {2, 5, 1, 1}, // decimal
        {3, 5, 1, 1}, // equals
        {3, 4, 1, 1}, // plus
        {3, 3, 1, 1}, // minus
        {3, 2, 1, 1}, // multiply
        {3, 1, 1, 1}, // divide
        {2, 1, 1, 1}, // percentage
        {1, 1, 1, 1}, // plus-minus
        {0, 1, 1, 1}  // AC
    };
    
    
    public GUICalculator() 
    {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
       
        layout = new GridBagLayout();
        layout.columnWidths = new int[] {80, 80, 80, 80};
        layout.rowHeights = new int[] {80, 80, 80, 80, 80, 80};
        setLayout(layout);
        boldFont = new Font("Menlo", Font.BOLD, 18);
        
        gbc = new GridBagConstraints();
        
        
        
        // Create and format the number buttons
        numberButtons = new JButton[10];
        for (int i = 0; i < numberButtons.length; i++)
        {
            numberButtons[i] = new JButton("" + i);
            
            gbc.gridx = numConstraints[i][0];
            gbc.gridy = numConstraints[i][1];
            gbc.gridwidth = numConstraints[i][2];
            gbc.gridheight = numConstraints[i][3];
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(2, 2, 2, 2);
            
            add(numberButtons[i], gbc); 
            
            numberButtons[i].setBackground(Color.DARK_GRAY);
            numberButtons[i].setForeground(Color.WHITE);
            numberButtons[i].setFont(boldFont);
            numberButtons[i].setOpaque(true);
            numberButtons[i].setBorderPainted(false);
            
        }
        
        
        
        // Create and format the op buttons
        String[] opLabels = { ".", "=", "+", "-", "x", "÷", "%", "+/-", "AC" };
        opButtons = new JButton[9];
        
        for (int i = 0; i < opButtons.length; i++)
        { 
           opButtons[i] = new JButton("" + opLabels[i]); 
            
           gbc.gridx = opConstraints[i][0];
           gbc.gridy = opConstraints[i][1];
           gbc.gridwidth = opConstraints[i][2];
           gbc.gridheight = opConstraints[i][3];
           gbc.fill = GridBagConstraints.BOTH;
           gbc.insets = new Insets(2, 2, 2, 2);
           
           add(opButtons[i], gbc);
            
        }
        
           opButtons[0].setBackground(Color.DARK_GRAY);
           opButtons[0].setForeground(Color.WHITE);
           opButtons[0].setFont(boldFont);
           opButtons[0].setOpaque(true);
           opButtons[0].setBorderPainted(false);
        
        for (int i = 1; i < 6; i++)
        {
           opButtons[i].setBackground(new Color(244, 167, 66));
           opButtons[i].setForeground(Color.WHITE);
           opButtons[i].setFont(boldFont);
           opButtons[i].setOpaque(true);
           opButtons[i].setBorderPainted(false);  
        }   
            
        for (int i = 6; i < opButtons.length; i++)
        {
            opButtons[i].setBackground(Color.LIGHT_GRAY);
            opButtons[i].setFont(boldFont);
            opButtons[i].setOpaque(true);
            opButtons[i].setBorderPainted(false);
        }
        
        // Create and format the text area
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(boldFont);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        
        add(textArea, gbc);
        
        
        // Create an action listener and add it to each of the buttons
        ActionListener buttonClick = new ButtonListener();
        for (int i = 0; i < numberButtons.length; i++)
        {
            numberButtons[i].addActionListener(buttonClick);
        }
        for (int i = 0; i < opButtons.length; i++)
        {
            opButtons[i].addActionListener(buttonClick);
        }
        
        
    } // end of constructor
    
    
    
    class ButtonListener implements ActionListener 
   {
       public void actionPerformed(ActionEvent e) 
       {
           if (e.getSource() == numberButtons[0] )
           {
               if (defaultState) 
               {
                  textArea.setText("0");
                  isDefaultState(false);
               }
               else
                  textArea.append("0");   
           }
           if (e.getSource() == numberButtons[1] )
           {
              if (defaultState) 
               {
                  textArea.setText("1");
                  isDefaultState(false);
               }
               else
                  textArea.append("1");  
           }
           if (e.getSource() == numberButtons[2] )
           {
              if (defaultState) 
               {
                  textArea.setText("2");
                  isDefaultState(false);
               }
               else
                  textArea.append("2");  
           }
           if (e.getSource() == numberButtons[3] )
           {
              if (defaultState) 
               {
                  textArea.setText("3");
                  isDefaultState(false);
               }
               else
                  textArea.append("3");  
           }
           if (e.getSource() == numberButtons[4] )
           {
              if (defaultState) 
               {
                  textArea.setText("4");
                  isDefaultState(false);
               }
               else
                  textArea.append("4");  
           }
           if (e.getSource() == numberButtons[5] )
           {
              if (defaultState) 
               {
                  textArea.setText("5");
                  isDefaultState(false);
               }
               else
                  textArea.append("5");  
           }
           if (e.getSource() == numberButtons[6] )
           {
              if (defaultState) 
               {
                  textArea.setText("6");
                  isDefaultState(false);
               }
               else
                  textArea.append("6");  
           }
           if (e.getSource() == numberButtons[7] )
           {
              if (defaultState) 
               {
                  textArea.setText("7");
                  isDefaultState(false);
               }
               else
                  textArea.append("7");  
           }
           if (e.getSource() == numberButtons[8] )
           {
              if (defaultState) 
               {
                  textArea.setText("8");
                  isDefaultState(false);
               }
               else
                  textArea.append("8");  
           }
           if (e.getSource() == numberButtons[9] )
           {
              if (defaultState) 
               {
                  textArea.setText("9");
                  isDefaultState(false);
               }
               else
                  textArea.append("9");  
           }
           if (e.getSource() == opButtons[8])
           {
               isDefaultState(true);
               textArea.setText("0");
               setArg1(0);
               setArg2(0);
           }
           if (e.getSource() == opButtons[7])
           {
               // makes a positive number negative and a negative number positive
               setArg1(convertTextToDouble());
               
               doubleResult = Operations.flipSigns(arg1);
               setDisplayArea("" + doubleResult);   
           }
           if (e.getSource() == opButtons[6])
           {
               // Calls the asPercent() method on the argument
               setArg1(convertTextToDouble());
               doubleResult = Operations.asPercent(arg1);
               setDisplayArea("" + doubleResult);
           }
           if (e.getSource() == opButtons[5])
           {
               // Calls the division() method on the arguments
               setArg1(convertTextToDouble());
               isDefaultState(true);
               setDesiredOperation("Division"); 
           }
           if (e.getSource() == opButtons[4])
           {
               // Calls the multiplication() method on the arguments
               setArg1(convertTextToDouble());
               isDefaultState(true);
               setDesiredOperation("Multiplication"); 
           }
           if (e.getSource() == opButtons[2])
           {
               // Calls the addition() method on the arguments
               setArg1(convertTextToDouble());
               isDefaultState(true);
               setDesiredOperation("Addition");
           }
           if (e.getSource() == opButtons[3])
           {
               // Calls the subtraction() method on the arguments
               setArg1(convertTextToDouble());
               isDefaultState(true);
               setDesiredOperation("Subtraction"); 
           }
           if (e.getSource() == opButtons[0])
           {
               textArea.append(".");
           }
           if (e.getSource() == opButtons[1])
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
    
}
