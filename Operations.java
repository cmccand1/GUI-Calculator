package calculator;


/**
 *
 * @author clintmccandless
 */
public class Operations {
    
    
    public static double addition(double x, double y) 
    {
        double doubleResult = x + y;
        return doubleResult;
    }
    
    
    public static double subtraction(double x, double y) 
    {
        double doubleResult = x - y;
        return doubleResult;
    }
    
    public static double multiplication(double x, double y) 
    {
        double doubleResult = x * y;
        return doubleResult;
    }
    
    public static double division(double x, double y) 
    {
        double doubleResult;
        if (y != 0)
        {
            doubleResult = x / y;
            return doubleResult;
        }
        else
            return -1;
         
    }
    
    public static double asPercent(double x) 
    {
        double doubleResult = x / 100;
        return doubleResult;
        
    }
    
    public static double flipSigns(double arg) 
    {
        return arg * -1;
    }
    
   
}
