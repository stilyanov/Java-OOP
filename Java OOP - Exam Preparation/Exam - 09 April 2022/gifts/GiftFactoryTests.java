package gifts;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GiftFactoryTests {

    @Test
    public void testConstructorNewInstance() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("toy", 10.41);
    }

    @Test
    public void testCreateGift() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("toy", 10.41);
        giftFactory.createGift(gift);
        Assert.assertEquals(giftFactory.getCount(), 1);
        Assert.assertEquals(gift.getType(), "toy");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateGiftAlreadyExist() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("toy", 10.41);
        Gift gift2 = new Gift("toy", 10.41);
        giftFactory.createGift(gift);
        giftFactory.createGift(gift2);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveGiftWithNameNull() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift(null, 10.13);
        giftFactory.createGift(gift);
        giftFactory.removeGift(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveGiftWithEmptyName() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("    ", 10.13);
        giftFactory.createGift(gift);
        giftFactory.removeGift("    ");
    }

    @Test
    public void testRemoveGiftCorrectly() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("toy", 10.13);
        giftFactory.createGift(gift);
        boolean toy = giftFactory.removeGift("toy");
        Assert.assertTrue(toy);
    }

    @Test
    public void testGetPresentWithLeastMagic() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("toy", 10.41);
        Gift gift2 = new Gift("toy2", 20.41);
        giftFactory.createGift(gift);
        giftFactory.createGift(gift2);

        Assert.assertEquals(gift, giftFactory.getPresentWithLeastMagic());
    }

    @Test
    public void testGetPresent() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("toy", 10.41);
        Gift gift2 = new Gift("toy2", 20.41);
        giftFactory.createGift(gift);
        giftFactory.createGift(gift2);

        Assert.assertEquals(gift, giftFactory.getPresent("toy"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void IfTrueToModifiedCollectionThrowException(){
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("toy", 10.41);
        Gift gift2 = new Gift("toy2", 20.41);
        giftFactory.createGift(gift);
        giftFactory.createGift(gift2);

        giftFactory.getPresents().remove(gift);

    }
}
