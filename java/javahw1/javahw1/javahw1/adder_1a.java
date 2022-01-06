package javahw1;

import java.util.Scanner;

public class adder_1a {
	public static void main(String[] args) {
		int[] data=new int[50];
		Scanner input=new Scanner(System.in);
		int in=input.nextInt(),accu=0,instr=1020;
		int i=0,c=0;
		while(c<10) {
			data[i]=1020;
			data[i+1]=3020;
			for(int k=i;k<i+2;k++) {
				switch(data[k]/100) {
				case(10)://1
					data[data[k]%100]=input.nextInt();
					break;
				case(11):
					System.out.println(data[data[k]%100]);
					//System.out.println("here");
					break;
				case(20):
					accu=data[data[k]%100];	
					break;
				case(21):
					data[data[k]%100]=accu;
					break;
				case(30):
					accu+=data[data[k]%100];
					break;
				case(31):
					break;
				case(40):
					data[data[k]%100]=accu;
					break;
				case(43):
					break;
				}
			}
			c++;
		}
		System.out.println(accu);
	}
}