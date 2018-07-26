package com.dyheart.cointracker.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyheart.cointracker.dao.CoinDAO;
import com.dyheart.cointracker.dao.GenericDAO;
import com.dyheart.cointracker.domain.Coin;
import com.dyheart.cointracker.dto.CoinDTO;
import com.dyheart.cointracker.dto.GroupDTO;
import com.dyheart.cointracker.service.CoinService;

@Service(value="coinService")
@Transactional
public class CoinServiceImpl extends GenericServiceImpl<Coin> implements CoinService {
	
	@PersistenceContext							//Make an instance managed and persistent.
	private EntityManager entityManager; 	
	
	@PersistenceContext							
	protected EntityManager em; 
	
	@Autowired
	CoinDAO coinDAO;
	
	@Autowired
	CoinService coinService; 
	
	private static final Logger logger = Logger.getLogger(CoinServiceImpl.class);

	@Override
	public GenericDAO<Coin> getDAO() {
		return coinDAO;
	}

	@Override
	public List<CoinDTO> getAllCoins() throws Exception {
		
		
		return null;
	}

}
