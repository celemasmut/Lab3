package guide3.geometricfigures;

public class Square extends Rectangle{

    public Square(){
        super(3.0f,3.0f);
    }

    public Square(float side, String colour){
        super(side,side,colour);
    }


    @Override
    public String toString() {
        return "Square{" +
                "is a:"+super.toString()+
                '}';
    }
}
