package com.automobile.service;

import java.util.List;

import com.automobile.model.Dealer;
import com.automobile.model.Storge;

public interface IStorgeService {
	
	public List<Storge> showStorgesListAll() ;
	
	public Storge getStorgeById(int stoId);
}
