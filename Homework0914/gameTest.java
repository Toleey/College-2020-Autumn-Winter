package gameTest;

import org.junit.jupiter.api.Test;

import gamesetting.gameConfig;

public class gameTest {
	

	@Test
	public void gameTest() {
		System.out.println(gameConfig.getProperty("playername"));
		System.out.println(gameConfig.getProperty("playerpwd"));
		System.out.println(gameConfig.getProperty("livervalue"));
		System.out.println(gameConfig.getProperty("wulizhi"));
	}
}
