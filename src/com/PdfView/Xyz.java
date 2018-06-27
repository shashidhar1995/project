package com.PdfView;

public class Xyz extends Rohit{  
     int ss=2;
	public  int show() {
		int y=9;   
		System.out.println("xyz non static");    
		return y;
	}                         
 void met() { 

	int temp=ss;              
	System.out.println(" met in xyz"+temp);
}                
	public static void main(String[] args) {
	Rohit r=new Xyz();
r.show();          
r.met();    
	}
}
         