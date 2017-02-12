package css.cis3334.pizzaorder;

/**
 * Created by tgibbons on 2/10/2017.
 */
public class Pizza {
    public enum pizzaSize { SMALL, MEDIUM, LARGE};
    public static final Double SMALL_PRICE = 7.00;
    public static final Double MEDIUM_PRICE = 9.00;
    public static final Double LARGE_PRICE = 11.00;
    public static final Double EXTRA_CHEESE_PRICE = 1.50;
    public static final Double DELIVERY_PRICE = 10.00;

    private String topping;
    private boolean extraCheese;
    private boolean delivery;
    private pizzaSize size;
    private Double price;
    private String description;


    public Pizza(String topping, pizzaSize size, boolean extraCheese, boolean delivery) {
        this.topping = topping;
        this.delivery = delivery;
        this.size = size;
        this.extraCheese = extraCheese;
        if (size==pizzaSize.SMALL) {
            price = SMALL_PRICE;
            description = "Small " + topping + " pizza";
        } else if (size==pizzaSize.MEDIUM) {
            price = MEDIUM_PRICE;
            description = "Medium " + topping + " pizza";
        } else {
            price = LARGE_PRICE;
            description = "Large " + topping + " pizza";
        }
        if (extraCheese) {
            price += EXTRA_CHEESE_PRICE;
            description += " with extra cheese";
        }

        if (delivery) {
            price += DELIVERY_PRICE;
            description += " to be delivered";
        }
    }

    public Double getPrice() {
        return price;
    }

    public String toString() {
        return description;
    }


}
