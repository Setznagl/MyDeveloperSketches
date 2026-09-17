package Fila.Nodes;

public class QueueMain {
    public static void main(String[] args) {
        Node.Queue queue = new Node.Queue();
        Node node1 = new Node("Ice Cream");
        Node node2 = new Node("Chips");
        Node node3 = new Node("Fries");

        queue.enqueue(node1, node2, node3);
        System.out.println(queue);
        System.out.println("O primeiro elemento é: " + queue.first());

        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        //queue.dequeue();
    }
}
