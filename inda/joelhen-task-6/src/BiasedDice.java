import java.util.Random;

public class BiasedDice extends Dice{
    

    public BiasedDice() {
        random = new Random();
        value = random.nextInt(2);
        if (value == 0) {
            value = 6;
        }
        else {
            value = random.nextInt(5) + 1;
        }
    }
}
