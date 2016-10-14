package DomainClasses;

public class EmployeePay {

    private String employeeName;
    private String finalSalary;

    public EmployeePay(){

    }

    public EmployeePay(String newEmployeeName, String newFinalSalary){

        this.employeeName = newEmployeeName;
        this.finalSalary = newFinalSalary;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getFinalSalary() {
        return finalSalary;
    }


    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setFinalSalary(String finalSalary) {
        this.finalSalary = finalSalary;
    }
}
