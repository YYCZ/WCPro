package WCPro.unittest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import WCPro.yycz.Input;

public class InputTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		//�����Ѵ��ڵ��ļ�a.txt
//		String [] args=new String[1];
//		args[0]="a.txt";
//		assertEquals(false,new Input(args).inValid());
		
		//�������Ͳ���
//		String [] args=new String[1];
//		args[0]="a.c";
//		assertEquals(true,new Input(args).inValid());
		
		//������������
//		String [] args=new String[2];
//		args[0]="a.c";
//		args[0]="a.txt";
//		assertEquals(true,new Input(args).inValid());
		
		//����Ϊ�ղ���
//		String [] args=new String[0];
//		assertEquals(true,new Input(args).inValid());
	}

}
