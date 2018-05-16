package ioc;

public class C implements Service {
	public C() {
		System.out.println("C()");
	}

	public void f1() {
		System.out.println("C's f1()");
	}

}
