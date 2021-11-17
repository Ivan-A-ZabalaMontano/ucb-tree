package bo.edu.ucb.est;

import java.util.Stack;

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
    
    public void addRecursive(D data)
    {
    	   Node<D> newNode = new Node<>(data);
           if(this.root==null)
           {
           	this.root=newNode;
           }
           else
           {
        	   addNode(root,newNode);
           }
    }
    private void addNode(Node<D> root, Node<D> newNode)
    {
        if(root.getData().compareTo(newNode.getData())>0)
        {
        	if(root.getLeft()==null)
        	{
        		root.setLeft(newNode);
        	}
        	else
        	{
        		addNode(root.getLeft(),newNode);
        	}
        
        }
        else if(root.getData().compareTo(newNode.getData())<0)
        {
        	if(root.getLeft()==null)
        	{
        		root.setRight(newNode);
        	}
        	else
        	{
        		addNode(root.getRight(),newNode);
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
    public void printInOrderNonRecursive()
    {
    	System.out.print("{");
    	Stack<Node<D>> treeStack= new Stack<>();
    	Node<D> current=this.root;
    	treeStack.add(current);
    	while(treeStack.size()>0)
    	{
    		while(current!=null) 
        	{
    			treeStack.push(current);		
        		current=current.getLeft();
        	}
    		Node<D> pop=treeStack.pop();
    		if(treeStack.size()!=0)
    		{
    			System.out.print(" "+pop.getData()+" ");
    		}
    		current=pop.getRight();
    	}
    	System.out.print("}");
    	System.out.println();
    }
    /**
     * 1. El nodo que se va a eliminar no tiene hijo, es una hoja.
     * Este es el caso más simple; dado que un nodo hoja no tiene hijos, no necesitamos preocuparnos por nada. 
     * Podemos reemplazar el nodo hoja con NULL y liberar el espacio asignado a este nodo.
     *
     * 2. El nodo que se va a eliminar tiene un solo hijo (hijo izquierdo o derecho).
     * En este caso, almacenamos el hijo del nodo y eliminamos el nodo de su posición original. 
     * Luego, el nodo hijo se inserta en la posición original del nodo eliminado.
     *
     * 3. El nodo que se va a eliminar tiene hijos, hijo izquierdo y derecho.
     * Este es el caso más complicado porque aquí, no podemos simplemente eliminar o reemplazar el nodo con su hijo. 
     * En este caso, encontramos el nodo más pequeño en el subárbol derecho del nodo minnode. 
     * Reemplace el valor del nodo que se eliminará con el valor de minnode y llame de forma recursiva a delete en este nodo.
     * @param data
     */
    public void remove(D data)
    {
    	Node<D> current=this.root;
    	Node<D> toDelete=null;
    	Node<D> parent=null;
    	Node<D> minNode=null;
    	while(current!=null)
    	{
    		if(current.getData().compareTo(data)>0)
    		{
    			parent=current;
    			current=current.getLeft();
    		}
    		else if(current.getData().compareTo(data)<0) 
    		{
    			parent=current;
    			current=current.getRight();
    		}
    		else if(current.getData().compareTo(data)==0)
    		{
    			toDelete=current;
    			break;
    		}
    	}
    	if(toDelete.getRight()==null && toDelete.getLeft()==null) //Es un nodo hoja
    	{
    		if(parent.getRight()==toDelete)
    		{
    			parent.setRight(null);
    		}
    		else
    		{
    			parent.setLeft(null);
    		}
    	}
    	else if(toDelete.getLeft()!=null && toDelete.getRight()==null)//Solo tiene el nodo izquierdo
    	{
    		parent.setLeft(toDelete.getLeft());
    	}
    	else if(toDelete.getLeft()==null && toDelete.getRight()!=null)//Solo tiene el nodo derecho
    	{
    		parent.setLeft(toDelete.getLeft());
    	}
    	else
    	{
    		minNode=toDelete.getRight();
    		while(minNode!=null)
    		{
    			if(minNode.getLeft()!=null)
    			{
    				minNode=minNode.getLeft();
    			}
    			else if(minNode.getRight()!=null)
    			{
    				minNode=minNode.getRight();
    			}
    			else
    			{
    				break;
    			}
    		}
    		remove(minNode.getData());
    		minNode.setRight(toDelete.getRight());
    		minNode.setLeft(toDelete.getLeft());
    		if(toDelete==this.root) 
    		{
    			root=minNode;
    		}
    		else
    		{
    			if(parent.getRight()==toDelete) 
        		{
        			parent.setRight(minNode);
        		}
        		else
        		{
        			parent.setLeft(minNode);
        		}
    		}
    
    	}
    }

}
