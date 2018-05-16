package spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

/**
 * @PostConstruct注解用于声明Bean初始化的方法
 * @PreDestory用于声明Bean销毁方法
 * 注：需要导包javax.annotation
 * @author liurenyou
 *
 */
@Component
public class NoteDemo {
	@PostConstruct
	public void init() {
		System.out.println("init");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("destroy");
	}
}
