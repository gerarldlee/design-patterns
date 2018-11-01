Singleton pattern is one of the creational patterns described in the GoF book.

Purpose

- Ensures only one instance of the class is created
- Instantiation is controlled by the class

Implementation

- Private constructors hides the class. Therefore it cannot be created by any other means.
- Public static method ensures that the class is created in its own terms and only one.
- Can be programmed to lazily initialize
- Can be programmed to be thread safe

Usage
- It can be used with other creational design patterns
- Facade are often singleton
- States are often singleton