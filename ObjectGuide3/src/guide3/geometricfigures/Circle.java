package guide3.geometricfigures;

public class Circle extends GeometricFigures{

    private float radio= 1.0f;

    public Circle(){
        super();
    }
    public Circle(float radio){
        super();
        this.radio=radio;
    }
    public Circle(float radio, String colour){
        super(colour);
        this.radio=radio;
    }


    public float getRadio() {
        return this.radio;
    }
    public void setRadio(float radio) {
        this.radio = radio;
    }

    @Override
    public float calculatePerimeter() {
        return (float) ((2*Math.PI)*this.radio);
    }

    @Override
    public float calculateArea() {
        return (float) (Math.PI*Math.pow(radio, 2));
    }

    @Override
    public String toString() {
        return "Circle{" +
                "is a:"+super.toString()+
                "radio=" + radio +
                ", area="+calculateArea()+
                ", perimeter="+calculatePerimeter()+
                '}';
    }
}
