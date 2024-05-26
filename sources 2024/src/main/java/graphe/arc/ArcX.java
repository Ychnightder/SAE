package main.java.graphe.arc;

public class ArcX extends Arc {
    public ArcX(String source) {
        super(source, "", -1);
    }

    @Override
    public String toString() {
        return getSource() + ":";
    }
}
