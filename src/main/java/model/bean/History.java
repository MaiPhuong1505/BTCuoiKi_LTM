package model.bean;

public class History {
	private int function;
	private int input;
	private int input2;
	private String output;
	
	public History (int function, int input, int input2, String output) {
		super();
		this.function = function;
		this.input = input;
		this.input2 = input2;
		this.output = output;
	}
	
	public int getFunction() {
		return function;
	}
	public int getInput() {
		return input;
	}
	public int getInput2() {
		return input2;
	}
	public String getOutput() {
		return output;
	}

	public void setFunction(int function) {
		this.function = function;
	}

	public void setInput(int input) {
		this.input = input;
	}

	public void setInput2(int input2) {
		this.input2 = input2;
	}

	public void setOutput(String output) {
		this.output = output;
	}
}

