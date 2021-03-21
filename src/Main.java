import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Stack<Integer> value = new Stack<Integer>();
		Stack<String> operator = new Stack<String>();
		
		System.out.println("Enter expression: ");
		
		String string = scanner.nextLine();
		String[] words = string.split(" ");
		
		for(String s : words) {
			if(s.matches("[0-9]+")) value.push(Integer.parseInt(s));
			else if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("%")) operator.push(s);
			else if(s.equals(")")) {
				String temp = operator.pop();
				int tempval1 = value.pop();
				if(temp.equals("+")) {
					int tempval = value.pop() + tempval1;
					value.push(tempval);
				}else if(temp.equals("-")) {
					int tempval = value.pop() - tempval1;
					value.push(tempval);
				}else if(temp.equals("*")) {
					int tempval = value.pop() * tempval1;
					value.push(tempval);
					
				}else if(temp.equals("%")) {
					int tempval = value.pop() % tempval1;
					value.push(tempval);
				}
				else{
					int tempval = value.pop() / tempval1;
					value.push(tempval);
				}
			}
		}
		System.out.println("Result: " + value.pop());
	}

}
