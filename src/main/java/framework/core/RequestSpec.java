package framework.core;

import framework.config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

    public static RequestSpecification getSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(ConfigReader.get("base.url"))
                .setContentType("application/json")
                .setAccept("application/json")
                .build();
    }


}
