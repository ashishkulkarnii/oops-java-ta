## Lab 9: MVC Architecture

The MVC is one of the most widely used architecture patterns for application and web development. MVC stands for Model View Controller:
- **Model**: Contains the data
- **View**: Contains the presentation logic
- **Controller**: Contains the backend code

To complete this week’s lab, use any of the following frameworks:
- Spring
- Grails
- Vaadin
- Play
- Struts
- Java Server Faces

Last year, when I was in your place, I found that creating an entire application, along with a GUI using a Java web-app framework (such as *Spring Boot*) was a pretty daunting task–especially to complete within a single lab session.

To make things easier for you, I have created template code using *Vaadin* with all the required classes and methods, you only need to fill them in. Use [this guide](https://vaadin.com/docs/latest/guide/quick-start) to set up *Vaadin* on your system.

From [here](9-mvc), download `code.zip` and extract it into any directory. You will find the main MVC files in `mvc\src\main\java\com\example\application\views\main`. Once you have filled in all the methods, `CD` into the `mvc` folder, and run `mvnw` on Windows, or `./mvnw` on Unix to run the project. You can also use the quick start project in the guide page to get started.

In case you decide to use *Vaadin*, look into the following components:
- [Grid](https://vaadin.com/docs/latest/components/grid)
- [Button](https://vaadin.com/docs/latest/components/button)
- [TextField](https://vaadin.com/docs/latest/components/text-field)
- [Dialog](https://vaadin.com/docs/latest/components/dialog)

### Problem Statement

Create an employee directory by storing each employee’s name using a HashMap, where the key is their ID and value is their name. Create another HashMap that determines the employees who are under a specific employee. Here, the key will be an employee ID, and the value will be a List of reporting employee IDs.

In the UI, have methods to display all employees, add an employee, get an employee’s subordinates’ names, and add a subordinate to an employee.

### Solution

[mvc folder](mvc)
