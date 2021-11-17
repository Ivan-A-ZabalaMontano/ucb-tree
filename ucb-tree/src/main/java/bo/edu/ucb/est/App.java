package bo.edu.ucb.est;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )  {
        Tree<Integer> tree = new Tree<Integer>();
        
        tree.add(30);
        tree.add(20);
        tree.add(40);
        tree.add(15);
        tree.add(25);
        tree.add(5);
        tree.add(18);
        tree.add(35);
        tree.add(50);
        tree.add(45);
        tree.add(60);
        
        
  
        tree.printInOrder(); 
        tree.printPreOrder();
        tree.printPostOrder();
        
        tree.printInOrderNonRecursive();
        
        
        tree.remove(30);
        
        tree.printInOrder();

    }
}
