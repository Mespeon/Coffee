package arithmeticexceptions;

public class ArithmeticExceptions {

    public static void main(String[] args) {
        try {
            int num01 = 2;
            int num02 = 0;
            int output = num01/num02;
            System.out.println("The result is: " + output);
        }
        
        catch (ArithmeticException e) {
            System.out.println("You can't divide a number by 0.");
        }
    }
    
}