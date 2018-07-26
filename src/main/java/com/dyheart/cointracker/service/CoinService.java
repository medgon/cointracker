package com.dyheart.cointracker.service;

import java.util.List;

import com.dyheart.cointracker.domain.Coin;
import com.dyheart.cointracker.dto.CoinDTO;

public interface CoinService extends GenericService<Coin> {
	
	List<CoinDTO> getAllCoins() throws Exception; 

}
