package StreamApi.fileController.model;

import com.github.mygreen.supercsv.annotation.CsvBean;
import com.github.mygreen.supercsv.annotation.CsvColumn;

@CsvBean(header=true)
public class Person {
	@CsvColumn(number=1, label="id")
	private Integer id;
	@CsvColumn(number=2, label="name")
	private String name;
	@CsvColumn(number=3, label="age")
	private Integer age;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "id：[" + this.id + "]、name：[" + this.name + "]、age：[" + this.age + "]";
	}
}
