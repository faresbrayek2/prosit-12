import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StudentManagement implements Management{
    public void displayStudents(List<Etudiant> etudiants, Consumer<Etudiant> con){
        for(Etudiant e :etudiants){
            con.accept(e);
        }
    }
    public void displayStudentsByFilter(List<Etudiant> etudiants, Predicate<Etudiant> pre, Consumer<Etudiant> con){
        for(Etudiant e :etudiants){
            if(pre.test(e))
                con.accept(e);
        }
    }
    public String returnStudentsNames(List<Etudiant> etudiants, Function<Etudiant, String> fun){
        String names = "";
        for (Etudiant e : etudiants) {
            names += " " + fun.apply(e);
        }
        return names;
    }
    public Etudiant createStudent(Supplier<Etudiant> sup){
        return sup.get();
    }
    public List<Etudiant> sortStudentsById(List<Etudiant> etudiants, Comparator<Etudiant> com){
        Collections.sort(etudiants,com);
        return etudiants;
    }
    public Stream<Etudiant> convertToStream(List<Etudiant> etudiants){
        return etudiants.stream();
    }
}