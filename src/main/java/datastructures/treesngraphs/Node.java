package datastructures.treesngraphs;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
@RequiredArgsConstructor
public class Node<T extends Comparable<?>> {

	public Node<T> left;
	public Node<T> right;
	@NonNull
	public T data;
}
