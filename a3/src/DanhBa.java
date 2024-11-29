import java.io.*;
import java.util.*;

public class DanhBa {
    private List<SinhVien> danhSachSinhVien = new ArrayList<>();
    private List<GiangVien> danhSachGiangVien = new ArrayList<>();

    // Thêm sinh viên hoặc giảng viên
    public void themSinhVien() {
        Scanner scanner = new Scanner(System.in);
        String ma, ten, sdt, email, khoaHoc, nganh, lop;

        System.out.print("Nhap ma sinh vien: ");
        ma = scanner.nextLine();
        System.out.print("Nhap ten sinh vien: ");
        ten = scanner.nextLine();
        System.out.print("Nhap so dien thoai: ");
        sdt = scanner.nextLine();
        System.out.print("Nhap email: ");
        email = scanner.nextLine();
        System.out.print("Nhap khoa hoc: ");
        khoaHoc = scanner.nextLine();
        System.out.print("Nhap nganh: ");
        nganh = scanner.nextLine();
        System.out.print("Nhap lop: ");
        lop = scanner.nextLine();

        SinhVien sv = new SinhVien(ma, ten, sdt, email, khoaHoc, nganh, lop);
        danhSachSinhVien.add(sv);
    }

    public void themGiangVien() {
        Scanner scanner = new Scanner(System.in);
        String ma, ten, sdt, email, chucVu, boMon;

        System.out.print("Nhap ma giang vien: ");
        ma = scanner.nextLine();
        System.out.print("Nhap ten giang vien: ");
        ten = scanner.nextLine();
        System.out.print("Nhap so dien thoai: ");
        sdt = scanner.nextLine();
        System.out.print("Nhap email: ");
        email = scanner.nextLine();
        System.out.print("Nhap chuc vu: ");
        chucVu = scanner.nextLine();
        System.out.print("Nhap bo mon: ");
        boMon = scanner.nextLine();

        GiangVien gv = new GiangVien(ma, ten, sdt, email, chucVu, boMon);
        danhSachGiangVien.add(gv);
    }

    // Sửa thông tin sinh viên hoặc giảng viên
    public void sua(String ma) {
        boolean timThay = false;
        Scanner scanner = new Scanner(System.in);

        for (SinhVien sv : danhSachSinhVien) {
            if (sv.getMa().equals(ma)) {
                timThay = true;
                System.out.print("Nhap ten moi: ");
                sv.ten = scanner.nextLine();
                System.out.print("Nhap so dien thoai moi: ");
                sv.sdt = scanner.nextLine();
                System.out.print("Nhap email moi: ");
                sv.email = scanner.nextLine();
                break;
            }
        }

        for (GiangVien gv : danhSachGiangVien) {
            if (gv.getMa().equals(ma)) {
                timThay = true;
                System.out.print("Nhap ten moi: ");
                gv.ten = scanner.nextLine();
                System.out.print("Nhap so dien thoai moi: ");
                gv.sdt = scanner.nextLine();
                System.out.print("Nhap email moi: ");
                gv.email = scanner.nextLine();
                break;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay ma.");
        }
    }

    // Xóa sinh viên hoặc giảng viên
    public void xoa(String ma) {
        danhSachSinhVien.removeIf(sv -> sv.getMa().equals(ma));
        danhSachGiangVien.removeIf(gv -> gv.getMa().equals(ma));
    }

    // Tìm kiếm sinh viên hoặc giảng viên
    public void timKiem(String ma) {
        boolean timThay = false;

        for (SinhVien sv : danhSachSinhVien) {
            if (sv.getMa().equals(ma)) {
                timThay = true;
                System.out.println("Sinh vien: ");
                System.out.println(sv);
                break;
            }
        }

        for (GiangVien gv : danhSachGiangVien) {
            if (gv.getMa().equals(ma)) {
                timThay = true;
                System.out.println("Giang vien: ");
                System.out.println(gv);
                break;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay ma.");
        }
    }

    // Hiển thị danh sách sinh viên và giảng viên
    public void hienThi() {
        System.out.println("Danh sach sinh vien: ");
        System.out.printf("|%-10s|%-20s|%-15s|%-20s|%-15s|%-15s|%-10s|\n", "Ma", "Ten", "Sdt", "Email", "Khoa Hoc", "Nganh", "Lop");
        for (SinhVien sv : danhSachSinhVien) {
            System.out.println(sv);
        }

        System.out.println("Danh sach giang vien: ");
        System.out.printf("|%-10s|%-20s|%-15s|%-20s|%-15s|%-15s|\n", "Ma", "Ten", "Sdt", "Email", "Chuc Vu", "Bo Mon");
        for (GiangVien gv : danhSachGiangVien) {
            System.out.println(gv);
        }
    }

    // Lưu danh bạ vào tệp
    public void luuVaoFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("danhba.dat"))) {
            oos.writeObject(danhSachSinhVien);
            oos.writeObject(danhSachGiangVien);
            System.out.println("Danh ba da duoc luu vao tệp danhba.dat.");
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu danh bạ: " + e.getMessage());
        }
    }

    // Đọc danh bạ từ tệp
    public void docTuFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("danhba.dat"))) {
            danhSachSinhVien = (List<SinhVien>) ois.readObject();
            danhSachGiangVien = (List<GiangVien>) ois.readObject();
            System.out.println("Danh ba da duoc tai tu tệp danhba.dat.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi khi tải danh bạ: " + e.getMessage());
        }
    }
}


