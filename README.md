# ATM Management System - Java Console Application

This Java console application simulates an ATM system, allowing users to perform various banking transactions such as checking balance, depositing money, withdrawing money, and transferring money between accounts.  It emphasizes secure handling of user data and transactions.

---
<img width="395" alt="Screenshot 2025-02-03 224816" src="https://github.com/user-attachments/assets/93ce90ff-d14e-4eba-82a6-2c5f54160937" />

## Features

1. *User Authentication:*
    - Secure login system requiring users to enter a valid account number and PIN.

2. *Check Balance:*
    - Allows users to view their current account balance.

3. *Deposit Money:*
    - Enables users to deposit funds into their account.

4. *Withdraw Money:*
    - Allows users to withdraw funds from their account, with checks for sufficient balance.

5. *Transfer Money:*
    - Facilitates transferring funds between two accounts within the system.

6. *Transaction History:*
    - Maintains a record of all transactions performed by the user.

7. *Data Persistence:*
    - User account data and transaction history are stored persistently, ensuring data is retained across sessions.

8. *Error Handling:*
    - Implements robust error handling to manage invalid inputs, insufficient funds, and other potential issues.

9. *User-Friendly Interface:*
    - Provides a clear and easy-to-navigate command-line interface.

---

## Technologies Used

1. *Java:*
    - The primary programming language used for development.

2. *Object-Oriented Programming (OOP) Principles:*
    - Encapsulation, Inheritance, and Polymorphism are used to structure the application effectively.

3. *Data Structures:*
    - Appropriate data structures (e.g., ArrayList, HashMap) are used to manage user accounts and transactions.

4. *File I/O:*
    - Used for persistent storage of user data and transaction history.

5. *Exception Handling:*
    - Mechanisms for handling exceptions and errors gracefully.

---

## Installation

### Step 1: Clone the Repository

Clone the GitHub repository to your local machine using the following command:

bash
git clone https://github.com/BubalanShanmugam/ATM.git

*step 2: Compile the application:*
bash
javac ATM.java

*step 3:  Run the application:*
bash   
java ATM


## Usage Instructions

1. *Login:*
   - Enter your account number and PIN when prompted.

2. *Main Menu:*
   - After successful admin login, you will be presented with a menu of options:
     - Check Balance
     - Deposit
     - Withdraw
     - Transaction History
     - Exit
    
   - After successful user login, you will be presented with a menu of options:
     - Check Balance
     - Deposit
     - Withdraw
     - Transaction History
     - Change PIN
     - Exit

3. *Select an Option:*
   - Enter the corresponding number for the desired transaction.

4. *Follow Prompts:*
   - The application will guide you through the necessary steps for each transaction.

5. *Exit:*
   - Choose the "Exit" option to terminate the program.

## Security Considerations

* *PIN Storage:* While this example may not demonstrate advanced security measures like hashing and salting for PIN storage (which is crucial in real-world applications), consider implementing these in a production environment.  Do not store PINs in plain text.
* *Input Validation:* The application should thoroughly validate user input to prevent errors and potential security vulnerabilities.

## Contact

* *Developer:* Bubalan
* *Email:* bubalanshanmugam62@gmail.com
* *LinkedIn:* www.linkedin.com/in/bubalan-s-1515a82b0
