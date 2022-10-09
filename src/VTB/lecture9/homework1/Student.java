package VTB.lecture9.homework1;

//@Table(title = "students")
public class Student {
  //  @Column
    String name;
    //@Column
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
