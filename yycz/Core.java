package yycz;

import java.util.ArrayList;
import java.util.Collections;

public class Core {
	
	private String content;
	
	public Core(String content) {
		this.content=content;
	}
	
	private void updateWords(ArrayList<Word> words,String str) {
		boolean newWord=true;
		for(Word word : words) {
			if(word.getStr().equals(str)) {
				word.setFrequency(word.getFrequency()+1);
				newWord=false;
				break;
			}
		}
		if(newWord) {
			Word word=new Word(str,1);
			words.add(word);
		}
	}
	
	public ArrayList<Word> countWords(){
		ArrayList<Word> words=new ArrayList<Word>();
		boolean inWord=false;
		char ch;
		String str="";
		content+=";";
		for(int i=0;i<content.length();i++) {
			ch=content.charAt(i);
			if(Character.isLetter(ch)||ch=='-'&&Character.isLetter(content.charAt(i+1))) {
				str+=ch;
				inWord=true;
			}
			else if(inWord) {
				updateWords(words,str);
				inWord=false;
				str="";
			}
		}
		Collections.sort(words);
		return words;
	}
}
