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
    private int [][] numberButtonConstraints = new int[][] {
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
    private int[][] opButtonConstraints = new int[][] {
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
        setBackground(Color.BLACK);
        
        gbc = new GridBagConstraints();
        
        
        
        /**
         * Create and format the number buttons
         */
        numberButtons = new JButton[10];
        for (int i = 0; i < numberButtons.length; i++)
        {
            numberButtons[i] = new JButton("" + i);
            
            gbc.gridx = numberButtonConstraints[i][0];
            gbc.gridy = numberButtonConstraints[i][1];
            gbc.gridwidth = numberButtonConstraints[i][2];
            gbc.gridheight = numberButtonConstraints[i][3];
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(2, 2, 2, 2);
            
            add(numberButtons[i], gbc); 
            
            numberButtons[i].setBackground(Color.DARK_GRAY);
            numberButtons[i].setForeground(Color.WHITE);
            numberButtons[i].setFont(boldFont);
            numberButtons[i].setOpaque(true);
            numberButtons[i].setBorderPainted(false);
            
        }
        
        
        
        /**
         *  Create and format the op buttons
         */
        String[] opLabels = { ".", "=", "+", "-", "x", "÷", "%", "+/-", "AC" };
        opButtons = new JButton[9];
        
        for (int i = 0; i < opButtons.length; i++)
        { 
           opButtons[i] = new JButton("" + opLabels[i]); 
            
           gbc.gridx = opButtonConstraints[i][0];
           gbc.gridy = opButtonConstraints[i][1];
           gbc.gridwidth = opButtonConstraints[i][2];
           gbc.gridheight = opButtonConstraints[i][3];
           gbc.weightx = 1;
           gbc.weighty = 1;
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
        
        
        
        /**
         *  Create and format the text area
         */
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(boldFont);
        textArea.setText("0");
        defaultState = true;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        
        add(textArea, gbc);
        
        
        
        /**
         * Create an action listener and add it to each of the buttons
         */
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
    
    
    
    /**
     * Specify functionality of the buttons
     */
    class ButtonListener implements ActionListener 
   {
       public void actionPerformed(ActionEvent e) 
       {
           if (e.getSource() == numberButtons[0]) 
           {
               if (defaultState) 
               {
                  textArea.setText("0");
                  defaultState = false;
               }
               else
                  textArea.append("0");   
           }
           if (e.getSource() == numberButtons[1])
           {
              if (defaultState) 
               {
                  textArea.setText("1");
                  defaultState = false;
               }
               else
                  textArea.append("1");  
           }
           if (e.getSource() == numberButtons[2])
           {
              if (defaultState) 
               {
                  textArea.setText("2");
                  defaultState = false;
               }
               else
                  textArea.append("2");  
           }
           if (e.getSource() == numberButtons[3])
           {
              if (defaultState) 
               {
                  textArea.setText("3");
                  defaultState = false;
               }
               else
                  textArea.append("3");  
           }
           if (e.getSource() == numberButtons[4])
           {
              if (defaultState) 
               {
                  textArea.setText("4");
                  defaultState = false;
               }
               else
                  textArea.append("4");  
           }
           if (e.getSource() == numberButtons[5])
           {
              if (defaultState) 
               {
                  textArea.setText("5");
                  defaultState = false;
               }
               else
                  textArea.append("5");  
           }
           if (e.getSource() == numberButtons[6])
           {
              if (defaultState) 
               {
                  textArea.setText("6");
                  defaultState = false;
               }
               else
                  textArea.append("6");  
           }
           if (e.getSource() == numberButtons[7])
           {
              if (defaultState) 
               {
                  textArea.setText("7");
                  defaultState = false;
               }
               else
                  textArea.append("7");  
           }
           if (e.getSource() == numberButtons[8])
           {
              if (defaultState) 
               {
                  textArea.setText("8");
                  defaultState = false;
               }
               else
                  textArea.append("8");  
           }
           if (e.getSource() == numberButtons[9])
           {
              if (defaultState) 
               {
                  textArea.setText("9");
                  defaultState = false;
               }
               else
                  textArea.append("9");  
           }
           if (e.getSource() == opButtons[8])
           {
               defaultState = true;
               textArea.setText("0");
               arg1 = 0;
               arg1 = 0;
           }
           if (e.getSource() == opButtons[7])
           {
               arg1 = Double.parseDouble(textArea.getText());
               
               doubleResult = Operations.flipSigns(arg1);
               if (doubleResult == Math.floor(doubleResult))
               {
                   textArea.setText("" + (int) doubleResult);
               }
               else
               {
                   textArea.setText("" + doubleResult);
               }
           }
           if (e.getSource() == opButtons[6])
           {
               arg1 = Double.parseDouble(textArea.getText());
               
               doubleResult = Operations.asPercent(arg1);
               textArea.setText("" + doubleResult);
           }
           if (e.getSource() == opButtons[5])
           {
               arg1 = Double.parseDouble(textArea.getText());
               
               defaultState = true; 
               desiredOperation = "Division";
           }
           if (e.getSource() == opButtons[4])
           {
               arg1 = Double.parseDouble(textArea.getText());
               
               defaultState = true; 
               desiredOperation = "Multiplication"; 
           }
           if (e.getSource() == opButtons[2])
           {
               arg1 = Double.parseDouble(textArea.getText());
               
               defaultState = true; 
               desiredOperation = "Addition";
           }
           if (e.getSource() == opButtons[3])
           {
               arg1 = Double.parseDouble(textArea.getText());
               
               defaultState = true; 
               desiredOperation = "Subtraction"; 
           }
           if (e.getSource() == opButtons[0]) // decimal button
           {
               textArea.append(".");
           }
           if (e.getSource() == opButtons[1])
           {
               if (defaultState)
               {
                    arg1 = doubleResult;

                    switch (desiredOperation)
                    {
                        case "Addition":
                            doubleResult = Operations.addition(arg1, arg2);
                            if (doubleResult == Math.floor(doubleResult))
                            {
                                textArea.setText("" + (int) doubleResult);
                            }
                            else
                            {
                                textArea.setText("" + doubleResult);
                            }
                            break;
                        case "Subtraction":
                            doubleResult = Operations.subtraction(arg1, arg2);
                            if (doubleResult == Math.floor(doubleResult))
                            {
                                textArea.setText("" + (int) doubleResult);   
                            }
                            else
                            {
                                textArea.setText("" + doubleResult);
                            }
                            break;
                        case "Multiplication":
                            doubleResult = Operations.multiplication(arg1, arg2);
                            if (doubleResult == Math.floor(doubleResult))
                            {
                                textArea.setText("" + (int) doubleResult);   
                            }
                            else
                            {
                                textArea.setText("" + doubleResult);
                            }
                            break;
                        case "Division":
                            doubleResult = Operations.division(arg1, arg2);
                            if (doubleResult == Math.floor(doubleResult))
                            {
                                textArea.setText("" + (int) doubleResult);   
                            }
                            else
                            {
                                textArea.setText("" + doubleResult);
                            }
                            break;
                        default:
                            System.exit(-1);
                    }
                }
                else 
                {
                    arg2 = Double.parseDouble(textArea.getText());

                    switch (desiredOperation)
                    {
                        case "Addition":
                            doubleResult = Operations.addition(arg1, arg2);
                            if (doubleResult == Math.floor(doubleResult))
                            {
                                textArea.setText("" + (int) doubleResult);
                                defaultState = true;
                            }
                            else
                            {
                                textArea.setText("" + doubleResult);
                                defaultState = true;
                            }
                            break;
                        case "Subtraction":
                            doubleResult = Operations.subtraction(arg1, arg2);
                            if (doubleResult == Math.floor(doubleResult))
                            {
                                textArea.setText("" + (int) doubleResult);
                                defaultState = true;
                            }
                            else
                            {
                                textArea.setText("" + doubleResult);
                                defaultState = true;
                            }
                            break;
                        case "Multiplication":
                            doubleResult = Operations.multiplication(arg1, arg2);
                            if (doubleResult == Math.floor(doubleResult))
                            {
                                textArea.setText("" + (int) doubleResult);
                                defaultState = true;
                            }
                            else
                            {
                                textArea.setText("" + doubleResult);
                                defaultState = true;
                            }
                            break;
                        case "Division":
                            doubleResult = Operations.division(arg1, arg2);
                            if (doubleResult == Math.floor(doubleResult))
                            {
                                textArea.setText("" + (int) doubleResult);
                                defaultState = true;
                            }
                            else
                            {
                                textArea.setText("" + doubleResult);
                                defaultState = true;
                            }
                            break;
                        default:
                            System.exit(-1);        
                    } 
                }
           }      
        }       
    } // end of buttonListener inner class
    
}
