public class Employee {
    String companyNo;
    String employeeName;
    Double totalAmount;
    int id;

    public Employee(String companyNo, String employeeName, Double totalAmount, int id) {
        this.companyNo = companyNo;
        this.employeeName = employeeName;
        this.totalAmount = totalAmount;
        this.id = id;
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /* This function is used to easily amend the total value of an employee */
    public void addToTotalAmount(Double addition) {
        this.totalAmount += addition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "companyNo='" + companyNo + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
