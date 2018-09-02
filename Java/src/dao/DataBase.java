package dao;

public interface DataBase {
	public void insert(Object obj, Object key) throws RepeatedKeyException;
	public Object get(Object obj, Object key);
}
