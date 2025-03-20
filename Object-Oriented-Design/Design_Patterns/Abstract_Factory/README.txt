
—————————————————————————————————————————————————————————————————————————————————————————————


The Difference Between The Two
The main difference between a "factory method" and an "abstract factory" is that the factory method is a single method, and an abstract factory is an object. I think a lot of people get these two terms confused, and start using them interchangeably. I remember that I had a hard time finding exactly what the difference was when I learnt them.

Because the factory method is just a method, it can be overridden in a subclass, hence the second half of your quote:

... the Factory Method pattern uses inheritance and relies on a subclass to handle the desired object instantiation.

The quote assumes that an object is calling its own factory method here. Therefore the only thing that could change the return value would be a subclass.

The abstract factory is an object that has multiple factory methods on it. Looking at the first half of your quote:

... with the Abstract Factory pattern, a class delegates the responsibility of object instantiation to another object via composition ...

What they're saying is that there is an object A, who wants to make a Foo object. Instead of making the Foo object itself (e.g., with a factory method), it's going to get a different object (the abstract factory) to create the Foo object.

Code Examples
To show you the difference, here is a factory method in use:


FACTORY METHOD 
——————————————

	class A {

	    public void doSomething() {
	        Foo f = makeFoo();
	        f.whatever();   
	    }

	    protected Foo makeFoo() {
	        return new RegularFoo();
	    }
	}

	class B extends A {
	    protected Foo makeFoo() {
	        //subclass is overriding the factory method 
	        //to return something different
	        return new SpecialFoo();
	    }
	}


And here is an abstract factory in use:


	class A {

	    private Factory factory;

	    public A(Factory factory) {
	        this.factory = factory;
	    }

	    public void doSomething() {
	        //The concrete class of "f" depends on the concrete class
	        //of the factory passed into the constructor. If you provide a
	        //different factory, you get a different Foo object.
	        Foo f = factory.makeFoo();
	        f.whatever();
	    }
	}

	interface Factory {

	    Foo makeFoo();
	    Bar makeBar();
	    Aycufcn makeAmbiguousYetCommonlyUsedFakeClassName();
	}


//need to make concrete factories that implement the "Factory" interface here
—————————————————————————————————————————————————————————————————————————————————————————————





ABSTRACT FACTORY DESIGN PATTERN 
———————————————————————————————

## Intent
—————————

"The Abstract Factory (A.K.A. Kit) is a design pattern which provides an interface for creating families of related or dependent objects without specifying their concrete classes."



In the previous lesson, we had developed an application for a product company to parse XMLs and display results to them. We did this by creating different parsers for the different types of communication between the company and its clients. We used the Factory Method Design Pattern to solve their problem.

The application is working fine for them. But now the clients don’t want to follow the company’s specifics XML rules. The clients want to use their own XML rules to communicate with the product company. This means that for every client, the company should have client specific XML parsers. For example, for the NY client there should be four specific types of XML parsers, i.e. NYErrorXMLParser, NYFeedbackXML, NYOrderXMLParser, NYResponseXMLParser, and four different parsers for the TW client.

The company has asked you to change the application according to the new requirement. To develop the parser application we have used the Factory Method Design Pattern in which the exact object to use is decided by the subclasses according to the type of parser. Now, to implement this new requirement, we will use a factory of factories i.e. an Abstract Factory.

This time we need parsers according to client specific XMLs, so we will create different factories for different clients which will provide us the client specific XML to parse. We will do this by creating an Abstract Factory and then implement the factory to provide client specific XML factory. Then we will use that factory to get the desired client specific XML parser object.

Abstract Factory is the design pattern of our choice and before implementing it to solve our problem, lets us know more about it.

The Abstract Factory (A.K.A. Kit) is a design pattern which provides an interface for creating families of related or dependent objects without specifying their concrete classes. The Abstract Factory pattern takes the concept of the Factory Method Pattern to the next level. An abstract factory is a class that provides an interface to produce a family of objects. In Java, it can be implemented using an interface or an abstract class.

The Abstract Factory pattern is useful when a client object wants to create an instance of one of a suite of related, dependent classes without having to know which specific concrete class is to be instantiated. Different concrete factories implement the abstract factory interface. Client objects make use of these concrete factories to create objects and, therefore, do not need to know which concrete class is actually instantiated.

The abstract factory is useful for plugging in a different group of objects to alter the behavior of the system. For each group or family, a concrete factory is implemented that manages the creation of the objects and the inter-dependencies and consistency requirements between them. Each concrete factory implements the interface of the abstract factory




AbstractFactory
Declares an interface for operations that create abstract product objects.

ConcreteFactory
Implements the operations to create concrete product objects.

AbstractProduct
Declares an interface for a type of product object.

ConcreteProduct
Defines a product object to be created by the corresponding concrete factory.
Implements the AbstractProduct interface.

Client
Uses only interfaces declared by AbstractFactory and AbstractProduct classes.



Use the Abstract Factory pattern
————————————————————————————————
A system should be independent of how its products are created, composed, and represented.
A system should be configured with one of multiple families of products.
A family of related product objects is designed to be used together, and you need to enforce this constraint.
You want to provide a class library of products, and you want to reveal just their interfaces, not their implementations.


Abstract Factory Pattern in JDK
———————————————————————————————

java.util.Calendar#getInstance()
java.util.Arrays#asList()
java.util.ResourceBundle#getBundle()
java.sql.DriverManager#getConnection()
java.sql.Connection#createStatement()
java.sql.Statement#executeQuery()
java.text.NumberFormat#getInstance()
javax.xml.transform.TransformerFactory#newInstance()









Provide an interface for creating families of related or dependent objects without specifying their concrete classes. A hierarchy that encapsulates: many possible 
"platforms", and the construction of a suite of "products". The new operator considered harmful.

## Problem
——————————

If an application is to be portable, it needs to encapsulate platform dependencies. These "platforms" might include: windowing system, operating system, database, etc. Too often, this encapsulation is not engineered in advance, and lots of #ifdef case statements with options for all currently supported platforms begin to procreate like rabbits throughout the code.


## Discussion
—————————————

Provide a level of indirection that abstracts the creation of families of related or dependent objects without directly specifying their concrete classes. The "factory" object has the responsibility for providing creation services for the entire platform family. Clients never create platform objects directly, they ask the factory to do that for them.

This mechanism makes exchanging product families easy because the specific class of the factory object appears only once in the application - where it is instantiated. The application can wholesale replace the entire family of products simply by instantiating a different concrete instance of the abstract factory.

Because the service provided by the factory object is so pervasive, it is routinely implemented as a Singleton.


## Structure
————————————

The Abstract Factory defines a Factory Method per product. Each Factory Method encapsulates the new operator and the concrete, platform-specific, product classes. Each "platform" is then modeled with a Factory derived class.

Abstract Factory is the design pattern of our choice and before implementing it to solve our problem, lets us know more about it.

The Abstract Factory (A.K.A. Kit) is a design pattern which provides an interface for creating families of related or dependent objects without specifying their concrete classes. The Abstract Factory pattern takes the concept of the Factory Method Pattern to the next level. An abstract factory is a class that provides an interface to produce a family of objects. In Java, it can be implemented using an interface or an abstract class.

The Abstract Factory pattern is useful when a client object wants to create an instance of one of a suite of related, dependent classes without having to know which specific concrete class is to be instantiated. Different concrete factories implement the abstract factory interface. Client objects make use of these concrete factories to create objects and, therefore, do not need to know which concrete class is actually instantiated.

The abstract factory is useful for plugging in a different group of objects to alter the behavior of the system. For each group or family, a concrete factory is implemented that manages the creation of the objects and the inter-dependencies and consistency requirements between them. Each concrete factory implements the interface of the abstract factory.



Participants

    The classes and objects participating in this pattern are:

AbstractFactory  (ContinentFactory)
declares an interface for operations that create abstract products
ConcreteFactory   (AfricaFactory, AmericaFactory)
implements the operations to create concrete product objects
AbstractProduct   (Herbivore, Carnivore)
declares an interface for a type of product object
Product  (Wildebeest, Lion, Bison, Wolf)
defines a product object to be created by the corresponding concrete factory
implements the AbstractProduct interface
Client  (AnimalWorld)
uses interfaces declared by AbstractFactory and AbstractProduct classes




——————————————————————————————————————————————————————————————————————————————————————
## AbstractFactory: Declares an interface for operations that create abstract product objects.

## ConcreteFactory: Implements the operations to create concrete product objects.

## AbstractProduct: Declares an interface for a type of product object.

## ConcreteProduct: Defines a product object to be created by the corresponding concrete factory. Implements the AbstractProduct interface.

## Client: Use only interfaces declared by AbstractFactory and AbstractProduct classes.
——————————————————————————————————————————————————————————————————————————————————————


## Example
——————————

The purpose of the Abstract Factory is to provide an interface for creating families of related objects, without specifying concrete classes. This pattern is found in the sheet metal stamping equipment used in the manufacture of Japanese automobiles. The stamping equipment is an Abstract Factory which creates auto body parts. The same machinery is used to stamp right hand doors, left hand doors, right front fenders, left front fenders, hoods, etc. for different models of cars. Through the use of rollers to change the stamping dies, the concrete classes produced by the machinery can be changed within three minutes.



The clients want to use their own XML rules to communicate with the product company. This means that for every client, the company should have client specific XML parsers. For example, for the NY client there should be four specific types of XML parsers, i.e. NYErrorXMLParser, NYFeedbackXML, NYOrderXMLParser, NYResponseXMLParser, and 4 different parsers for the TW client.

The company has asked you to change the application according to the new requirement. To develop the parser application we have used the Factory Method Design Pattern in which the exact object to use is decided by the subclasses according to the type of parser. Now, to implement this new requirement, we will use a factory of factories i.e. an Abstract Factory.

This time we need parsers according to client specific XMLs, so we will create different factories for different clients which will provide us the client specific XML to parse. We will do this by creating an Abstract Factory and then implement the factory to provide client specific XML factory. Then we will use that factory to get the desired client specific XML parser object.


## Check list
—————————————

Decide if "platform independence" and creation services are the current source of pain.

Map out a matrix of "platforms" versus "products".

Define a factory interface that consists of a factory method per product.

Define a factory derived class for each platform that encapsulates all references to the new operator.

The client should retire all references to new, and use the factory methods to create the product objects.



## Rules of thumb
—————————————————

Sometimes creational patterns are competitors: there are cases when either Prototype or Abstract Factory could be used profitably. At other times they are complementary: Abstract Factory might store a set of Prototypes from which to clone and return product objects, Builder can use one of the other patterns to implement which components get built. Abstract Factory, Builder, and Prototype can use Singleton in their implementation.

Abstract Factory, Builder, and Prototype define a factory object that's responsible for knowing and creating the class of product objects, and make it a parameter of the system. Abstract Factory has the factory object producing objects of several classes. Builder has the factory object building a complex product incrementally using a correspondingly complex protocol. Prototype has the factory object (aka prototype) building a product by copying a prototype object.

Abstract Factory classes are often implemented with Factory Methods, but they can also be implemented using Prototype.

Abstract Factory can be used as an alternative to Facade to hide platform-specific classes.
Builder focuses on constructing a complex object step by step. Abstract Factory emphasizes a family of product objects (either simple or complex). Builder returns the product as a final step, but as far as the Abstract Factory is concerned, the product gets returned immediately.

Often, designs start out using Factory Method (less complicated, more customizable, subclasses proliferate) and evolve toward Abstract Factory, Prototype, or Builder (more flexible, more complex) as the designer discovers where more flexibility is needed.













