package framework.utils;

import io.qameta.allure.Allure;
import io.restassured.response.Response;

public class AllureUtils {

    public static void attachResponse(Response response) {

        if (response == null) {
            return;
        }

        Allure.addAttachment(
                "API Response",
                "application/json",
                response.asPrettyString(),
                ".json"
        );
    }

    public static void attachRequest(String requestBody) {

        if (requestBody == null || requestBody.isBlank()) {
            return;
        }

        Allure.addAttachment(
                "API Request",
                "application/json",
                requestBody,
                ".json"
        );
    }

    public static void attachText(
            String name,
            String content) {

        if (content == null || content.isBlank()) {
            return;
        }

        Allure.addAttachment(
                name,
                "text/plain",
                content,
                ".txt"
        );
    }

    public static void attachJson(
            String name,
            String json) {

        if (json == null || json.isBlank()) {
            return;
        }

        Allure.addAttachment(
                name,
                "application/json",
                json,
                ".json"
        );
    }
}
