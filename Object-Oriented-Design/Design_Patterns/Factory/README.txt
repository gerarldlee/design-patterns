

FACTORY DESIGN PATTERN
——————————————————————


In today’s modern world, everyone is using software to facilitate their jobs. Recently, a product company has shifted the way they used to take orders from their clients. The company is now looking to use an application to take orders from them. They receive orders, errors in orders, feedback for the previous order, and responses to the order in an XML format. The company has asked you to develop an application to parse the XML and display the result to them.

The main challenge for you is to parse an XML and display its content to the user. There are different XML formats depending on the different types of messages the company receives from its clients. Like, for example, an order type XML has different sets of xml tags as compared to the response or error XML. But the core job is the same; that is, to display to the user the message being carried in these XMLs.

Although the core job is the same, the object that would be used varies according to the kind of XML the application gets from the user. So, an application object may only know that it needs to access a class from within the class hierarchy (hierarchy of different parsers), but does not know exactly which class from among the set of subclasses of the parent class is to be selected.

In this case, it is better to provide a factory, i.e. a factory to create parsers, and at runtime a parser gets instantiated to do the job, according to the kind of XML the application receives from the user.

The Factory Method Pattern, suited for this situation, defines an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.

Let us see some more details about the Factory Method Pattern and then we will use it to implement the XML parser for the application.


The Factory Method Pattern gives us a way to encapsulate the instantiations of concrete types. The Factory Method pattern encapsulates the functionality required to select and instantiate an appropriate class, inside a designated method referred to as a factory method. The Factory Method selects an appropriate class from a class hierarchy based on the application context and other influencing factors. It then instantiates the selected class and returns it as an instance of the parent class type.

The advantage of this approach is that the application objects can make use of the factory method to get access to the appropriate class instance. This eliminates the need for an application object to deal with the varying class selection criteria.



Product
Defines the interface of objects the factory method creates.

ConcreteProduct
Implements the Product interface.

Creator
Declares the factory method, which returns an object of type Product. Creator may also define a default implementation of the factory method that returns a default ConcreteProduct object.
May call the factory method to create a Product object.

ConcreteCreator
Overrides the factory method to return an instance of a ConcreteProduct.



Usages of the Factory Method Pattern
————————————————————————————————————

A class can’t anticipate the class of objects it must create.
A class wants its subclasses to specify the objects it creates.
Classes delegate responsibility to one of several helper subclasses, and you want to localize the knowledge of which helper subclass is the delegate.
5. Factory Method Pattern in JDK


Usage(s) of the Factory Method Pattern in JDK
—————————————————————————————————————————————

java.util.Calendar#getInstance()
java.util.ResourceBundle#getBundle()
java.text.NumberFormat#getInstance()
java.nio.charset.Charset#forName()
java.net.URLStreamHandlerFactory#createURLStreamHandler(String) (Returns singleton object per protocol)









The Factory Method Pattern gives us a way to encapsulate the instantiations of concrete types. The Factory Method pattern encapsulates the functionality required to select and instantiate an appropriate class, inside a designated method referred to as a factory method. The Factory Method selects an appropriate class from a class hierarchy based on the application context and other influencing factors. It then instantiates the selected class and returns it as an instance of the parent class type.





---
layout: pattern
title: Factory Method
folder: factory-method
permalink: /patterns/factory-method/
pumlid: NSZB3G8n30N0Lg20n7UwCOxPP9MVx6TMT0zdRgEvjoazYeRrMmMsFuYChtmqr7Y6gycQq8aiQr3hSJ7OwEGtfwBUZfas0shJQR3_G2yMBFkaeQYha4B-AeUDl6FqBm00
categories: Creational
tags:
 - Java
 - Difficulty-Beginner
 - Gang Of Four
---

## Also known as
Virtual Constructor

## Intent
Define an interface for creating an object, but let subclasses
decide which class to instantiate. Factory Method lets a class defer
instantiation to subclasses.

## Explanation
Real world example

> Blacksmith manufactures weapons. Elves require Elvish weapons and orcs require Orcish weapons. Depending on the customer at hand the right type of blacksmith is summoned.

In plain words

> It provides a way to delegate the instantiation logic to child classes.

Wikipedia says

> In class-based programming, the factory method pattern is a creational pattern that uses factory methods to deal with the problem of creating objects without having to specify the exact class of the object that will be created. This is done by creating objects by calling a factory method—either specified in an interface and implemented by child classes, or implemented in a base class and optionally overridden by derived classes—rather than by calling a constructor.

 **Programmatic Example**

Taking our blacksmith example above. First of all we have a blacksmith interface and some implementations for it

```
public interface Blacksmith {
  Weapon manufactureWeapon(WeaponType weaponType);
}

public class ElfBlacksmith implements Blacksmith {
  public Weapon manufactureWeapon(WeaponType weaponType) {
    return new ElfWeapon(weaponType);
  }
}

public class OrcBlacksmith implements Blacksmith {
  public Weapon manufactureWeapon(WeaponType weaponType) {
    return new OrcWeapon(weaponType);
  }
}
```

Now as the customers come the correct type of blacksmith is summoned and requested weapons are manufactured

```
Blacksmith blacksmith = new ElfBlacksmith();
blacksmith.manufactureWeapon(WeaponType.SPEAR);
blacksmith.manufactureWeapon(WeaponType.AXE);
// Elvish weapons are created
```

## Applicability
Use the Factory Method pattern when

* a class can't anticipate the class of objects it must create
* a class wants its subclasses to specify the objects it creates
* classes delegate responsibility to one of several helper subclasses, and you want to localize the knowledge of which helper subclass is the delegate

## Known uses

* [java.util.Calendar](http://docs.oracle.com/javase/8/docs/api/java/util/Calendar.html#getInstance--)
* [java.util.ResourceBundle](http://docs.oracle.com/javase/8/docs/api/java/util/ResourceBundle.html#getBundle-java.lang.String-)
* [java.text.NumberFormat](http://docs.oracle.com/javase/8/docs/api/java/text/NumberFormat.html#getInstance--)
* [java.nio.charset.Charset](http://docs.oracle.com/javase/8/docs/api/java/nio/charset/Charset.html#forName-java.lang.String-)
* [java.net.URLStreamHandlerFactory](http://docs.oracle.com/javase/8/docs/api/java/net/URLStreamHandlerFactory.html#createURLStreamHandler-java.lang.String-)
* [java.util.EnumSet](https://docs.oracle.com/javase/8/docs/api/java/util/EnumSet.html#of-E-)
* [javax.xml.bind.JAXBContext](https://docs.oracle.com/javase/8/docs/api/javax/xml/bind/JAXBContext.html#createMarshaller--)

## Credits

* [Design Patterns: Elements of Reusable Object-Oriented Software](http://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612)






Participants

    The classes and objects participating in this pattern are:

Product  (Page)
defines the interface of objects the factory method creates
ConcreteProduct  (SkillsPage, EducationPage, ExperiencePage)
implements the Product interface
Creator  (Document)
declares the factory method, which returns an object of type Product. Creator may also define a default implementation of the factory method that returns a default ConcreteProduct object.
may call the factory method to create a Product object.
ConcreteCreator  (Report, Resume)
overrides the factory method to return an instance of a ConcreteProduct.

