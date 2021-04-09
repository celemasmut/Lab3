package guide3.geometricfigures;

public class Rectangle extends GeometricFigures {
  private   float width;
   private float height;

    public Rectangle () {
        super();
    }
    public Rectangle(float width, float height){
        super();
        this.height=height;
        this.width=width;
    }
    public Rectangle(float width, float height, String colour){
        super(colour);
        this.height=height;
        this.width=width;
    }
    public void setWidth(float width)
    {
        this.width=width;
    }
    public void setHeight(float height)
    {
        this.height=height;
    }
    public float getWidth()
    {
        return this.width;
    }
    public float getHeight() {
        return this.height;
    }

    @Override
    public float calculateArea() {
        return this.width*this.height;
    }

    @Override
    public float calculatePerimeter() {
        return 2*(this.width+this.height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "is a :"+super.toString()+
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
