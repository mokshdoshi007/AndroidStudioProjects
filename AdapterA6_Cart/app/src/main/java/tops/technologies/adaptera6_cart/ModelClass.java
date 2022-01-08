package tops.technologies.adaptera6_cart;

public class ModelClass {
    String Name,Rate;
    int Quantity;

    public ModelClass(String name, String rate, int quantity) {
        Name = name;
        Rate = rate;
        Quantity = quantity;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String rate) {
        Rate = rate;
    }

}
