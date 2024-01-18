package PRACTICA_09;

public class CoffeMaker{

    protected boolean on;

    public void on() {
        on = true;
    }

    public void off() {
        on = false;
    }

    public boolean isOff() {
        return !on;
    }
    
}