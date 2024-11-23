public class Employee {
    private String name;
    private String position;
    private String phoneNumber;
    private String email;

    public Employee(String name, String position, String phoneNumber, String email) {
        this.name = name;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name + " | " + position + " | " + phoneNumber + " | " + email;
    }
}
