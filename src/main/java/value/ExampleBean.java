package value;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ExampleBean {
	private String name;
	private int age;
	private List<String> interest;
	private Set<String> cities;
	private Map<String,Double> score;
	private Properties db;
	
	@Override
	public String toString() {
		return "ExampleBean [name=" + name + ", age=" + age + ", interest=" + interest + ", cities=" + cities
				+ ", score=" + score + ", db=" + db + "]";
	}

	public ExampleBean() {
		System.out.println("ExampleBean()");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<String> getInterest() {
		return interest;
	}
	public void setInterest(List<String> interest) {
		this.interest = interest;
	}
	public Set<String> getCities() {
		return cities;
	}
	public void setCities(Set<String> cities) {
		this.cities = cities;
	}
	public Map<String, Double> getScore() {
		return score;
	}
	public void setScore(Map<String, Double> score) {
		this.score = score;
	}
	public Properties getDb() {
		return db;
	}
	public void setDb(Properties db) {
		this.db = db;
	}
	
}
