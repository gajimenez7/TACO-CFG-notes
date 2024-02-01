package creditCards;

import Offers.OfferVisitor;

public class BronzeCreditCard implements CreditCard{
    public String getName(){
        return "Bronze";
    }

    public void accept(OfferVisitor v){
        v.visitBronzeCreditCard(this);
    }
}