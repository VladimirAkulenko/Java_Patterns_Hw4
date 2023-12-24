package com.company;

//Single Responsibility Principle - класс Milk описывает только молоко, а не все продукты
//Open Closed Principle - имплементируя интерфейс Food мы добавляем классу функциональности, не изменяя его код

//Interface Segregation Principle - применяем разные интерфейсы вместо одного большого
//Dependency Inversion Principle - разделив интерфейсы мы не зависим от их общей функциональности, мы можем поменять один интерфейс на другой
public class Apple extends Product implements Food, Weigher {

    private final String name = "Яблоко";
    private final int price = 200;

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
        System.out.println("Яблоки съедены");
    }

    @Override
    public void productWeighed() {
        System.out.println("Яблоки взвешены");
    }
}
