package TestEnum;

import java.util.Arrays;


public class MapTest {

	public static void main(String[] args) {
		String[] testStrings = {"62314061","61801012"};
		if(Arrays.asList(testStrings).contains("62314061")){
			System.out.println("11");
		}else{
			System.out.println("22");
		}
	}
}
