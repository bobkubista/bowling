package com.bobkubista.bowling;

public class TenthFrame extends Frame {

	@Override
	public boolean isFrameFull() {
		return getRolls().size() == 3;
	}

	@Override
	public int spareBonus(Frame nextFrame) {
		return getRolls().get(2).getPins();
	}

	@Override
	public int strikeBonus(Frame nextFrame) {
		return score() + nextFrame.score() + getRolls().get(2).getPins();
	}

	@Override
	public boolean isLastFrame() {
		return true;
	}

}
