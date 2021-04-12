package guide2.salesControl;

import java.util.UUID;

public class Client {
    //Private properties
    private UUID id;
    private String name;
    private String email;
    private float percentDiscount;

    public Client(String name,String email,float percentDiscount){
        setName(name);
        setId();
        setEmail(email);
        setPercentDiscount(percentDiscount);
    }



    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return this.email;
    }

    public void setPercentDiscount(float percentDiscount){
        this.percentDiscount=percentDiscount;
    }
    public float getPercentDiscount(){
        return this.percentDiscount;
    }


    public void setId(){
        this.id=java.util.UUID.randomUUID();
    }
    public UUID getId(){
        return this.id;
    }


    //Methods

    @Override
    public String toString() {
        return "Client{" +
                ", id='" + getId()+ '\''+
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", percentDiscount=" + getPercentDiscount() +
                '}';
    }
}
