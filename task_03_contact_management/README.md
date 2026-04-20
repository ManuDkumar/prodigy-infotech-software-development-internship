# Contact Management System

## Overview

A console-based Contact Management System developed in Java as part of the Prodigy InfoTech Software Development Internship.

The application allows users to add, view, edit, and delete contacts through a menu-driven interface.  

All contact data is stored persistently using file handling (CSV format).


## Features

- Add new contacts (Name, Phone, Email)

- View all saved contacts

- Edit existing contacts

- Delete contacts

- Automatic file persistence

- Data loading on application restart

## Technical Implementation

The project follows a structured Object-Oriented design:

- Contact  

&nbsp; Represents an individual contact entity.

- ContactManager  

&nbsp; Handles business logic, data storage, and file operations.


- Main  

&nbsp; Provides the user interface and manages menu interaction.

## Data Storage

Contacts are stored in a file named:

contacts.csv

Each contact is saved in CSV format:
Name,Phone,Email


Example:

Raya,190326,raya@toxic.com

Ticket,13092026,ticket@toxic.com



## Concepts Demonstrated

- Object-Oriented Programming

- File I/O (BufferedReader, BufferedWriter)

- Collections (ArrayList)

- CRUD Operations

- Menu-driven console application

- Basic data persistence


## How to Run
1. Open the project in Eclipse / STS.

2. Run Main.java.

3. Use the menu options to manage contacts.

## Author: 
Manu Kumar H N 

## Year: 
2026

