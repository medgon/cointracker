package com.dyheart.cointracker.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.dyheart.cointracker.dto.*;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.dyheart.cointracker.dao.CoinDAO;
import com.dyheart.cointracker.dao.GenericDAO;
import com.dyheart.cointracker.domain.Coin;
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

	    List<CoinDTO> coinDTOList = new ArrayList<CoinDTO>();
	    List<Coin> coinlist = coinDAO.getAll();

	    for (Coin coin: coinlist){
	        CoinDTO coinDTO = this.convertToDTO(coin);
	        coinDTOList.add(coinDTO);
        }

		return coinDTOList;
	}

	public CoinDTO convertToDTO(Coin coin){

	    CoinDTO coinDTO = new CoinDTO();
	    BeanUtils.copyProperties(coin, coinDTO);

	    return coinDTO;
    }

    public Coin convertFromDTO(CoinDTO coinDTO){

	    Coin coin = new Coin();

        BeanUtils.copyProperties(coinDTO, coin);

        return coin;
    }

}
