package sample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wojciech.misiak on 4/26/2017.
 */
public class PinsRow {
    private final List<Pin> pins = new ArrayList<>();
    private int row;

    public PinsRow(int row) {
        this.row = row;
    }

    public List<Pin> getPins() {
        return pins;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void addPin(Pin pin) {
        pins.add(pin);
    }

    public void addPin(int index, Pin pin) {
        pins.add(index, pin);
    }

    public Pin getPin(int index) {
        return pins.get(index);
    }

    public void setPin(int index, Pin pin) {
        pins.set(index, pin);
    }
}
