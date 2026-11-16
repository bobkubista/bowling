package com.bobkubista.bowling;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {

	private Game game;

	@BeforeEach
	void setup() {
		game = new Game();
	}

	@Test
	void testGutterGame() {
		rollMany(20, 0);
		assertEquals(0, game.score());
	}

	@Test
	void testAllOnes() {
		rollMany(20, 1);
		assertEquals(20, game.score());
	}

	private void rollMany(int frameAmount, int score) {
		for (int i = 0; i < frameAmount; i++) {
			game.roll(score);
		}
	}

	@Test
	void testOneSpare() {
		rollSpare();
		game.roll(3);
		rollMany(17, 0);
		assertEquals(16, game.score());
	}

	@Test
	void testOneSpareAtEnd() {
		rollMany(18, 0);
		rollSpare();
		game.roll(3);
		assertEquals(16, game.score());
	}

	@Test
	void testOneStrike() {
		rollStrike();
		game.roll(3);
		game.roll(4);
		rollMany(16, 0);
		assertEquals(24, game.score());
	}

	@Test
	void testPerfectGame() {
		rollMany(12, 10);
		assertEquals(300, game.score());

	}

	private void rollStrike() {
		game.roll(10);
	}

	private void rollSpare() {
		game.roll(5);
		game.roll(5);
	}
}
