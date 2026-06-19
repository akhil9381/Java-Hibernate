package com.example.student;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    		StudentDAO studentDAO=new StudentDAO();
    		Scanner sc=new Scanner(System.in);
    		while(true) {
    			System.out.println("1.Insert\n2.Update\n3.Find By Id\n4.List all students\n5.Delete by Id\n6.Exit");
    			System.out.print("Enter your choice: ");
    			int choice=sc.nextInt();
    			switch (choice) {
					case 1:
						System.out.print("Enter Student Id: ");
						int id=sc.nextInt();
						System.out.print("Enter Student Name: ");
						sc.nextLine();
						String name=sc.nextLine();
						System.out.print("Enter Student Email: ");
						String email=sc.nextLine();
						System.out.print("Enter Student Course: ");
						String course=sc.nextLine();
						System.out.print("Enter Student age: ");
						int age=sc.nextInt();
						Student newStudent=new Student();
						newStudent.setId(id);
						newStudent.setName(name);
						newStudent.setEmail(email);
						newStudent.setCourse(course);
						newStudent.setAge(age);
						studentDAO.insert(newStudent);
						System.out.println("Student Added Successfully");
						break;
					case 2:
						System.out.print("Enter Student Id: ");
						int uid=sc.nextInt();
						System.out.print("Enter Student Name: ");
						sc.nextLine();
						String uname=sc.nextLine();
						System.out.print("Enter Student Email: ");
						String uemail=sc.nextLine();
						System.out.print("Enter Student Course: ");
						String ucourse=sc.nextLine();
						System.out.print("Enter Student age: ");
						int uage=sc.nextInt();
						Student uStudent=new Student();
						uStudent.setId(uid);
						uStudent.setName(uname);
						uStudent.setEmail(uemail);
						uStudent.setCourse(ucourse);
						uStudent.setAge(uage);
						studentDAO.update(uStudent);
						System.out.println("Student Updated Successfully");
						break;
					case 3:
						System.out.print("Enter Student Id: ");
						int fid=sc.nextInt();
						Student student=studentDAO.find(fid);
						System.out.println(student);
						break;
					case 4:
						List<Student> students=studentDAO.findAll();
						for(Student s:students) {
							System.out.println(s);
						}
						break;
					case 5:
						System.out.print("Enter Student Id: ");
						int did=sc.nextInt();
						studentDAO.delete(did);
						System.out.println("Student Deleted Successfully");
						break;
					case 6:
						sc.close();
						return;
					default:
						break;
				}
    		}
    }
}
