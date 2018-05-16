package spring;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Spring支持三种注解，都可以实现属性的注入
 * 
 * @Resource @Inject @Autoware
 * 
 * @author liurenyou
 *
 */
@Component
public class Boy {
	/*
	 * Spring会将Bean Id为girl对象注入到girl1属性中
	 */
	@Resource(name = "girl")
	private Girl girl1;

	/*
	 * 默认情况下，Spring自动将Bean Id为girl的Bean注入到 相同变量名的girl中
	 */
	@Autowired
	private Girl girl;

	/*
	 * 将Bean Id为girl的Bean注入到girl2中
	 */
	@Autowired
	@Qualifier("girl")
	private Girl girl2;

	/*
	 * 将Bean Id为girl的Bean注入到girl3中 
	 * 注：需要导包javax.Inject
	 */
	@Inject
	@Named("girl")
	private Girl girl3;

	/*
	 * Bean属性注入：set方法注入
	 */
	private Girl girl4;

	@Resource(name = "girl")
	public void setGirl4(Girl girl4) {
		this.girl4 = girl4;
		System.out.println(girl4 + "你是我的唯一");
	}

	@Override
	public String toString() {
		return "Boy [girl1=" + girl1 + ", girl=" + girl + ", girl2=" + girl2 + ", girl3=" + girl3 + ", girl4=" + girl4
				+ "]";
	}

}
