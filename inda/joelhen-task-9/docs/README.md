### Optimizations for the Sieve of Eratosthenes

Idea 1:
Instead of storing the primality of all numbers up to the input number the primeCache array could be optimized by only storing the primality of odd numbers. Since even numbers (except for 2) cannot be prime, you can reduce the size of the array by half.
