// Lab 7 için.  

public class Student {

    String name;
    int age;

    public Student() {
        name = "Default Name";
        age = 18;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void printStudentInfo() {
        System.out.println("Name = " + name);
        System.out.println("Age = " + age);
    }

}
