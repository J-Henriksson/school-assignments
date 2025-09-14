package main

import "golang.org/x/tour/pic"

// Pic returns a slice of slices of uint8 for displaying an image.
func Pic(dx, dy int) [][]uint8 {
	pictureSlice := make([][]uint8, dy)
	for i := 0; i < dy; i++ {
		row := make([]uint8, dx)
		for x := 0; x < dx; x++ {
			if x%2 == 0 {
				row[x] = uint8(i*i + x*x)
			} else {
				row[x] = uint8(i*i - x*x)
			}
		}
		pictureSlice[i] = row
	}
	return pictureSlice
}

func main() {
	pic.Show(Pic)
}
