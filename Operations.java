package gui.calculator;


/**
 *
 * @author clintmccandless
 */
public class Operations {
    
    
    public static double addition(double x, double y) 
    {
        return x + y;
    }
    
    
    public static double subtraction(double x, double y) 
    {
        return x - y;
    }
    
    public static double multiplication(double x, double y) 
    {
        return x * y;
    }
    
    public static double division(double x, double y) 
    {
        if (y != 0)
            return x / y;
        else
            return -1;
         
    }
    
    public static double asPercent(double x) 
    {
        return x / 100;
        
    }
    
    public static double flipSigns(double arg) 
    {
        return arg * -1;
    }
    
   
}
