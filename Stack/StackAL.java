import java.util.*;

public class StackAL {
    static class Stack {
        ArrayList<Integer> list = new ArrayList<>();

        public void push(int data) {
            list.add(data);
        }

        public boolean isEmpty() {
            return list.size() == 0;
        }

        public int pop() {
            return list.remove(list.size()-1);
        }

        public int peek() {
            return list.get(list.size()-1);
        }
    }

    public static void main(String args[]) {
        Stack stack = new Stack();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter\n1. Push\n2. Pop\n3.Peek\n0. Quit");

        int ch = 0;
        do {
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch(ch) {
                case 0: { // quit
                    System.out.println("Bye");
                } break;
                case 1: { // push
                    System.out.print("Enter data to push: ");
                    stack.push(sc.nextInt());
                } break;
                case 2: { // pop
                    if (stack.isEmpty())
                        System.out.println("The stack is empty!");
                    else
                        System.out.println("The popped data is: " + stack.pop());
                } break;
                case 3: { // peek
                    if (stack.isEmpty())
                        System.out.println("The stack is empty!");
                    else
                        System.out.println("Top most element is: " + stack.peek());
                } break;
                default:
                    System.out.println("INVALID CHOICE INPUT");
            } // end of switch case statement
        } while (ch != 0);

        sc.close();

        // stack.push(1);
        // stack.push(2);
        // stack.push(3);
        // stack.push(4);

        while(!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}