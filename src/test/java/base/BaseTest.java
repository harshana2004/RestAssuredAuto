package base;

import framework.services.AuthService;
import framework.services.BookingService;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected BookingService bookingService;
    protected AuthService authService;

    @BeforeClass
    public void SetUp(){
        bookingService = new BookingService();
        authService = new AuthService();
    }
}
