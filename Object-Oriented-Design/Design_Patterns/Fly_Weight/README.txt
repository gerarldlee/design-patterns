


Object Oriented programming has made programming easy and interesting. It makes a programmer’s job easier by modeling real world entities into the programming world. A programmer creates a class and instantiates it by creating an object of it. This object models a real world entity and objects inside an application coordinate with each other in order to accomplish the required work.

But sometimes too many objects can slow things down. Too many objects might consume a large piece of memory and can slow down the application or even cause out of memory problems. As a good programmer, one should keep track of instantiated objects and control the object creation in an application. This is especially true, when we have a lot of similar objects and two objects from the pool don’t have much differences between them.

Sometimes the objects in an application might have great similarities and be of a similar kind (a similar kind here means that most of their properties have similar values and only a few of them vary in value). In case they are also heavy objects to create, they should be controlled by the application developer. Otherwise, they might consume much of the memory and eventually slow down the whole application.

The Flyweight Pattern is designed to control such kind of object creation and provides you with a basic caching mechanism. It allows you to create one object per type (the type here differs by a property of that object), and if you ask for an object with the same property (already created), it will return you the same object instead of creating a new one.


Before digging into the details of the Flyweight pattern, let’s consider the following scenario: a site which allows users to create and execute programs online. We will discuss the scenario now and we will later try to solve the problem using the Flyweight pattern.

The X-programming site allows users to create and execute programs using their favorite programming language. It provides you with plenty of programming language options. You choose one, write a program with it and execute it to see the result.

But now the site has started losing its users, the reason being the slowness of the site. The users are not interested in it any more. The site is very popular and sometimes there could be more than thousands of programmers using it. Because of that, the site is crawling. But the heavy usage is not the real problem behind the slowness of the site. Let us see the core programming of the site which allows users to run and execute their program, and the true issue will be revealed there.


The intent of the Flyweight Pattern is to use shared objects to support large numbers of fine-grained objects efficiently. A flyweight is a shared object that can be used in multiple contexts simultaneously. The flyweight acts as an independent object in each context – it’s indistinguishable from an instance of the object that’s not shared. Flyweights cannot make assumptions about the context in which they operate. The key concept here is the distinction between intrinsic and extrinsic state. Intrinsic state is stored in the flyweight; it consists of information that’s independent of the flyweight’s context, thereby making it sharable. The extrinsic state depends on and varies with the flyweight’s context and therefore can’t be shared. Client objects are responsible for passing extrinsic state to the flyweight when it needs it.

Consider an application scenario that involves creating a large number of objects that are unique only in terms of a few parameters. In other words, these objects contain some intrinsic, invariant data that are common among all objects. This intrinsic data needs to be created and maintained as part of every object that is being created. The overall creation and maintenance of a large group of such objects can be very expensive in terms of memory-usage and performance. The Flyweight pattern can be used in such scenarios to design a more efficient way of creating objects.








## Intent
——————————————————————
Use sharing to support large numbers of fine-grained objects
efficiently.

## Explanation
Real world example

> Alchemist's shop has shelves full of magic potions. Many of the potions are the same so there is no need to create new object for each of them. Instead one object instance can represent multiple shelf items so memory footprint remains small.

In plain words

> It is used to minimize memory usage or computational expenses by sharing as much as possible with similar objects.

Wikipedia says

> In computer programming, flyweight is a software design pattern. A flyweight is an object that minimizes memory use by sharing as much data as possible with other similar objects; it is a way to use objects in large numbers when a simple repeated representation would use an unacceptable amount of memory.

**Programmatic example**

Translating our alchemist shop example from above. First of all we have different potion types

```
public interface Potion {
  void drink();
}

public class HealingPotion implements Potion {
  private static final Logger LOGGER = LoggerFactory.getLogger(HealingPotion.class);
  @Override
  public void drink() {
    LOGGER.info("You feel healed. (Potion={})", System.identityHashCode(this));
  }
}

public class HolyWaterPotion implements Potion {
  private static final Logger LOGGER = LoggerFactory.getLogger(HolyWaterPotion.class);
  @Override
  public void drink() {
    LOGGER.info("You feel blessed. (Potion={})", System.identityHashCode(this));
  }
}

public class InvisibilityPotion implements Potion {
  private static final Logger LOGGER = LoggerFactory.getLogger(InvisibilityPotion.class);
  @Override
  public void drink() {
    LOGGER.info("You become invisible. (Potion={})", System.identityHashCode(this));
  }
}
```

Then the actual Flyweight object which is the factory for creating potions

```
public class PotionFactory {

  private final Map<PotionType, Potion> potions;

  public PotionFactory() {
    potions = new EnumMap<>(PotionType.class);
  }

  Potion createPotion(PotionType type) {
    Potion potion = potions.get(type);
    if (potion == null) {
      switch (type) {
        case HEALING:
          potion = new HealingPotion();
          potions.put(type, potion);
          break;
        case HOLY_WATER:
          potion = new HolyWaterPotion();
          potions.put(type, potion);
          break;
        case INVISIBILITY:
          potion = new InvisibilityPotion();
          potions.put(type, potion);
          break;
        default:
          break;
      }
    }
    return potion;
  }
}
```

And it can be used as below

```
PotionFactory factory = new PotionFactory();
factory.createPotion(PotionType.INVISIBILITY).drink(); // You become invisible. (Potion=6566818)
factory.createPotion(PotionType.HEALING).drink(); // You feel healed. (Potion=648129364)
factory.createPotion(PotionType.INVISIBILITY).drink(); // You become invisible. (Potion=6566818)
factory.createPotion(PotionType.HOLY_WATER).drink(); // You feel blessed. (Potion=1104106489)
factory.createPotion(PotionType.HOLY_WATER).drink(); // You feel blessed. (Potion=1104106489)
factory.createPotion(PotionType.HEALING).drink(); // You feel healed. (Potion=648129364)
```

## Applicability
The Flyweight pattern's effectiveness depends heavily on how
and where it's used. Apply the Flyweight pattern when all of the following are
true

* an application uses a large number of objects
* storage costs are high because of the sheer quantity of objects
* most object state can be made extrinsic
* many groups of objects may be replaced by relatively few shared objects once extrinsic state is removed
* the application doesn't depend on object identity. Since flyweight objects may be shared, identity tests will return true for conceptually distinct objects.

## Real world examples

* [java.lang.Integer#valueOf(int)](http://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html#valueOf%28int%29) and similarly for Byte, Character and other wrapped types.

## Credits

* [Design Patterns: Elements of Reusable Object-Oriented Software](http://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612)







Participants

    The classes and objects participating in this pattern are:

Flyweight   (Character)
declares an interface through which flyweights can receive and act on extrinsic state.
ConcreteFlyweight   (CharacterA, CharacterB, ..., CharacterZ)
implements the Flyweight interface and adds storage for intrinsic state, if any. A ConcreteFlyweight object must be sharable. Any state it stores must be intrinsic, that is, it must be independent of the ConcreteFlyweight object's context.
UnsharedConcreteFlyweight   ( not used )
not all Flyweight subclasses need to be shared. The Flyweight interface enables sharing, but it doesn't enforce it. It is common for UnsharedConcreteFlyweight objects to have ConcreteFlyweight objects as children at some level in the flyweight object structure (as the Row and Column classes have).
FlyweightFactory   (CharacterFactory)
creates and manages flyweight objects
ensures that flyweight are shared properly. When a client requests a flyweight, the FlyweightFactory objects assets an existing instance or creates one, if none exists.
Client   (FlyweightApp)
maintains a reference to flyweight(s).
computes or stores the extrinsic state of flyweight(s).