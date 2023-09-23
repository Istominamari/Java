
import java.util.*;

public class OperationWithNotebook {

    private Set<Notebook> notebooks = new HashSet<>();
    private List<Criterion> criterionList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public void printList(){
        for (Notebook notebook : this.notebooks){
            if (notebook.check(this.criterionList)){
                System.out.println(notebook);
            }
        }
    }

    public OperationWithNotebook(Set<Notebook> notebooks) {
        scanner = new Scanner(System.in);
        this.notebooks = notebooks;
    }

    public void start(){

        boolean flag = true;
        while (flag){

            System.out.println(
                "Выберите опрерацию: \n " +
                "1. Добавить критерий \n " +
                "2. Вывести список \n " +
                "3. Завершить"
            );
            String operation = scanner.next();

            if (operation.equals("3")) {
                flag = false;
                scanner.close();
                continue;

            } else if (operation.equals("1")) {

                String[] properties = Notebook.propertiesDescriptions();
                String text = "Введите цифру, соответствующую необходимому критерию: ";
                for (int i = 0; i < properties.length; i++) {
                    text += "\n" + (i + 1) + ". " + properties[i];
                }
                System.out.println(text);

                int propertyNumber = scanner.nextInt() - 1;
                if (propertyNumber < 0 || propertyNumber > properties.length) {
                    System.out.println("Введено некорректное значение");
                    continue;
                }

                Criterion criterion = Notebook.getCriterionByProperty(propertyNumber);
                try {
                    if (criterion == null) {
                        throw new Error("Не удалось определить критерий");
                    }
                    criterion.startGetting(scanner);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    continue;
                }

                System.out.println("Критерий добавлен");
                criterionList.add(criterion);
            } else if (operation.equals("2")) {
                printList();
            } else {
                System.out.println("Введено некорректное значение");
            }
        }
    }
}