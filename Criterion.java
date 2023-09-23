import java.util.*;

public class Criterion {
    String stringValue;
    Boolean flagValue;
    Double minValue;
    Double maxValue;
    boolean isQuantitative;
    boolean isFlag;
    String property;

    public Criterion(String property, boolean isQuantitative, boolean isFlag) {
        this.property = property;
        this.isQuantitative = isQuantitative;
        this.isFlag = isFlag;
        this.stringValue = null;
        this.flagValue = null;
        this.minValue = null;
        this.maxValue = null;
    }

    public void startGetting(Scanner scanner) throws Exception {
        if (this.isQuantitative) {
            System.out.println(
                "Выберите тип криетрия: " +
                "\n 1. Значение" +
                "\n 2. Меньше" +
                "\n 3. Больше" +
                "\n 4. Интервал"
            );

            String type = scanner.next();
            if (type.equals("1")) {
                System.out.println("Введите значение поиска: ");
                this.minValue = scanner.nextDouble();
                this.maxValue = this.minValue;
            } else if (type.equals("2")) {
                System.out.println("Введите максимальное предельное значение: ");
                this.maxValue = scanner.nextDouble();
            } else if (type.equals("3")) {
                System.out.println("Введите минимальное предельное значение: ");
                this.minValue = scanner.nextDouble();
            } else if (type.equals("4")) {
                System.out.println("Введите минимальное предельное значение: ");
                this.minValue = scanner.nextDouble();
                System.out.println("Введите максимальное предельное значение: ");
                this.maxValue = scanner.nextDouble();
            } else {
                throw new Exception("Некорректный тип критерия.");
            }
            return;
        }

        if (this.isFlag) {
            System.out.println(
                "Выберите значение флага: " +
                "\n 1. Положительное" +
                "\n 2. Отрицательное"
            );

            String text = scanner.next();

            if (text.equals("1")) {
                this.flagValue = true;
            } else if (text.equals("2")) {
                this.flagValue = false;
            } else {
                throw new Exception("Некорректное значение флага.");
            }
            return;
        }

        System.out.println("Введите значение текстового поиска: ");
        this.stringValue = scanner.next();
    }
}
