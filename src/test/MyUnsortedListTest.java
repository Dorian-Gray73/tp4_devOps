package test;

import org.junit.*;

import datastruct.EmptyListException;
import datastruct.MyUnsortedList;

import static org.junit.Assert.*;

public class MyUnsortedListTest {
    MyUnsortedList<Integer> liste;

    @Before
    public void init(){
        liste = MyUnsortedList.of();
    }
    
    @Test
    public void testIsEmpty(){
        assertTrue("La liste n'est pas vide à l'initialisation", liste.isEmpty());
    }

    @Test
    public void testSize(){
        liste = MyUnsortedList.of(1, 2, 3);
        assertEquals("Une liste créé n'a pas la bonne taille", 3, liste.size());
        liste = MyUnsortedList.of(1);
        assertEquals("Une liste créé n'a pas la bonne taille", 1, liste.size());
        liste = MyUnsortedList.of(1, 2, 3, 4, 5);
        assertEquals("Une liste créé n'a pas la bonne taille", 5, liste.size());
    }

    @Test
    public void testAddPop(){
        liste.append(1);
        liste.append(42);
        liste.append(59);
        assertEquals("Append n'ajoute pas les valeurs comme il faut.",MyUnsortedList.of(1, 42, 59), liste);
        assertEquals("Pop ne retire pas les bonnes valeurs", 1, (int) liste.pop());
        assertEquals("Pop ne retire pas les bonnes valeurs", 42, (int) liste.pop());
        assertEquals("Pop ne retire pas les bonnes valeurs", 59, (int) liste.pop());
    }

    @Test
    public void testPrependLast(){
        liste.prepend(1);
        liste.prepend(42);
        liste.prepend(59);
        assertEquals(MyUnsortedList.of(59, 42, 1), liste);
        assertEquals(liste.toString(), 1, (int) liste.popLast());
        assertEquals(liste.toString(), 42, (int) liste.popLast());
        assertEquals(59, (int) liste.popLast());
    }

    @Test
    public void testAddPrepPopLast(){
        liste.append(1);
        liste.append(42);
        liste.prepend(57);
        assertEquals(42, (int) liste.popLast());
        assertEquals(57, (int) liste.pop());
    }

    @Test
    public void testRemove(){
        liste = MyUnsortedList.of(0, 1, 2, 3, 4);
        assertEquals(4, (int) liste.remove(4));
        assertEquals(3, (int) liste.remove(3));
        assertEquals(2, (int) liste.remove(2));
        assertEquals(1, (int) liste.remove(1));
        assertEquals(0, (int) liste.remove(0));
    }

    @Test
    public void testRemoveSize(){
        liste = MyUnsortedList.of(0, 1, 2, 3, 4);
        assertEquals(5, liste.size());
        assertEquals(2, (int) liste.remove(2));
        assertEquals(4, liste.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testErrorRemove() throws IndexOutOfBoundsException{
        liste.remove(0);
    }
    @Test(expected = EmptyListException.class)
    public void testErrorPop() throws EmptyListException{
        liste.pop();
    }

    @Test(expected = EmptyListException.class)
    public void testErrorPopLast() throws EmptyListException{
        liste.popLast();
    }
}
