package anagrams;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class ULHashMap<K,V> implements java.lang.Cloneable, java.lang.Iterable<ULHashMap.Mapping<K,V>>{
    private LinkedList<Entry<K,V>>[] table;
    // look at the problem sets for how to do this for a better way.  this can work but its harder.

    private class Entry<K,V>
    {
        K key;
        V value;
        // point to next node.
    }
    private int size;


    public ULHashMap(){}

    public ULHashMap(int expectedSize){

    }

    @Override
    public Iterator<Mapping<K, V>> iterator() {
        return null;
    }

    public static class Mapping<K,V>{

    }

    public void clear ()
    {

    }

    public ULHashMap clone()
    {

        return null;
    }

    public boolean containsKey(K key)
    {

        return false;
    }

    public boolean empty()
    {

        return false;
    }

    public boolean equals(java.lang.Object otherObject)
    {

        return false;
    }

    public void erase(K key)
    {

    }

    public void insert(K key, V value)
    {

    }

    public V lookup(K key)
    {

        return null;
    }

    public void put(K key, V value)
    {

    }
    public int size()
    {
        return 0;
    }

    public int tableSize()
    {
        return 0;
    }


}

