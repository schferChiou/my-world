package studyItem;
/**
 * final 修饰的变量不可重写
 * final 修饰的方法不可重写，可重载
 * final 修饰的类不可继承
 * @author XiaoQiu
 *
 */
public final class TestFinal {

	public static void main(String[] args) {
		double b = Math.PI;
		System.out.println("b="+b);
	}
}

class bird extends animal{
	public void seat(){
		
	}
}
class  animal{
	public final void run() {

	}
}
final class mouth{
	public  void eat(){
		
	}
}
