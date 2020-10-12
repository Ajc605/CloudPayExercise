public class Payment {
    /* variable */
    private String effectiveDate;
    private String companyNo;
    private String employeeName;
    private String paycode;
    private double  amount;

    public Payment(String effectiveDate, String companyNo, String employeeName, String paycode, double amount) {
        this.effectiveDate = effectiveDate;
        this.companyNo = companyNo;
        this.employeeName = employeeName;
        this.paycode = paycode;
        this.amount = amount;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
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

    public String getPaycode() {
        return paycode;
    }

    public void setPaycode(String paycode) {
        this.paycode = paycode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Data{" +
                "effectiveDate='" + effectiveDate + '\'' +
                ", companyNo='" + companyNo + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", paycode='" + paycode + '\'' +
                ", Amount=" + amount +
                '}';
    }

}