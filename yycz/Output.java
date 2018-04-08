package yycz;

import java.util.ArrayList;
import java.io.*;
import java.io.IOException;

public class Output {

	private String filePath;
	private ArrayList<Word> words;

	public Output(ArrayList<Word> words) {
		this.filePath="result.txt";
		this.words=words;
	}

	public void write() throws IOException {
		String str;
		Word word;
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<100 && i<words.size();i++){
			word=words.get(i);
			if(i==0){
				sb.append(word.getStr()).append(' ').append(word.getFrequency());
			}else {
				sb.append("\r\n").append(word.getStr()).append(' ').append(word.getFrequency());
			}
		}
		str=sb.toString();
		File afile =new File(filePath);
		try {
			afile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter output = null;
		try {
			output = new BufferedWriter(new FileWriter(afile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		output.write(str);
		output.flush();
		output.close();
	}
}
