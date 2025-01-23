package org.example.models;

import java.util.*;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    private final Scanner scanner = new Scanner(System.in);

    public void startGrocery() {
        int choice;
        do {
            System.out.println("Ne yapmak istersiniz?");
            System.out.println("0 - Çıkış\n1 - Eleman ekle\n2 - Eleman çıkar");
            choice = scanner.nextInt();
            scanner.nextLine(); // Satır sonu karakterini temizle

            switch (choice) {
                case 1 -> {
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz (virgülle ayırabilirsiniz):");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    printSorted();
                }
                case 2 -> {
                    System.out.println("Çıkarılmasını istediğiniz elemanları giriniz (virgülle ayırabilirsiniz):");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    printSorted();
                }
                case 0 -> System.out.println("Uygulamadan çıkılıyor...");
                default -> System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        } while (choice != 0);

        scanner.close();
    }

    public static void addItems(String itemsToAdd) {
        String[] splitItems = itemsToAdd.split(",");
        for (String item : splitItems) {
            item = item.trim();
            if (checkItemIsInList(item)) {
                System.out.println(item + " zaten listede.");
            } else {
                groceryList.add(item);
            }
        }
        sortItems();
    }

    public static void removeItems(String itemsToRemove) {
        String[] splitItems = itemsToRemove.split(",");
        for (String item : splitItems) {
            item = item.trim();
            if (checkItemIsInList(item)) {
                groceryList.remove(item);
            } else {
                System.out.println(item + " listede bulunamadı.");
            }
        }
        sortItems();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        sortItems();
        System.out.println("Mevcut Pazar Listesi:");
        for (String item : groceryList) {
            System.out.println("- " + item);
        }
    }

    private static void sortItems() {
        Collections.sort(groceryList);
    }
}
