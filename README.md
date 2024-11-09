# ClickUp API Testing with Rest Assured

This repository contains a series of automated tests written in Java using the Rest Assured library to test ClickUp's API endpoints. The purpose of this project is to validate the functionality of the ClickUp API by covering CRUD operations for specific resources.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Environment Variables](#environment-variables)
- [Running the Tests](#running-the-tests)
- [Reporting](#reporting)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites

- **Java JDK 11+**: Make sure you have Java JDK version 11 or later installed. This project uses Amazon Corretto 17.
- **Maven**: A build tool for managing project dependencies.
- **Git**: A version control system for managing the project code.
- **IDE**: Preferably IntelliJ IDEA or Eclipse for easy project management.
- **ClickUp API Token**: You will need an API token from ClickUp to authenticate requests.

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/ypohranychnyy/r_d_HW9_Java_RestAssured.git
   cd r_d_HW9_Java_RestAssured
   ```

2. Ensure that the required dependencies are installed by running:
   ```bash
   mvn clean install
   ```

3. Set up your environment variables in a `.env` file as described in [Environment Variables](#environment-variables).

## Project Structure

- `src/main/java/com/clickup/tests`: Contains the test classes for API endpoints.
  - `BaseTest.java`: Base configuration for Rest Assured and common settings.
  - `ClickUpListsCRUDTest.java`: Tests for CRUD operations on ClickUp lists.
  - `SpaceTagsTest.java`: Tests for CRUD operations on ClickUp space tags.

- `.env`: Environment variables used for secure storage of API credentials.

- `pom.xml`: Maven configuration file to manage dependencies and plugins.

## Environment Variables

Create a `.env` file in the root directory with the following variables:

```plaintext
BASE_URL=https://api.clickup.com/api/v2
CLICKUP_API_TOKEN=your_token_here
SPACE_ID=your_space_id_here
```

The `.env` file helps manage sensitive information securely.

## Running the Tests

1. To run the tests, use Maven:
   ```bash
   mvn test
   ```

2. You can also run individual test classes directly from your IDE.

### Running Tests with Allure Reporting

To generate and view an Allure report:

1. Run the tests and generate the Allure result files:
   ```bash
   mvn test -Dallure.results.directory=target/allure-results
   ```

2. Serve the Allure report:
   ```bash
   allure serve target/allure-results
   ```

## Reporting

This project uses **Allure** for reporting the results of test execution. Allure provides detailed information about test results, including steps, parameters, and logs.

Ensure that you have Allure installed on your system to view the reports.

## Contributing

Feel free to submit issues, fork the repository, and create pull requests. Contributions are always welcome.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

