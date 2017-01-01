package com.wrox.algorithms.maps;

public class DefaultEntry<K, V> implements Map.Entry<K, V> {
	
	private final K key;
	private V value;
	
	

	public DefaultEntry(K key, V value) {
		assert key != null : "key can’t be null";
		this.key = key;
		setValue(value);
	}	

	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return this.key;
	}

	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return this.value;
	}
	
	public V setValue(V value) {
		// TODO Auto-generated method stub
		V oldValue = this.value;
		this.value = value;
		return oldValue;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		DefaultEntry other = (DefaultEntry) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	

}
