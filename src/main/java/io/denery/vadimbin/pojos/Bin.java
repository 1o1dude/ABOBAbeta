package io.denery.vadimbin.pojos;

public class Bin {
    private String text;

    public Bin() {}

    public Bin(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Bin{" +
                "text='" + text + '\'' +
                '}';
    }
}
