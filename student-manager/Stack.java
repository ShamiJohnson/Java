/*
 Honor Pledge: I pledge that I have neither given, nor received any help on this assignment.
 Ehtsham Nisar
 */



// Generic Stack Class
public class Stack<E> 
{
	// Points to the top of the Stack.
	private int top; 
	
	// The size of our stack.
	private int size;

	// Array to emulate the Stack. 
	private E [] stack ;

	// Our Constructor
	public Stack(int stackSize)
	{ 
		if(stackSize > 0)
		{
			size = stackSize; 
		} else
		{
			System.out.println("Invalid Stack size!");
			System.out.println("Using default size of 10");
			
			size = 10;
		} 

		// Here we create a generic array instance.
		stack = (E[]) new Object[size]; 
		top = -1;
	}
	
	// Push Operation
	public void push(E dataElement)
	{ 
		// Check to see if the Stack is full - if not push the element.
		if(isFull())
		{ 
			// We should really throw an exception here...
			System.out.println("Your Stack is full!");
		} 
		else
		{ 
			// "Push" the data element onto the Stack.
			stack[++top] = dataElement; 
		}
	 }
	 
	// Pop Operation 
	public E pop()
	{ 
		// Check to see if the Stack is empty.
		if(!isEmpty()) 
		{	
			// Return the popped data element. 
			return stack[top--]; 
		}
		else 
		{
			// We should really throw an exception here...
			System.out.println("Stack is empty - cannot pop!"); 
			
			return null;
		}
	}

	// Check to see if the Stack is empty: T:Empty/F:Not Empty
	public boolean isEmpty()
	{ 
		return top == -1; 
	}

	// Check to see if the Stack is full: T:Full/F:Not Full
	public boolean isFull()
	{
		return (top+1) == size;
	}

	// Get the "top" element on the Stack.
	public E getTop() 
	{
		return stack[top];
	}
	
	// Prints out the contents of the Stack.
	public void displayStack() 
	{
		// Loop through our Stack array 
		// printing the values.
		for(int i = 0; i <= top; i++)
		{ 
			System.out.print(stack[i]+ " , "); 
		} 
	}
}

