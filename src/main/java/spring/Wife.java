package spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 默认情况下，Spring中的Bean组件都是单例的，获取Bean 对象都是同一个对象，在增加@Socpe("prototype")以后，
 * 则可以变成多个实例，每次getBean都会创建新实例
 * @author liurenyou
 *
 */
@Component
@Scope("prototype")
public class Wife {

	@Override
	public String toString() {
		return "Wife()";
	}

}
