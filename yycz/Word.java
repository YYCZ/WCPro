package yycz;

public class Word {
	
	private String str;
	private int frequency;
	
	public Word(String str,int frequency) {
		this.str=str;
		this.frequency=frequency;
	}
	
	public String getStr() {
		return str;
	}
	
	public void setStr(String str) {
		this.str = str;
	}
	
	public int getFrequency() {
		return frequency;
	}
	
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
}
