package guide3.util;

import guide3.circle.Cylinder;
import guide3.college.Person;
import guide3.college.Staff;
import guide3.college.Student;
import guide3.geometricfigures.Circle;
import guide3.geometricfigures.GeometricFigures;
import guide3.geometricfigures.Rectangle;
import guide3.geometricfigures.Square;

public class Util {
   // static Scanner scan = new Scanner(System.in);

    public static void  exerciseMenu() {
        System.out.println("[1] Circle");
        System.out.println("[2] College");
        System.out.println("[3] Geometric Figures");
    }

    public static void circleClass(){
        Cylinder myCylinder1=new Cylinder();
        Cylinder myCylinder2=new Cylinder(2.5f,5.7f,"Light blue");
        System.out.println(myCylinder1.showCylinderDat());
        System.out.println(myCylinder2.showCylinderDat());
        System.out.println(myCylinder2.toString());
    }

    public static void collegeClass(){
        Student x=new Student();
        Student sofia=new Student("12345678","Sofia","Punsol","sofiaPun@mail.com","algun 123","03/04/2021",4750,"Classic");
        Student luis=new Student("34567890","Luis","Punsol","luisPun@mail.com","algun 234","10/04/2021",8750,"Law");
        Student aldo=new Student("56789012","Aldo","Numsot","aldoNum@mail.com","cualk 789","07/03/2012",3500,"Chef");
        Staff n = new Staff();
        Staff belen = new Staff("38479256","Belen","Soneto","beluSoneto@mail.com","dir 123",10000,38000,"Afternoon");
        Staff jose = new Staff("79256838","Jose","Soneto","joseSoneto@mail.com","dire 1234",10000,38000,"Morning");
        Staff alfon = new Staff("384799683","Alfonso","Soneto","alfonSoneto@mail.com","add 423",10000,38000,"Afternoon");
        Staff clau = new Staff("74679256","Claudia","Soneto","clauSoneto@mail.com","dir 733",10000,38000,"Morning");
        Person [] college=new Person[8];
        college[0]=sofia;
        college[1]=luis;
        college[2]=aldo;
        college[3]=x;
        college[4]=n;
        college[5]=belen;
        college[6]=alfon;
        college[7]=clau;
        int i=0,j=0;
        for(Person thePerson : college){
            if(thePerson instanceof Student) i++;
            if (thePerson instanceof Staff) j++;
        }
        System.out.println("In the array there are "+i+" Students and "+j+" Staff");
        float total=0;
        for(Person stud : college){
            if(stud instanceof Student) total+=((Student) stud).getMonthlyFee();
        }
        System.out.println("College's income :$"+total);
    }

    public static void geometricFiguresClass(){
        Circle circle1=new Circle(4.3f);
        Circle circle2=new Circle();

        Rectangle rectangle1 = new Rectangle();
        Rectangle rectangle2= new Rectangle(2.7f,0.8f,"Mahogany");

        Square square1 = new Square();
        Square square2 = new Square(6.0f,"Aqua");

        GeometricFigures [] myGeometricFigures = new GeometricFigures[6];
        myGeometricFigures[0]=circle1;
        myGeometricFigures[1]=circle2;
        myGeometricFigures[2]=rectangle1;
        myGeometricFigures[3]=rectangle2;
        myGeometricFigures[4]=square1;
        myGeometricFigures[5]=square2;

        for(GeometricFigures myFig : myGeometricFigures){
            System.out.println(myFig.toString());
        }

    }
}
