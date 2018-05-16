package spring;

import org.springframework.stereotype.Component;

/**
 * Component：组件
 * 	Spring会将DemoBean实例化为对象，Bean ID为demoBean,
 *  注：DemoBean必须与spring-ctx.xml文件中的组件扫描包相呼应，
 *  否则将无法被Spring扫描到
 * @author liurenyou
 *
 */
@Component
public class DemoBean {
	public String toString() {
		return "Hello World";
	}
}
