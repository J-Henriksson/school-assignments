package main

import (
	"fmt"
	"math"
)

// Sqrt computes the square root of x.
func Sqrt(x float64) float64 {
	z := 1.0

	for math.Abs((z*z-x)/(2*z)) > 0.0001 {
		z -= (z*z - x) / (2 * z)
	}

	return z
}

func main() {
	fmt.Println(Sqrt(2))
}
