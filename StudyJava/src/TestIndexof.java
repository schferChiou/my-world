
public class TestIndexof {

	public static void main(String[] args) {
		
		
		String dataString = "123456";
		String dataTwo = "";
		
		for (int i = 0; i < 100; i++) {
			String cardNo = String.valueOf(Math.random());
			System.out.println(i+"="+cardNo);
		}
		System.out.println("dataString==="+dataString.indexOf(1));
		System.out.println("dataTwo=="+dataTwo.indexOf(1));
	}
}
