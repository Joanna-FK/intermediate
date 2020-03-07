package day1.exercise1;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Diary dz = new Diary();
        dz.addStudent(new Student("123", "Pawel", "Kowal"));
        dz.addStudent(new Student("124", "Jan", "Kowalski"));
        dz.addStudent(new Student("125", "Marian", "Kowalewski"));
        dz.addStudent(new Student("126", "Zygmunt", "Jankowski"));
        dz.addStudent(new Student("127", "Zdzislaw", "Janek"));


        dz.removeStudent("125");

        Optional<Student> box = dz.returnStudent("126");
        if (box.isPresent()) {
            Student student = box.get();
            System.out.println(student.getStudentName());
        }
        dz.sortStudentsByIndex().forEach(System.out :: println); //wywołaj prnt na każdym obiekcie
    }
}
