package ioc;

public class A {
	private Service service;

	public void setService(Service service) {
		System.out.println("setService()");
		this.service = service;
	}

	public A() {
		System.out.println("A()");
	}

	public void execute() {
		service.f1();
	}
}
