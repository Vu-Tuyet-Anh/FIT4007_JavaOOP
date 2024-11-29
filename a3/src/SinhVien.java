public class SinhVien extends LienHe {
    private String khoaHoc, nganh, lop;

    public SinhVien(String ma, String ten, String sdt, String email, String khoaHoc, String nganh, String lop) {
        super(ma, ten, sdt, email);
        this.khoaHoc = khoaHoc;
        this.nganh = nganh;
        this.lop = lop;
    }

    public String getKhoaHoc() {
        return khoaHoc;
    }

    public String getNganh() {
        return nganh;
    }

    public String getLop() {
        return lop;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("|%-15s|%-15s|%-10s|", khoaHoc, nganh, lop);
    }
}
