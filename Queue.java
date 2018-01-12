//Author Peter Adamson

import java.util.Scanner;

public class Queue
{

	private int[] myQueue = new int[4];
	private int rear, front;
	
	public static void main(String[] args) throws Exception
	{
		String s = "";
		int i;
		Scanner sc = new Scanner(System.in);
		Queue test = new Queue();
		test.queue_init();
		System.out.println("enter a positive integer to insert the value into the stack");
		System.out.println("Enter a negative integer to return the value from the front of the queue");
		System.out.println("Enter 0 to remove the value from the front of the queue");
		do	//loops as long as the user has not input "n" or "N".  Continues to take user input values while looping
		{
			System.out.println("Enter a value:");
			i = sc.nextInt();
			if(i > 0)
			{
				test.enqueue(i);	
			}	
			else if(i==0)
			{
				test.dequeue();
			}
			else
			{
				test.front();
			}
			System.out.println("would you like to enter another value? (y/n)");
			s = sc.next();
		} while(!s.equals("n") && !s.equals("N"));
	}

	public void queue_init()
	{
		rear = front = -1;
	}

	public boolean empty()
	{
		if(rear==-1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void enqueue(int val)
	{
		try
		{		
			if(rear==-1)	//Special case when adding first value into the queue
			{
				rear = front = 0;
			}
			else		//general case for a queue with more than one value
			{
				rear += 1;
				if(rear==myQueue.length-1)
				{
					rear = 0;
				}
				if(rear==front)
				{
					throw new FullQException("Queue is full");
				}
			}
			myQueue[rear] = val;
		}
		catch(FullQException e)
		{
			System.out.println(e);	
		}
	}

	public void dequeue()
	{
		try
		{
			if(rear==-1)
			{
				throw new QEmptyException("Error - Queue is empty");
			}
			else
			{
				if(rear==front)		//special case for removing the last value from the queue
				{
					rear = front = -1;	
				}
				else			//general case for removing a value from the queue
				{
					front += 1;
					if(front==myQueue.length-1)
					{
						front = 0;
					}
				}
			}		
		}
		catch(QEmptyException e)
		{
			System.out.println(e);
		}
	}

	public void front()
	{
		try
		{
			if(rear==-1)
			{
				throw new QEmptyException("Error - Queue is empty");
			}
			else
			{
				System.out.println(myQueue[front]);
			}
		}
		catch(QEmptyException e)
		{
			System.out.println(e);
		}
	}
}
