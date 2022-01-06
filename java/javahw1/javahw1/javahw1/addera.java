package javahw1;

import java.util.Scanner;

public class adder {
	public static void main(String[] args) {
		int[] data=new int[11];
		Scanner input=new Scanner(System.in);
		int instr=input.nextInt(),accu=0;
		while(instr!=4300) {
			switch(instr/100) {
				case(10)://1
					data[instr%100]=input.nextInt();
					break;
				case(11)://5
					System.out.println(data[instr%100]);
					break;
				case(20)://2
					accu=data[instr%100];
					break;
				case(21)://4
					data[instr%100]=accu;
					break;
				case(30)://3
					accu+=data[instr%100];
					break;
			}
			instr=input.nextInt();
		}
	}
}
