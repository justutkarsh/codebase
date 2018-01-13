package hashmapntables;

import java.util.LinkedList;
import java.util.List;

public class HashtableChained<K,V> {
	static class Entry<K,V>{
		private K k;
		private V v;
		Entry(K k, V v){
			this.k=k;
			this.v=v;
		}
	}


Object[] store = new Object[100];
int index;

void put(K k, V v){
	Entry<K,V> e = new Entry<K,V>(k,v);
	index = k.hashCode()%100;
	
	if (store[index]!=null){
		List<Entry<K,V>> entryList = (List<Entry<K, V>>) store[index];
		entryList.add(e);
		store[index]=entryList;
		
	}else{
		List<Entry<K,V>> entryList = new LinkedList<Entry<K,V>>();
	    entryList.add(e);
	    store[index]=entryList;
	}
}

V get(K k){
	index = k.hashCode()%100;
	List<Entry<K,V>> entryList = (List<Entry<K, V>>) store[index];
	return (V)entryList.get(0);
}



}
