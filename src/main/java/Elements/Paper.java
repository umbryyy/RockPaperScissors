package Elements;
public class Paper extends Choice {
    public Paper(){
        this.name = "Paper";
    }

    @Override
    public void beats(Choice element) {
        System.out.println("Paper beats " + element.name);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
