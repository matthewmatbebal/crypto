package com.yeel.crypto.service;

import com.yeel.crypto.model.Coin;
import com.yeel.crypto.repository.CoinRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Slf4j
public class CoinService {

    private final CoinRepository coinRepository;
    public CoinService(CoinRepository coinRepository) {
        this.coinRepository = coinRepository;
    }
    public Coin saveCoin(String name, String code) {
        Coin coin = new Coin();

        coin.setName(name);
        coin.setCode(code);

        coinRepository.save(
                coin
        );

        return coin;
    }

    public List<Coin> getAllCoins() {
        return coinRepository.findAll();
    }

    public Coin getById(Long id) {
        return coinRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }
}
