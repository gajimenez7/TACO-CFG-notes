package creditCards;

import Offers.OfferVisitor;

public interface CreditCard {
    String getName();
    void accept(OfferVisitor v);
}