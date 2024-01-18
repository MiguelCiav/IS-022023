package PRACTICA_09;

public class CoffeMakerAdapter extends CoffeMaker implements Connectable{

    @Override
    public void turnOn() {
        this.on();
    }

    @Override
    public void turnOff() {
        this.off();
    }

    @Override
    public boolean isOn() {
        return !(this.isOff());
    }
    
}
