import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

/* This application is for the CouldPay Technical test for the Software graduate role.

    Task:
    1) List all payments showing Effective Date,Company No,Employee Name,Paycode,Amount
    Sorted by Effective Date,Company No,Employee Name,Paycode ascending
    Example:

    |Effective Date|Company No|Employee Name|Paycode|Amount|
    |2020-01-01    |XYZ456    |Fred        |BONUS   | 80.22|
    |2020-02-01    |ABC123    |Mary        |BONUS   | 80.22|
    |2020-02-02    |XYZ456    |Jane        |BONUS   | 80.77|
    |2020-03-01    |XYZ456    |Fred        |EXPENSES| 95.50|
    |2020-03-02    |ABC123    |Bob         |BONUS   | 50.00|
    |2020-03-02    |XYZ456    |Jane        |EXPENSES| 20.11|

    2) List total payments for each employee (unsorted)
    Example:

    |CompanyNo |Employee Name|Total Amount|
    |XYZ456    |Fred         |      175.72|
    |ABC123    |Mary         |       80.22|
    |XYZ456    |Jane         |      100.88|
    |ABC123    |Bob          |       50.00|

    The data used for this application can be found in two JSON files. This application
    first gets the contents from the JSON files as local variables for use. This was
    achieved by using a JSON Parser. Once the data is retrieved as a JSON Object, a JSON
    Array is retrieved from the JSON Object. This step was need due to the structure of
    the JSON file. Once this has been complete for the Employee JSON file an array of
    Employee class objects is created using the values found in the JSON Array. This was
    done to achieve 2. Employee class has a addToTotalAmount function that is used to
    add amounts of an individual employee amount value. Once both JSON files have been
    read and local variables have been created the application will loop through all
    values within the payment JSON Array and compare the payment employeeid field with all
    the id field of the employee array. If a match is found then the payment array element
    fields are complete with the relevant data from both arrays. Also the employees amount
    is increased by the amount of the payment. Once this loop is completed, all payments
    records have been recorded with teh data required for task 1. This data is printed out
    in different orders by using Comparators. Then the employee array is displayed to
    achieve task 2.

    This work was completed by Aiden Cooper.
 */
public class App {

    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("CouldPay Technical Test");
        System.out.println("");
        System.out.println("1. List all payments showing Effective Date,Company No,Employee Name, Paycode, Amount");
        JSONParser jsonParser = new JSONParser();

        /* Get employees.json as an JSONArray */
        JSONObject employeesJSONObject = (JSONObject) jsonParser.parse(new FileReader("src/main/resources/employees.json"));
        /* Get the JSON Array from inside employeeJSONObject */
        JSONArray employeesJSONArray = (JSONArray) employeesJSONObject.get("employees");

        /* Create an array of employee objects from the JSONArray of employees */
        Employee[] employees = new Employee[employeesJSONArray.size()];
        for(int i=0; i < employeesJSONArray.size(); i++) {
            employees[i] = new Employee(((JSONObject)employeesJSONArray.get(i)).get("companyNo").toString(),
                    ((JSONObject)employeesJSONArray.get(i)).get("employeeName").toString(),
                    0.00,
                    Integer.parseInt (((JSONObject)employeesJSONArray.get(i)).get("id").toString()));
        }

        /* Get payment.json as an JSONArray */
        JSONObject paymentsJSONObject = (JSONObject) jsonParser.parse(new FileReader("src/main/resources/payments.json"));
        /* Get the JSON Array from inside paymentsJSONObject */
        JSONArray paymentsJSONArray = (JSONArray) paymentsJSONObject.get("payments");

        /* Create an array of payments from the JSONArray payments and employee data*/
        Payment[] payments = new Payment[paymentsJSONArray.size()];
        for(int i=0; i <= paymentsJSONArray.size()-1; i++) {
            for(int j=0; j <= employeesJSONArray.size()-1; j++) {
                /* Check the employee id with all employees numbers to find the corresponding employee */
                if(employees[j].getId() == Integer.parseInt(((JSONObject)paymentsJSONArray.get(i)).get("employeeId").toString())){
                    /* Create a Payment object with data from both resource and add this to the array */
                    payments[i] = new Payment(((JSONObject)paymentsJSONArray.get(i)).get("effectiveDate").toString(),
                    employees[j].getCompanyNo(),
                    employees[j].getEmployeeName(),
                    ((JSONObject)paymentsJSONArray.get(i)).get("paycode").toString(),
                            (Double) ((JSONObject)paymentsJSONArray.get(i)).get("amount"));
                    /* Increase the Employee amount by the amount found in the payment */
                    employees[j].addToTotalAmount((Double) ((JSONObject)paymentsJSONArray.get(i)).get("amount"));
                }
            }
        }

        /* Print array of Payments in different  sorted values */
        System.out.println("Sort by Effective Date");
        Arrays.sort(payments, new effectiveDataComparator());
        for(Payment payment: payments) {
            System.out.println(payment.toString());
        }
        System.out.println("");

        System.out.println("Sort by Company No");
        Arrays.sort(payments, new companyNoComparator());
        for(Payment payment: payments) {
            System.out.println(payment.toString());
        }
        System.out.println("");

        System.out.println("Sort by Employee Name");
        Arrays.sort(payments, new employeeNameComparator());
        for(Payment payment: payments) {
            System.out.println(payment.toString());
        }
        System.out.println("");

        System.out.println("Sort by Paycode");
        Arrays.sort(payments, new paycodeComparator());
        for(Payment payment: payments) {
            System.out.println(payment.toString());
        }
        System.out.println("");

        System.out.println("Sort by Amount");
        Arrays.sort(payments, new amountComparator());
        for(Payment payment: payments) {
            System.out.println(payment.toString());
        }
        System.out.println("");
        System.out.println("");

        /* Print array of Employees */
        System.out.println("2. List of total payments for each employee");
        for(Employee e: employees) {
            System.out.println(e.toString());
        }
    }
}

/* Below is a list of comparators used for 1,  Listing the payments in different orders*/

/* Oder by effective date ascending*/
class effectiveDataComparator implements Comparator<Payment> {
    @Override
    public int compare(Payment payment1, Payment payment2){
        return payment1.getEffectiveDate().compareTo(payment2.getEffectiveDate());
    }
}

/* Oder by company no ascending*/
class companyNoComparator implements Comparator<Payment> {
    @Override
    public int compare(Payment payment1, Payment payment2) {
        return payment1.getCompanyNo().compareTo(payment2.getCompanyNo());
    }
}

/* Oder by employee name ascending*/
class employeeNameComparator implements Comparator<Payment> {
    @Override
    public int compare(Payment payment1, Payment payment2){
        return payment1.getEmployeeName().compareTo(payment2.getEmployeeName());
    }
}

/* Oder by paycode ascending*/
class paycodeComparator implements Comparator<Payment> {
    @Override
    public int compare(Payment payment1, Payment payment2){
        return payment1.getPaycode().compareTo(payment2.getPaycode());
    }
}

/* Oder by amount ascending*/
class amountComparator implements Comparator<Payment> {
    @Override
    public int compare(Payment payment1, Payment payment2){
        if(payment1.getAmount() < payment2.getAmount()) return -1;
        if(payment1.getAmount() > payment2.getAmount()) return 1;
        return 0;
    }
}


