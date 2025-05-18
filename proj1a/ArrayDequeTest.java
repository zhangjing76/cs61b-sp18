import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the AList class*/
public class ArrayDequeTest {
	@Test
	public void testEmptySize() {
		ArrayDeque<Integer> L = new ArrayDeque();
		assertEquals(0, L.size());
	}

	@Test
	public void testAddAndSize() {
		ArrayDeque<Integer> L = new ArrayDeque();
		L.addLast(99);
		L.addLast(99);
		assertEquals(2, L.size());
	}

	@Test
	public void testGet() {
		ArrayDeque<Integer> L = new ArrayDeque();
		L.addLast(99);
		int want = L.get(0);
		assertEquals(99, want);
		L.addLast(36);
		want = L.get(0);
		assertEquals(99, want);
		want = L.get(1);
		assertEquals(36, want);
	}


	@Test
	public void testRemove() {
		ArrayDeque<Integer> L = new ArrayDeque();
		L.addLast(99); //99
		int want = L.get(0);
		assertEquals(99, want);
		L.addLast(36); //99, 36
		want = L.get(0);
		assertEquals(99, want);
		L.removeLast(); //99
		want = L.get(0);
		assertEquals(99, want);
		L.addLast(100); //99, 100
		want = L.get(1);
		assertEquals(100, want);
		assertEquals(2, L.size());
	}

	/** Tests insertion of a large number of items.*/
	@Test
	public void testMegaInsert() {
		ArrayDeque<Integer> L = new ArrayDeque();
		int N = 1000000;
		for (int i = 0; i < N; i += 1) {
			L.addLast(i);
		}

		for (int i = 0; i < N; i += 1) {
			L.addLast(L.get(i));
		}
	}

	@Test
	public void testAddFirstRemoveLastIsEmpty() {
		ArrayDeque<Integer> L = new ArrayDeque();
		L.addFirst(99); //99
		int want;
		L.addFirst(36); //36, 99
		L.removeLast(); //36
		want = L.get(0);
		assertEquals(36, want);
		L.addLast(100); //36, 100
		want = L.get(1);
		assertEquals(100, want);
		L.removeLast(); //36
		L.removeLast(); //none
        assertTrue(L.isEmpty());
	}

	@Test
	public void testFillUpEmptyfillUp() {
		//TODO
	}


	public static void main (String[]args){
		jh61b.junit.TestRunner.runTests("all", ArrayDequeTest.class);
	}
}