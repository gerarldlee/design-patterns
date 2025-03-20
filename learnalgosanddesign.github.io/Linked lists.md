# Linked lists

Is an array, or list, or collection of elements, represented contiguously, and does not impose a size limitation.  It can grow indefinitely.

- Represented contiguously means that it does not have to be contiguous in memory like an array; but from the developers perspective, it is represented contiguous.  A node that has a value, is linked to another node that has value, forming a list of nodes.
- Does not have a size limitation means that we can create new nodes that holds new values and link it to the already existing list.

Note that even though we can create the linked list data structure with a node, we can also create the linked list with an array implementation, which is more efficient with regards to space requirements, too.

Java’s `ArrayList` is a linked list too, and a linked list is not to be confused with the Java’s `LinkedList`.  In fact, a stack and a queue is a form of linked list, too.  We will derive it as we go along.

```java
// a node that has a value, and a next that pointers to the next node
class Node<T> {
	T value;
	Node next;
	public Node(T value) {
		this.value = value;
	}

	// for a doubly linked list, we might use the prev pointer to point to the previous node
	Node prev;
}
```

Linked list Node representations:

- Singly Linked Node - is represented by a Node with a value, and a single pointer that points to the next Node
- Doubly Linked Node - is represented by a Node with a value, just like the singly linked list, but adds another pointer that points to the previous Node.  Like the Two-Pointers approach in the Arrays, we can also use a second pointer in a Singly Linked list to form a Doubly Linked list.  It will make it more convenient for us to track back the previous Node, when we are iterating from the middle, or from the tail.