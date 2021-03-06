package SystemDesign.Adapter;

public class Adapter {
    
    public static void main(String[] args) {
        IHero originalHero = new Hero();
        IHero thirdPartyHero = new HeroAdapter(new ThirdPartyHero());

        originalHero.Attack();
        thirdPartyHero.Attack();

    }
}
