package guide1.exc1;

public class Rectangle {
    private float width;
    private float height;


    public Rectangle ()
    {
        this.height= 1.0;
        this.width= 1.0;
    }

    public Rectangle (float width, float height) {
        this.width = width;
        this.height = height;
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
    public float getHeight()
    {
        return this.height;
    }
    public float calculateArea()
    {
        float area;
        area=getWidth()*getHeight();
        return area;
    }
    public float calculatePerimeter()
    {
        float perimeter;
        perimeter=2*(getHeight()+getWidth());
        return perimeter;
    }
    public String printHeightAndWidth()
    {
        String showHandW="Width: "+getWidth()+" Height: "+getHeight();
        return showHandW;
    }
    public String printPerimeterAndArea()
    {
        String showPandA="Perimeter: "+calculatePerimeter()+" Area: "+calculateArea();
        return showPandA;
    }
    public void modifyHeightAndWidth(float height, float width)
    {
        setHeight(height);
        setWidth(width);
    }
}
