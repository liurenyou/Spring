package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.ExampleBean;
import basic.MessageBean;
import ioc.A;
import ioc.Restaurant;
import spring.Boy;
import spring.DBUtil;
import spring.DBUtil2;
import spring.DemoBean;
import spring.DemoBean2;
import spring.NoteDemo;
import spring.Wife;

public class TestCase {
	// 1.测试作用域
	@Test
	public void test1() {
		// 启动spring容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("basic.xml");
		// 通过容器获得对象
		ExampleBean eb1 = ac.getBean("eb1", ExampleBean.class);
		ExampleBean eb2 = ac.getBean("eb1", ExampleBean.class);
		System.out.println(eb1 == eb2); // 因为创建了多个实例，所以为false，若scope为singleton则为true
	}

	// 2.测试生命周期
	@Test
	public void test2() {
		// 启动spring容器
		/*
		 * 因为ApplicationContext接口没有定义关闭容器的方法 所以需要用其子接口
		 */
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("basic.xml");
		// 通过容器获得对象
		MessageBean mb1 = ac.getBean("mb1", MessageBean.class);
		mb1.sendMsg();
		// 关闭容器
		ac.close();
	}

	// 3.测试延迟加载
	@Test
	public void test3() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("basic.xml");
	}

	// 4.测试set方法注入
	@Test
	public void test4() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ioc.xml");
		A a1 = ac.getBean("a1", A.class);
		a1.execute();
	}

	// 5.测试构造器注入
	@Test
	public void test5() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ioc.xml");
		Restaurant rest1 = ac.getBean("rest1", Restaurant.class);
		System.out.println(rest1);
	}

	// 6.测试自动装配
	@Test
	public void test6() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("automatic.xml");
		Restaurant rest = ac.getBean("rest", Restaurant.class);
		System.out.println(rest);
	}

	// 7.测试注入基本类型的值
	@Test
	public void test7() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("value.xml");
		// 不同包内相同类名的类需要加上包的名字
		value.ExampleBean eb1 = ac.getBean("eb1", value.ExampleBean.class);
		System.out.println(eb1);
	}

	// 8.测试以引用方式注入集合类型的值
	@Test
	public void test8() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("value.xml");
		value.ExampleBean eb2 = ac.getBean("eb2", value.ExampleBean.class);
		System.out.println(eb2);
	}

	// 9.测试读取properties文件
	@Test
	public void test9() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("value.xml");
		System.out.println(ac.getBean("configBean"));
	}

	// 为方便测试，加一个init初始化Spring容器
	ClassPathXmlApplicationContext ctx;

	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("spring-ctx.xml");
	}

	// 10.测试DBUtil
	@Test
	public void testDBUtil() {
		DBUtil bean = ctx.getBean("dbUtil", DBUtil.class);
		System.out.println(bean);
	}

	// 11.测试DemoBean
	@Test
	public void testDemoBean() {
		DemoBean bean1 = ctx.getBean("demoBean", DemoBean.class);
		System.out.println(bean1);
	}

	// 12.测试DemoBean2
	@Test
	public void testDemoBean2() {
		// 采用自定义的BeanId
		DemoBean2 bean1 = ctx.getBean("myBean", DemoBean2.class);
		System.out.println(bean1);
		DemoBean2 bean2 = ctx.getBean("myBean", DemoBean2.class);
		System.out.println(bean2);
		System.out.println(bean1 == bean2);// true，默认情况下Spring中的Bean都是单例的
	}

	// 13.测试Wife
	@Test
	public void testWife() {
		Wife wife1 = ctx.getBean("wife", Wife.class);
		System.out.println(wife1);
		Wife wife2 = ctx.getBean("wife", Wife.class);
		System.out.println(wife2);
		System.out.println(wife1 == wife2);// false，设定成原型后
	}
	
	// 14.测试NoteDemo
	@After
	public void testDestroy() {
		ctx.close();
	}
	@Test
	public void testNoteDemo() {
		NoteDemo demo = ctx.getBean("noteDemo",NoteDemo.class);
		System.out.println(demo);
	}
	
	// 15.测试注解的属性注入
	@Test
	public void testBoy() {
		Boy boy = ctx.getBean("boy",Boy.class);
		System.out.println(boy);
	}
	
	// 16.测试DBUtil2
	@Test
	public void testDBUtil2() {
		DBUtil2 bean = ctx.getBean("dataBaseUtil",DBUtil2.class);
		System.out.println(bean);
	}

}
