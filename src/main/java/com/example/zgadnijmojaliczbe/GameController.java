package com.example.zgadnijmojaliczbe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
public class GameController {
    @Autowired
    private final GameService gameService= new GameService();

    @GetMapping("/start")
    public UUID start(){
        return gameService.getId();
    }

    @PostMapping("/guess")
    public GameResult guess(@RequestBody HashMap<String,String> json){
        return gameService.guess(json.get("id"),json.get("number"));
    }

    @GetMapping("/highscores")
    public List<Score> highscores(){
        return gameService.highscores();
    }
}
