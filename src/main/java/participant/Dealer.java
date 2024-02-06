package participant;

public class Dealer extends Participant{

    public Dealer() {
        super(new Name("딜러"));
    }

    @Override
    public boolean isDealer() {
        return true;
    }

}
