package controller;

import java.util.ArrayList;

public interface DAOInterface<T> {
    public ArrayList<T> selectAll();
    public T selectByBook(String sach);
    public T selectByAuthor(String tacGia);
    public void insertAll(ArrayList<T> list);
    public void insert(T t);
    public void deleteAll(ArrayList<T> list);
    public void delete(String t);
    public void update(T t);
}
