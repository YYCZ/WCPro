package yycz;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		
		if(args[0].startsWith("-")) {
			Counter ctr=new Counter(args);
			for(int i=0;i<ctr.ipfiles.size();i++)
			{
				Stat fstat=new Stat(ctr.ipfiles.get(i));
				ctr.write(fstat);
			}
			return;
		}
		
		Input in=new Input(args);
		
		if(in.inValid())
			return;
		
		String content=in.getContent();
		
		Core core=new Core(content);
		
		ArrayList<Word> words=core.countWords();
		
		Output out=new Output(words);
		
		out.write();
		
	}

}


