package models;

import java.nio.file.Path;

public class Writing {
    private Path p;
    private String text;

    public Writing() {
    }

    public Path getP() {
        return p;
    }

    public void setP(Path p) {
        this.p = p;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
