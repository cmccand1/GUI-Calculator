package calculator;


/**
 *
 * @author clintmccandless
 */
public class Operations {
    
    public static int addition(int x, int y) 
    {
        int result = x + y;
        return result;
    }
    
    public static double addition(double x, double y) 
    {
        double result = x + y;
        return result;
    }
    
    public static int subtraction(int x, int y) 
    {
        int result = x - y;
        return result;
    }
    
    public static double subtraction(double x, double y) 
    {
        double result = x - y;
        return result;
    }
    
    public static double multiplication(double x, double y) 
    {
        double result = x * y;
        return result;
    }
    
    public static double division(double x, double y) 
    {
        double result;
        if (y != 0)
        {
            result = x / y;
            return result;
        }
        else
            return -1;
         
    }
    
    public static double asPercent(double x) 
    {
        double result = x / 100;
        return result;
        
    }
    
    public static double flipSigns(double arg) 
    {
        return arg * -1;
    }
    
   
}
