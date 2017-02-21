package com.tictactoe.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tictactoe.api.model.Game;
import com.tictactoe.api.service.GameService;

@Service("gameService")
@Transactional
public class GameServiceImpl implements GameService {

	@Override
	public int getNextChoice(Game game) {

		if (checkGameOver(game)) {
			return calculateScore(game);
		}

		List<Integer> scores = new ArrayList<>();
		List<String> moves = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (game.getBoard()[i][j] == 0) {
					if (game.getActivePlayer() == 1) {
						Game g = calculateNewState(game, i + " " + j);
						g.setActivePlayer(2);
						scores.add(getNextChoice(g));
						moves.add(i + " " + j);
					} else {
						Game g = calculateNewState(game, i + " " + j);
						g.setActivePlayer(1);
						scores.add(getNextChoice(g));
						moves.add(i + " " + j);
					}

				}
			}
		}

		if (game.getActivePlayer() == 2) {
			int max = -30;
			for (int i = 0; i < scores.size(); i++) {
				if (scores.get(i) >= max) {
					max = scores.get(i);
				}
			}
			game.setNextChoice(moves.get(scores.indexOf(max)));
			return max;

		} else {
			int min = 1000;
			for (int i = 0; i < scores.size(); i++) {
				if (scores.get(i) <= min) {
					min = scores.get(i);
				}
			}
			game.setNextChoice(moves.get(scores.indexOf(min)));
			return min;
		}

	}

	@Override
	public int calculateScore(Game game) {
		if (winStrategy(game))
			return -10;
		else if (winStrategy(game))
			return 10;
		else
			return 0;
	}

	@Override
	public boolean winStrategy(Game game) {
		boolean rowwin = true;
		boolean columnwin = true;
		boolean diagnoalwin = true;
		for (int i = 0; i < 3; i++) {
			rowwin = true;
			for (int j = 0; j < 3; j++) {
				if (game.getBoard()[i][j] != game.getActivePlayer()) {
					rowwin = false;
				}

			}
			if (!rowwin) {
				columnwin = true;
				for (int j = 0; j < 3; j++) {
					if (game.getBoard()[j][i] != game.getActivePlayer()) {
						columnwin = false;
					}

				}
			}

			if (columnwin || rowwin) {
				break;
			}
		}
		if (!rowwin && !columnwin) {
			for (int i = 0; i < 3; i++) {
				if (game.getBoard()[i][i] != game.getActivePlayer()) {
					diagnoalwin = false;
				}
			}
			if (!diagnoalwin) {
				diagnoalwin = true;
				for (int i = 0; i < 3; i++) {
					if (game.getBoard()[i][2 - i] != game.getActivePlayer()) {
						diagnoalwin = false;
					}
				}
			}
		}

		return columnwin || rowwin || diagnoalwin;
	}

	@Override
	public boolean checkGameOver(Game game) {
		if (!winStrategy(game) && !winStrategy(game)) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (game.getBoard()[i][j] == 0)
						return false;

				}
			}
		}
		return true;
	}

	@Override
	public Game calculateNewState(Game game, String move) {
		int copyArray[][] = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				copyArray[i][j] = game.getBoard()[i][j];
			}
		}
		copyArray[Integer.parseInt(move.split(" ")[0])][Integer.parseInt(move.split(" ")[1])] = game.getActivePlayer();
		game.setBoard(copyArray);
		return game;
	}

}
