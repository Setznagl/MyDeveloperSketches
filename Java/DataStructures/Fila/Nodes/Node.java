package Fila.Nodes;

import lombok.Getter;

@Getter
public class Node {
    private final String content;
    private Node nextNode;

    public Node(String content) {
        this.content = content;
        this.nextNode = null;
    }

    @Override
    public String toString() {
        return "[ Node: " +
                "content='" + content + '\'' +
                ", nextNode=" + nextNode +
                ']';
    }

    public static class Queue {
        private Node entranceNode = null;

        public boolean isEmpty() {
            return entranceNode == null;
        }

        public void enqueue(Node... newNodes) {
            for (int i = 0; i < newNodes.length; i++) {
            Node newNode = newNodes[i];

                Node current = entranceNode;

                if (entranceNode != null) {
                    while (current.nextNode != null) {
                        current = current.nextNode;
                    }
                    current.nextNode = newNode;
                } else {
                    entranceNode = newNode;
                }
            }
        }

        public void dequeue() {
            if (entranceNode == null) {
                throw new RuntimeException("The queue is already empty");
            }
            entranceNode = entranceNode.nextNode;
        }

        public String first(){
            return entranceNode.content;
        }

        @Override
        public String toString() {
            return "Queue{" +
                    "entranceNode=" + entranceNode +
                    '}';
        }
    }
}
