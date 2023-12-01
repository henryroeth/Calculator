
public class Calculator {
	
	private double first;
	
	private double second;
	
	private double result;
	
	private boolean isFirst;
	
	private boolean opComplete;
	
	private String op;
	
	public Calculator() {
		isFirst = true;
		opComplete = false;
	}
	
	public boolean isFirst() {
		return isFirst;
	}
	
	public double getFirst() {
		return first;
	}
	
	public double getSecond() {
		return second;
	}
	
	public double getResult() {
		return result;
	}
	
	public String getOp() {
		return op;
	}
	
	public boolean opComplete() {
		return opComplete;
	}
	
	public void setCompleteState(boolean opComplete) {
		this.opComplete = opComplete;
	}
	
	public void setOp(String op) {
			if(op.equalsIgnoreCase("+") || op.equalsIgnoreCase("-") || op.equalsIgnoreCase("*") || 
			op.equalsIgnoreCase("/") || op.equalsIgnoreCase("√") || op.equalsIgnoreCase("x^2")) {
				this.op = op;
			} else {
				System.out.println("String literal must be one of the following:\nadd | subtract | multiply | divide | sqrt | square");
			}
	}
	
	public void setFirstState(boolean isFirst) {
		this.isFirst = isFirst;
	}
	
	public void setFirst(double first) {
		this.first = first;
	}
	
	public void setSecond(double second) {
		this.second = second;
	}
	
	public void add() {
		result = first + second;
	}
	
	public void subtract() {
		result = first - second;
	}
	
	public void multiply() {
		result = first * second;
	}
	
	public void divide() {
		result = first/second;
	}
	
	public void sqrt() {
		result = Math.sqrt(first);
	}
	
	public void square() {
		result = first * first;
	}
	
	public void clearResult() {
		result = 0;
	}
}
