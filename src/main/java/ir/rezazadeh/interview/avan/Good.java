package ir.rezazadeh.interview.avan;

import java.util.Objects;

/**
 * Represent a movable property which has id, weight and price.
 */
public class Good {

    public Good(Integer id, Float weight, Float price) {
        this.id = id;
        this.weight = weight;
        this.price = price;
    }

    private Integer id;
    private Float weight;
    private Float price;

    public Integer getId() {
        return id;
    }

    public Float getWeight() {
        return weight;
    }

    public Float getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good other = (Good) o;
        return id.equals(other.id) && weight.equals(other.weight) && price.equals(other.price);
    }
}
