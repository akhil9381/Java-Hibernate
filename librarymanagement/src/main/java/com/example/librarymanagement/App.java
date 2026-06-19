package com.example.librarymanagement;

import java.util.List;
import java.util.Scanner;
/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    		LibraryDAO libraryDAO=new LibraryDAO();
    		Scanner sc=new Scanner(System.in);
    		while(true) {
    			System.out.println("1.Insert\n2.Update\n3.Find By Id\n4.List all items\n5.Delete by Id\n6.Exit");
			System.out.print("Enter your choice: ");
			int choice=sc.nextInt();
			switch (choice) {
				case 1:
					System.out.print("Enter Book Id: ");
					int id=sc.nextInt();
					System.out.print("Enter Book Name: ");
					sc.nextLine();
					String name=sc.nextLine();
					System.out.print("Enter Book Author name: ");
					String author=sc.nextLine();
					System.out.print("Enter Book Category: ");
					String cat=sc.nextLine();
					System.out.print("Enter Book Count: ");
					int copies=sc.nextInt();
					System.out.print("Enter Price: ");
					double price=sc.nextDouble();
					Library book=new Library();
					book.setId(id);
					book.setName(name);
					book.setAuthor(author);
					book.setCategory(cat);
					book.setCopies(copies);
					book.setPrice(price);
					libraryDAO.insert(book);
					System.out.println("Book added successfully");
					break;
				case 2:
					System.out.print("Enter Book Id: ");
					int uid=sc.nextInt();
					System.out.print("Enter Book Name: ");
					sc.nextLine();
					String uname=sc.nextLine();
					System.out.print("Enter Book Author name: ");
					String uauthor=sc.nextLine();
					System.out.print("Enter Book Category: ");
					String ucat=sc.nextLine();
					System.out.print("Enter Book Count: ");
					int ucopies=sc.nextInt();
					System.out.print("Enter Price: ");
					double uprice=sc.nextDouble();
					Library ubook=new Library();
					ubook.setId(uid);
					ubook.setName(uname);
					ubook.setAuthor(uauthor);
					ubook.setCategory(ucat);
					ubook.setCopies(ucopies);
					ubook.setPrice(uprice);
					libraryDAO.update(ubook);
					System.out.println("Book updated successfully");
					break;
				case 3:
					System.out.print("Enter Book Id: ");
					int fid=sc.nextInt();
					Library book2=libraryDAO.find(fid);
					System.out.println(book2);
					break;
				case 4:
					List<Library> books=libraryDAO.findAll();
					for(Library p:books) {
						System.out.println(p);
					}
					break;
				case 5:
					System.out.print("Enter Book Id: ");
					int did=sc.nextInt();
					libraryDAO.delete(did);
					System.out.println("Book Deleted Successfully");
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
