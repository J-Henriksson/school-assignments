public class Loops {

    // Method for looping through the 100 first multiples of 7
    public void multiplesOfSeven() {
        int multiple = -1;
        while(multiple < 100) {
            multiple++; 
            System.out.println("7 times " + multiple + " = " + 7 * multiple);  
        }
    }

    // Method that takes one int parameter and sums up every integer up until that parameter 
    public int sumUpTo(int max) {
        int sum = 0;
        int sumNumber = 0;
        while(sumNumber < max) {
            sumNumber++;
            sum += sumNumber;
        }
        return sum;
    }

    // Method that calculates the sum in between two integers
    public int sumBetween(int min, int max) {
        int sum = 0;
        for(int sumNumber = min; sumNumber <= max; sumNumber += 1) {
            sum += sumNumber;
        }

        return sum;
    }

    // Method that squares each number up until the max parameter and adds them together into a sum
    public int sumSquares(int max) {
        int sum = 0;
        for(int sumNumber = 1; sumNumber <= max; sumNumber += 1) {
            sum += Math.pow(sumNumber, 2);
        }

        return sum;
    }
    
    // Method that takes the reciprocal of each number up until the max parameter and adds them together into a sum
    public double sumReciprocals(int max) {
        double sum = 0;
        for(double sumNumber = 1; sumNumber <= max; sumNumber += 1) {
            sum += 1 / sumNumber;
        }

        return sum;
    }

    // Main method
    public static void main(String[] args) {
        Loops loops = new Loops();
        System.out.println(loops.sumBetween(10, 12));
        System.out.println(loops.sumSquares(2));
        System.out.println(loops.sumReciprocals(2));
    }
}
