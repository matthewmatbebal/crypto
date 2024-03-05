package com.yeel.crypto.controller;

import com.yeel.crypto.model.Coin;
import com.yeel.crypto.service.CoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CoinController {

    private final CoinService coinService;

    @PostMapping("addCoin")
    public Coin saveNewCoin(@RequestParam String name,
                            @RequestParam String code) {
        return coinService.saveCoin(name, code);
    }

    @GetMapping("getAll")
    public List<Coin> getAllCoins() {
        return coinService.getAllCoins();
    }

    @GetMapping("{id}")
    public Coin getCoin(@PathVariable Long id) {
        return coinService.getById(id);
    }
}
