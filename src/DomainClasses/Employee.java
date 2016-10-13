package DomainClasses;

/**
 * Created by eoghanb on 13/10/2016.
 */
public class Employee {
    private int employee_id;
    private String first_name;
    private String last_name;
    private String address_1;
    private String address_2;
    private String city;
    private String postcode;
    private String national_insurance;
    private String bank_account;
    private double salary;

    public Employee(){

    }

    public Employee(int employee_id) {
        this.employee_id = employee_id;
    }

    public Employee(int employee_id, String first_name) {
        this(employee_id);
        this.first_name = first_name;
    }

    public Employee(int employee_id, String first_name, String last_name) {
        this(employee_id, first_name);
        this.last_name = last_name;
    }

    public Employee(int employee_id, String first_name, String last_name, String address_1, String address_2,
                    String city, String postcode) {
        this(employee_id, first_name, last_name);
        this.address_1 = address_1;
        this.address_2 = address_2;
        this.city = city;
        this.postcode = postcode;
    }

    public Employee(int employee_id, String first_name, String last_name, String address_1, String address_2,
                    String city, String postcode, String national_insurance, String bank_account, double salary) {
        this(employee_id, first_name, last_name, address_1, address_2, city, postcode);
        this.national_insurance = national_insurance;
        this.bank_account = bank_account;
        this.salary = salary;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress_1() {
        return address_1;
    }

    public void setAddress_1(String address_1) {
        this.address_1 = address_1;
    }

    public String getAddress_2() {
        return address_2;
    }

    public void setAddress_2(String address_2) {
        this.address_2 = address_2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getNational_insurance() {
        return national_insurance;
    }

    public void setNational_insurance(String national_insurance) {
        this.national_insurance = national_insurance;
    }

    public String getBank_account() {
        return bank_account;
    }

    public void setBank_account(String bank_account) {
        this.bank_account = bank_account;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address_1='" + address_1 + '\'' +
                ", address_2='" + address_2 + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                ", national_insurance='" + national_insurance + '\'' +
                ", bank_account='" + bank_account + '\'' +
                ", salary=" + salary +
                '}';
    }

    public double calcGrossPay(){

        double grossPay = this.getSalary() * 0.75;
        return grossPay;

    }
}
