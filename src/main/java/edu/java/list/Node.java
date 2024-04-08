package edu.java.list;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Node<E> {
	private E val;
	private Node<E> next;
	private Node<E> prev;

	public Node(E val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return val.toString();
	}
}
