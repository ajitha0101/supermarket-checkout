# Supermarket Checkout System

This project is a supermarket checkout system that calculates the total price of items with support for special pricing rules.

## Features

- Scanning items individually
- Special pricing rules for multiple quantities
- Easily updatable pricing rules
- Custom exception handling
- JUnit tests

## Folder Structure

supermarket-checkout/
│
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ ├── Item.java
│ │ │ ├── Checkout.java
│ │ │ ├── InvalidItemException.java
│ │ │ └── Main.java
│ │ └── resources/
│ └── test/
│ ├── java/
│ │ └── CheckoutTest.java
│ └── resources/
│
├── .gitignore
└── README.md


## Classes

- `Item`: Represents an item in the store with its SKU, unit price, and special price.
- `Checkout`: Handles the checkout process, including scanning items and calculating the total price.
- `InvalidItemException`: Custom exception for handling invalid item entries.
- `Main`: Entry point for the application.
- `CheckoutTest`: JUnit test class for the `Checkout` class.

## How to run

1. Clone this repository.
2. Compile and run the `Main.java` file in your favorite IDE or from the command line.
3. Follow the prompts to input items one by one (A, B, C, D), or type 'total' to calculate the total price.

## Running tests

Open the project in your favorite IDE and run the `CheckoutTest.java` file to execute the JUnit tests.
