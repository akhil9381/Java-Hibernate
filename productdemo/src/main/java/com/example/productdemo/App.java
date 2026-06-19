package com.example.productdemo;

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
    		ProductDAO productDAO=new ProductDAO();
    		Scanner sc=new Scanner(System.in);
    		while(true) {
    			System.out.println("1.Insert\n2.Update\n3.Find By Id\n4.List all items\n5.Delete by Id\n6.Exit");
    			System.out.print("Enter your choice: ");
    			int choice=sc.nextInt();
    			switch (choice) {
					case 1:
						System.out.print("Enter Product Id: ");
						int id=sc.nextInt();
						System.out.print("Enter Product Name: ");
						sc.nextLine();
						String name=sc.nextLine();
						System.out.print("Enter Product Price: ");
						double price=sc.nextDouble();
						Product newProduct=new Product();
						newProduct.setId(id);
						newProduct.setName(name);
						newProduct.setPrice(price);
						productDAO.addProduct(newProduct);
						System.out.println("Product Added Successfully");
						break;
					case 2:
						System.out.print("Enter Product Id: ");
						int uid=sc.nextInt();
						System.out.print("Enter Product Name: ");
						sc.nextLine();
						String uname=sc.nextLine();
						System.out.print("Enter Product Price: ");
						double uprice=sc.nextDouble();
						Product uProduct=new Product();
						uProduct.setId(uid);
						uProduct.setName(uname);
						uProduct.setPrice(uprice);
						productDAO.update(uProduct);
						System.out.println("Product Updated Successfully");
						break;
					case 3:
						System.out.print("Enter Product Id: ");
						int fid=sc.nextInt();
						Product product=productDAO.find(fid);
						System.out.println(product);
						break;
					case 4:
						List<Product> products=productDAO.findAll();
						for(Product p:products) {
							System.out.println(p);
						}
						break;
					case 5:
						System.out.print("Enter Product Id: ");
						int did=sc.nextInt();
						productDAO.delete(did);
						System.out.println("Product Deleted Successfully");
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
