import java.util.*;

class Result {
   boolean success;
   int data;

   Result(boolean success) {
      this.success = success;
      data = 0;
   } // end of constructor
} // end of class Result

class Node {
   int data;
   Node next;

   Node() {
      data = 0;
      next = null;
   } // end of default constructor

   Node(int data) {
      this.data = data;
      next = null;
   } // end of parameterised constructor
} // end of class Node

class Queue {
   Node head;
   Node tail;

   Queue () {
      head = null;
      tail = null;
   } // end of constructor

   boolean isEmpty() {
      return (head == null);
   }

   Result enQueue(int data) {
      Node newNode = null;
      
      try { 
         newNode = new Node(data);
      }
      catch(Exception e) { 
         return new Result(false);
      }

      if (isEmpty()) {
         head = newNode;
         tail = newNode;
      }
      else {
         tail.next = newNode;
         tail = tail.next;
      }

      return new Result(true);
   } // end of enQueue(int)

   Result deQueue() {
      if (isEmpty())
         return new Result(false);

      Result result = new Result(true);
      result.data = head.data;

      head = head.next;

      return result;
   } // end of deQueue()

   Result front() {
      if (isEmpty())
         return new Result(false);

      Result result = new Result(true);
      result.data = head.data;

      return result;
   } // end of front()
} // end of class List

class Stack {
   Queue q1;
   Queue q2;

   Stack() {
      q1 = new Queue();
      q2 = new Queue();
   } // end of constructor

   Result push(int data) {
      if (!q2.enQueue(data).success)
         return new Result(false);

      while (!q1.isEmpty())
         q2.enQueue(q1.deQueue().data);

      Queue q = q1;
      q1 = q2;
      q2 = q;

      return new Result(true);
   } // end of push(int)

   Result pop() {
      return q1.deQueue();
   }

   Result peek() {
      return q1.front();
   }
} // end of class Stack

class StackFromQueue {

   boolean log(Result res) {
      System.out.print(
         res.success
         ? ""
         : "Error: Could not execute operation\n"
      );
      return res.success;
   } // end of log(Result)

   void requestHandler(Stack stack) {
      Scanner sc = new Scanner(System.in);

      System.out.println("1. push");
      System.out.println("2. pop");
      System.out.println("3. peek");
      System.out.println("0. quit");

      int req = 0;
      do {
         System.out.print("Enter choice: ");
         req = sc.nextInt();

         switch (req) {
            case 1: {
               System.out.print("Enter data: ");
               log(stack.push(sc.nextInt()));
            } break;
            case 2: {
               Result result = stack.pop();
               if (log(result))
                  System.out.println("Popped data: " + result.data);
            } break;
            case 3: {
               Result result = stack.peek();
               if (log(result))
                  System.out.println("Topmost element in stack: " + result.data);
            } break;
            case 0:
               System.out.println("Goodbye :)");
            break;
            default:
               System.out.println("INVALID REQUEST!");
         } // end of switch statement
      } while (req != 0);
   } // end of requestHandler()

   public static void main(String[] args) {
      Stack stack = new Stack();
      new StackFromQueue().requestHandler(stack);
   } // end of main(String[])
} // end of class StackFromQueue
