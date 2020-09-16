package com.bobkubista.bowling;

public class Roll {

	private int pins;

	public Roll(int pins) {
		this.pins = pins;
	}

	public int getPins() {
		return pins;
	}

	@Override
	public String toString() {
		return "Roll [pins=" + pins + "]";
	}

}
