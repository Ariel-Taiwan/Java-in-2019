package javahw1;
import java.util.Scanner;

public class SMLSimulator{
	private int accumulator;
	private int InstructionRegister;
	private int InstructionCounter;
	private int [] memory;
	private int OperationCode;
	private int Operand;
	
	public SMLSimulator()
	{
		InitSMLSimulator();
		BeginRunSMLSimulator();
	}
	public void runSML(){
		int MemPointer = 0;
		int InstructionNum = 0;
		Scanner input = new Scanner(System.in);
		while(true)
		{
			System.out.printf("%02d ? ",MemPointer);
			InstructionNum = input.nextInt();
			if(InstructionNum == -99999) break;
			if(InstructionNum < -9999 || InstructionNum > 9999){
				System.out.printf("Your input %04d is not law, Please try again.\n",InstructionNum);
				continue;
			}
			memory[MemPointer] = InstructionNum;
			MemPointer++;
		}
		System.out.println("*** Program loading completed ***");
		System.out.println("*** Program execution begins  ***");
		
		for(InstructionCounter=0;InstructionCounter<MemPointer;){
			InstructionRegister = memory[InstructionCounter];
			OperationCode = InstructionRegister/100;
			Operand = InstructionRegister%100;
			Execute();
		}
	}
	
	private void InitSMLSimulator()
	{
		memory = new int [100];
		for(int i=0;i<100;i++){
			memory[i] = 0;
		}
		InstructionCounter = 0;	
	}
	private void BeginRunSMLSimulator()
	{
		System.out.println("*** Welcome to Simpletron! ***");
		System.out.println("*** Please enter your program one instruction    ***");
		System.out.println("*** (or data word) at a time. I will display     ***");
		System.out.println("*** the location number and a question mark (?). ***");
		System.out.println("*** You then type the word for that location.    ***");
		System.out.println("*** Type -99999 to stop entering your program.   ***");
	}
	private void Execute()
	{
		InstructionCounter++;
		switch(OperationCode){
			case 10: // read
				System.out.println("Enter an integer");
				Scanner input=new Scanner(System.in);
				memory[Operand] = input.nextInt();
				break;
			case 11: // write
				System.out.printf("result: +%04d\n", memory[Operand]);
				break;
			case 20: // Load
				accumulator = memory[Operand];
				break;
			case 21: // Store
				memory[Operand] = accumulator;
				break;
			case 30: // Add
				accumulator += memory[Operand];
				if(accumulator < -9999 || accumulator > 9999){
					System.out.println("*** Accumulator overflow ***");
					Halt();
					Terminated();
				}
				break;
			case 31: // Sub
				accumulator -= memory[Operand];
				if(accumulator < -9999 || accumulator > 9999){
					System.out.println("*** Accumulator overflow ***");
					Halt();
					Terminated();
				}
				break;
			case 32: // Div
				if(memory[Operand] == 0){
					System.out.println("*** Attempt to divide by zero ***");
					Halt();
					Terminated();
					break;
				}
				accumulator /= memory[Operand];
				if(accumulator < -9999 || accumulator > 9999){
					System.out.println("*** Accumulator overflow ***");
					Halt();
					Terminated();
				}
				break;
			case 33: // Mul
				accumulator *= memory[Operand];
				if(accumulator < -9999 || accumulator > 9999){
					System.out.println("*** Accumulator overflow ***");
					Halt();
					Terminated();
				}
				break;
			case 40: // Branch
				InstructionCounter = Operand;
				break;
			case 41: // Branch negative
				if(accumulator < 0) InstructionCounter = Operand;
				break;
			case 42: // Branch zero
				if(accumulator == 0) InstructionCounter = Operand;
				break;
			case 43: // HALT
				Halt();
				Terminated();
				break;
			default:
				break;
		}
	}
	private void Terminated()
	{
		System.out.println("*** Simpletron execution abnormally terminated ***");
		System.exit(0);
	}
	private void Halt()
	{
		System.out.printf("REGISTERS:\n");
		System.out.printf("accumulator            +%04d\n",accumulator);
		System.out.printf("instructionCounter      %04d\n",InstructionCounter);
		System.out.printf("instructionRegister    +%04d\n",InstructionRegister);
		System.out.printf("operationCode           %04d\n",OperationCode);
		System.out.printf("operands                %04d\n",Operand);
		System.out.printf("\n");
		System.out.printf("MEMORY:\n");

		System.out.printf("%6d",0);
		for(int i=1;i<10;i++){
			System.out.printf("%6d",i);
		}
		System.out.printf("\n");
		int counter=0;
		for(int i=0;i<10;i++){
			System.out.printf("%2d ",counter);
			for(int j=0;j<10;j++){
				System.out.printf("+%04d ",memory[counter]);
				counter++;
			}
            System.out.printf("\n");
		}
	}
	public static void main(String args[]){
		SMLSimulator simulator=new SMLSimulator();
		simulator.runSML();
	}
}