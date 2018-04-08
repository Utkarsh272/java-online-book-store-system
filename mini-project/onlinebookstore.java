import java.io.*;
import java.math.BigDecimal;
import java.util.*;
//import java.util.Scanner;

public class onlinebookstore {

	public static void main(String[] args) {
		
		ArrayList<Customer> list = new ArrayList<Customer>();
		
System.out.println("Welcome to the Online Book Store");
System.out.println("Choose from the below options");
System.out.println("1. Old Customer");
System.out.println("2. New Customer");
System.out.println("3. Manager");
System.out.println("4. Exit");
Scanner sc=new Scanner(System.in);
int option=Integer.parseInt(sc.nextLine());
//sc.nextLine();
while(option!=4)
	{switch(option){
	case 1:
		int j=0;
		System.out.println("Enter your Customer ID");
		String custId = sc.nextLine();
		for(int i = 0;i<list.size();i++)
		{
			if(custId.equals(list.get(i).CustID))
			{
				System.out.println("Enter your password");
				String pass=sc.nextLine();
				if(pass.equals(list.get(i).Password))
				{System.out.println("Welcome to online book store");
				list.get(i).Customer(option);}
				else
				{System.out.println("Wrong Password");}
				break;
			}
			else
			{j++;}
		}
		if(j==list.size())
		{System.out.println("Wrong Customer ID");}
		break;
		
		
	case 2:

		list.add(new Customer());
		System.out.println("Welcome to Online Book Store");
		sc.nextLine();
		System.out.println("Enter your desired Customer Id");
		custId=sc.nextLine();
		System.out.println("Enter your desired Password");
		String pass=sc.nextLine();
		System.out.println("Enter your name");
		String name=sc.nextLine();
		System.out.println("Enter your Phone Number");
		long phn=sc.nextLong();
		sc.nextLine();
		list.get(list.size()-1).CustID=custId;
		list.get(list.size()-1).Password=pass;
		list.get(list.size()-1).Name=name;
		list.get(list.size()-1).phone=phn;
		String s="C:\\Users\\Shubham Mittal\\Desktop\\mini-project\\"+custId+".txt";
		String s1="C:\\Users\\Shubham Mittal\\Desktop\\mini-project\\"+custId+"bill.txt";
		String s2="C:\\Users\\Shubham Mittal\\Desktop\\mini-project\\"+custId+"recommendations.txt";
		try {
			BufferedWriter br=new BufferedWriter(new FileWriter(s));
			BufferedWriter br1=new BufferedWriter(new FileWriter(s1));
			BufferedWriter br2=new BufferedWriter(new FileWriter(s2));
			br.close();
			br1.close();
			br2.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list.get(list.size()-1).Customer(option);
		break;
	
	
	case 3:Manager mg=new Manager();
	
		System.out.println("Enter the password");
	String q=sc.nextLine();
	if(q.equals(mg.pass))
	{mg.Manager();}
	else
	{System.out.println("Wrong Password");}
		break;
	
	
	default:System.out.println("No such option available");
	
	}
	System.out.println("Welcome to the Online Book Store");
	System.out.println("Choose from the below options");
	System.out.println("1. Old Customer");
	System.out.println("2. New Customer");
	System.out.println("3. Manager");
	System.out.println("4. Exit");
	option=sc.nextInt();
	sc.nextLine();		
	}
//sc.close();

	}

}
