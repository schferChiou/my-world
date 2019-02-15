package studyItem;

/**
 * 匿名内部类
 * @author XiaoQiu
 *
 */
public class TestNiminneibulei {
	public static void main(String[] args) {
		A a = new A(){
			public void test(){
				boolean a = "".equals("");
				System.out.println("Hello word .");
			}
		};
		a.test();
	}
}

interface A {
	public void test();
}