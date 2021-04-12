package guide2.salesControl;

import java.util.UUID;

public class SaleItem {
        private UUID id;
        private String name;
        private String description;
        private float unitPrice;

        public SaleItem(){
            setId();
        }


        public SaleItem(String name,String description, float unitPrice)
        {
            setId();
            setName(name);
            setDescription(description);
            setUnitPrice(unitPrice);
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

         public void setDescription(String description)
        {
            this.description=description;
        }
        public void setUnitPrice(float unitPrice)
        {
            this.unitPrice=unitPrice;
        }

        public String getDescription()
        {
            return this.description;
        }
        public float getUnitPrice()
        {
            return this.unitPrice;
        }

        public UUID  getID()
        {
            return this.id;
        }

    public void setId(){
        this.id = java.util.UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "SaleItem{" +
                "id='" + getID() + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", unitPrice=" + getUnitPrice() +
                '}';
    }
}
