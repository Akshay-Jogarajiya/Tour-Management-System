# Tour Management System

## Overview
The **Tour Management System** is a web-based application designed to streamline the management of tours. It allows users to plan, book, and manage various aspects of tours in a user-friendly interface. This project aims to provide an efficient system for managing tour operations, with a focus on ease of use and scalability.

## Features
- **Tour Planning:** Users can view and plan their tours, including itinerary and location details.
- **Booking System:** Users can book tours and manage their bookings through a simple interface.
- **Admin Panel:** Admin users can manage tours, bookings, and user accounts.
- **Real-Time Updates:** The system provides real-time updates about tour availability and booking status.

## Technologies Used
- **Backend:** Java, Spring Boot
- **Database:** MySQL 
- **Frontend:** JSP, HTML, CSS, JavaScript
- **Build Tools:** Maven
- **Version Control:** Git

## Setup and Installation

### Prerequisites
- JDK 11 or later
- Maven 3.6 or later
- MySQL 
- Git

### Steps to Set Up
1. Clone the repository:
    ```bash
    git clone https://github.com/Akshay-Jogarajiya/Tour-Management-System.git
    cd Tour-Management-System
    ```

2. Install dependencies using Maven:
    ```bash
    mvn install
    ```

3. Configure the database by modifying the `application.properties` file in `src/main/resources/` to include your database credentials:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```

4. Run the application:
    ```bash
    mvn spring-boot:run
    ```

5. The application will now be running on `http://localhost:8080/`.

## Usage
- Navigate to `http://localhost:8080/` to access the system's homepage.
- Use the provided interface to plan tours, book tours, and manage your bookings.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments
- Thank you to all the contributors who have helped improve this project.

