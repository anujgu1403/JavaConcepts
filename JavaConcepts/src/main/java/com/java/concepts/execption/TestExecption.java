package testexecption;

public class TestExecption {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		try {
			
			Integer obj= 20;
			throw new Exception();
			
		} catch (Exception e) {
			throw new RuntimeException();
		}

	}

}
