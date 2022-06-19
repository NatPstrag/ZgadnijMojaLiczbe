package com.example.zgadnijmojaliczbe;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


@Service
public class GameService {

    private final Game game = new Game();

    public UUID getId() {
        return game.getId();
    }

    public Game getGame() {
        return game;
    }

    public GameResult guess(String id, String number) {
        String result;

        int numberInt = Integer.parseInt(number);

        if (numberInt > game.getNumber()) {
            result = "too big";
        } else if (numberInt < game.getNumber()) {
            result = "too small";
        } else {
            result = "winner";
        }

        GameResult gameResult = new GameResult(id, result, 0);
        gameResult.incrementCounter();
        if (result.equals("winner")) {
            gameResult.setTotalTime((int) (System.nanoTime() - gameResult.getStartTime()) / 1_000_000_000);
            saveScore(gameResult.getId(), gameResult.getTries(), gameResult.getTotalTime());
        }
        return gameResult;
    }

    public void saveScore(String id, int tries, int time) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/highscores.csv", true));
            writer.append("\n" + id + "," + tries + "," + time);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Score> getScores() {
        List<String[]> allScores = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/main/resources/highscores.csv");
            CSVReader csvReader = new CSVReader(fileReader);
            allScores = csvReader.readAll();
            allScores.remove(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Score> scoreList = new ArrayList<>();
        for (String[] row : allScores) {
            scoreList.add(new Score(row[0],Integer.parseInt(row[1]), Integer.parseInt(row[2])));
        }
        return scoreList;
    }

    public List<Score> highscores() {
        List<Score> highscore = getScores();
        Collections.sort(highscore, Collections.reverseOrder());
        List<Score> result = new ArrayList<>();

        int i = 0;
        for (Score x : highscore) {

            i++;
            result.add(x);

            if (i == 10) {
                break;
            }
        }

        return result;
    }
}
