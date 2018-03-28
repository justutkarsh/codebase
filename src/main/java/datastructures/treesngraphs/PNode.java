package datastructures.treesngraphs;

//Class that Carries Parent Node as well.
class PNode<T extends Comparable<?>> extends Node<T> {

  Node<T> parent;

  public PNode(T data) {
    super(data);
  }

}