package Offers;

import creditCards.BronzeCreditCard;
import creditCards.GoldCreditCard;
import creditCards.SilverCreditCard;

public class ShoppingOfferVisitor implements OfferVisitor {
    public void visitBronzeCreditCard(BronzeCreditCard bronze){
        System.out.println("We are computing the cashback for a bronze card shopping online");
    }

	public void visitSilverCreditCard(SilverCreditCard silver) {
		System.out.println("We are computing the cashback for a silver card shopping online");
	}

	public void visitGoldCreditCard(GoldCreditCard gold) {
		System.out.println("We are computing the cashback for a gold card shopping online");
	}
}
