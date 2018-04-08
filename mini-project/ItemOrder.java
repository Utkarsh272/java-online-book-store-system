import java.util.Scanner;

import javax.swing.JOptionPane;

public class ItemOrder {
//int quantity;
Item item;
	void ItemOrder(String str) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Choose from the below options");
		System.out.println("1. Add Item");
		System.out.println("2. Display Item");
		//System.out.println("3. Get Price");
		System.out.println("3. Exit");
		int option=sc.nextInt();
		sc.nextLine();
		while(option!=3)
		{
			switch(option)
			{
			case 1:AddItem(str); break;
			case 2:Display(); break;
			//case 3:Getprice(); break;
			default: System.out.println("No such option available");
			}
			System.out.println("Choose from the below options");
			//System.out.println("1. Add Item");
			System.out.println("2. Display Item");
			//System.out.println("3. Get Price");
			System.out.println("3. Exit");
			 option=sc.nextInt();
			sc.nextLine();
		}
	}
	
	void Display() {
		JOptionPane.showMessageDialog(null, "BookId :"+item.itemid+"\n"+"Title :"+item.title+"\n"+"Genre :"+item.genre+"\n"+"Price :"+item.price+"\n"+"Quantity"+item.quantity);
	
	}
	
	void AddItem(String str) {
		item=new Book();
		item.Item(str);
		//BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\Admin\\Desktop\\mini-project\\",true));
	}
}
