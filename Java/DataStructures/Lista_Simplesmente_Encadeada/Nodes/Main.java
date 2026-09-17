package Lista_Simplesmente_Encadeada.Nodes;

public class Main {
    public static void main(String[] args) {
        Node.NodeList newNodeList = new Node.NodeList();

        Node node1 = new Node("Marrocos");
        Node node2 = new Node("Bangladesh");
        Node node3 = new Node("Suécia");
        Node node4 = new Node("Madagascar");
        Node node5 = new Node("Teste Indice 2");
        Node node6 = new Node("Teste Indice 4");
        newNodeList.addNode(node1);
        newNodeList.addNode(node2);
        newNodeList.addNode(node3);
        newNodeList.addNode(node4);
        newNodeList.addNodeAtIndex(node5 , 2);
        newNodeList.addNodeAtIndex(node6 , 4);
        //Removendo Marrocos e Bangladesh
        //Lembre-se que se remover o índice Test indice 2 a linha 29 vai estourar erro;
        newNodeList.removeAtIndex(0);
        newNodeList.removeAtIndex(0);

        System.out.println("  ");
            newNodeList.printAllNodes();
        System.out.println(" ");
            System.out.println("O tamanho da lista é: " + newNodeList.getListNodeSize());
        System.out.println(" ");
            System.out.println("O índice do elemento 'Teste Indice 2' é: " + newNodeList.indexOfContent("Teste Indice 2"));

    }
}