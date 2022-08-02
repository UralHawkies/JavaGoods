package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product {
    public String madeBy;

    public Smartphone(int id, String name, int price, String madeBy) {
        super(id, name, price);
        this.madeBy = madeBy;
    }

    public String getMadeBy() {
        return madeBy;
    }

    public void setMadeBy (String madeBy) {
        this.madeBy = madeBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(madeBy, that.madeBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), madeBy);
    }
}
