package yycz;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		
		long startTime=System.currentTimeMillis();
		
		Input in=new Input(args);
		
		if(in.inValid())
			return;
		
		String content=in.getContent();
		
		Core core=new Core(content);
		
		ArrayList<Word> words=core.countWords();
		
		System.out.println(words.size());
		
/*		for(int i=0;i<words.size();i++)
			System.out.println(words.get(i).getStr()+" : "+words.get(i).getFrequency());
*/		
		long endTime=System.currentTimeMillis();
		System.out.println("程序运行时间： " + (endTime-startTime) + "ms");
		
		//Output out=new Output(words);
		
		//out.write();
	}

}
