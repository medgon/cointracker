package com.dyheart.cointracker.controller;

import com.dyheart.cointracker.dto.*;
import com.dyheart.cointracker.service.CoinService;
import com.dyheart.cointracker.utils.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.util.List;


@RestController
@RequestMapping("/coins")
public class CoinController {

    @Autowired
    CoinService coinService;

    @RequestMapping(value="", method= RequestMethod.GET)
    public List<CoinDTO> getAllCoins(HttpServletRequest request) throws Exception{

        List<CoinDTO> coinList = coinService.getAllCoins();

        return coinList;
    }
}
