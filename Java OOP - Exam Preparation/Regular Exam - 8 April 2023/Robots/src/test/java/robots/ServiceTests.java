package robots;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServiceTests {
    private Service service;
    private Robot robot;

    @Before
    public void setUp() {
        this.service = new Service("Clean", 5);
        this.robot = new Robot("DeepCleanRobot");
    }

    @Test
    public void testConstructor() {
        Assert.assertEquals(service.getCapacity(), 5);
        Assert.assertEquals(service.getName(), "Clean");
        Assert.assertEquals(robot.getName(), "DeepCleanRobot");
        Assert.assertEquals(service.getCount(), 0);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameNullOrSpace() {
        Service service1 = new Service(null, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityNegative() {
        Service service1 = new Service("Cleaner", -1);
    }

    @Test
    public void testAddRobotCorrectly() {
        Robot robot2 = new Robot("HouseCleaner");
        service.add(robot2);
        Assert.assertEquals(robot2.getName(), "HouseCleaner");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRobotFullCapacity() {
        Service service2 = new Service("WC", 2);
        Robot robot2 = new Robot("HouseCleaner");
        Robot robot3 = new Robot("WcCleaner");
        service2.add(robot);
        service2.add(robot2);
        service2.add(robot3);

    }

    @Test
    public void testRemoveCorrectly() {
        Robot robot2 = new Robot("HouseCleaner");
        Robot robot3 = new Robot("WcCleaner");
        Robot robot4 = new Robot("OfficeCleaner");
        service.add(robot2);
        service.add(robot3);
        service.add(robot4);
        service.remove(robot2.getName());
        Assert.assertEquals(robot.getName(), "DeepCleanRobot");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveRobotWithUnCorrectName() {
        Robot robot2 = new Robot("HouseCleaner");
        Robot robot3 = new Robot("WcCleaner");
        Robot robot4 = new Robot("OfficeCleaner");
        service.remove("Gosho");
    }

    @Test
    public void testRobotForSale() {
       this.service.add(robot);
       Assert.assertTrue(robot.isReadyForSale());
       this.service.forSale(robot.getName());
       Assert.assertFalse(this.robot.isReadyForSale());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRobotForSaleWithNullName() {
        this.service.add(new Robot(null));
        this.service.forSale(robot.getName());
        Assert.assertFalse(this.robot.isReadyForSale());
    }

    @Test
    public void testReportMessage() {
        this.service.add(robot);
        Assert.assertEquals("The robot DeepCleanRobot is in the service Clean!",
                service.report());
    }
}
