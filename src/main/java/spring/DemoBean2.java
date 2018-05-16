package spring;

import org.springframework.stereotype.Component;

/**
 * 默认的Bean Id是自动命名的，规则为类名首字母小写 但也可以改变这个规则自行指定
 * @author liurenyou
 *
 */
@Component("myBean")
public class DemoBean2 {

	@Override
	public String toString() {
		return "DemoBean2";
	}

}
