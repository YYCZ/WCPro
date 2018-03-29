package yycz;
import java.io.*;

public class Input {//�ļ�����ģ��
	
	private String[] args;
	
	public Input(String[] args) {
		this.args=args;
	}
	
	public boolean inValid() {		

		if (args.length==0){
			System.out.println("����Ϊ�գ�������һ��txt��ʽ�ļ���Ϊ������");			
			return false;
		}
		
		if (args.length==1){
			
			String fileType = args[0].substring(args[0].lastIndexOf(".") + 1, args[0].length()).toLowerCase();
			String fType="txt";
			
			if (fType.matches(fileType)){							
				return true;				
			}			
			System.out.println("�������Ͳ�ƥ�䣨������txt��ʽ�ļ���");
			return false;		
		}
			System.out.println("�������������ϣ��޶�Ϊһ����");
			return false;							
	}
	
	public String getContent() throws IOException {
		
		String encoding = "UTF-8";  		
        File file = new File(args[0]);  
        Long filelength = file.length();  
        byte [] filecontent = new byte [filelength.intValue()];     
        FileInputStream in = new FileInputStream(file);  
        in.read(filecontent);  
        in.close();       
        return new String(filecontent, encoding);              		
	}
	
}
