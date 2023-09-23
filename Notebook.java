import java.text.DecimalFormat;
import java.util.List;

public class Notebook {
    private String model;
    private int amountRAM;
    private boolean isGaming;
    private double price;
    private DecimalFormat priceFormat;

    public Notebook(String model, int amountRAM, boolean isGaming, double price) {
        this.model = model;
        this.amountRAM = amountRAM;
        this.isGaming = isGaming;
        this.price = price;
        this.priceFormat = new DecimalFormat("#.##");
    }

    public String toString() {
        return (this.isGaming ? "Игровой н" : "Н") + "оутбук \"" + this.model +
            "\"\t объем оперативной памяти: " + this.amountRAM +
            ";\t цена: " + (this.priceFormat.format(this.price));
    }

    public boolean check(List<Criterion> cs) {
        for (Criterion c : cs) {
            if (!this.check(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean check(Criterion c) {
        if (c.property.equals("model")) {
            return c.stringValue == null || this.model.startsWith(c.stringValue);
        } else if (c.property.equals("isGaming")) {
            return c.flagValue == null || this.isGaming == c.flagValue;
        } else if (c.property.equals("amountRAM") || c.property.equals("price")) {
            double v = this.price;
            if (c.property.equals("amountRAM")) {
                v = this.amountRAM;
            }
            return (
                (c.maxValue == null || c.maxValue >= v)
                && (c.minValue == null || c.minValue <= v)
            );
        }
        return false;
    }

    public static String[] propertiesDescriptions() {
        return new String[] {
            "Модель",
            "Объем оперативной памяти",
            "Игровой ноутбук",
            "Цена"
        };
    }

    public static Criterion getCriterionByProperty(int n) {
        if (n == 0) {
            return new Criterion("model", false, false);
        } else if (n == 2) {
            return new Criterion("isGaming", false, true);
        } else if (n == 1 || n == 3) {
            String pn = "amountRAM";
            if (n == 3) {
                pn = "price";
            }
            return new Criterion(pn, true, false);
        }
        return null;
    }
}