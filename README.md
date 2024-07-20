<p align="center">
<img src="https://imgur.com/gq76rZY" alt="Travel" style="width:350px">
</p>

# Travelogue

Travelogue is a college project aimed at creating a comprehensive travel site. The application consists of an Angular frontend and a Java backend with a MySQL database. The project is currently being updated to have the layout planned on CodePen before deployment with Docker.

## Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [License](#license)

## Project Overview

Travelogue is designed to provide users with an immersive travel experience. Users can explore destinations, plan trips, and share their travel experiences. The project leverages modern web technologies to ensure a seamless and interactive user experience.

## Features

- User registration and authentication
- Browse and search for travel destinations
- Detailed destination information
- User-generated reviews and ratings
- Trip planning and itinerary management
- Responsive design for mobile and desktop

## Technologies Used

### Frontend

- Angular
- HTML5
- CSS3
- TypeScript

### Backend

- Java
- Spring Boot
- MySQL

### Deployment

- Docker

## Setup and Installation

### Prerequisites

- Node.js and npm
- Angular CLI
- Java JDK
- MySQL
- Docker

### Backend Setup

1. Clone the repository:

   ```sh
   git clone https://github.com/snufkinwa/travelogue.git
   cd travelogue/backend
   ```

2. Configure the MySQL database in `application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/travelogue
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   ```

3. Build and run the backend:
   ```sh
   ./mvnw spring-boot:run
   ```

### Frontend Setup

1. Navigate to the frontend directory:

   ```sh
   cd travelogue/frontend
   ```

2. Install dependencies:

   ```sh
   npm install
   ```

3. Run the Angular development server:
   ```sh
   ng serve
   ```

### Docker Deployment

1. Build the Docker images:

   ```sh
   docker-compose build
   ```

2. Start the services:
   ```sh
   docker-compose up
   ```

## Usage

1. Open your browser and navigate to `http://localhost:4200` for the frontend.
2. Access the backend API at `http://localhost:8080`.

## License

This project is licensed under the MIT License.

---

Feel free to customize the content as needed. Let me know if you need any more details or changes!
