package javahw1;

import java.util.Scanner;

public class adder_a {
	public static void main(String[] args) {
		int[] memory=new int[102];
		Scanner input=new Scanner(System.in);
		int instr,accu=0,InstructionCounter,OperationCode,Operand,InstructionRegister;
		int i=0;
		System.out.println("*** Welcome to Simpletron! ***");
		System.out.println("*** Please enter your program one instruction    ***");
		System.out.println("*** (or data word) at a time. I will display     ***");
		System.out.println("*** the location number and a question mark (?). ***");
		System.out.println("*** You then type the word for that location.    ***");
		System.out.println("*** Type -99999 to stop entering your program.   ***");
		System.out.printf("%02d ? ",i);
		instr=input.nextInt();
		while(instr!=-99999) {
			memory[i]=instr;
			i++;
			System.out.printf("%02d ? ",i);
			instr=input.nextInt();
		}
		System.out.println("*** Program loading completed ***");
		System.out.println("*** Program execution begins  ***");
		for(int k=0;k<i;k++) {
			InstructionCounter=k;
			InstructionRegister = memory[InstructionCounter];
			OperationCode = InstructionRegister/100;
			Operand = InstructionRegister%100;
			//System.out.println(k);
			switch(OperationCode) {
				case(10):
					memory[Operand]=input.nextInt();
					break;
				case(11)://5
					System.out.println(memory[Operand]);
					//System.out.println("here");
					break;
				case(20)://2
					accu=memory[Operand];
					break;
				case(21)://4
					memory[Operand]=accu;
					break;
				case(30)://3
					accu+=memory[Operand];
					break;
				case(31):
					accu-=memory[Operand];
					break;
				case(32):
					accu/=memory[Operand];
					break;
				case(33):
					accu*=memory[Operand];
					break;
				case(40):
					InstructionCounter=Operand;
					break;
				case(41):
					if(accu<0) 
						InstructionCounter = Operand;
					//System.out.println(i);
					break;
				case(42):
					if(accu==0) 
						InstructionCounter = Operand;
					break;
				case(43):
					System.out.println("REGISTERS:");
					System.out.printf("accumulator           +%04d\n",accu);
					System.out.printf("instructionCounter     %04d\n",InstructionCounter);
					System.out.printf("instructionRegister   +%04d\n",InstructionRegister);
					System.out.printf("operationCode          %04d\n",OperationCode);
					System.out.printf("operands               %04d\n",Operand);
					System.out.println();
					System.out.println("MEMORY:");
					System.out.printf("%6d",0);
					for(int e=1;e<10;e++)
						System.out.printf("%6d",e);
					System.out.println();
					for(int l=0;l<10;l++){
						System.out.printf("%2d ",l);
						for(int p=0;p<10;p++)
							System.out.printf("+%04d ",memory[l]);
			            System.out.println();
					}
					System.out.println("*** Simpletron execution abnormally terminated ***");
					break;
			}
		}
	}
}
