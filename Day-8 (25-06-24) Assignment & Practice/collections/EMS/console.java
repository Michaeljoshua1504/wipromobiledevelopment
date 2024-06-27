package collections.EMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.UUID;

public class console {
    public int showOptions() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Employee Management System:");
        System.out.println("1. Read All Employee's");
        System.out.println("2. Add Employee");
        System.out.println("3. Update Employee");
        System.out.println("4. Delete Employee");
        System.out.println("5. Exit");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        return choice;
    }

    public emp acceptEmp() throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        
        System.out.print("Enter the emp name: ");
        String name = br.readLine();

        System.out.print("Enter the emp pos: ");
        String pos = br.readLine();

        System.out.print("Enter the salary: ");
        double salary = Double.parseDouble(br.readLine());

        System.out.print("Enter the age: ");
        int age = Integer.parseInt(br.readLine());

        String id = UUID.randomUUID().toString();

        emp e = new emp(id, name, pos, salary, age);
        return e;
    }

    public String removeEmp() throws IOException {
        System.out.print("Enter the emp id: ");

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);

        String id = br.readLine(); 
        return id;
    }

    public String getEmpId() throws IOException {
        System.out.print("Enter the emp Id to update: ");
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);

        String id = br.readLine(); 
        return id;
    }

    public emp editEmp(emp updatedEmp) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        
        System.out.println("Enter the value to edit or leave empty");

        System.out.print("Enter the emp name: ");
        String name = br.readLine();

        System.out.print("Enter the emp pos: ");
        String pos = br.readLine();

        System.out.print("Enter the salary: ");
        String salary = br.readLine();

        System.out.print("Enter the age: ");
        String age = br.readLine();

        if(!name.isEmpty()) {
            updatedEmp.setName(name);
        } if(!pos.isEmpty()) {
            updatedEmp.setPosition(pos);
        } if(!salary.isEmpty()) {
            updatedEmp.setSalary(Double.parseDouble(salary));
        } if(!age.isEmpty()) {
            updatedEmp.setAge(Integer.parseInt(age));
        }

        return updatedEmp;
    }
}