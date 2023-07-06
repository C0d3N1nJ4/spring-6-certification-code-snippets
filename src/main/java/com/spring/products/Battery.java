package com.spring.products;

public class Battery extends Product{

    private final boolean rechargeable;

    public Battery(String name, double price, boolean rechargeable) {
        super(name, price);
        this.rechargeable = rechargeable;
    }

    public boolean isRechargeable() { return rechargeable; }

    @Override
    public String toString() {
        return super.toString() + String.format(", rechargeable=%s", rechargeable);
    }
}
