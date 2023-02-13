package com.addressBook;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class AddressBookRepo {
    static Map<String,AddressBook> addressBookMap = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    public static void addNewAddressBook() {
        AddressBook addressBook=new AddressBook();
        System.out.println("Enter AddressBook Name :");
        String addressBookName = sc.next();
        if(checkAddressBook(addressBookName)) {
            System.out.println("Entered AddressBook is Already Available");
        } else {
            addressBookMap.put(addressBookName,addressBook);
        }
    }
    public static void displayAddressBooks() {
        for(String key: addressBookMap.keySet()){
            System.out.println(key);
        }
    }
    public static boolean checkAddressBook(String addressbookName) {
        for(String key: addressBookMap.keySet()){
            if(addressbookName.equalsIgnoreCase(key)) {
                return true;
            }
        }
        return false;
    }
    public static void selectAddressBook() {
        displayAddressBooks();
        System.out.println("Enter AddressBook Name :");
        String addressbookName = sc.next();
        if(checkAddressBook(addressbookName)) {
            addressBookMap.get(addressbookName).contactOptions(addressBookMap.get(addressbookName));
        } else {
            System.out.println("Invalid AddressBook Name");
        }
    }
    public static void deleteAddressBook() {
        displayAddressBooks();
        System.out.println("Enter the AddressBook Name :");
        String addressbookName = sc.next();
        if(checkAddressBook(addressbookName)) {
            addressBookMap.remove(addressbookName);
            System.out.println("AddressBook Deleted Successfully----!!");
        } else {
            System.out.println("Invalid AddressBook Name-----!!");
        }
    }
    public static final int userInput() {
        return sc.nextInt();
    }
}


