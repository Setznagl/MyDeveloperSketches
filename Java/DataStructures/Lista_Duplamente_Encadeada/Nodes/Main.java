package Lista_Duplamente_Encadeada.Nodes;

/**
 Implementar o toString() com nextNode e PreviousNode simultaneamente causaria renderizações infinitas,
 para previnir isso somente content e indice foram implementados no toString e nextNode e previousNode
 aparecem quando o elemento é solicitado pelo índice
*/
public class Main {
    public static void main(String[] args) {
        Node.NodeList newBidirectionalNodeList = new Node.NodeList();

        Node node1 = new Node("Arcane");
        Node node2 = new Node("Code Geass");
        Node node3 = new Node("Full Metal Alchemist");
        Node node4 = new Node("Death Parade");
        Node node5 = new Node("BTOOM");
        Node node6 = new Node("Fate:Zero");

        //Graças ao varArgs a função add aceita multiplas instancias do mesmo elemento como argumento
        newBidirectionalNodeList.addNode(node1, node2, node3, node4, node5);
        newBidirectionalNodeList.addNodeAtIndex(node6 , 5);

        newBidirectionalNodeList.printAllNodes();
        //System.out.println(newBidirectionalNodeList.printByIndexByHead(2));
        System.out.println(" ");System.out.println("O índice de 'Death Parade' é : " + newBidirectionalNodeList.indexOfContent("Death Parade"));
        System.out.println("O tamanho da lista é : " + newBidirectionalNodeList.getListNodeSize());System.out.println(" ");
        System.out.println("A cauda da lista é: " + newBidirectionalNodeList.getTail());

    }
}