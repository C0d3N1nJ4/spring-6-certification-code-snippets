package com.spring.products;

public class Disc extends Product{

    private final int capacity;

    public Disc(String name, double price, int capacity) {
        super(name, price);
        this.capacity = capacity;
    }

    public int getCapacity() { return capacity; }

    @Override
    public String toString() {
        return super.toString() + String.format(", capacity=%dMB", capacity);
    }
}
