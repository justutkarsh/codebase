package treesngraphs;

public class Node<T extends Comparable<?>> {
	protected Node<T> left;
	protected Node<T> right;
	protected T data;

	public Node(Node<T> left, Node<T> right, T data) {
		super();
		this.left = left;
		this.right = right;
		this.data = data;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node(T data){
		this.data=data;
	}

	@Override
	public String toString() {
		return "Node [left=" + left + ", right=" + right + ", data=" + data
				+ "]";
	}
 
}
