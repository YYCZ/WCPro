package unittest;
import yycz.Core;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CoreTest {

	private Core core;
	private String input;
	private String expected;
	
	public CoreTest(String input,String expected) {
		this.input=input;
		this.expected=expected;
	}
	
	@Parameters
	public static Collection<String []> getParameters(){
		return Arrays.asList(
			new String[][] {
				{"",""},
				{"a","a:1/"},
				{"a-b","a-b:1/"},
				{"hell0","hell:1/"},
				{"let's","let:1/s:1/"},
				{"night-","night:1/"},
				{"hello\ndarkness\t","darkness:1/hello:1/"},
				{"ÄãºÃ ¤Ð¤«  hello","hello:1/"},
				{"=====(£þ¨Œ£þ*)",""},
				{"(see Box 3-2).8865d_c01_016","box:1/c:1/d:1/see:1/"},
				{"WORLD world","world:2/"},
				{"a a a b b c","a:3/b:2/c:1/"},
				{"a a b b c","a:2/b:2/c:1/"},
				{"ab ac","ab:1/ac:1/"},
				{"--a-","a:1/"},
				{"cool!est!","cool:1/est:1/"},
				{"hi hi","hi:2/"},
				{"hoLa Hola","hola:2/"},
				{"hi hola hi","hi:2/hola:1/"},
				{"cat car bool z z","z:2/bool:1/car:1/cat:1/"}
			});
	}
	
	@Before
	public void setUp() throws Exception {
		this.core=new Core(input);
	}

	@Test
	public void test() {
		assertEquals(expected,core.getTestResult());
	}

}
