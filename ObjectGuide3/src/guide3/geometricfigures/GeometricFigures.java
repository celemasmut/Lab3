package guide3.geometricfigures;

public abstract class GeometricFigures {
    private String colour;

    public GeometricFigures(){}

    public GeometricFigures(String colour){
        this.colour=colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return this.colour;
    }

    public abstract float calculateArea();

    public abstract float calculatePerimeter();

    @Override
    public String toString() {
        return "GeometricFigures{" +
                "colour='" + this.colour + '\'' +
                '}';
    }
}
