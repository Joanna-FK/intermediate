package day1.exercise1;

import java.util.*;
import java.util.stream.Collectors;

public class Diary {
    private List<Student> listStudent = new ArrayList<>();

    public void addStudent(Student studentAdd) {
        listStudent.add(studentAdd);
    }

    public void removeStudent(Student studentRemove) {
        listStudent.remove(studentRemove);
    }

    public void removeStudent(String indexNumber) {
        for (Student student : listStudent) {
            if (student.getStudentIndexNumber().equalsIgnoreCase(indexNumber)) {
                listStudent.remove(student);
                break;
            }
        }
        //opcja 2
//        for (int i =0; i<listStudent.size(); i++){
//            if (listStudent.get(i).getStudentIndexNumber().equalsIgnoreCase(indexNumber)){
//                listStudent.remove(i);
//                i--; //cofnięcie się  po usunięciu
//            }
//        }
//opcja 3
//        Iterator<Student> it = listStudent.iterator();
//        while (it.hasNext()){
//            Student student = it.next();
//            if(student.getStudentIndexNumber().equalsIgnoreCase(indexNumber))
//            {
//                it.remove();
//            }
//        }
        //equalsIgnoreCase - ignoruje wielkość liter
    }

    public Optional<Student> returnStudent(String studentIndexNumber) {
        for (Student st : listStudent) {
            if (st.getStudentIndexNumber().equalsIgnoreCase(studentIndexNumber)) {
                return Optional.of(st);
            }
        }
        return Optional.empty();
    }

    public Optional<Double> getStudentAverage(String indexNumber) {
        Optional<Student> studentOptional = returnStudent(indexNumber);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            return Optional.of(student.calculateAverage());
        }
        return Optional.empty();
    }

    public List<Student> provideStudentAsRisk() {
        return listStudent.stream()
                .filter(student -> student.calculateAverage() <= 2.5)
                .collect(Collectors.toList());
    }

    public List<Student> sortStudentsByIndex() {
        Collections.sort(listStudent, new Comparator<Student>() {
            //-1
            //0
            //1
            @Override
            public int compare(Student student1, Student student2) {
                Long s1 = Long.parseLong(student1.getStudentIndexNumber());
                Long s2 = Long.parseLong(student2.getStudentIndexNumber());
                return s2.compareTo(s1);
            }
        });
        return listStudent;
    }

    public void addRating(String indexNumber, Double rating) {
        Optional<Student> studentOptional = returnStudent(indexNumber);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.getRatingList().add(rating);
        } else {
            throw new RuntimeException("Failed to find student");
        }
    }
}
