import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JOptionPane;

public class Order {
	static int billId=0;
	ArrayList<String> al=new ArrayList<String>();
int shipping=0;double total=0;
double salestax;

Customer cust;
	void Order(String str) {
		String s="C:\\Users\\Shubham Mittal\\Desktop\\mini-project\\"+str+".txt";
		try {
			BufferedReader br = new BufferedReader(new FileReader(s));
			String s1;
			
			
			while((s1 = br.readLine())!=null)
			{
				String[] msg=s1.split(",");
				System.out.println(msg[0]+" "+msg[1]+" "+msg[3]+" "+msg[4]+" "+msg[5]);
				al.add(s1);
				
			}
			for(int i=0;i<al.size();i++)
			{
				String[] split = al.get(i).split(",");
				total+=Double.parseDouble(split[4])*Integer.parseInt(split[5]);
			
			}
			
			System.out.println("Total : "+total);
			salestax=0.09*total;
			if(total>500)
			{shipping=0;}
			else
			{shipping=50;}
			System.out.println("Salestax : "+salestax);
			System.out.println("Shipping cost : "+shipping);
			System.out.println("Payment method : COD only available");
			int reply=JOptionPane.showConfirmDialog(null, "Do you want to proceed");
			if(reply==JOptionPane.YES_OPTION)
			{process(str);}
			
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	void process(String str) {
		System.out.println("Total amount paid : "+(total+salestax+shipping));
		String s1="C:\\Users\\Shubham Mittal\\Desktop\\mini-project\\"+str+"bill.txt";
		//String s="C:\\Users\\Admin\\Desktop\\mini-project"+str+"recommendations.txt";
		try {
			Date dNow = new Date( );
		      SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

		      //System.out.println("Current Date: " + ft.format(dNow));
			PrintWriter bw=new PrintWriter(new FileWriter(s1,true));
			
			bw.print((++billId)+","+ft.format(dNow)+","+(total+salestax+shipping));
			for(int i=0;i<al.size();i++)
			{
				String[] split = al.get(i).split(",");
				bw.print(","+split[1]+","+split[4]+","+split[5]);
			
			}
			bw.println();
			//bw=new PrintWriter(new FileWriter(s,true));
			
			bw.close();
			BufferedWriter bw1=new BufferedWriter(new FileWriter("C:\\Users\\Shubham Mittal\\Desktop\\mini-project\\"+str+".txt"));
			bw1.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
