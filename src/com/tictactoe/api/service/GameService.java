package com.tictactoe.api.service;

import com.tictactoe.api.model.Game;

public interface GameService {

	int getNextChoice(Game game);

	int calculateScore(Game game);

	boolean winStrategy(Game game);

	boolean checkGameOver(Game game);

	Game calculateNewState(Game game, String move);
}