import constans.Urls;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojo.Pet;
import service.Specification;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PetTest {

    @Test
    public void FindById() {

        Specification.installSpecification(Specification.requestSpec(Urls.BASEURL), Specification.responseSpecOK200());
        Pet pet = given()
                .when()
                .contentType(ContentType.JSON)
                .get("pet/" + "2")
                .then().log().all()
                .extract().body().jsonPath().getObject("category", Pet.class);

        System.out.println(pet);
    }

}
