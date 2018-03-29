package yycz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class Core {
	
	private String content;
	
	public Core(String content) {
		this.content=content;
	}
	
	/*以朴素的办法统计词频,O(n^2)*/
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
	
	/*以哈希的办法统计词频,O(n)*/
	private void updateWordsWithHash(HashMap<String,Integer> map,String str) {
		if(map.containsKey(str))
			map.replace(str,map.get(str)+1);
		else
			map.put(str, 1);
	}
	
	private void hashmapToWordList(HashMap<String,Integer> map,ArrayList<Word> words) {
		if(map.isEmpty()) {
			words=null;
			return;
		}
		for(Entry<String, Integer> entry : map.entrySet()) {
			Word word=new Word(entry.getKey(),entry.getValue());
			words.add(word);
		}
	}
	
	public ArrayList<Word> countWords(){
		ArrayList<Word> words=new ArrayList<Word>();
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		char ch;
		String str;
		boolean inWord=false;
		StringBuilder sb=new StringBuilder();
		content+=";";
		for(int i=0;i<content.length();i++) {
			ch=content.charAt(i);
			if(Character.isLetter(ch)||ch=='-'&&Character.isLetter(content.charAt(i+1))) {
				sb.append(ch);
				inWord=true;
			}
			else if(inWord) {
				str=sb.toString();
				str=str.toLowerCase();
				//updateWords(words,str);
				updateWordsWithHash(map, str);
				inWord=false;
				sb=new StringBuilder();
			}
		}
		hashmapToWordList(map, words);
		Collections.sort(words);
		return words;
	}
}
