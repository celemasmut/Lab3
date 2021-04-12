package guide3.circle;

public class Cylinder extends Circle {
    private float height = 1.0f;

    public Cylinder(){
        super();
    }

    public Cylinder(float height, float radio, String colour){
        super(radio,colour);
        this.height=height;
    }

    public float getHeight() {
        return this.height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float calculateVolume(){
        return super.calculateArea()*this.height;
    }

    @Override
    public float calculateArea() {
        return (float) (((Math.PI*2)*super.getRadio()*this.height)+(super.calculateArea()));
    }

    public String showCylinderDat(){
        return "Cylinder{" + "radio="+ getRadio() + " height=" + this.height + " area="+calculateArea()+ " volume="+ calculateVolume()+ '}';
    }

    @Override
    public String toString() {
        return "Cylinder:{" +
                "subclass of="+super.toString()+
                "height="+this.height+
                '}';
    }
}
