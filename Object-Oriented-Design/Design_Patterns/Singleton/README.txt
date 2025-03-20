

Singleton Design Pattern 
————————————————————————


Intent 
——————

Ensure a class has only one instance, and provide a global point of access to it. Encapsulated "just-in-time initialization" or "initialization on first use". Problem Application needs one, and only one, instance of an object. Additionally, lazy initialization and global access are necessary.

There are several issues to break the singleton pattern:

i.   If the class is thread-safe 

ii.  If the class is Serializable.

iii. If it’s Clonable.

iv.  It can be break by Reflection.

v.   If the class is loaded by multiple class loaders.



Make the class of the single instance object responsible for creation, initialization, access, and enforcement. Declare the instance as a private static data member. Provide a public static member function that encapsulates all initialization code, and provides access to the instance.

The client calls the accessor function (using the class name and scope resolution operator) whenever a reference to the single instance is required.





Singleton should be considered only if all three of the following criteria are satisfied:

Ownership of the single instance cannot be reasonably assigned
Lazy initialization is desirable

Global access is not otherwise provided for
If ownership of the single instance, when and how initialization occurs, and global access are not issues, Singleton is not sufficiently interesting.

The Singleton pattern can be extended to support access to an application-specific number of instances.

The "static member function accessor" approach will not support subclassing of the Singleton class. If subclassing is desired, refer to the discussion in the book.





 As of JDK 1.5, you can create a singleton class using enums. The Enum constants 
 are implicitly static and final and you cannot change their values once created.

You will get a compile time error when you attempt to explicitly instantiate an 
Enum object. As Enum gets loaded statically, it is thread-safe. The clone method 
in Enum is final which ensures that enum constants never get cloned. Enum is 
inherently serializable, the serialization mechanism ensures that duplicate instances 
are never created as a result of deserialization. Instantiation using reflection 
is also prohibited. These things ensure that no instance of an enum exists beyond 
the one defined by the enum constants.

by default enums have implicit private constructor and that explicitly adding a 
private constructor is not needed unless you actually have code that you need to 
run in that constructor 

An enum type is a special type of class type.

Your enum declaration actually compiles to something like

	public final class MySingleton {
	    public final static MySingleton INSTANCE = new MySingleton();
	    private MySingleton(){} 
	}

When your code first accesses INSTANCE, the class MySingleton will be loaded and 
initialized by the JVM. This process initializes the static field above once (lazily).





Deletation 
——————————

If you really need to reset a singleton instance (which doesn't makes much sense actually) you could wrap all its inner members in a private object, and reinitialize via an explicit initialize() and reset() methods. That way, you can preserve your singleton istance and provide some kind of "reset" functionality.

Deleting a Singleton class/instance is a non-trivial design problem. See "To Kill A Singleton" by John Vlissides for a discussion.



Applicability
—————————————

Use the Singleton pattern when

i.  There must be exactly one instance of a class, and it must be accessible to clients from a well-known access point

ii. When the sole instance should be extensible by subclassing, and clients should be able to use an extended instance without modifying their code


Typical Use Case
————————————————

i.    The logging class
ii.   File manager
iii.  Managing a connection to a database



Real world examples
———————————————————

i.   java.lang.Runtime#getRuntime()
ii.  java.awt.Desktop#getDesktop()
iii. java.lang.System#getSecurityManager


Consequences
————————————

Violates Single Responsibility Principle (SRP) by controlling their own creation and lifecycle.

Encourages using a global shared instance which prevents an object and resources used by this object from being deallocated.     

Creates tightly coupled code. The clients of the Singleton become difficult to test.

Makes it almost impossible to subclass a Singleton.



Participants
————————————

The classes and objects participating in this pattern are:

Singleton/ LoadBalancer:
————————————————————————

Defines an Instance operation that lets clients access its unique instance. Instance is a class operation. responsible for creating and maintaining its own unique instance.


