package edu.java.impl;

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
}
