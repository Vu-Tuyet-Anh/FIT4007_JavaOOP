public class GiangVien extends LienHe {
    private String chucVu, boMon;

    public GiangVien(String ma, String ten, String sdt, String email, String chucVu, String boMon) {
        super(ma, ten, sdt, email);
        this.chucVu = chucVu;
        this.boMon = boMon;
    }

    public String getChucVu() {
        return chucVu;
    }

    public String getBoMon() {
        return boMon;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("|%-15s|%-15s|", chucVu, boMon);
    }
}
