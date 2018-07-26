package com.dyheart.cointracker.dao.impl;

import com.dyheart.cointracker.dao.CoinDAO;
import com.dyheart.cointracker.dao.GenericDAO;
import com.dyheart.cointracker.domain.Coin;
import org.springframework.stereotype.Repository;

@Repository
public class CoinDAOImpl extends GenericDAOImpl<Coin> implements CoinDAO {

}
