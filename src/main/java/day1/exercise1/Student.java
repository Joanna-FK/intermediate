package day1.exercise1;


import lombok.*;

import java.util.List;
import java.util.OptionalDouble;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Student {
    private List<Double> ratingList;
    private String studentIndexNumber;
    private String studentName;
    private String studentsSurname;

    public Student(String studentIndexNumber, String studentName, String studentsSurname) {
        this.studentIndexNumber = studentIndexNumber;
        this.studentName = studentName;
        this.studentsSurname = studentsSurname;
    }
    public Double calculateAverage(){
    double sum = 0;
    //opcja 1
    for (int i = 0; i<ratingList.size(); i++){
    sum += ratingList.get(i);}
    //opcja 2
    sum = ratingList.stream().mapToDouble(Double::doubleValue).sum();

       //opcja 3 daje od razu wynik
    OptionalDouble average= ratingList.stream().mapToDouble(Double::doubleValue).average();
    return average.orElseGet(() -> 0.0);
   // return sum/ratingList.size();
    }
}
