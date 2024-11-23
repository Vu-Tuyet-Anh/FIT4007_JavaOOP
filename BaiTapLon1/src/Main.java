import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CompanyEmployeeManager manager = new CompanyEmployeeManager();

        // Tải danh bạ từ tệp khi bắt đầu
        manager.loadFromFile();

        while (true) {
            System.out.println("\n=== Quản Lý Danh Bạ Nhân Viên Công Ty A ===");
            System.out.println("1. Thêm phòng ban mới");
            System.out.println("2. Thêm nhân viên mới vào phòng ban");
            System.out.println("3. Xóa phòng ban");
            System.out.println("4. Hiển thị toàn bộ nhân viên (dạng bảng)");
            System.out.println("5. Hiển thị nhân viên trong phòng ban (dạng bảng)");
            System.out.println("6. Tìm kiếm nhân viên");
            System.out.println("7. Lưu danh bạ vào tệp");
            System.out.println("8. Chỉnh sửa thông tin nhân viên");
            System.out.println("9. Xóa nhân viên");
            System.out.println("10. Hiển thị toàn bộ phòng ban");
            System.out.println("11. Thoát chương trình");

            System.out.print("Chọn chức năng (1-11): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng nhập sau khi chọn chức năng

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên phòng ban mới: ");
                    String depName = scanner.nextLine();
                    manager.addDepartment(depName);
                    break;
                case 2:
                    System.out.print("Nhập tên phòng ban: ");
                    String departmentName = scanner.nextLine();
                    System.out.print("Nhập tên nhân viên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập chức vụ: ");
                    String position = scanner.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    String phone = scanner.nextLine();
                    System.out.print("Nhập email: ");
                    String email = scanner.nextLine();
                    Employee newEmployee = new Employee(name, position, phone, email);
                    manager.addEmployeeToDepartment(departmentName, newEmployee);
                    break;
                case 3:
                    System.out.print("Nhập tên phòng ban cần xóa: ");
                    String depNameToDelete = scanner.nextLine();
                    manager.deleteDepartment(depNameToDelete);
                    break;
                case 4:
                    manager.displayAllEmployeesAsTable();
                    break;
                case 5:
                    System.out.print("Nhập tên phòng ban cần xem: ");
                    String depNameToView = scanner.nextLine();
                    manager.displayEmployeesInDepartmentAsTable(depNameToView);
                    break;
                case 6:
                    System.out.print("Nhập từ khóa tìm kiếm: ");
                    String keyword = scanner.nextLine();
                    manager.searchEmployee(keyword);
                    break;
                case 7:
                    manager.saveToFile();
                    break;
                case 8:
                    System.out.print("Nhập tên phòng ban: ");
                    String depForEdit = scanner.nextLine();
                    System.out.print("Nhập tên nhân viên cần chỉnh sửa: ");
                    String empNameToEdit = scanner.nextLine();
                    System.out.print("Nhập thông tin mới cho nhân viên (Chức vụ, Số điện thoại, Email): ");
                    String newPosition = scanner.nextLine();
                    String newPhone = scanner.nextLine();
                    String newEmail = scanner.nextLine();
                    manager.editEmployeeInformation(depForEdit, empNameToEdit, newPosition, newPhone, newEmail);
                    break;
                case 9:
                    System.out.print("Nhập tên phòng ban: ");
                    String depForDeleteEmp = scanner.nextLine();
                    System.out.print("Nhập tên nhân viên cần xóa: ");
                    String empNameToDelete = scanner.nextLine();
                    manager.deleteEmployeeFromDepartment(depForDeleteEmp, empNameToDelete);
                    break;
                case 10:
                    manager.displayAllDepartments();
                    break;
                case 11:
                    System.out.println("Thoát chương trình.");
                    // Lưu lại tệp và thoát
                    manager.saveToFile(); // Lưu lại dữ liệu vào tệp trước khi thoát
                    scanner.close(); // Đóng scanner
                    return; // Thoát khỏi chương trình
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
