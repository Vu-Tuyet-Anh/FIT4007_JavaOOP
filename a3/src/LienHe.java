import java.io.Serializable;

public class LienHe implements Serializable {
    protected String ma, ten, sdt, email;

    public LienHe(String ma, String ten, String sdt, String email) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getSdt() {
        return sdt;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return String.format("|%-10s|%-20s|%-15s|%-20s|", ma, ten, sdt, email);
    }
}
