/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incometax1;
import java.util.Scanner;

/**
 *
 * @author mkino
 */
public class IncomeTax1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double tax,inc;
	Scanner scan=new Scanner(System.in);
	System.out.println("Enter your income:");
	inc=scan.nextDouble();
	if(inc<=25000)
		tax=0;
	else if(inc<=50000)
		tax=0.1*(inc);
	else if(inc<=100000)
		tax=(0.25*(inc));
	else if(inc<=200000)
		tax=(0.3*(inc));
	else
		tax=(0.33*(inc));
	System.out.println("Income tax calculated is :"+tax);
    }
    
}
