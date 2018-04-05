package unittest;
import yycz.Output;
import yycz.Word;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
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
public class OutputTest {

	private Output out;
	private ArrayList<Word> words;
	private String expected;
	public OutputTest(String input,String filepath) throws IOException {
		words=new ArrayList<Word>();
		String word="";
		String freq="";
		int i=0;
		while(i<input.length()) {
			while(i<input.length()&&input.charAt(i)!=':') {
				word+=input.charAt(i);
				i++;
			}
			i++;
			while(i<input.length()&&input.charAt(i)!=' ') {
				freq+=input.charAt(i);
				i++;
			}
			while(i<input.length()&&input.charAt(i)==' ')
				i++;
			words.add(new Word(word,Integer.parseInt(freq)));
			word="";
			freq="";
		}
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
				{"hola:3 hello:1","1.txt"};
				{"seas:22 would:19 rise:15 when:13 I:10 gave:7 the:5 word:1","2.txt"};
				{"alone:200 arrow:199 apple:198 at:197 alive:196 all:195 angry:194 any:193 abuse:192 ability:191 ache:190 acheive:189 acomplishment:188 avoide:187 annouce:186 ah:185 ambulance:184 asia:183 asian:182 Africa:181"
				+"Australia:180 Australian:179 attach:178 attachment:177 able:176 about:175 above:174 abroad:173 aceident:172 across:171 active:170 activity:169 ad:168 address:167 advertisement:166 afford:165 afraid:164 after:163 aai:162 ahe:161"
				+"ago:160 agree:159 aha:158 air:157 alike:156 all:155 allow:154 almost:153 alone:152 alreaddd:151 also:150 am:149 always:148 amaze:147 baby:146 back:145 backward:144 bacteria:143 bad:142 badly:141"
				+"bag:140 bah:139 bake:138 ball:137 balance:136 balloon:135 bang:134 band:133 banana:132 bank:131 bare:129 banner:128 bargain:127 bark:126 barn:125 barrel:124 base:123 basic:122 basically:121"
				+"basin:120 basis:119 basket:118 bat:117 bath:116 bathe:115 bathroom:114 bay:113 battle:112 beach:111 beam:110 bean:109 bear:108 beard:107 beast:106 beat:105 beauty:104 because:103 bed:102 bee:101 beef:100 beer:99 before:98 beg:97 behalf:96 behave:95 being:94 bell:93","much.txt"
			})
	}
	
	@Before
	public void setUp() throws Exception {
		this.out=new Output(words);
	}

	@Test
	public void test() throws IOException {
		out.write();
		File file=new File("result.txt");
		char[] tmp=new char[4096];
		BufferedReader br=new BufferedReader(new FileReader(file));
		br.read(tmp);
		String result=String.valueOf(tmp);
		br.close();
		assertEquals(expected,result);
	}

}
