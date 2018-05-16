package first;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpring {
	public static void main(String[] args) {
		/*
		 * 启动Spring容器:
		 * 	ApplicationContext:接口
		 *  ClassPathXmlApplicationContext是
		 *  ApplicationContext接口的一个实现类
		 *  参数值是spring配置文件的位置
		 */
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ac);
		//通过spring容器获取对象
		Student stu1 = ac.getBean("stu1",Student.class);
		System.out.println(stu1);
		Date date1 = ac.getBean("date1",Date.class);
		System.out.println(date1);
		Calendar cal1 = ac.getBean("cal1",Calendar.class);
		System.out.println(cal1);
		Date date2 = ac.getBean("time1",Date.class);
		System.out.println(date2);
	}
}
