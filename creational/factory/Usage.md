Factory is a creational GoF design pattern that lets subclasses define which class to instantiate to give to the declaring object.

Why would we want that?
* Creating an object within the class is inflexible and rigid, you cannot change it afterwards instantiation
* To remove duplication of code and provide better encapsulation or separation of concern.

Guidelines to implement it?
* Concrete classes extends or implements an abstract class or interface.
* The composing class does not know of any concrete class. It knows the abstract or the interface only.
* The factory method in the composing class or another concrete class which may extend the composing class have a way to return the concrete classes based on the context that was given by the composing class.

