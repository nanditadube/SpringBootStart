package com.mygit.boot.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mygit.boot.dao.IFetchDao;
import com.mygit.boot.entity.ServerConfig;

@Service
public class FetchDaoImpl {
	
	@Autowired
	IFetchDao fetchDao;	
	
	public ServerConfig fetchById(long articleId) {
		ServerConfig obj = fetchDao.findById(articleId).get();
		return obj;
	}

	public Iterable<ServerConfig> findAllConfig() {
		return fetchDao.findAll();
	}	
}
