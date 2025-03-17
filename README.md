# Java Cafe Order Management System 

## Table of Contents
1. [Project Description](#project-description)
2. [System Components](#system-components)
3. [Installation Guide](#installation-guide)
4. [Usage Instructions](#usage-instructions)
   - [Order Management](#order-management)
   - [Order Search](#order-search)
5. [Additional Information](#additional-information)

## Project Description
This project is a **Java-based order management system** for a cafe, designed to help employees manage and process customer orders. The system allows:

- **Order Placement**: Customers can order drinks and beverages.
- **Order Processing**: Employees can update order status and handle deliveries.
- **Graphical User Interface**: A user-friendly interface for employees to interact with the system.
- **Data Management**: Storage and retrieval of orders using an `ArrayList`.

The application follows **Object-Oriented Programming (OOP) principles** and includes classes for different drink types, pricing calculations, and order management.

## System Components
The system consists of multiple Java classes, including:

1. **Drink Class**: Defines attributes for beverages such as type, sweetener, syrup, dairy, and additional ingredients.
2. **Coffee Class**: Inherits from `Drink` and adds attributes like coffee type, dose, and sugar level.
3. **Beverage Class**: Inherits from `Drink` and adds attributes like beverage type and size.
4. **PriceList Interface**: Defines pricing methods and includes a `calculateTotalPrice()` method.
5. **Order Class**: Implements `PriceList` and manages order details like order number, drink details, delivery method, and order status.
6. **Graphical User Interface**: Employees can add, modify, search, and delete orders using a simple GUI.

## Installation Guide
### Prerequisites:
- **Java Development Kit (JDK 8 or later)**
- **Eclipse IDE (or any Java IDE)**

### Installation Steps:
1. Clone the repository:
   ```sh
   git clone https://github.com/starfastasos/Java_Language-coursework.git
   ```
2. Open the project in **Eclipse**:
   - Go to `File` > `Import` > `Existing Projects into Workspace`.
   - Select the project folder.
   - Click `Finish`.
3. Compile and run the program:
   - Ensure all `.java` files are compiled.
   - Execute the `App.java` file to launch the application.

## Usage Instructions

### Order Management
- **New Order**: Employees can create a new order, select drink details, and specify delivery options.
- **View Orders**: A table displays all existing orders.
- **Modify Orders**: Employees can update order details, but only for orders in `Registered` status.
- **Cancel Orders**: Orders can be canceled only if their status is `Registered`.

### Order Search
Orders can be searched using:
1. **Beverage Type**: Coffee or other beverages.
2. **Order Status**: `Registered`, `Processing`, `Ready for Pickup`, etc.
3. **Order Date**: Filter by date range.

## Additional Information
- Orders are **stored in an ArrayList** and displayed in a table when the program starts.
- Data validation ensures correct input formatting.
- The pricing structure is based on a predefined price list.
- The program must be launched by executing `App.java`.
