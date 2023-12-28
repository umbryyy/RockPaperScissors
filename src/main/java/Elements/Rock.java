package Elements;
public class Rock extends Choice {
    public Rock(){
        this.name = "Rock";
    }

    @Override
    public void beats(Choice element) {
        System.out.println("Rock beats " + element.name);
    }

    @Override
    public String getName() {
        return this.name;
    }
}