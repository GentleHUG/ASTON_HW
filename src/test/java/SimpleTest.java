import edu.java.impl.MyLinkedList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class SimpleTest {

	@Test
	public void initTest() {
		MyLinkedList<Float> list1 = new MyLinkedList<>();
		assertEquals("[]", list1.toString());

		List<Integer> arrayList = new ArrayList<>();
		arrayList.add(11);
		arrayList.add(22);
		MyLinkedList<Integer> list2 = new MyLinkedList<>(arrayList);
		assertEquals("[11, 22]", list2.toString());

	}
	@Test
	public void addTest() {
		MyLinkedList<Integer> list = new MyLinkedList<>();
		list.add(11);
		list.add(12);

		assertEquals("[11, 12]", list.toString());

		list.add(13);
		assertEquals("[11, 12, 13]", list.toString());

		list.add(1, 14);
		assertEquals("[11, 14, 12, 13]", list.toString());

		assertThrows(IndexOutOfBoundsException.class, ()->list.add(12, 1));
	}

	@Test
	public void addAllTest() {
		MyLinkedList<String> list = new MyLinkedList<>();
		List<String> stringList = new ArrayList<>();
		stringList.add("hello");
		stringList.add("world");

		list.addAll(stringList);
		assertEquals("[hello, world]", list.toString());
	}

	@Test
	public void setTest() {
		MyLinkedList<Integer> list = new MyLinkedList<>();
		list.add(11);
		list.add(12);

		assertEquals("[11, 12]", list.toString());

		assertEquals(12, list.set(1, 13));
		assertEquals("[11, 13]", list.toString());
	}

	@Test
	public void getTest() {
		MyLinkedList<Integer> list = new MyLinkedList<>();
		list.add(11);
		list.add(12);
		list.add(13);
		assertEquals(11, list.get(0));
		assertEquals(13, list.get(2));
		assertThrows(IndexOutOfBoundsException.class, ()->list.get(12));

		list.add(1, 14);
		assertEquals("[11, 14, 12, 13]", list.toString());
	}

	@Test
	public void removeTest() {
		MyLinkedList<Integer> list = new MyLinkedList<>();
		list.add(11);
		list.add(12);
		list.add(13);

		list.remove(11);

		assertEquals("[12, 13]", list.toString());

		list.remove(123);
		assertEquals("[12, 13]", list.toString());

		list.add(14);
		list.add(15);
		assertTrue(list.remove(13));
		assertEquals("[12, 14, 15]", list.toString());

		list.add(11);
		list.add(12);
		assertEquals(14, list.removeIndex(1));
		assertEquals(12, list.removeIndex(0));
		assertEquals("[15, 11, 12]", list.toString());
	}



}
