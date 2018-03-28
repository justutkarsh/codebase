package datastructures.treesngraphs;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
@RequiredArgsConstructor
public class Node<T extends Comparable<?>> {

	protected Node<T> left;
	protected Node<T> right;
	@NonNull
	protected T data;
}
