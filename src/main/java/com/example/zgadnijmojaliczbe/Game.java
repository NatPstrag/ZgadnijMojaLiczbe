package com.example.zgadnijmojaliczbe;

import lombok.Data;

import java.util.Random;
import java.util.UUID;


public class Game {
    private final UUID id;
    private final int number;


    Random rand=new Random();

    public Game() {
        this.id = UUID.randomUUID();
        this.number = rand.nextInt(100)-1;

    }

    public UUID getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

}
