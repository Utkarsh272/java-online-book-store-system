import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class ShoppingCart {
	ArrayList<ItemOrder> al=new ArrayList<ItemOrder>();
	ArrayList<String> al1=new ArrayList<String>();
void ShoppingCart(String str) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Choose from the below options");
	System.out.println("1. Add Item to the Cart");
	System.out.println("2. Display items in the cart");
	System.out.println("3.Save items of the cart");
	System.out.println("4. Procced to checkout");
	System.out.println("5. Exit");
	int option=sc.nextInt();
	sc.nextLine();
	while(option!=5)
	{
		switch(option)
		{
		case 1: AddItem(str); break;
		case 2: Display(str); break;
		case 3: Save(str); break;
		case 4: checkout(str); break;
		default:System.out.println("No such option available"); 
		}
		System.out.println("Choose from the below options");
		System.out.println("1. Add Item to the Cart");
		System.out.println("2. Display items in the cart");
		System.out.println("3.Save items of the cart");
		System.out.println("4. Procced to checkout");
		System.out.println("5. Exit");
		option=sc.nextInt();
		sc.nextLine();	
	}
	//sc.close();
}
void AddItem(String str) {
	al.add(new ItemOrder());
	al.get(al.size()-1).ItemOrder(str);
	if(al.get(al.size()-1).item.itemid.equals(" "))
		al.remove(al.size()-1);
}
void Display(String str) {
	String s="C:\\Users\\Shubham Mittal\\Desktop\\mini-project\\"+str+".txt";
	try {
		BufferedReader br = new BufferedReader(new FileReader(s));
		String s1;
		
		System.out.format("%7s %32s %32s %20s %8s %s", "ItemID","Title","Publisher","Genre","Price","Quantity");
		System.out.println();
		while((s1 = br.readLine())!=null)
		{
			String[] Token=s1.split(",");
			System.out.format("%7s %32s %32s %20s %8s %s",Token[0], Token[1],Token[2],Token[3],Token[4],Token[5]);
			System.out.println();
		}
		
		br.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	for(int i=0;i<al.size();i++)
	{System.out.format("%7s %32s %32s %20s %8s %s", al.get(i).item.itemid,al.get(i).item.title,al.get(i).item.publisher,al.get(i).item.genre,al.get(i).item.price,al.get(i).item.quantity);
	System.out.println();}
	
}
void Save(String str) {
	String s="C:\\Users\\Shubham Mittal\\Desktop\\mini-project\\"+str+".txt";
	String s1="C:\\Users\\Shubham Mittal\\Desktop\\mini-project\\"+str+"recommendations.txt";
	try {
		for(int i=0;i<al.size();i++)
		{BufferedWriter bw=new BufferedWriter(new FileWriter(s,true));
		PrintWriter pw=new PrintWriter(bw);
		pw.println(al.get(i).item.itemid+","+al.get(i).item.title+","+al.get(i).item.publisher+","+al.get(i).item.genre+","+al.get(i).item.price+","+al.get(i).item.quantity);
		int QTY=al.get(i).item.QTY - al.get(i).item.quantity;
		pw.close();
		pw=new PrintWriter(new FileWriter(s1,true));
		pw.println(al.get(i).item.genre);
		pw.close();
		bw.close();
		//System.out.println(QTY);
	
		for(int k=1;k<=4;k++)
		{
			String s2="C:\\Users\\Shubham Mittal\\Desktop\\mini-project\\"+k+".txt";
			BufferedReader br=new BufferedReader(new FileReader(s2));
			String strLine;
            StringBuilder fileContent = new StringBuilder();
            while((strLine=br.readLine())!=null)
            {
            	//System.out.println(QTY);
            	String tokens[] = strLine.split(",");
            	if(tokens[0].equals(al.get(i).item.itemid) && tokens[2].equals(al.get(i).item.genre))
            	{
            		//System.out.println(QTY);
            		tokens[tokens.length-1]=Integer.toString(QTY);
            		String newline="";
            		for(int j=0;j<tokens.length;j++)
            		{
            			newline += tokens[j]+",";
            		}
            		fileContent.append(newline);
            		fileContent.append("\n");
            	}
            	else
            	{
            		fileContent.append(strLine);
            		fileContent.append("\n");
            	}
            }
            BufferedWriter bw1=new BufferedWriter(new FileWriter(s2));
            bw1.write(fileContent.toString());
            bw1.close();
            br.close();
		}	
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	al.clear();
}
void checkout(String str) {
	int reply=JOptionPane.showConfirmDialog(null, "Caution: Unsaved Data in Shopping Cart will get deleted and will not be displayed during checkout \nDo you want to proceed");
	if(reply==JOptionPane.YES_OPTION)
	{Order order=new Order();
	order.Order(str);}
}
}
