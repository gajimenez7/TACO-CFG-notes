package creditCards;

import Offers.OfferVisitor;

public class SilverCreditCard implements CreditCard{
    public String getName(){
        return "Silver";
    }

    public void accept(OfferVisitor v){
        v.visitSilverCreditCard(this);
    }
}