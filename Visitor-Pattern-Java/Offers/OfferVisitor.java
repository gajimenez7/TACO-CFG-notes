package Offers;

import creditCards.BronzeCreditCard;
import creditCards.GoldCreditCard;
import creditCards.SilverCreditCard;

public interface OfferVisitor {

    void visitBronzeCreditCard(BronzeCreditCard bronze);
    void visitSilverCreditCard(SilverCreditCard silver);
    void visitGoldCreditCard(GoldCreditCard gold);
}