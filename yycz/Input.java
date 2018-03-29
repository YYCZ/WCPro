package yycz;
import java.io.*;

public class Input {//文件输入模块
	
	private String[] args;
	
	public Input(String[] args) {
		this.args=args;
	}
	
	public boolean inValid() {		

		if (args.length==0){
			System.out.println("参数为空（请输入一个txt格式文件作为参数）");			
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
					
					System.out.println("参数类型不匹配（仅处理txt格式文件）");
					return true;															
				}
				
				System.out.println("文件不存在！");
				return true;
					
		}				
			System.out.println("参数个数不符合（限定为一个）");
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
