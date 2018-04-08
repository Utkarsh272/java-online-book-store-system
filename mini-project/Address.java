import java.util.*;

import javax.swing.JOptionPane;

public class Address {
private String addline,city,state,country;
int poscode;
void Address() {
	boolean option=true;
	Scanner sc=new Scanner(System.in);
	while(option)
	{
	System.out.println("Address Line 1(Address excluding city,state,country and postal code)");
	addline=sc.nextLine();
	System.out.println("City :");
	city=sc.nextLine();
	System.out.println("State :");
	state=sc.nextLine();
	System.out.println("Country :");
	country=sc.nextLine();
	System.out.println("Postal Code :");
	poscode=sc.nextInt();
	System.out.println("Do you want to proceed(1 Yes/0 No)");
	int reply=sc.nextInt();//JOptionPane.showConfirmDialog(null, "Do you want to proceed");
	if(reply==1)
	{
		option=false;
	}
	}
	//sc.close();
}
void Display() {
	JOptionPane.showMessageDialog(null, "Address :" + this.addline + "\n"+this.city+", "+this.state+", "+this.country+"\n"+this.poscode);
}
}
