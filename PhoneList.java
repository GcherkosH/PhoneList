import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneList {

		private ArrayList<String> numbers;
		private int numOfTestCase;
		private int PhoneNumList;
		private String phoneNum;
		private	Scanner k;
		private String ConsistencyCheck;

		public PhoneList(){

				this.numbers = new ArrayList<String>();
				this.phoneNum = new String();
				this.k = new Scanner(System.in);
		}

		private String start() 
		{
			
			numOfTestCase = k.nextInt();

			if (numOfTestCase < 1 || numOfTestCase > 40){
				 System.out.println(" Invalid number of testcases. 1 <= numberOfTestCase <= 40");
				 System.exit(0);
				}
			for (int i =0; i < numOfTestCase; i++){
				addNumbers();
				if(ConsistencyCheck())
					ConsistencyCheck = "Yes";
				else 
					ConsistencyCheck = "No";
			}
			return ConsistencyCheck;
		}

		private void addNumbers() {

			PhoneNumList = k.nextInt();
			if(PhoneNumList < 1 || PhoneNumList > 10000){
				System.out.println("Invalid number of phone numbers. It should be in the interval 1 between 10000");
				System.exit(0);

			}

			for(int i = 0; i < PhoneNumList; i++){

				phoneNum = k.next();
				if(phoneNum.length() > 10){
					System.out.println(" The length of phone number shouldn't be longer than 10 digits.");
					System.exit(0);

				}
				numbers.add(phoneNum);
			}
			Collections.sort(numbers);

		}

		private boolean ConsistencyCheck(){
				for(int i=0; i<PhoneNumList-1; i++){
					String potentialPrefix = numbers.get(i);
					String couldHavePrefix = numbers.get(i+1);
					if(couldHavePrefix.length() >= potentialPrefix.length()){
						phoneNum = couldHavePrefix.substring(0,potentialPrefix.length());
						if(phoneNum.equals(potentialPrefix))
							return false;				
					}
				}
				return true;
			}



	public static void main(String[] args){

		try{
			
			PhoneList phonelist = new PhoneList();
			phonelist.start();
			System.out.println(phonelist.ConsistencyCheck);
		}
		catch(Exception E){
			System.out.println(E.getMessage());	
		}
	}

}