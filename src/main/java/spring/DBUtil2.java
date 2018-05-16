package spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @value用于属性注入值
 * @author liurenyou
 *
 */
@Component("dataBaseUtil")
public class DBUtil2 {
	@Value("#{db.driver}")
	private String driverClass;

	@Override
	public String toString() {
		return "DBUtil2 [driverClass=" + driverClass + "]";
	}
}
