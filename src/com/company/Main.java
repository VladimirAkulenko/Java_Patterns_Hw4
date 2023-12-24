package com.company;

import java.util.Scanner;

public class Main {
    //Magic Numbers Principle - вместо чисел используем константы
    public static final char RUB = (char) 0x20BD;

    public static void main(String[] args) {
        //Liskov substitution principle - наследники класса Product полностью играют роль предка
        Product[] products = {new Bread(), new Apple(), new Milk(), new Cheese()};
        //принцип DRY - повторяющийся вывод списка продуктов на экран выносим в отдельный метод
        printListProducts(products);
        separate();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите товар и количество или введите `end`");

            String inputString = scanner.nextLine();

            if (inputString.equals("end")) {
                break;
            }
            try {
                String[] parts = inputString.split(" ");
                if (parts.length > 2) {
                    throw new ArrayIndexOutOfBoundsException();
                } else {
                    int productNumber = Integer.parseInt(parts[0]) - 1;
                    products[productNumber].setCount(Integer.parseInt(parts[1]));
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Неверно введено. Пример ввода: 1 2, что означает, товар номер 1 в количестве 2 штуки");
            }
        }
        separate();
        printListBasket(products);
    }

    private static void printListProducts(Product[] products) {
        System.out.println("Список возможных товаров для покупки");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " " + products[i].getPrice() + " " + RUB + "/шт");
        }
    }

    private static void printListBasket(Product[] products) {
        int sumProducts = 0;

        System.out.println("Ваша корзина:");
        for (Product product : products) {
            if (product.getCount() != 0) {
                sumProducts += product.getCount() * product.getPrice();
                System.out.println(product + " " + product.getCount() + " шт " + product.getPrice() + " " + RUB + "/шт  = "
                        + product.getCount() * product.getPrice() + " " + RUB + " в сумме");
            }
        }
        System.out.println("Итого " + sumProducts + " " + RUB);
    }

    public static void separate() {
        System.out.println("-------------------------------------------------------");
    }
}
