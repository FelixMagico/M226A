public class Square {
    public int side;

    public Square() {
        this.side = 5;
    }

    public Square(int side) {
        if(side<=0){
            this.side = 5;
        }
        else {
            this.side = side;
        }
    }

    public int getArea() {
        return this.side * this.side;
    }
    public int getPerimeter() {
        return this.side * 4;
    }
    public void draw() {
        if (side < 2) {
            System.out.println("La dimensione deve essere almeno 2.");
            return;
        }

        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                if (i == 0 || i == side - 1 || j == 0 || j == side - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    public String getDimension(){
        return "Quadrato "+this.side+"*"+this.side;
    }
}
