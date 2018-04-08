package yycz;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

public class Output {
	private String filePath;
	private ArrayList<Word> words;

	public Output(ArrayList<Word> words) {
		this.filePath="result.txt";//输出结果指定路径
		this.words=words;//获得的要进行处理的ArrayList
	}

	public void write() throws IOException {
		String str="";
		int flag =1;//使用flag标识是否是第一个列表对象
		Word word;
		for(int i=0;i<100&&i<words.size();i++){//当列表对象超过100个时，输出前100个；当不超过100个时，全部输出
			word=words.get(i);
			if(flag==1){
				str+=word.getStr()+' '+word.getFrequency();
				flag =0;
			}
			else str+="\r\n"+word.getStr()+' '+word.getFrequency();
			//这样输出是为了实现“输出规定”中“单词和词频间空一格，输出文件末尾多余的换行符应去除“的要求
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
