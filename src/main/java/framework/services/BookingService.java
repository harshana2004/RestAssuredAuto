package framework.services;

import framework.core.RequestSpec;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookingService {

    public Response getAllBookings(){

        return given()
                .spec(RequestSpec.getSpec())
                .when()
                .get("/booking");
    }

    public Response getBookingById(int bookingId){

        return given()
                .spec(RequestSpec.getSpec())
                .pathParam("id", bookingId)
                .when()
                .get("/booking/{id}");
    }

    public Response createBooking(String bookingData){

        return given()
                .spec(RequestSpec.getSpec())
                .body(bookingData)
                .when()
                .post("/booking");
    }

    public Response deleteBooking(int bookingId,String token){

        return given()
                .spec(RequestSpec.getSpec())
                .cookie("token", token)
                .when()
                .delete("/booking/", bookingId);
    }
}
