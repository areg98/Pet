import constans.Urls;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojo.Pet;
import service.Specification;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PetTest {

    @Test
    public void findById() {

        //https://petstore.swagger.io/v2/pet/2

        Pet pet = Specification.requestSpec(Urls.BASEURL)
                .when()
                .get("pet/" + "1")
                .then().log().all()
                .extract().body().jsonPath().getObject("category", Pet.class);

        System.out.println(pet);
    }

    @Test
    public void addPet() {
        Map<String, Object> category = new HashMap<>();
        category.put("id", 0);
        category.put("name", "string");

        Map<String, Object> tag = new HashMap<>();
        tag.put("id", 0);
        tag.put("name", "string");

        Map<String, Object> body = new HashMap<>();
        body.put("id", 0);
        body.put("category", category);
        body.put("name", "doggie");
        body.put("photoUrls", Arrays.asList("string"));
        body.put("tags", Arrays.asList(tag));
        body.put("status", "available");

        Specification.requestSpec(Urls.BASEURL)
                .when()
                .body(category)
                .post("pet")
                .then().log().all();



    }

}
