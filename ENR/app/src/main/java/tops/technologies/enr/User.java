package tops.technologies.enr;

public class User {
    int cartID;
    long Barcode;
    String employeeID;

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public long getBarcode() {
        return Barcode;
    }

    public void setBarcode(long barcode) {
        Barcode = barcode;
    }
}
