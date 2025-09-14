// Stefan Nilsson 2013-02-27

// This program creates pictures of Julia sets (en.wikipedia.org/wiki/Julia_set).

/*
Original runtime:

real    1m3.459s
user    1m3.097s
sys     0m0.739s

Improved runtime:

real    0m9.684s
user    1m13.942s
sys     0m0.306s
*/
package main

import (
	"image"
	"image/color"
	"image/png"
	"log"
	"os"
	"strconv"
	"sync"
)

type ComplexFunc func(complex128) complex128

var Funcs []ComplexFunc = []ComplexFunc{
	func(z complex128) complex128 { return z*z - 0.61803398875 },
	func(z complex128) complex128 { return z*z + complex(0, 1) },
}

func main() {

	var wg sync.WaitGroup
	wg.Add(len(Funcs))

	for n, fn := range Funcs {
		go func(n int, fn ComplexFunc) {
			defer wg.Done()
			err := CreatePng("picture-"+strconv.Itoa(n)+".png", fn, 1024)
			if err != nil {
				log.Fatal(err)
			}
		}(n, fn)
	}

	wg.Wait()
}

// CreatePng creates a PNG picture file with a Julia image of size n x n.
func CreatePng(filename string, f ComplexFunc, n int) (err error) {
	file, err := os.Create(filename)
	if err != nil {
		return
	}
	defer file.Close()
	err = png.Encode(file, Julia(f, n))
	return
}

// Julia returns an image of size n x n of the Julia set for f.
func Julia(f ComplexFunc, n int) image.Image {
	bounds := image.Rect(-n/2, -n/2, n/2, n/2)
	img := image.NewRGBA(bounds)
	s := float64(n / 4)
	var wg sync.WaitGroup
	wg.Add(n)

	for i := bounds.Min.X; i < bounds.Max.X; i++ {
		go func(i int) {
			defer wg.Done()
			for j := bounds.Min.Y; j < bounds.Max.Y; j++ {
				val := Iterate(f, complex(float64(i)/s, float64(j)/s), 256)
				r := uint8(0)
				g := uint8(0)
				b := uint8(val % 32 * 8)
				img.Set(i, j, color.RGBA{r, g, b, 255})
			}
		}(i)
	}

	wg.Wait()
	return img
}

// Iterate sets z_0 = z, and repeatedly computes z_n = f(z_{n-1}), n â‰¥ 1,
// until |z_n| > 2  or n = max and returns this n.
func Iterate(f ComplexFunc, z complex128, max int) (n int) {
	for ; n < max; n++ {
		if real(z)*real(z)+imag(z)*imag(z) > 4 {
			break
		}
		z = f(z)
	}
	return
}
