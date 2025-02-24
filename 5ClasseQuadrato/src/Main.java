//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Square square1 = new Square();
        Square square2 = new Square(7);
        Square square3 = new Square(2);

        System.out.println(square1.getDimension());
        System.out.println(square1.getArea());
        System.out.println(square1.getPerimeter());
        square1.draw();

        System.out.println(square2.getDimension());
        System.out.println(square2.getArea());
        System.out.println(square2.getPerimeter());
        square2.draw();

        System.out.println(square3.getDimension());
        System.out.println(square3.getArea());
        System.out.println(square3.getPerimeter());
        square3.draw();
    }
}