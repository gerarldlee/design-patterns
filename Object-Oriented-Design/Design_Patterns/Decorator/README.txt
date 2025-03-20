


Decorator Design Pattern
————————————————————————


The Decorator Pattern is used to extend the functionality of an object dynamically without having to change the original class source or using inheritance. 

To understand the Decorator Design Pattern, let’s help a pizza company make an extra topping calculator. A user can ask to add extra topping to a pizza and our job is to add toppings and increase its price using the system.

This is something like adding an extra responsibility to our pizza object at runtime and the Decorator Design Pattern is suitable for this type of requirement. But before that, let us know more about this beautiful pattern.


The intent of the Decorator Design Pattern is to attach additional responsibilities to an object dynamically. Decorators provide a flexible alternative to sub-classing for extending functionality.

The Decorator Pattern is used to extend the functionality of an object dynamically without having to change the original class source or using inheritance. This is accomplished by creating an object wrapper referred to as a Decorator around the actual object.

The Decorator object is designed to have the same interface as the underlying object. This allows a client object to interact with the Decorator object in exactly the same manner as it would with the underlying actual object. The Decorator object contains a reference to the actual object. The Decorator object receives all requests (calls) from a client. In turn, it forwards these calls to the underlying object. The Decorator object adds some additional functionality before or after forwarding requests to the underlying object. This ensures that the additional functionality can be added to a given object externally at runtime without modifying its structure.

Decorator prevents the proliferation of subclasses leading to less complexity and confusion. It is easy to add any combination of capabilities. The same capability can even be added twice. It becomes possible to have different decorator objects for a given object simultaneously. A client can choose what capabilities it wants by sending messages to an appropriate decorator.


Component
—————————

Defines the interface for objects that can have responsibilities added to them dynamically.


ConcreteComponent
—————————————————
Defines an object to which additional responsibilities can be attached.


Decorator
—————————
Maintains a reference to a Component object and defines an interface that conforms to Component’s interface.

ConcreteDecorator
—————————————————
Adds responsibilities to the component.




Usages of the Decorator pattern
———————————————————————————————

To add responsibilities to individual objects dynamically and transparently, that is, without affecting other objects.
For responsibilities that can be withdrawn.
When extension by sub-classing is impractical. Sometimes a large number of independent extensions are possible and would produce an explosion of subclasses to support every combination. Or a class definition may be hidden or otherwise unavailable for sub-classing.


Decorator Design Pattern in JDK
———————————————————————————————

i.   java.io.BufferedInputStream(InputStream)

ii.  java.io.DataInputStream(InputStream)

iii. java.io.BufferedOutputStream(OutputStream)

iv.  java.util.zip.ZipOutputStream(OutputStream)

v.   java.util.Collections#checked[List|Map|Set|SortedSet|SortedMap]()








## Also known as Wrapper

## Intent
Attach additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.

## Explanation

Real world example

> There is an angry troll living in the nearby hills. Usually it goes bare handed but sometimes it has a weapon. To arm the troll it's not necessary to create a new troll but to decorate it dynamically with a suitable weapon.

In plain words

> Decorator pattern lets you dynamically change the behavior of an object at run time by wrapping them in an object of a decorator class.

Wikipedia says

> In object-oriented programming, the decorator pattern is a design pattern that allows behavior to be added to an individual object, either statically or dynamically, without affecting the behavior of other objects from the same class. The decorator pattern is often useful for adhering to the Single Responsibility Principle, as it allows functionality to be divided between classes with unique areas of concern.

**Programmatic Example**

Let's take the troll example. First of all we have a simple troll implementing the troll interface

```
public interface Troll {
  void attack();
  int getAttackPower();
  void fleeBattle();
}

public class SimpleTroll implements Troll {

  private static final Logger LOGGER = LoggerFactory.getLogger(SimpleTroll.class);

  @Override
  public void attack() {
    LOGGER.info("The troll tries to grab you!");
  }

  @Override
  public int getAttackPower() {
    return 10;
  }

  @Override
  public void fleeBattle() {
    LOGGER.info("The troll shrieks in horror and runs away!");
  }
}
```

Next we want to add club for the troll. We can do it dynamically by using a decorator

```
public class ClubbedTroll implements Troll {

  private static final Logger LOGGER = LoggerFactory.getLogger(ClubbedTroll.class);

  private Troll decorated;

  public ClubbedTroll(Troll decorated) {
    this.decorated = decorated;
  }

  @Override
  public void attack() {
    decorated.attack();
    LOGGER.info("The troll swings at you with a club!");
  }

  @Override
  public int getAttackPower() {
    return decorated.getAttackPower() + 10;
  }

  @Override
  public void fleeBattle() {
    decorated.fleeBattle();
  }
}
```

Here's the troll in action

```
// simple troll
Troll troll = new SimpleTroll();
troll.attack(); // The troll tries to grab you!
troll.fleeBattle(); // The troll shrieks in horror and runs away!

// change the behavior of the simple troll by adding a decorator
troll = new ClubbedTroll(troll);
troll.attack(); // The troll tries to grab you! The troll swings at you with a club!
troll.fleeBattle(); // The troll shrieks in horror and runs away!
```

## Applicability
Use Decorator

* To add responsibilities to individual objects dynamically and transparently, that is, without affecting other objects
* For responsibilities that can be withdrawn
* When extension by subclassing is impractical. Sometimes a large number of independent extensions are possible and would produce an explosion of subclasses to support every combination. Or a class definition may be hidden or otherwise unavailable for subclassing

## Real world examples
 * [java.io.InputStream](http://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html), [java.io.OutputStream](http://docs.oracle.com/javase/8/docs/api/java/io/OutputStream.html),
 [java.io.Reader](http://docs.oracle.com/javase/8/docs/api/java/io/Reader.html) and [java.io.Writer](http://docs.oracle.com/javase/8/docs/api/java/io/Writer.html)
 * [java.util.Collections#synchronizedXXX()](http://docs.oracle.com/javase/8/docs/api/java/util/Collections.html#synchronizedCollection-java.util.Collection-)
 * [java.util.Collections#unmodifiableXXX()](http://docs.oracle.com/javase/8/docs/api/java/util/Collections.html#unmodifiableCollection-java.util.Collection-)
 * [java.util.Collections#checkedXXX()](http://docs.oracle.com/javase/8/docs/api/java/util/Collections.html#checkedCollection-java.util.Collection-java.lang.Class-)


## Credits

* [Design Patterns: Elements of Reusable Object-Oriented Software](http://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612)
* [Functional Programming in Java: Harnessing the Power of Java 8 Lambda Expressions](http://www.amazon.com/Functional-Programming-Java-Harnessing-Expressions/dp/1937785467/ref=sr_1_1)
* [J2EE Design Patterns](http://www.amazon.com/J2EE-Design-Patterns-William-Crawford/dp/0596004273/ref=sr_1_2)




------------------------------------------------------------------------------------------
DECORATOR IS THE Underlaying design pattern behind the Aspect Oriented Programming (AOP)








Participants

    The classes and objects participating in this pattern are:

Component   (LibraryItem)
defines the interface for objects that can have responsibilities added to them dynamically.
ConcreteComponent   (Book, Video)
defines an object to which additional responsibilities can be attached.
Decorator   (Decorator)
maintains a reference to a Component object and defines an interface that conforms to Component's interface.
ConcreteDecorator   (Borrowable)
adds responsibilities to the component.