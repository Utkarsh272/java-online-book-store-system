import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class Customer {
	Address[] address = new Address[2];
	{address[0] = new Address();
	address[1] = new Address();}
String Name,CustID,Password;
long phone;
void Customer(int a) {
	Scanner sc=new Scanner(System.in);
	if(a==2)
	{
	System.out.println("Enter Your Shipping Address");
	//address[0] = new Address();
	address[0].Address();
	System.out.println("Enter Your Billing Address");
	System.out.println("1. Same as the Shipping Address");
	System.out.println("2. New Billing Address");
	
	int add=sc.nextInt();
	if(add==2)
	{
		address[1].Address();
		
	}
	else
	{
		address[1] = address[0];
	}
	System.out.println("Your Profile is ready");
	}
	System.out.println("Choose from the below options");
	System.out.println("1. View your profile");
	System.out.println("2. Display the Bill History");
	System.out.println("3. Go to your Shopping Cart");
	System.out.println("4. Logout");
	int options=sc.nextInt();
	sc.nextLine();
	while(options!=4)
	{
	switch(options)
	{
	case 1: validate();
	break;
	case 2:
		Bill();
		break;
	case 3:
		GetCart();
		break;
		default:System.out.println("No such option available");
	}
	System.out.println("Choose from the below options");
	System.out.println("1. View your profile");
	System.out.println("2. Display the Bill History");
	System.out.println("3. Go to your Shopping Cart");
	System.out.println("4. Logout");
	options=sc.nextInt();
	sc.nextLine();
	}
	//sc.close();
}
void validate() {
	JOptionPane.showMessageDialog(null, "Name :"+this.Name+"\n"+"CustId :"+this.CustID+"\n"+"Phone Number :"+this.phone);
	address[0].Display();
	address[1].Display();
}
void GetCart() {
	ShoppingCart shopcart = new ShoppingCart();
	shopcart.ShoppingCart(CustID);
}
void Bill() {
	String s1="C:\\Users\\Shubham Mittal\\Desktop\\mini-project\\"+CustID+"bill.txt";
	try {
		BufferedReader br=new BufferedReader(new FileReader(s1));
		String s="";
		
		while((s=br.readLine())!=null)
		{
			String[] split=s.split(",");
			System.out.println("BillId : "+split[0]);
			System.out.println("Date of Bill Generation : "+split[1]);
			System.out.println("Items :");
			for(int j=3;j<split.length-1;j=j+3)
			{
				System.out.println(split[j]+" "+split[j+1]+" "+split[j+2]);
				
			}
			System.out.println("Total amount paid : "+split[2]);
			System.out.println();
			System.out.println();
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
