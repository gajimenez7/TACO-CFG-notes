package creditCards;

import Offers.OfferVisitor;

public class GoldCreditCard implements CreditCard{
    public String getName(){
        return "Gold";
    }

    public void accept(OfferVisitor v){
        v.visitGoldCreditCard(this);
    }
}