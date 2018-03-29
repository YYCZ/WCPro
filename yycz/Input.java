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
			return true;
		}
		
		if (args.length==1){
			
			File f = new File(args[0]);
			
				if(f.exists()){
					
					String fileType = args[0].substring(args[0].lastIndexOf(".") + 1, args[0].length()).toLowerCase();
					String fType="txt";
					
					if (fType.matches(fileType)){							
						return false;				
					}		
					
					System.out.println("�������Ͳ�ƥ�䣨������txt��ʽ�ļ���");
					return true;															
				}
				
				System.out.println("�ļ������ڣ�");
				return true;
					
		}				
			System.out.println("�������������ϣ��޶�Ϊһ����");
			return true;							
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
