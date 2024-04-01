package edu.java.impl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyLinkedList<E>{
	private int size;
	private Node<E> first;
	private Node<E> last;

	public MyLinkedList() {
		size = 0;
	}

	public MyLinkedList(Collection<? extends E> c) {
		size = 0;
		this.addAll(c);
	}



	public boolean add(E element) {
		size += 1;
		Node<E> newNode = new Node<>(element);

		if (first == null) {
			first = newNode;
			last = newNode;
			return true;
		}

		last.setNext(newNode);
		newNode.setPrev(last);
		last = last.getNext();
		return true;
	}

	public boolean add(int index, E element) {
		if (index == size) {
			add(element);
			size += 1;
			return true;
		}

		Node<E> newNode = new Node<>(element);
		if (index == 0) {
			newNode.setNext(first);
			first.setPrev(newNode);
			first = newNode;
			return true;
		}

		Node<E> nodeToMove = getNode(index);
		nodeToMove.getPrev().setNext(newNode);
		newNode.setPrev(nodeToMove.getPrev());
		newNode.setNext(nodeToMove);
		nodeToMove.setPrev(newNode);

		return true;
	}

	public boolean addAll(Collection<? extends E> collection) {
		for (E elem: collection) {
			add(elem);
		}
		return true;
	}

	public E set(int index, E elem) {
		Node<E> node = getNode(index);

		E oldVal = node.getVal();
		node.setVal(elem);
		return oldVal;
	}



	public E get(int index) {
		return getNode(index).getVal();
	}

	public boolean remove(E elem) {

		Node<E> cursor = first;

		while (cursor != null) {
			if (cursor.getVal().equals(elem)) {
				break;
			}
			cursor = cursor.getNext();
		}

		if (cursor == null) {
			return false;
		}

		Node<E> prev = cursor.getPrev();
		Node<E> next = cursor.getNext();

		if (cursor == first && cursor == last) {
			first = null;
			last = null;
		} else if (cursor == first) {
			first = first.getNext();
			first.setPrev(null);
		} else if (cursor == last) {
			last = last.getPrev();
			last.setNext(null);

		} else {
			prev.setNext(next);
			next.setPrev(prev);
		}

		size--;
		return true;
	}

	public E removeIndex(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException(
					String.format("Got index %d but size of List is %d", index, size)
			);
		}

		Node<E> cursor = first;
		for (int i = 0; i < index; i++) {
			cursor = cursor.getNext();
		}

		Node<E> prev = cursor.getPrev();
		Node<E> next = cursor.getNext();

		if (cursor == first && cursor == last) {
			first = null;
			last = null;
		} else if (cursor == first) {
			first = first.getNext();
			first.setPrev(null);
		} else if (cursor == last) {
			last = last.getPrev();
			last.setNext(null);

		} else {
			prev.setNext(next);
			next.setPrev(prev);
		}

		size--;
		return cursor.getVal();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");

		Node<E> cursor = first;
		while (cursor!=null) {
			builder.append(cursor.getVal());

			if (cursor.getNext() != null) {
				builder.append(", ");
			}

			cursor = cursor.getNext();
		}

		builder.append("]");
		return builder.toString();
	}

	private Node<E> getNode(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException(
					String.format("Got index %d but size of List is %d", index, size)
			);
		}

		Node<E> cursor = first;

		for (int i = 0; i < index; i++) {
			cursor = cursor.getNext();
		}

		return cursor;
	}

//	public static <T extends Comparable<T>> MyLinkedList<T> sort(MyLinkedList<T> old) {
//		MyLinkedList<T> newOne = new MyLinkedList<>();
//		newOne.addAll(old);
//
//		return newOne;
//	}
}
