import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Notebook> notebooks = new HashSet<Notebook>();
        notebooks.add(new Notebook("HP ololo 41K8", 8, false, 21432.564));
        notebooks.add(new Notebook("Lenovo 4z-SHABOOM", 64, true, 90000.1124));

        OperationWithNotebook operation = new OperationWithNotebook(notebooks);
        operation.start();
    }
}