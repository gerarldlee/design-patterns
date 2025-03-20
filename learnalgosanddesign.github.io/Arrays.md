# Arrays

Are a linear, contiguous collection of items or elements of pre-allocated size in the memory.

- you want to store contiguous elements to easily access it
- you already know how many elements to store, before you declare it. (if not, you use a linked list instead)
- you want O(1) access given an index of the middle of the array.  Obviously, head and tail of the array are always O(1) since you know array[0] and array[size-1] already.

Note that arrays are the basic building blocks of all data structures. I will show you that we can derive all data structures from an array as we go along.

Declare an array of type `int`:

```java
// an array always has a size
int[] array = new int[10];
```

Access an element of an array with a specific index:

```java
// get the value of array[5]
int fifthElement = array[5];

// set the value of array[5]
array[5] = 30;
```

Iterate an array:

```java
for (int index=0; index < array.length; index++) {
	int tmp = array[index];
	// do useful stuff with tmp
}
```

## Techniques for iterating through an Array

### Single-pointer approach

How we just iterate an array through its index is also called single pointer.  We use the concept of the array’s index as a pointer to its element value.  This is very trivial.

- We can manipulate how we want to increment or decrement its index.
- We can use `while` or `for` loops if we want to access elements in the array *randomly*
- Or an `Iterator` or a simplified `for-each` loop, to iterate through the array or a linked list

Note that ideally, its better to use a `for-each` loop, to prevent bugs such as accidentally deleting an element in the array with `Iterators` or accidentally accessing `iterator.next()`, unless you intentionally want to.

Using the index to access elements in an array or linked list is the most efficient way as its because of O(1) access time.

### Two-pointer approach

We can also access array elements with 2 pointers approach, and is much more efficient than the single pointer.  It can cut the time of iterating over an array in half.

2 pointers mean there will be 2 separate indexes accessing different elements of the array at the same time.  As with the single pointer, the second pointer can also be positioned anywhere in the array that make sense.  e.g. at the last index, at the first index, at the middle, or anywhere.

## Searching for an element in an Array

### Linear search

- We iterate each element, until we found the element we are looking for.

```java
int valueToFind = 4;
for (int index=0; index < array.length; index++) {
	if (array[index] == valueToFind) {
		// we can either return the index of the element, or the value itself
		return index;
	}
}
```

### Binary Search