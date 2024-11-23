import java.io.*;
import java.util.*;

public class CompanyEmployeeManager {
    private Map<String, Department> departments;

    public CompanyEmployeeManager() {
        departments = new HashMap<>();
    }

    public void addDepartment(String name) {
        if (departments.containsKey(name)) {
            System.out.println("Phòng ban đã tồn tại.");
        } else {
            departments.put(name, new Department(name));
            System.out.println("Đã thêm phòng ban \"" + name + "\".");
        }
    }

    public void addEmployeeToDepartment(String departmentName, Employee employee) {
        Department department = departments.get(departmentName);
        if (department != null) {
            department.addEmployee(employee);
            System.out.println("Đã thêm nhân viên vào phòng ban \"" + departmentName + "\".");
        } else {
            System.out.println("Phòng ban không tồn tại.");
        }
    }

    public void deleteDepartment(String name) {
        if (departments.containsKey(name)) {
            departments.remove(name);
            System.out.println("Đã xóa phòng ban \"" + name + "\".");
        } else {
            System.out.println("Phòng ban không tồn tại.");
        }
    }

    public void displayAllEmployeesAsTable() {
        System.out.println("\n=== Danh Sách Nhân Viên ===");
        System.out.println("Tên | Chức vụ | Số điện thoại | Email");
        for (Department department : departments.values()) {
            for (Employee emp : department.getEmployees()) {
                System.out.println(emp);
            }
        }
    }

    public void displayEmployeesInDepartmentAsTable(String departmentName) {
        Department department = departments.get(departmentName);
        if (department != null) {
            System.out.println("\n=== Danh Sách Nhân Viên trong phòng ban \"" + departmentName + "\" ===");
            System.out.println("Tên | Chức vụ | Số điện thoại | Email");
            for (Employee emp : department.getEmployees()) {
                System.out.println(emp);
            }
        } else {
            System.out.println("Phòng ban không tồn tại.");
        }
    }

    public void searchEmployee(String keyword) {
        System.out.println("\n=== Kết Quả Tìm Kiếm ===");
        System.out.println("Tên | Chức vụ | Số điện thoại | Email");
        for (Department department : departments.values()) {
            for (Employee emp : department.getEmployees()) {
                if (emp.getName().contains(keyword) || emp.getPosition().contains(keyword)) {
                    System.out.println(emp);
                }
            }
        }
    }

    // Phương thức lưu vào tệp .txt
    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt"))) {
            for (String depName : departments.keySet()) {
                writer.write("Phòng ban: " + depName + "\n");
                Department department = departments.get(depName);
                for (Employee emp : department.getEmployees()) {
                    writer.write(emp.getName() + "|" + emp.getPosition() + "|" + emp.getPhoneNumber() + "|" + emp.getEmail() + "\n");
                }
            }
            System.out.println("Đã lưu danh bạ vào tệp.");
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu vào tệp.");
        }
    }

    // Phương thức tải từ tệp .txt
    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("employees.txt"))) {
            String line;
            Department currentDepartment = null;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Phòng ban: ")) {
                    String departmentName = line.substring(12);
                    currentDepartment = new Department(departmentName);
                    departments.put(departmentName, currentDepartment);
                } else {
                    String[] employeeData = line.split("\\|");
                    if (employeeData.length == 4 && currentDepartment != null) {
                        Employee employee = new Employee(employeeData[0], employeeData[1], employeeData[2], employeeData[3]);
                        currentDepartment.addEmployee(employee);
                    }
                }
            }
            System.out.println("Đã tải danh bạ từ tệp.");
        } catch (IOException e) {
            System.out.println("Lỗi khi tải từ tệp.");
        }
    }

    public void editEmployeeInformation(String departmentName, String employeeName, String newPosition, String newPhone, String newEmail) {
        Department department = departments.get(departmentName);
        if (department != null) {
            boolean found = false;
            for (Employee emp : department.getEmployees()) {
                if (emp.getName().equalsIgnoreCase(employeeName)) {
                    emp.setPosition(newPosition);
                    emp.setPhoneNumber(newPhone);
                    emp.setEmail(newEmail);
                    System.out.println("Thông tin của nhân viên \"" + employeeName + "\" đã được chỉnh sửa.");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Không tìm thấy nhân viên với tên \"" + employeeName + "\" trong phòng ban \"" + departmentName + "\".");
            }
        } else {
            System.out.println("Phòng ban \"" + departmentName + "\" không tồn tại.");
        }
    }

    public void deleteEmployeeFromDepartment(String departmentName, String employeeName) {
        Department department = departments.get(departmentName);
        if (department != null) {
            boolean removed = department.removeEmployee(employeeName);
            if (removed) {
                System.out.println("Đã xóa nhân viên \"" + employeeName + "\" khỏi phòng ban \"" + departmentName + "\".");
            } else {
                System.out.println("Không tìm thấy nhân viên với tên \"" + employeeName + "\" trong phòng ban \"" + departmentName + "\".");
            }
        } else {
            System.out.println("Phòng ban \"" + departmentName + "\" không tồn tại.");
        }
    }

    public void displayAllDepartments() {
        System.out.println("\n=== Danh Sách Phòng Ban ===");
        for (String depName : departments.keySet()) {
            System.out.println("- " + depName);
        }
    }
}
