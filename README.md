# Merchant Product Management System

## 📌 About the Project

The **Merchant Product Management System** is a Java-based web application designed to help merchants manage their product inventory efficiently. The application provides a user-friendly web interface built with JSP, HTML, CSS, and Bootstrap, connected to a Java backend using Servlets, Hibernate, JPA, and MySQL.

The project demonstrates full-stack web development concepts, including server-side request handling, database integration, session management, and CRUD-related operations.

## 🚀 Features

- **Merchant Registration:** Register new merchant accounts.
- **Merchant Login:** Authenticate merchants using their credentials.
- **Dashboard:** Access a centralized merchant management interface.
- **Product Management:** Add products and view products associated with a merchant.
- **Database Integration:** Persist merchant and product data using Hibernate/JPA and MySQL.
- **Responsive UI:** Build a clean, responsive interface using Bootstrap.
- **Session Management:** Maintain merchant login sessions and restrict access to protected pages.

## 🛠️ Technologies Used

- **Programming Language:** Java
- **Frontend:** HTML, CSS, JSP, Bootstrap
- **Backend:** Java Servlets
- **ORM Framework:** Hibernate
- **Persistence:** JPA
- **Database:** MySQL
- **Web Server:** Apache Tomcat 9
- **Build Tool:** Maven
- **IDE:** Eclipse

## 🏗️ Application Architecture

The application follows a layered approach in which the frontend communicates with Java Servlets, the Servlets invoke DAO classes, and Hibernate/JPA handles database persistence.

```text
User Interface
  (JSP, HTML, CSS, Bootstrap)
           |
           v
      Java Servlets
           |
           v
       DAO Classes
           |
           v
     Hibernate / JPA
           |
           v
        MySQL DB
```

## ⚙️ Getting Started

### Prerequisites

Make sure you have installed:

- JDK 8 or a compatible later JDK
- Eclipse IDE with web development tools
- Apache Tomcat 9
- MySQL Server
- Maven

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/YOUR_USERNAME/Merchant-Product-Management-System.git
   ```

2. Import the project into Eclipse using **File → Import → Maven → Existing Maven Projects**.

3. Configure your MySQL database connection in `persistence.xml`.

4. Update Maven dependencies using **Maven → Update Project**.

5. Configure Apache Tomcat 9 in Eclipse and add the project to the server.

6. Start Tomcat and open the application in your browser:

   ```text
   http://localhost:8080/Merchant_Product_App/
   ```

## 🎯 Learning Outcomes

This project helped me gain practical experience in:

- Developing Java web applications using Servlets and JSP.
- Integrating Hibernate/JPA with a MySQL database.
- Organizing database operations using DAO classes.
- Connecting frontend forms with backend business logic.
- Implementing session-based authentication.
- Configuring Maven projects and deploying applications on Apache Tomcat.

## 👨‍💻 Author

**V. Vinod Kumar**

Java Developer | Aspiring Java Full Stack Developer
