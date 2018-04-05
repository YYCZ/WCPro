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
		String str="";
		int flag =1;
		Word word;
		for(int i=0;i<100&&i<words.size();i++){
			word=words.get(i);
			if(flag==1){
				str+=word.getStr()+' '+word.getFrequency();
				flag =0;
			}
			else str+="\r\n"+word.getStr()+' '+word.getFrequency();
		}
		System.out.println(str);
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
