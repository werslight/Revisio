package etu.unice.revisio;

public class Reponses {
    private int input;
    private int remove;

    public Reponses(int et, int r) {
        this.input = et;
        this.remove = r;
    }

    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public int getRemove() {
        return remove;
    }

    public void setRemove(int remove) {
        this.remove = remove;
    }
}
