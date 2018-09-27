/**
 * @program: test1
 * @description:
 * @author: Chao Qian
 * @create: 2018-07-31 10:49
 **/
public class Student {
    Integer id;
    Integer age;
    String name;

    public Student(Integer id, Integer age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
