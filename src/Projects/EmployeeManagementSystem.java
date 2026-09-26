package Projects;

import java.util.ArrayList;

class Employee{
    private final String id;
    private String name;
    private int age;
    private String designation;
    private int salary;

    Employee(String id){
        this.id = id;
    }

    Employee(String id, String name, int age, String designation, int salary){
        this.id = id;
        this.name = name;
        if(age >= 0)  this.age = age;
        this.designation = designation;
        if(salary >= 5000) this.salary = salary;
    }

    // getters
    String getId(){
        return id;
    }
    String getName(){
        return name;
    }
    String getDesignation(){
        return designation;
    }
    int getAge(){
        return age;
    }
    int getSalary(){
        return salary;
    }

    // setters
    void setName(String name){
        this.name = name;
    }
    void setDesignation(String designation){
        this.designation = designation;
    }
    void setAge(int age){
        this.age = age;
    }
    void setSalary(int salary){
        this.salary = salary;
    }

    void displayEmployeeDetails(){
        System.out.println("EmployeeId: " + id);
        System.out.println("EmployeeName: " + name);
        System.out.println("EmployeeAge: " + age);
        System.out.println("EmployeeDesignation: " + designation);
        System.out.println("EmployeeSalary: " + salary);
    }
}

public class EmployeeManagementSystem {
    ArrayList<Employee> employeesList = new ArrayList<>();

    void addEmployee(String id, String name, int age, String designation, int salary){
        employeesList.add(new Employee(id, name, age, designation, salary));
    }

    void displayAllEmployeeData(){
        System.out.println("EmployeeId EmployeeName EmployeeAge EmployeeDesignation EmployeeSalary");
        for(Employee emp: employeesList){
            System.out.print(emp.getId() + "             ");
            System.out.print(emp.getName() + "           ");
            System.out.print(emp.getAge() + "           ");
            System.out.print(emp.getDesignation() + "                ");
            System.out.print(emp.getSalary() + "           ");
            System.out.println();
        }
    }

    Employee searchEmployee(String id){
        for(Employee emp: employeesList){
            if(emp.getId().equals(id)) return emp;
        }
        return null;
    }

    String deleteEmployee(String id){
        for(Employee emp: employeesList){
            if(emp.getId().equals(id)){
                employeesList.remove(emp);
                return "Employee Data Removed";
            }
        }
        return "Employee Not Found!!";
    }

    String updateEmployeeName(String id, String name){
        for(Employee emp: employeesList){
            if(emp.getId().equals(id)){
                emp.setName(name);
                return "Employee Name Updated";
            }
        }
        return "Employee Not Found!!";
    }
    String updateEmployeeAge(String id, int age){
        for(Employee emp: employeesList){
            if(emp.getId().equals(id)){
                emp.setAge(age);
                return "Employee Age Updated";
            }
        }
        return "Employee Not Found!!";
    }
    String updateEmployeeDesignation(String id, String designation){
        for(Employee emp: employeesList){
            if(emp.getId().equals(id)){
                emp.setDesignation(designation);
                return "Employee Designation Updated";
            }
        }
        return "Employee Not Found!!";
    }
    String updateEmployeeSalary(String id, int salary){
        for(Employee emp: employeesList){
            if(emp.getId().equals(id)){
                emp.setSalary(salary);
                return "Employee Salary Updated";
            }
        }
        return "Employee Not Found!!";
    }


    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        // add employees
        ems.addEmployee("E1", "Daksh", 22, "SDE", 125000);
        ems.addEmployee("E2", "Sneha", 25, "SDE2", 250000);
        ems.addEmployee("E3", "Aryan", 22, "SDE", 125000);
        ems.addEmployee("E4", "Shreya", 22, "SDE", 125000);

        // display data of all employees
        ems.displayAllEmployeeData();

        // search employee
        Employee tempEmp = ems.searchEmployee("E1");

        if(tempEmp != null) {
            System.out.println("EmployeeId: " + tempEmp.getId());
            System.out.println("EmployeeName: " + tempEmp.getName());
            System.out.println("EmployeeAge: " + tempEmp.getAge());
            System.out.println("EmployeeDesignation: " + tempEmp.getDesignation());
            System.out.println("EmployeeSalary: " + tempEmp.getSalary());
        }
        else System.out.println("No Data Found");

        // delete employee
        System.out.println(ems.deleteEmployee("E4"));

        // update employee data
        System.out.println(ems.updateEmployeeName("E1", "Daksh sharma"));
        ems.displayAllEmployeeData();
    }
}
