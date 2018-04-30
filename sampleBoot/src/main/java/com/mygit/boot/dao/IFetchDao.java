package com.mygit.boot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mygit.boot.entity.ServerConfig;

@Repository
public interface IFetchDao extends CrudRepository<ServerConfig, Long> {
   // public List<ServerConfig> getConfigurationData(Long l); 
}
