import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Notebook> notebooks = new HashSet<Notebook>();
        notebooks.add(new Notebook("HP P5", 8, false, 21432.564));
        notebooks.add(new Notebook("Lenovo 4z", 64, true, 11000.1124));
        notebooks.add(new Notebook("Acer 55-88", 64, true, 90000.1124));
        notebooks.add(new Notebook("Lenovo SHABOOM", 64, true, 70000.1124));
        notebooks.add(new Notebook("HP-54-455", 64, true, 100000.1124));
        notebooks.add(new Notebook("Acer 99-io-00", 64, false, 20000.00));

        OperationWithNotebook operation = new OperationWithNotebook(notebooks);
        operation.start();
    }
}