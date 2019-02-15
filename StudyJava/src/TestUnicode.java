import java.io.UnsupportedEncodingException;


public class TestUnicode {

	public static void main(String[] args) {
		
		String str = "我是中国人";
		String encode = "GBK";
		String encode1 = "UTF-8";
		 try {
			if (str.equals(new String(str.getBytes(encode1), encode1))) {      //判断是不是GB2312
			     System.out.println("str= "+str);    
			 }
			if (str.equals(new String(str.getBytes(encode), encode1))) {
				 System.out.println("str= "+str+"-"+encode1);    
			 }else{
				 
			 }
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}      
	}
}
