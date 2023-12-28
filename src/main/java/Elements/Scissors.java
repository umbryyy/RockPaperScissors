package Elements;
public class Scissors extends Choice {
    public Scissors(){
        this.name = "Scissors";
    }

    @Override
    public void beats(Choice element) {
        System.out.println("Scissors beats " + element.name);
    }

    @Override
    public String getName() {
        return this.name;
    }
}