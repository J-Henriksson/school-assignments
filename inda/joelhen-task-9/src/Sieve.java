import java.util.Arrays;
import java.lang.Math;

/**
 * Implementation of the Sieve of Eratosthenes algorithm for checking if a
 * number is prime or not. The implementation is lacking in error-checking
 * and optimization, and needs some patching up!
 *
 * @author Simon Larsén
 * @author Joel Henriksson
 */
public class Sieve {
    private boolean[] primeCache = new boolean[0];

    private void exceptionIfIllegalArg(int number) {
        if (number < 2 || number >  Math.pow(2, 26)) {
            throw new IllegalArgumentException("Number must be greater or equal than 2");
        }
    }

    private boolean[] sieve(int number) {
        if (number < primeCache.length) {
            return primeCache;
        }
        else {
            boolean[] prime = new boolean[(number + 1) / 2]; // + 1 because of 0-indexing
            Arrays.fill(prime, true); // Assume all numbers are prime
            int sqrt = (int) Math.floor(Math.sqrt(number));
            for (int i = 1; i <= (sqrt - 1) / 2; i++) {
                if (prime[i]) {
                    int iActual = i * 2 + 1;
                    for (int j = iActual*iActual; j <= prime.length * 2 - 1; j += iActual) {
                        prime[(j - 1)/ 2] = false; // Mark multiples of i as not prime
                        System.out.println((j - 1)/ 2 + "is not prime");
                    }
                }
            }
            primeCache = prime.clone();
            return prime;
        }
    }

    /**
     * Check if a number is prime or not!
     *
     * Note that prime[n] denotes the primality of number n.
     *
     * @param   number  An integer value to be checked for primality.
     * @return  true if number is prime, false otherwise.
     */
    public boolean isPrime(int number) {
        exceptionIfIllegalArg(number);
        if (number == 2) {
            return true;
        }
        else if (number % 2 ==  0) {
            return false;
        }
        else {
            boolean[] prime = sieve(number);
            return prime[(number - 1) / 2];
        }
    }

    public static void main(String[] args) {
        Sieve primeChecker = new Sieve();
        System.out.println(primeChecker.isPrime(9));
    }
}