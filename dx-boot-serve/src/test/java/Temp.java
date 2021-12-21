import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author yaojian
 * @createTime 2021/12/12
 */
public class Temp {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setName("tom");
        students.add(student);
        Student student2 = new Student();
        student2.setName("tom");
        students.add(student2);

        students.forEach(student1 -> {
            student1.setId("23323");
        });


        System.out.println(students);


    }
}

@Data
@ToString
class Student {
    private String id;
    private String name;
    private boolean isGood;
    private boolean test;

    public boolean isGood() {
        return isGood;
    }

    public void setGood(boolean good) {
        isGood = good;
    }

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }
}