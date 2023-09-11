# Abdellah ORM MVC Library

This library provides a simple and efficient way to work with object-relational mapping (ORM) and model-view-controller (MVC) architecture in your Java applications. With this library, you can easily perform CRUD (Create, Read, Update, Delete) operations on your models and map them to database tables.

## 1. Configuration

### App Configuration

1.  Navigate to `dao/utils/config/AppConfig.java`.
2.  Update the following settings:
    -   `APP_NAME`: Set your application's name.
    -   `APP_VERSION`: Specify the application version.
    -   `APP_DEVELOPER`: Enter the developer's name.
    -   `APP_MODE`: Choose between "production" and "development" modes.

### Database Configuration

1.  Go to `dao/utils/config/DatabaseConfig.java`.
2.  Modify the database settings as follows:
    -   `DATABASE_NAME`: Set your database name.
    -   `USERNAME`: Enter your database username.
    -   `PASSWORD`: Provide your database password.
    -   `PORT`: Specify the database port.
    -   `HOST`: Enter the database host.
    -   `DATABASE_TYPE`: Choose between "mysql" and "postgresql" for your database type.

## 2. Create Your Model

1.  Navigate to the `app/model` directory.
2.  Create your model class.
3.  Extend it from `BaseRepository` and implement the `createInstance` method. This method is used to create a new instance of your model class for data mapping.

Example:

javaCopy code

```
public class User extends ModelMapper<User> {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String role;

    @Override
    public User createInstance() {
        return new User();
    }
}
```
## 3. Create Your Repository

1.  In the `app/repository` directory, create your repository class.
2.  Extend it from `BaseRepository`.
3.  In the constructor, call the `super` constructor and pass your model class.

Example:

javaCopy code

```
public class UserRepository extends BaseRepository<User> {
    public UserRepository() {
        super(User.class);
    }
}
```



Use `super(User.class)` to invoke the constructor of `BaseRepository` and pass the model class as an argument.


### 5. Create Your Service (Continued)

In the previous section, we created a basic `UserService` class that interacts with the `UserRepository`. Now, let's enhance it with additional methods and business logic.

javaCopy code

```
public class UserService {
    UserRepository userRepository = new UserRepository();

    public User saveUser(User user) {
        // Add validation or additional business logic here if needed
        return user.mapData(userRepository.save(user));
    }

    public User updateUser(User user, int id) {
        // Add validation or additional business logic here if needed
        return user.mapData(userRepository.update(user, id));
    }

    public void deleteUser(int id) {
        // Add validation or additional business logic here if needed
        userRepository.delete(id);
    }

    public User getUser(int id) {
        // Add validation or additional business logic here if needed
        return user.mapData(userRepository.findById(id));
    }

    public List<User> getAllUsers() {
        // Add filtering, sorting, or additional business logic here if needed
        return user.mapDataList(userRepository.findAll());
    }
    
    // Add more methods as needed for your application's specific requirements
}
```

In this section, we've expanded the service class with comments indicating where you can include validation, business logic, or other custom code specific to your application.

### 6. Test Your Code

You can now use your enhanced service class in your application's main class to perform various operations on your model objects. Here's a sample of how to use the updated `UserService`:

javaCopy code

```
public class App {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserService();

        // Create a new user
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john@example.com");
        user.setPassword("password");
        user.setPhone("+1234567890");
        user.setAddress("123 Main St");
        user.setRole("user");

        // Save the user to the database
        userService.saveUser(user);

        // Update the user's information
        User updatedUser = userService.getUser(1); // Replace 1 with the actual user ID
        updatedUser.setName("Updated Name");
        userService.updateUser(updatedUser, 1);

        // Delete a user
        userService.deleteUser(2); // Replace 2 with the actual user ID to delete

        // Retrieve all users
        List<User> users = userService.getAllUsers();
        users.forEach(System.out::println); // Print all users
    }
}

```
