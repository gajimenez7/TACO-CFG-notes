import Offers.GasOfferVisitor;
import Offers.HotelOfferVisitor;
import Offers.OfferVisitor;
import Offers.ShoppingOfferVisitor;
import creditCards.BronzeCreditCard;
import creditCards.CreditCard;
import creditCards.GoldCreditCard;
import creditCards.SilverCreditCard;

/**
 * Differentiating single and double dispatch
 * @Author: George Jimenez
 */
public class Runner{
    public static void main(String[] args) {
        OfferVisitor visitor = new HotelOfferVisitor();
        OfferVisitor visitor2 = new GasOfferVisitor();
        OfferVisitor visitor3 = new ShoppingOfferVisitor();

        CreditCard bronze = new BronzeCreditCard();
        CreditCard silver = new SilverCreditCard();
        CreditCard gold = new GoldCreditCard();

        bronze.accept(visitor);
        silver.accept(visitor);
        gold.accept(visitor);

        bronze.accept(visitor2);
        silver.accept(visitor2);
        gold.accept(visitor2);

        bronze.accept(visitor3);
        silver.accept(visitor3);
        gold.accept(visitor3);
    }
}