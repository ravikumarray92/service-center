package com.training.ifaces;

import java.util.List;

public interface MyDAO<T> {
	T find(int key);
    boolean add(T t);
    public List<T> findAll();
}
