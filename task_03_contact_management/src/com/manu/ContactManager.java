package com.manu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactManager {

    private List<Contact> contacts;
    private final String FILE_NAME = "contacts.csv";

    public ContactManager() {
        contacts = new ArrayList<>();
        loadFromFile();
    }

    // Add Contact
    public void addContact(Contact contact) {
        contacts.add(contact);
        saveToFile();
        System.out.println("Contact added successfully.\n");
    }

    // View Contacts
    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.\n");
            return;
        }

        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("Contact ID: " + i);
            System.out.println(contacts.get(i).display());
            System.out.println("------------------------");
        }
    }

    // Edit Contact
    public void editContact(int index, String name, String phone, String email) {
        if (index >= 0 && index < contacts.size()) {
            Contact contact = contacts.get(index);
            contact.setName(name);
            contact.setPhone(phone);
            contact.setEmail(email);
            saveToFile();
            System.out.println("Contact updated successfully.\n");
        } else {
            System.out.println("Invalid Contact ID.\n");
        }
    }

    // Delete Contact
    public void deleteContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
            saveToFile();
            System.out.println("Contact deleted successfully.\n");
        } else {
            System.out.println("Invalid Contact ID.\n");
        }
    }

    // Save contacts to file
    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Contact contact : contacts) {
                writer.write(contact.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }

    // Load contacts from file
    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    contacts.add(new Contact(data[0], data[1], data[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading contacts: " + e.getMessage());
        }
    }
}