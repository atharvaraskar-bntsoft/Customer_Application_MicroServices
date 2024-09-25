# Customer Application Microservices

The Customer Application is designed to manage customer data using a microservices architecture. It leverages Spring Boot and Feign Client to communicate with different microservices hosted on separate machines. This application allows users to submit customer information via a REST API, facilitating efficient data handling and scalability.

## Overview

This application is built to manage customer information effectively by calling two different microservices for address and contact details. Each microservice can be hosted on different machines, accessed via their respective IP addresses, ensuring a seamless integration of data across the system.

### Key Features

- **Microservices Architecture**: Enables independent deployment and scaling of services.
- **Feign Client Integration**: Simplifies HTTP requests to other microservices, enhancing maintainability.
- **RESTful API**: Provides a simple interface for client interaction.
- **Structured Data Handling**: Allows comprehensive customer data submissions in a consistent format.

## API Documentation

### Create a Customer

You can create a new customer by sending a POST request to the `/customerapi/customer` endpoint.

#### Example Request

Use the following `curl` command to test the API:

```bash
curl -X POST http://localhost:8080/customerapi/customer 
-H "Content-Type: application/json" \
-d '{
    "customerName": "Rohit Sharma",
    "customerFirstName": "Rohit",
    "gender": "Male",
    "organisation": "Indian Cricket Team",
    "addressDetails": {
        "city": "Mumbai",
        "state": "Maharashtra"
    },
    "contactDetails": {
        "email": "rohitsharma45@gmail.com",
        "mobileNo": "9921204050"
    }
}'

### get Customer 

####API -   GET http://localhost:8080/customerapi/customer/1
