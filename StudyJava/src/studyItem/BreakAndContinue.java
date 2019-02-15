package studyItem;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

/**
 * 测试break和continue
 * @author XiaoQiu
 *
 */
public class BreakAndContinue {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			if(i == 4){
				break;
			}
			System.out.println("i="+i);
		}
		System.out.println("**************");
		for (int j = 0; j < 10; j++) {
			if(j == 3){
				continue;
			}
			System.out.println("j="+j);
		}
	}
}
