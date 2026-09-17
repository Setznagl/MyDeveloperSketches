package Lista_Duplamente_Encadeada.Nodes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {

    private String content;
    private Node nextNode = null;
    private Node previousNode = null;
    private Integer index = 0;

    public Node(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Node{" +
                "content=' " + content + '\'' +
                ", index= " + index +
                '}';
    }

    @Getter
    public static class NodeList {
        private Node head = null;
        private Node tail = null;
        private int size = 0;

        public void setListIndexes() {

            Node current = this.head;
            int indexIterator = 0;

            if (current != null) {
                while (current != null) {
                    current.index = indexIterator;
                    indexIterator++;
                    current = current.nextNode;
                }
            }
        }

        public void printAllNodes() {
            setListIndexes();

            Node current = this.head;

            if (current != null) {
                while (current != null) {
                    System.out.println(current);
                    current = current.nextNode;
                }
            } else {
                System.out.println("Não existe nenhum nó nessa lista: ");
            }
        }

        public String printByIndexByHead(Integer indexParameter) {

            Node current = this.head;

            if (current == null) {
                return "Lista vazia";
            } else {
                for (int i = 0; i != indexParameter; i++) {
                    current = current.nextNode;
                }
                return "Node{" +
                        "content=' " + current.getContent() + '\'' +
                        ", nextNode= " + current.getNextNode() +
                        ", previousNode= " + current.getPreviousNode() +
                        ", index= " + current.getIndex() +
                        '}';
            }
        }

        public Integer indexOfContent(String contentParameter) {

            Node current = this.head;

            if (current == null) {
                return null;
            }

            while (!current.content.equals(contentParameter)) {
                current = current.nextNode;
            }

            return current.index;
        }

        public int getListNodeSize() {
            return this.getSize();
        }

        //Falta validações se o item é a cauda
        public void addNode(Node... newNodes) {
            for (Node newNode : newNodes) {

                Node current = this.head;
                int indexIterator = 0;

                if (head == null) {
                    head = newNode;
                } else {
                    while (current.nextNode != null) {
                        indexIterator++;
                        current.nextNode.previousNode = current;
                        current = current.nextNode;
                    }
                    current.nextNode = newNode;
                    current.nextNode.previousNode = current;
                    tail = newNode;
                }
                newNode.index = indexIterator;
                this.size++;
                setListIndexes();
            }
        }

        public void addNodeAtIndex(Node newNode, int indexParameter) {
            Node current = this.head;
            newNode.setIndex(indexParameter);

            if (head == null && indexParameter == 0) {
                head = newNode;
            } else if (head != null && indexParameter == 0) {
                newNode.nextNode = head;
            } else {
                Node tempManipulatedNode;
                int currentIndex = 0;

                assert current != null;
                while (currentIndex < indexParameter - 1) {
                    current.nextNode.previousNode = current;
                    current = current.nextNode;
                    currentIndex++;
                }
                tempManipulatedNode = current.nextNode;
                if(current.nextNode == null){
                    current.nextNode = newNode;
                    tail = newNode;
                }else{
                current.nextNode = newNode;
                }
                newNode.nextNode = tempManipulatedNode;
            }
            this.size++;
            setListIndexes();
        }

        public void removeAtIndex(Integer indexParameter) {

            Node current = this.head;

            if (indexParameter == 0) {
                this.head = this.head.nextNode;
            } else {
                for (int i = 0; i < indexParameter - 1; i++) {
                    current = current.nextNode;
                }
                current.nextNode = current.nextNode.nextNode;
            }
            this.size--;
            setListIndexes();
        }

        //toString() referente a lista
        @Override
        public String toString() {
            return "NodeList{" + "head= \n\n" + head + "\n\n, size= " + size + '}';
        }
    }
}
