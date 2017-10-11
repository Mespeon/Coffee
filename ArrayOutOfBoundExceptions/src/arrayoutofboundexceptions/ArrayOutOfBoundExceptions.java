package arrayoutofboundexceptions;

public class ArrayOutOfBoundExceptions {

    public static void main(String[] args) {
        int array[] = {20, 20, 40};
        int num01 = 15;
        int num02 = 5;
        int result = 10;
        
        try {
            result = num01/num02;
            System.out.println("The result is: " + result);
            
            for (int i = 5; i >= 0; i--){
                System.out.println("The value of array is: " + array[i]);
            }
        }
        
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The array index is out of bounds. \n" + e);
        }
        
        catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero. \n" + e);
        }
       
    }
    
}
