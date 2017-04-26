package sample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wojciech.misiak on 4/26/2017.
 */
public class MatchesRow {
    private final List<SingleMatch> matches = new ArrayList<>();
    private int row;

    public MatchesRow(int row) {
        this.row = row;
    }

    public List<SingleMatch> getMatches() {
        return matches;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void addPin(SingleMatch match) {
        matches.add(match);
    }

    public void addMatch(int index, SingleMatch match) {
        matches.add(index, match);
    }

    public SingleMatch getMatch(int index) {
        return matches.get(index);
    }

    public void setmatch(int index, SingleMatch match) {
        matches.set(index, match);
    }
}
