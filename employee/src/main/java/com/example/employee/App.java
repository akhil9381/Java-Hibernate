package com.example.employee;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    		EmployeeDAO employeeDAO=new EmployeeDAO();
    		Scanner sc=new Scanner(System.in);
    		while(true) {
    			System.out.println("1.Insert\n2.Update\n3.Find By Id\n4.List all items\n5.Delete by Id\n6.Exit");
			System.out.print("Enter your choice: ");
			int choice=sc.nextInt();
			switch (choice) {
				case 1:
					System.out.print("Enter Employee Id: ");
					int id=sc.nextInt();
					System.out.print("Enter Employee Name: ");
					sc.nextLine();
					String name=sc.nextLine();
					System.out.print("Enter Employee Department: ");
					String dept=sc.nextLine();
					System.out.print("Enter Employee Joining Date(yyyy-mm-dd): ");
					String date=sc.nextLine();
					LocalDate jd=LocalDate.parse(date);
					System.out.print("Enter Employee salary: ");
					int salary=sc.nextInt();
					Employee employee=new Employee();
					employee.setId(id);
					employee.setName(name);
					employee.setDepartment(dept);
					employee.setSalary(salary);
					employee.setJoiningDate(jd);
					employeeDAO.insert(employee);
					System.out.println("Employee added successfully");
					break;
				case 2:
					System.out.print("Enter Employee Id: ");
					int uid=sc.nextInt();
					System.out.print("Enter Employee Name: ");
					sc.nextLine();
					String uname=sc.nextLine();
					System.out.print("Enter Employee Department: ");
					String udept=sc.nextLine();
					System.out.print("Enter Employee Joining Date(yyyy-mm-dd): ");
					String udate=sc.nextLine();
					LocalDate ujd=LocalDate.parse(udate);
					System.out.print("Enter Employee salary: ");
					int usalary=sc.nextInt();
					Employee uemployee=new Employee();
					uemployee.setId(uid);
					uemployee.setName(uname);
					uemployee.setDepartment(udept);
					uemployee.setSalary(usalary);
					uemployee.setJoiningDate(ujd);
					employeeDAO.update(uemployee);
					System.out.println("Employee updated successfully");
					break;
				case 3:
					System.out.print("Enter Employee Id: ");
					int fid=sc.nextInt();
					Employee employee2=employeeDAO.find(fid);
					System.out.println(employee2);
					break;
				case 4:
					List<Employee> employees=employeeDAO.findAll();
					for(Employee p:employees) {
						System.out.println(p);
					}
					break;
				case 5:
					System.out.print("Enter Employee Id: ");
					int did=sc.nextInt();
					employeeDAO.delete(did);
					System.out.println("Employee Deleted Successfully");
					break;
				case 6:
					Utility.shutdown();
					sc.close();
					return;
				default:
					break;
			}
		}
    }
}
