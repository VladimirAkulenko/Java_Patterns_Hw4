package com.company;

//Single Responsibility Principle - класс Milk описывает только молоко, а не все продукты
//Open Closed Principle - имплементируя интерфейс Food мы добавляем классу функциональности, не изменяя его код
public class Bread extends Product implements Food {

    private final String name = "Хлеб";
    private final int price = 50;

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void eat() {
        System.out.println("Хлеб съеден");
    }
}
