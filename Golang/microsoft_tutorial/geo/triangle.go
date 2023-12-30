package geo

type Triangle struct {
	edge int
}

func (t *Triangle) doubleSize() {
	t.edge *= 2
}

func (t *Triangle) SetEdge(e int) {
	t.edge = e
}

func (t *Triangle) GetPerimeter() int {
	return t.edge * 3
}
