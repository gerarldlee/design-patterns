

Composite Design Pattern   
————————————————————————

Intent 
——————

Compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly. 

There are times when you feel a need of a tree data structure in your code. There are many variations to the tree data structure, but sometimes there is a need of a tree in which both branches as well as leafs of the tree should be treated as uniformly.

The Composite Pattern allows you to compose objects into a tree structure to represent the part-whole hierarchy which means you can create a tree of objects that is made of different parts, but that can be treated as a whole one big thing. Composite lets clients to treat individual objects and compositions of objects uniformly, that’s the intent of the Composite Pattern.

In software engineering, the composite pattern is a partitioning design pattern. The composite pattern describes that a group of objects is to be treated in the same way as a single instance of an object. The intent of a composite is to "compose" objects into tree structures to represent part-whole hierarchies. Implementing the composite pattern lets clients treat individual objects and compositions uniformly.

The English meaning of the word Composite is something that is made up of complicated and related parts. The composite means “putting together” and this is what this design pattern is all about.

There are times when you feel a need of a tree data structure in your code. There are many variations to the tree data structure, but sometimes there is a need of a tree in which both branches as well as leafs of the tree should be treated as uniformly.

The Composite Pattern allows you to compose objects into a tree structure to represent the part-whole hierarchy which means you can create a tree of objects that is made of different parts, but that can be treated as a whole one big thing. Composite lets clients to treat individual objects and compositions of objects uniformly, that’s the intent of the Composite Pattern.

There can be lots of practical examples of the Composite Pattern. A file directory system, an html representation in java, an XML parser all are well managed composites and all can easily be represented using the Composite Pattern. But before digging into the details of an example, let’s see some more details regarding the Composite Pattern.

The formal definition of the Composite Pattern says that it allows you to compose objects into tree structures to represent part-whole hierarchies. Composite lets clients to treat individual objects and compositions of objects uniformly.

If you are familiar with a tree data structure, you will know a tree has parents and their children. There can be multiple children to a parent, but only one parent per child. In Composite Pattern, elements with children are called as Nodes, and elements without children are called as Leafs.

The Composite Pattern allows us to build structures of objects in the form of trees that contains both composition of objects and individual objects as nodes. Using a composite structure, we can apply the same operations over both composites and individual objects. In other words, in most cases we can ignore the differences between compositions of objects and individual objects.


Structure 
—————————

Component

Leaf

Composite

Client


	Component/ DrawingElement
	—————————————————————————
	declares the interface for objects in the composition. implements default behavior for the interface common to all classes, as appropriate. declares an interface for accessing and managing its child components. Optionally, it defines an interface for accessing a component's parent in the recursive structure, and implements it if that's appropriate.

	Leaf/ PrimitiveElement
	——————————————————————
	represents leaf objects in the composition. A leaf has no children and defines behavior for primitive objects in the composition.

	Composite/ CompositeElement
	———————————————————————————
	Defines behavior for components having children. stores child components and implements child-related operations in the Component interface.

	Client/ CompositeApp
	————————————————————
	It manipulates objects in the composition through the Component interface.



Examples
—————————

The Composite pattern can be implemented anywhere you have the hierarchical nature of the system or a subsystem and you want to treat individual objects and compositions of objects uniformly. A File System, an XML, an Html, or a hierarchy of an office (starting from the president to employees) can be implemented using the Composite Pattern.

Let’s see a simple example where we implement an html representation in Java using the Composite Pattern. An html is hierarchical in nature, its starts from an <html> tag which is the parent or the root tag, and it contains other tags which can be a parent or a child tag.

The Composite Pattern in Java can be implemented using the Component class as an abstract class or an interface. In this example, we will use an abstract class which contains all the important methods used in a composite class and a leaf class.


Applicability
—————————————

Use the Composite pattern when

i.   You want to represent part-whole hierarchies of objects

ii.  You want clients to be able to ignore the difference between compositions of objects and individual objects. Clients will treat all objects in the composite structure uniformly

iii. When you want to represent part-whole hierarchies of objects.

iv.  When you want clients to be able to ignore the difference between compositions of objects and individual objects. Clients will treat all objects in the composite structure uniformly.



Example 
———————

Every sentence is composed of words which are in turn composed of characters. Each of these objects is printable and they can have something printed before or after them like sentence always ends with full stop and word always has space before it


Real world examples
———————————————————

i.   java.awt.Container
ii.  java.awt.Component
iii. Apache Wicket] Component(https://github.com/apache/wicket) component tree
iv.  Apache Wicket] MarkupContainer(https://github.com/apache/wicket) MarkupContainer 



