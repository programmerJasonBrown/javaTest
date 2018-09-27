import java.util.*;
import java.util.stream.Collectors;

public class Hello {
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(new Student(2, 18, "阿龙"),
                new Student(2, 17, "小花"),
                new Student(4, 17, "阿浪"));
        Map<Integer, List<Student>> map = new HashMap<>();
        for (Student student : studentList) {
            map.merge(student.getId(), new ArrayList<>(Arrays.asList(student)), (newValueList, oldValueList) -> {
                oldValueList.addAll(newValueList);
                return oldValueList;
            });
        }

        map.forEach((key, value) -> {
            System.out.println("key: " + key + "    value: " + value);
        });

//       List<Integer> ids = studentList.stream().map(Student::getId)
//               .collect(() -> new ArrayList<>(),(list,item)->{list.add(item);},(list1,list2)->{list1.addAll(list2);});

        List<Integer> ids = studentList.stream().map(Student::getId).collect(Collectors.toList());
        List<Integer> subids = ids.subList(0,3);



        System.out.println();


    }
}
