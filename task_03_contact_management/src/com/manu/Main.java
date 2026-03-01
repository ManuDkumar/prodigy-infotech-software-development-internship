package com.manu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ContactManager manager = new ContactManager();

        int choice;

        do {
            System.out.println("===== Contact Management System =====");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    manager.addContact(new Contact(name, phone, email));
                    break;

                case 2:
                    manager.viewContacts();
                    break;

                case 3:
                    System.out.print("Enter Contact ID to edit: ");
                    int editIndex = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter New Phone: ");
                    String newPhone = scanner.nextLine();

                    System.out.print("Enter New Email: ");
                    String newEmail = scanner.nextLine();

                    manager.editContact(editIndex, newName, newPhone, newEmail);
                    break;

                case 4:
                    System.out.print("Enter Contact ID to delete: ");
                    int deleteIndex = scanner.nextInt();
                    scanner.nextLine();

                    manager.deleteContact(deleteIndex);
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.\n");
            }

        } while (choice != 5);

        scanner.close();
    }
}