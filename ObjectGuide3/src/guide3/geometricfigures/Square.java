package guide3.geometricfigures;

public class Square extends GeometricFigures{
    private float side;

    public Square(){
        super();
    }
    public Square(float side){
        super();
        this.side=side;
    }
    public Square(float side, String colour){
        super(colour);
        this.side=side;
    }

    public float getSide() {
        return side;
    }

    public void setSide(float side) {
        this.side = side;
    }

    @Override
    public float calculateArea() {
        return (float) Math.pow(this.side,2);
    }

    @Override
    public float calculatePerimeter() {
        return this.side*4;
    }

    @Override
    public String toString() {
        return "Square{" +
                "is a:"+super.toString()+
                "side=" + side +
                '}';
    }
}
