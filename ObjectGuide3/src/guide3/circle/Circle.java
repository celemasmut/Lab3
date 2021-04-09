package guide3.circle;

public class Circle {

    private float radio= 1.0f;
    private String colour= "red";

    public Circle(){

    }
    public Circle(float radio, String colour){
        this.radio=radio;
        this.colour=colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public float getRadio() {
        return this.radio;
    }

    public String getColour() {
        return this.colour;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    public float calculateArea(){
        return (float) (Math.PI*Math.pow(radio, 2));
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radio=" + this.radio +
                ", colour='" + this.colour + '\'' +
                '}';
    }
}
