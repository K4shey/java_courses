package VTB.lecture7.homework1;

public abstract class Stage {
    protected int length;
    protected String description;
    public String getDescription(){
        return description;
    }
    public abstract void go(Car c);
}
