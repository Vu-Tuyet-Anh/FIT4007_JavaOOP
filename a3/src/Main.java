import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DanhBa danhBa = new DanhBa();
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Tải danh bạ từ tệp (nếu có)
        danhBa.docTuFile();

        do {
            System.out.println("\n-------- MENU --------");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Thêm giảng viên");
            System.out.println("3. Sửa thông tin");
            System.out.println("4. Xóa thông tin");
            System.out.println("5. Tìm kiếm thông tin");
            System.out.println("6. Hiển thị danh bạ");
            System.out.println("7. Lưu vào tệp");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Xóa buffer

            switch (choice) {
                case 1:
                    danhBa.themSinhVien();
                    break;
                case 2:
                    danhBa.themGiangVien();
                    break;
                case 3:
                    System.out.print("Nhập mã để sửa thông tin: ");
                    String maSua = scanner.nextLine();
                    danhBa.sua(maSua);
                    break;
                case 4:
                    System.out.print("Nhập mã để xóa thông tin: ");
                    String maXoa = scanner.nextLine();
                    danhBa.xoa(maXoa);
                    break;
                case 5:
                    System.out.print("Nhập mã để tìm kiếm: ");
                    String maTimKiem = scanner.nextLine();
                    danhBa.timKiem(maTimKiem);
                    break;
                case 6:
                    danhBa.hienThi();
                    break;
                case 7:
                    danhBa.luuVaoFile();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);

        // Lưu danh bạ trước khi thoát
        danhBa.luuVaoFile();
    }
}
