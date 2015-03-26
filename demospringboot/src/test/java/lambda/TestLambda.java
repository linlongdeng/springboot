package lambda;

public class TestLambda {
	public static void main(String[] args) {
		String params ="343423";
		UsingITestLam one = new UsingITestLam((String param) ->{return param;});
		new UsingITestLam(new ITestLam(){

			@Override
			public String test(String param) {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
	}
}
