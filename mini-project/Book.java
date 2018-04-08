import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Book extends Item {
	String Author,Edition;
	int Volume;

	void Item(String str) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Do you want to see our recommendations for you(1 Yes/ 0 No)");
		int op=sc.nextInt();
		sc.nextLine();
		if(op==1)
		{recommendations(str);}
		System.out.println("Choose the genre of the book you want to select");
		System.out.println("1. Science Fiction");
		System.out.println("2. Horror");
		System.out.println("3. Action and Adventure");
		System.out.println("4. Mystery");
		System.out.println("0. Exit");
		int options=sc.nextInt();
		sc.nextLine();
		//while(options != 0)
		//{
			switch(options)
			{
			case 1:Display(1); break;
			case 2:Display(2); break;
			case 3:Display(3); break;
			case 4:Display(4); break;
			default:System.out.println("No such genre available");
			}
			//System.out.println("Choose the genre of the book you want to select");
			//System.out.println("1. Science Fiction");
			//System.out.println("2. Horror");
			//System.out.println("3. Action and Adventure");
			//System.out.println("4. Mystery");
			//System.out.println("0. Exit");
			//options=sc.nextInt();
			//sc.nextLine();
		//}
	}

	private void Display(int i) {
		Scanner sc=new Scanner(System.in);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Shubham Mittal\\Desktop\\mini-project\\"+i+".txt"));
			String str="";
			System.out.format("%6s %32s %20s %32s %32s %8s %7s %8s %s", "ItemID","Title","Genre","Publisher","Author","Editon","Volume","Price","Availability");
			System.out.print("\n");
			while((str=br.readLine())!=null)
			{
				//String msg=s;
				String[] Token=str.split(",");
				if(!Token[Token.length-1].equals("0"))
				{System.out.format("%6s %32s %20s %32s %32s %8s %7s %8s %s", Token[0],Token[1],Token[2],Token[3],Token[4],Token[5],Token[6],Token[7],"Available");
					//System.out.println(Arrays.toString(Token));
			
				}
				else
				{System.out.format("%6s %32s %20s %32s %32s %8s %7s %8s %s", Token[0],Token[1],Token[2],Token[3],Token[4],Token[5],Token[6],Token[7],"Not Available");}
			System.out.print("\n");
			}	
			
			
			System.out.println("Choose from the below options");
			System.out.println("1. Back");
			System.out.println("2. choose from the shown books");
			int a=sc.nextInt();
			sc.nextLine();
			if(a==2)
			{System.out.println("Enter the ItemID of the book you want to Buy");
			int choice=sc.nextInt();
			sc.nextLine();
			String s="";
			String ms="";
			//int b=1;
			br = new BufferedReader(new FileReader("C:\\Users\\Shubham Mittal\\Desktop\\mini-project\\"+i+".txt"));
			while((s=br.readLine())!=null)
			{String[] st=s.split(",");
			if(st[0].equals(choice));
			{ms=s;}
			}
			
			//System.out.println(s);
			String[] st =ms.split(",");
			//System.out.println(st[0]);
			itemid=st[0];
			title=st[1];
			genre=st[2];
			publisher=st[3];
			Author=st[4];
			Edition=st[5];
			Volume=Integer.parseInt(st[6]);
			price=Double.parseDouble(st[7]);
			QTY=Integer.parseInt(st[8]);
			System.out.println("Enter the quantity(not more than 5)");
			int c=sc.nextInt();
			sc.nextLine();
			if(c>5)
			{
				System.out.println("Quantity of this item can not be more than 5");
			}
			else if(c>QTY)
			{
				System.out.println("Only "+QTY+" books left");
			}
			else
				quantity=c;
			}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	void recommendations(String str){
		Scanner sc=new Scanner(System.in);
		String s="C:\\Users\\Shubham Mittal\\Desktop\\mini-project\\"+str+"recommendations.txt";
		try {
			BufferedReader br=new BufferedReader(new FileReader(s));
			File file=new File(s);
			if(file.length()==0)
			{System.out.println("We don't have any recommendations for you at the moment");}
			else
			{
				String s1="";
				while((s1=br.readLine())!=null)
				{
					if(s1.equals("Science Fiction"))
					{
						try {
							BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\Admin\\Desktop\\mini-project\\1.txt"));
							String s2="";
							String msg="";
							int o=1;
							while((s2=br1.readLine())!=null)
							{msg+=o+" "+s2+"\n";
							o++;}
							System.out.println(msg);
							
							System.out.println("Choose from the below options");
							System.out.println("1. Back");
							System.out.println("2. choose from the shown books");
							int a=sc.nextInt();
							sc.nextLine();
							if(a==2)
							{System.out.println("Enter your choice");
							int choice=sc.nextInt();
							sc.nextLine();
							s2="";
							String ms="";
							int b=1;
							br1 = new BufferedReader(new FileReader("C:\\Users\\Shubham Mittal\\Desktop\\mini-project\\1.txt"));
							while((s2=br1.readLine())!=null)
							{if(b==choice)
								{ms+=s2;}
							b++;}
							
							System.out.println(s2);
							String[] st =ms.split(",");
							System.out.println(st[0]);
							itemid=st[0];
							title=st[1];
							genre=st[2];
							publisher=st[3];
							Author=st[4];
							Edition=st[5];
							Volume=Integer.parseInt(st[6]);
							price=Double.parseDouble(st[7]);
							System.out.println("Enter the quantity(not more than 5)");
							int c=sc.nextInt();
							sc.nextLine();
							quantity=c;
							}
						} 
						catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else if(s1.equals("Horror"))
					{
						try {
							BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\Shubham Mittal\\Desktop\\mini-project\\2.txt"));
							String s2="";
							String msg="";
							int j=1;
							while((s2=br1.readLine())!=null)
							{msg+=j+" "+s2+"\n";
							j++;}
							System.out.println(msg);
							
							System.out.println("Choose from the below options");
							System.out.println("1. Back");
							System.out.println("2. choose from the shown books");
							int a=sc.nextInt();
							sc.nextLine();
							if(a==2)
							{System.out.println("Enter your choice");
							int choice=sc.nextInt();
							sc.nextLine();
							s2="";
							String ms="";
							int b=1;
							br1 = new BufferedReader(new FileReader("C:\\Users\\Shubham Mittal\\Desktop\\mini-project\\2.txt"));
							while((s2=br1.readLine())!=null)
							{if(b==choice)
								{ms+=s2;}
							b++;}
							
							System.out.println(s2);
							String[] st =ms.split(",");
							System.out.println(st[0]);
							itemid=st[0];
							title=st[1];
							genre=st[2];
							publisher=st[3];
							Author=st[4];
							Edition=st[5];
							Volume=Integer.parseInt(st[6]);
							price=Double.parseDouble(st[7]);
							System.out.println("Enter the quantity(not more than 5)");
							int c=sc.nextInt();
							sc.nextLine();
							quantity=c;
							}
						} 
						catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else if(s1.equals("Action and Adventure"))
					{
						try {
							BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\Shubham Mittal\\Desktop\\mini-project\\3.txt"));
							String s2="";
							String msg="";
							int k=1;
							while((s2=br1.readLine())!=null)
							{msg+=k+" "+s2+"\n";
							k++;}
							System.out.println(msg);
							//br.close();
							System.out.println("Choose from the below options");
							System.out.println("1. Back");
							System.out.println("2. choose from the shown books");
							int a=sc.nextInt();
							sc.nextLine();
							if(a==2)
							{System.out.println("Enter your choice");
							int choice=sc.nextInt();
							sc.nextLine();
							s2="";
							String ms="";
							int b=1;
							br1 = new BufferedReader(new FileReader("C:\\Users\\Shubham Mittal\\Desktop\\mini-project\\3.txt"));
							while((s2=br1.readLine())!=null)
							{if(b==choice)
								{ms+=s2;}
							b++;}
							
							System.out.println(s2);
							String[] st =ms.split(",");
							System.out.println(st[0]);
							itemid=st[0];
							title=st[1];
							genre=st[2];
							publisher=st[3];
							Author=st[4];
							Edition=st[5];
							Volume=Integer.parseInt(st[6]);
							price=Double.parseDouble(st[7]);
							System.out.println("Enter the quantity(not more than 5)");
							int c=sc.nextInt();
							sc.nextLine();
							quantity=c;
							}
						} 
						catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else
					{
						try {
							BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\Shubham Mittal\\Desktop\\mini-project\\4.txt"));
							String s2="";
							String msg="";
							int l=1;
							while((s2=br1.readLine())!=null)
							{msg+=l+" "+s2+"\n";
							l++;}
							System.out.println(msg);
							//br.close();
							System.out.println("Choose from the below options");
							System.out.println("1. Back");
							System.out.println("2. choose from the shown books");
							int a=sc.nextInt();
							sc.nextLine();
							if(a==2)
							{System.out.println("Enter your choice");
							int choice=sc.nextInt();
							sc.nextLine();
							s2="";
							String ms="";
							int b=1;
							br1 = new BufferedReader(new FileReader("C:\\Users\\Shubham Mittal\\Desktop\\mini-project\\4.txt"));
							while((s2=br1.readLine())!=null)
							{if(b==choice)
								{ms+=s2;}
							b++;}
							
							System.out.println(s2);
							String[] st =ms.split(",");
							System.out.println(st[0]);
							itemid=st[0];
							title=st[1];
							genre=st[2];
							publisher=st[3];
							Author=st[4];
							Edition=st[5];
							Volume=Integer.parseInt(st[6]);
							price=Double.parseDouble(st[7]);
							System.out.println("Enter the quantity(not more than 5)");
							int c=sc.nextInt();
							sc.nextLine();
							quantity=c;
							}
						} 
						catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

