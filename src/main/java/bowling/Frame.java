package bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    private List<Roll> rolls = new ArrayList<>(2);

    public int score(Frame nextFrame) {
        int sum = getBasicScore();
        sum += addBonus(nextFrame);
        return sum;
    }

    private int addBonus(Frame nextFrame) {
        if (isStrike()) {
            return strikeBonus(nextFrame);
        } else if (isSpare()) {
            return spareBonus(nextFrame);
        } else {
            return 0;
        }
    }

    private int getBasicScore() {
        int sum = 0;
        for (Roll roll : rolls) {
            sum += roll.getPins();
        }
        return sum;
    }

    protected int score() {
        return rolls.stream()
                .mapToInt(Roll::getPins)
                .sum();
    }

    protected List<Roll> getRolls() {
        return rolls;
    }

    public void roll(int pinsKnockedDown) {
        if (!isFrameFull()) {
            rolls.add(new Roll(pinsKnockedDown));
        }
    }

    public boolean isFrameFull() {
        return rolls.size() == 2 || isStrike();
    }

    @Override
    public String toString() {
        return "Frame [rolls=" + rolls + "]";
    }

    public boolean isSpare() {
        return score() >= 10;
    }

    public boolean isStrike() {
        if (!getRolls().isEmpty()) {
            return getRolls().get(0).getPins() == 10;
        } else {
            return false;
        }
    }

    public int spareBonus(Frame nextFrame) {
        return nextFrame.getRolls().get(0).getPins();
    }

    public int strikeBonus(Frame nextFrame) {
        return nextFrame.score();
    }

    public boolean isLastFrame() {
        return false;
    }
}
