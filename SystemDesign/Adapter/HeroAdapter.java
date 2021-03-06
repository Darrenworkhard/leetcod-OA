package SystemDesign.Adapter;

public class HeroAdapter implements IHero{
    private ThirdPartyHero _thirdPartyHero;

    public HeroAdapter(ThirdPartyHero thirdPartyHero)
    {
        _thirdPartyHero = thirdPartyHero;
    }

    @Override
    public void Attack()
    {
        _thirdPartyHero.Hit();
    }
}
