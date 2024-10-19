import java.util.Scanner;
class NgoaiThanh extends ChuyenXe
{
    private String noiDen;
    private int soNgay;
    Scanner in = new Scanner(System.in);
    public void setNoiDen(String noiDen) {
        this.noiDen = noiDen;
    }
    public String getNoiDen() {
        return noiDen;
    }
    public void setSoNgay(int soNgay) {
        this.soNgay = soNgay;
    }
    public int getSoNgay() {
        return soNgay;
    }
    public NgoaiThanh()
    {
        super();
        this.soNgay=0;
        this.noiDen="";
    }
    public NgoaiThanh(String Max, String NameTX, String SoX, double DoanhThu, String noiDen,
                      int soNgay)
    {
        super(Max, NameTX, SoX, DoanhThu);
        this.soNgay=soNgay;
        this.noiDen=noiDen;
    }
    public void nhap()
    {
        super.wait();
        System.out.println("Noi Den: ");
        this.noiDen=in.nextLine();
        System.out.println("So Ngay: ");
        this.soNgay=in.nextInt();
    }
    public String toString()
    {
        return "Chuyen Xe Ngoai Thanh" + super.toString()
                + "\nNoi Den: " + this.noiDen + "\nSo Ngay: " + this.soNgay
                + "\nDoanh Thu: " + this.DoanhThu;
    }
}