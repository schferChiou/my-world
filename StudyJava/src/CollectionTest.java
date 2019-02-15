import java.util.ArrayList;
import java.util.List;


public class CollectionTest {
	
	public static void main(String[] args) {
		
		List<String> all = new ArrayList<String>();
		
		all.add("String");
		all.add("people");
		System.out.println(all);
		all.set(0, "setString");
		System.out.println(all);
		
	}
	
}
