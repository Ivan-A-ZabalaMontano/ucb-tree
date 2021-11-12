package bo.edu.ucb.est;

public class Tree<D extends Comparable<D>> {
    private Node<D> root;

    public Tree() {
    }

    public Node<D> getRoot() {
        return root;
    }

    public void setRoot(Node<D> root) {
        this.root = root;
    }

    public void add(D data) {
        Node<D> newNode = new Node<>(data);
        if ( root == null) { // arbol vacio
            root = newNode;
        } else {
            Node<D> current = root;
            while(current != null ) {
                if (current.getData().compareTo(data) > 0) {
                    if (current.getLeft() == null) { // Tengo el espacio vacio para agregar el nodo
                        current.setLeft(newNode);
                        break; // Terminamos el recorrido
                    } else { // continuo bajando por la rama izquierda
                        current = current.getLeft();
                    }
                } else if (current.getData().compareTo(data) < 0) {
                    if (current.getRight() == null) { // Tengo el espacio vacio para agregar el nodo
                        current.setRight(newNode);
                        break; // Terminamos el recorrido
                    } else { // continuo bajando por la rama derecha
                        current = current.getRight();
                    }
                } else { // igual a cero
                    // Entonces el elemento ya existe.
                    throw new RuntimeException("No se puede agregar elementos duplicados a un ABB");
                }

            }
        }
    }

    public void printInOrder() 
    {
    	System.out.print("{");
    	print(this.root,"in");
    	System.out.print("}");
    	System.out.println();
    }
    public void printPreOrder()
    {
    	System.out.print("{");
    	print(this.root,"pre");
    	System.out.print("}");
    	System.out.println();
    }
    public void printPostOrder()
    {
    	System.out.print("{");
    	print(this.root,"post");
    	System.out.print("}");
    	System.out.println();
    }
    private void print(Node<D> root, String order)
    {
    	if(root!=null)
    	{
	    	if(order.equalsIgnoreCase("in"))
	    	{
	    		print(root.getLeft(),order);
	        	System.out.print(" "+root.getData()+" ");
	        	print(root.getRight(),order);  	
	    	}
	    	else if(order.equalsIgnoreCase("pre"))
	    	{
	    		System.out.print(" "+root.getData()+" ");
	    		print(root.getLeft(),order);
	    		print(root.getRight(),order);
	    	}
	    	else if(order.equalsIgnoreCase("post"))
	    	{
	    		print(root.getLeft(),order);
	    		print(root.getRight(),order);
	    		System.out.print(" "+root.getData()+" ");   		
	    	}	
    	}
    }
}
