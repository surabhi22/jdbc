package com.training.utils;

import java.util.List;

public interface MyDAO<T> {

	public int add(T object);
	public int delete(long DonorCode);
	public int update(long newPhoneNumber);
	public T find(long DonorCode);
	public List<T> findAll(T t );
	
	
}
