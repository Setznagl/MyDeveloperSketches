package Pilha.Nodes;

public class StackMain {
    public static void main(String[] args) {
        Node.Stack stack = new Node.Stack();
        Node node1 = new Node("Ice Cream");
        Node node2 = new Node("Chips");
        Node node3 = new Node("Fries");

        stack.push(node1, node2, node3);
        System.out.println(stack);
        System.out.println("isEmpty: " + stack.isEmpty());

        stack.pop();
        stack.pop();
        //stack.pop();
    }
}
