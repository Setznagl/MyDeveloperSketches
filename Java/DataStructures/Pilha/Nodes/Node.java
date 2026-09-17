package Pilha.Nodes;

import lombok.Getter;

import java.util.EmptyStackException;

@Getter
public class Node {
    private final String content;
    private Node nextNode = null;

    Node(String contentParameter) {
        this.content = contentParameter;
    }

    @Override
    public String toString() {
        return "Node{" + "content='" + content + '\'' + '}';
    }

    @Getter
    public static class Stack {
        private Node top = null;
        private Node entranceNode = null;

        public void push(Node... newNodes) {
            for (Node newNode : newNodes) {
                Node current = this.top;

                if (top != null) {
                    while (current.nextNode != null) {
                        current = current.nextNode;
                    }
                    current.nextNode = newNode;
                } else {
                    entranceNode = newNode;
                }
                this.top = newNode;
            }
        }

        public void pop() {
            if (this.entranceNode == this.top) {
                this.top = null;
                this.entranceNode = null;
                throw new RuntimeException("Custom exception, the stack is already empty");
            }
            Node current = entranceNode;

            while (current.nextNode != this.top) {
                current = current.nextNode;
            }
            this.top = current;
        }

        public boolean isEmpty() {
            return top == null;
        }

        public Node top() {
            return this.top;
        }

        @Override
        public String toString() {
            return "Stack{" + "top=" + top + '}';
        }
    }
}
