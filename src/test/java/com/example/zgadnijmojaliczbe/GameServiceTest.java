package com.example.zgadnijmojaliczbe;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GameServiceTest {
    @Autowired
    GameService gameService;

    @Test
    void guess(){
        assertNotNull(gameService.guess("330f8f7e-371a-40d6-9cbc-ff6b94c7ced7","5"));
    }

    @Test
    void getScores(){
        assertNotNull(gameService.getScores());
    }

    @Test
    void saveScores(){
        Score score= new Score("12345678-test-1234-test-12345fsa6671",99,99);
        gameService.saveScore("12345678-test-1234-test-12345fsa6671",99,99);
        List<Score> scoreList=gameService.getScores();
        scoreList.get(scoreList.size()-1).getId();
        assertEquals(scoreList.get(scoreList.size() - 1).getId(), score.getId());

    }

    @Test
    void highScores(){
        assertNotNull(gameService.highscores());
    }

}