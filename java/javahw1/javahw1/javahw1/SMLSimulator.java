package javahw1;

import java.util.Scanner;

public class SMLSimulator {
	public static void main(String[] args) {
		int[] data=new int[50];
		Scanner input=new Scanner(System.in);
		int in=input.nextInt(),accu=0,instr=1020;
		int i=0,c;
		for(c=0;c<7;c++) {
			data[i]=1020;
			data[i+1]=3020;
			for(int k=i;k<i+2;k++) {
				switch(data[k]/100) {
				case(10)://1
					data[data[k]%100]=input.nextInt();
					break;
				case(20):
					accu=data[data[k]%100];	
					break;
				case(30):
					accu+=data[data[k]%100];
					break;
				case(32):
					accu/=data[data[i]%100];
					break;
				case(43):
					break;
				}
			}
		}
		System.out.println(accu/7);
	}
}