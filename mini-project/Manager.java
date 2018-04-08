import java.io.*;
import java.util.Scanner;

public class Manager {
static String pass="Manager@123";
static int threshold=10;
void Manager() {
	Scanner sc=new Scanner(System.in);
	int i=1;
	while(i<5)
	{
		String s="C:\\Users\\Shubham Mittal\\Desktop\\mini-project\\"+i+".txt";
		try {
			BufferedReader br=new BufferedReader(new FileReader(s));
			while((s=br.readLine())!=null)
			{
				String[] split=s.split(",");
				int j=Integer.parseInt(split[split.length-1]);
				if(j<=5)
				{
					System.out.println("Item with ItemID :"+split[0]+" and genre : "+split[2]+" is less on stock");
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;
	}
	System.out.println("Choose from the below options");
	System.out.println("1. Increse Stock");
	System.out.println("2. Add Items to the Book Store");
	System.out.println("3. LogOut");
	int options=sc.nextInt();
	sc.nextLine();
	while(options!=3)
	{
		if(options==2)
		{
			System.out.println("Choose the genre in which you want to add the item");
			System.out.println("1. Science Fiction");
			System.out.println("2. Horror");
			System.out.println("3. Action and Adventure");
			System.out.println("4. Mystery");
			int choice=sc.nextInt();
			sc.nextLine();
			String s;
			if(choice==1)
			{s="Science Fiction";}
			else if(choice==2)
			{s="Horror";}
			else if(choice==3)
			{s="Action and Adventure";}
			else
			{s="Mystery";}
			Add(choice,s);
			System.out.println("Item added");
		}
		else if(options==1)
		{
			System.out.println("Choose the genre in which you want to add the item");
			System.out.println("1. Science Fiction");
			System.out.println("2. Horror");
			System.out.println("3. Action and Adventure");
			System.out.println("4. Mystery");
			int choice=sc.nextInt();
			sc.nextLine();
			String s;
			if(choice==1)
			{s="Science Fiction";}
			else if(choice==2)
			{s="Horror";}
			else if(choice==3)
			{s="Action and Adventure";}
			else
			{s="Mystery";}
			Inc(choice,s);
			System.out.println("Item added");
			
		}
		System.out.println("Choose from the below options");
		System.out.println("1. Increse Stock");
		System.out.println("2. Add Items to the Book Store");
		System.out.println("3. LogOut");
		options=sc.nextInt();
		sc.nextLine();
	}
}

void Add(int i,String str) {
	Scanner sc=new Scanner(System.in);
	String s="C:\\Users\\Shubham Mittal\\Desktop\\mini-project\\"+i+".txt";
	System.out.println("Enter the name of the book");
	String s1=sc.nextLine();
	System.out.println("Enter the Publisher of the book");
	String s2=sc.nextLine();
	System.out.println("Enter the Author of the book");
	String s3=sc.nextLine();
	System.out.println("Enter the Edition of the book");
	String s4=sc.nextLine();
	System.out.println("Enter the Volume of the book");
	String s5=sc.nextLine();
	System.out.println("Enter the price of the book");
	String s6=sc.nextLine();
	System.out.println("Enter the quantity of the item in the book store");
	String s7=sc.nextLine();
	int a=0;
	try{BufferedReader br=new BufferedReader(new FileReader(s));
	String id="";
	String msg="";
	while((id=br.readLine())!=null)
	{msg=id;}
	String[] ID=msg.split(",");
	a=Integer.parseInt(ID[0]);

	}
	catch(Exception e)
	{e.printStackTrace();}
		try{BufferedWriter bw;
		
			bw = new BufferedWriter(new FileWriter(s,true));
			PrintWriter pw=new PrintWriter(bw);
			pw.println((a++)+","+s1+","+str+","+s2+","+s3+","+s4+","+s5+","+s6+","+s7);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
}

void Inc(int i,String str) {
	Scanner sc=new Scanner(System.in);
	String s="C:\\Users\\Shubham Mittal\\Desktop\\mini-project\\"+i+".txt";
	System.out.println("Enter the ItemID of the item you want to restock");
	String s1=sc.nextLine();
	try {
		BufferedReader br=new BufferedReader(new FileReader(s));
		String msg="";
		StringBuilder fileContent = new StringBuilder();
		while((msg=br.readLine())!=null)
		{
			String[] token=msg.split(",");
			if(token[0].equals(s1))
			{
				System.out.println("Enter the new quantity");
				int quantity=sc.nextInt();
				sc.nextLine();
				token[token.length-1]=Integer.toString(quantity);
				String newline="";
        		for(int j=0;i<token.length-1;i++)
        		{
        			newline += token[j]+",";
        		}
        		fileContent.append(newline);
        		fileContent.append("\n");
			}
			else
			{fileContent.append(msg);
			fileContent.append("\n");}
		}
		BufferedWriter bw1=new BufferedWriter(new FileWriter(s));
        bw1.write(fileContent.toString());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


}
