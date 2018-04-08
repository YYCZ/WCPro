package unittest;
import yycz.Input;
import yycz.Main;
import yycz.Core;
import yycz.Output;
import yycz.Word;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MainTest {

	private String[] args;
	private String expected;
	
	public MainTest(String input,String filepath) throws IOException {
		this.args=input.split(" ");
		File file=new File(filepath);
		char[] tmp=new char[4096];
		BufferedReader br=new BufferedReader(new FileReader(file));
		br.read(tmp);
		this.expected=String.valueOf(tmp);
		br.close();
	}
	
	@Parameters
	public static Collection<String []> getParameters(){
		return Arrays.asList(
			new String[][] {
				{"1.txt","1_e.txt"},
				{"2.txt","2_e.txt"},
				{"3.txt","3_e.txt"},
				{"4.txt","4_e.txt"},
				{"5.txt","5_e.txt"},
				{"6.txt","6_e.txt"},
				{"7.txt","7_e.txt"},
				{"8.txt","8_e.txt"},
				{"9.txt","9_e.txt"}
			});
	}

	@Test
	public void test() throws IOException {
		Main.main(args);
		File file=new File("result.txt");
		char[] tmp=new char[4096];
		BufferedReader br=new BufferedReader(new FileReader(file));
		br.read(tmp);
		String result=String.valueOf(tmp);
		br.close();
		assertEquals(expected,result);
	}

}

