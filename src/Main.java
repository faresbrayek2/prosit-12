import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println("prosit 12");
        // Creating a list of students
        List<Etudiant> etudiants = Arrays.asList(
                new Etudiant(1, "jhon", 23),
                new Etudiant(2, "david", 25),
                new Etudiant(3, "maria", 31)
        );
        // Creating an instance of StudentManagement
        StudentManagement studentManagement = new StudentManagement();
        // Displaying all students
        System.out.println("display all students");
        studentManagement.displayStudents(etudiants,System.out::println);

        // Displaying students filtered by age (displaying students older than 30)
        System.out.println("Displaying students older than 30:");
        studentManagement.displayStudentsByFilter(etudiants, etudiant -> etudiant.getAge() > 30, System.out::println);

        // Returning  names of students
        System.out.println("list of names:");
        Function<Etudiant, String> fun = e -> e.getNom();
        String names = studentManagement.returnStudentsNames(etudiants, fun);
        System.out.println(names);

        //Creating a new student using Supplier
        System.out.println("new student");
        Supplier<Etudiant> sup = () -> new Etudiant(4,"seif",33);
        Etudiant etudiant = studentManagement.createStudent(sup);
        System.out.println(etudiant);

        // Sorting students by ID
        System.out.println("Sorting students by ID:");
        List<Etudiant> sortedStudents = studentManagement.sortStudentsById(etudiants, Comparator.comparingInt(Etudiant::getId));
        studentManagement.displayStudents(sortedStudents, System.out::println);

        // Converting the list of students to a stream
        System.out.println("Converting students to a stream and displaying:");
        studentManagement.convertToStream(etudiants).forEach(System.out::println);


    }
}