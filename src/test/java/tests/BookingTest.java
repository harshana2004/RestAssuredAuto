package tests;

import base.BaseTest;
import framework.services.BookingService;
import framework.utils.AllureUtils;
import framework.utils.TestDataReader;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class BookingTest extends BaseTest {


    @Epic("Booking API")
    @Feature("Get All Bookings")
    @Test(description = "Verify user can get all bookings")
    public void getAllBookings() {
        BookingService bookingService = new BookingService();
        Response response = bookingService.getAllBookings();

        assertEquals(response.getStatusCode(), 200);
        assertNotNull(response.jsonPath().getList("$"));
        AllureUtils.attachResponse(response);


    }

    @Feature("Create Booking")
    @Test(description = "Verify user can create a booking")
    public void createBooking() {
        String bookingData = TestDataReader.read("booking.json"
        );
        BookingService bookingService = new BookingService();
        Response response = bookingService.createBooking(bookingData);
        assertEquals(response.getStatusCode(), 200);
        assertNotNull(response.jsonPath().getInt("bookingid"));
        assertEquals(response.jsonPath().getString("booking.firstname"), "John");
        AllureUtils.attachRequest(bookingData);
    }


    @Feature("Get Booking Details")
    @Test(description = "Verify user firstname is present in the booking details")
    public void getBookingById() {
        String bookingData = TestDataReader.read("booking.json");

        Response createResponse = new BookingService().createBooking(bookingData);

        assertEquals(createResponse.getStatusCode(), 200);

        int bookingId = createResponse.jsonPath().getInt("bookingid");

        Response response = bookingService.getBookingById(bookingId);

        assertEquals(response.getStatusCode(), 200);

        assertEquals(response.jsonPath().getString("firstname"), "John");
    }

}

