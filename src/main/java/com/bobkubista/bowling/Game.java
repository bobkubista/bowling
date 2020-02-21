package com.bobkubista.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Frame> frames = new ArrayList<>(10);
    private int currentFrame = 0;

    public Game() {
        for (int i = 0; i < 9; i++) {
            this.frames.add(new Frame());
        }
        this.frames.add(new TenthFrame());
    }

    public void roll(int pinsKnockedDown) {
        frames.get(currentFrame).roll(pinsKnockedDown);
        if (frames.get(currentFrame).isFrameFull()) {
            currentFrame++;
        }
    }

    public int score() {
        int sum = 0;
        for (int i = 0; i < frames.size(); i++) {
            Frame frame = frames.get(i);
            sum = sum + frame.score(getFrameForBonus(i));
        }
        return sum;
    }

    private Frame getFrameForBonus(int i) {
        Frame frame = frames.get(i);
        if (!frame.isLastFrame()) {
            frame = frames.get(i + 1);
        }
        return frame;
    }
}
