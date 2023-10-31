# LAB 3.1 NOTES

## The “UserController” class gets an instance of “userRepository” through its constructor; how is this new repository instantiated?

The `userRepository` instance is instantiated by the `@Repository` annotation. This annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.


## List the methods invoked in the “userRepository” object by the “UserController”. Where are these methods defined?

The methods invoked in the `userRepository` object are `findAll()`, `findById()`, `save()` and `delete()`.

* `findAll()` - returns all instances of the type.
* `findById()` - returns entity with the given id.
* `save()` - saves a given entity.
* `delete()` - deletes the given entity.

These methods are defined in the `CrudRepository` interface, which is extended by the `UserRepository` interface.


## Where is the data being saved?

The data is being saved in the `UserRepository` interface, which extends the `CrudRepository` interface.

## Where is the rule for the “not empty” email address defined?

The rule for the "not empty" email address is defined in the `User` class.

```java
  @NotBlank(message = "Email is mandatory")
    private String email;
```