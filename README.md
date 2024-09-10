# Currency Converter Application

## Overview
The *Currency Converter Application* allows users to convert one currency to another based on real-time exchange rates. The backend is powered by a Spring Boot REST API that fetches exchange rates from a third-party service, while the frontend is built using HTML, CSS, and JavaScript for an intuitive user experience.

## Features
- *Real-Time Conversion*: Convert between multiple currencies using up-to-date exchange rates.
- *Simple UI*: Easy-to-use interface for selecting currencies and entering amounts.
- *REST API*: Efficient backend API built with Spring Boot to handle conversion requests.
  
## Technologies Used
- *Backend*: Spring Boot (Java), REST API
- *Frontend*: HTML, CSS, JavaScript
- *Third-Party API*: Exchange rates fetched from an external service (e.g., OpenExchangeRates, Fixer.io)
- *Build Tool*: Maven or Gradle
- *Dependencies*:
  - Spring Web
  - Spring Boot DevTools
  - RestTemplate/WebClient for external API calls
  - lombok (Builder Pattern)

---

## Installation & Setup

### Prerequisites
- Java 8 or higher
- Maven  (for building the Spring Boot project)

### Backend Setup
1. Clone the repository:
    bash
    git clone [https://github.com/your-username/currency-converter-app.git](https://github.com/akashdas031/Currency-Convertor.git)
    cd currency-converter-app
    
2. Open the project in your favorite IDE (IntelliJ, Eclipse, etc.).

    
3. Build the project using Maven or Gradle:
    bash
    # Using Maven
    mvn clean install
    
   
5. Run the Spring Boot application:
    bash
    mvn spring-boot:run
    
    The application will start at http://localhost:8855/currency/v1/

### Frontend Setup
1. Navigate to the frontend directory where index.html, styles.css, and script.js are located.
2. Open index.html in a browser.
3. Start converting currencies by selecting the "From" and "To" currencies and inputting the amount.

---

## API Endpoints

### Convert Currency
- *URL*: http://localhost:8855/currency/v1/
- *Method*: POST
- *Description*: Converts the given amount from one currency to another using real-time exchange rates.
- *Query Parameters*:
  - from (String): The source currency code (e.g., USD, EUR).
  - to (String): The target currency code.
  - amount (double): The amount to convert.
  
*Example Request*:
bash
POST http://localhost:8855/currency/v1/


*Response*:
json
{
    "convertedAmount": 91.34
}


---


## How to Use

1. *Launch the application*: Run the backend using Spring Boot (mvn spring-boot:run).
2. *Open the frontend*: Open index.html in your browser.
3. *Convert currencies*:
   - Choose the source currency.
   - Choose the target currency.
   - Enter the amount to convert.
   - Click the *Convert* button to see the converted result.

---

## Future Improvements
- *Historical Data*: Add functionality to show historical exchange rates for a specified date.
- *Support for More Currencies*: Add support for more currency pairs and better handling of less common currencies.
- *Error Handling*: Add more robust error handling for invalid inputs and API errors.

---



## Contributions
Contributions are welcome! Feel free to submit a Pull Request or open an issue for any feature requests, bug reports, or enhancements.

---

## Contact
For any questions or support, please feel free to contact the project maintainer at akashdas7781@gmail.com

---


---

This README.md file is suitable for your GitHub repository, detailing how to install, run, and use the Currency Converter application.
