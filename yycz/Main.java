package yycz;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		
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


