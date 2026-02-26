import constans.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.User;
import service.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserTest {

    @Test
    public void createUserTest() {

        User user = new User(1, "areg98", "Areg", "Hovakimyan", "areg@mail.com", "1234", "+8123456", 1);


        Specification.requestSpec(Urls.BASEURL)
                .when()
                .body(user)
                .post("user")
                .then()
                .log().all()
                .assertThat().statusCode(200);

    }


    @Test
    public void createUserWithListTest() {
        User user = new User(1, "areg98", "Areg", "Hovakimyan", "areg@mail.com", "1234", "+8123456", 1);

        List<User> list = new ArrayList<>();
        list.add(user);

        Specification.requestSpec(Urls.BASEURL)
                .when()
                .body(list)
                .post("user/createWithList")
                .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void getUserByUserNameTest() {

        User userResponse = new User();

        userResponse = Specification.requestSpec(Urls.BASEURL)
                .when()
                .get("user/areg98")
                .then()
                .log().all()
                .extract().response().as(User.class);

        Assert.assertEquals(userResponse.username, "areg98");


    }


    // extract response u grel asert testi hamar
    @Test
    public void updateUserTest() {
        User user = new User(1, "areg98", "Areg", "Hovakimyan", "hov@mail.com", "1234", "+8123456", 1);
        User userResponse = new User();

        Specification.requestSpec(Urls.BASEURL)
                .when()
                .body(user)
                .put("user/areg98")
                .then()
                .log().all();

        userResponse = Specification.requestSpec(Urls.BASEURL)
                .when()
                .get("user/areg98")
                .then()
                .log().all()
                .extract().response().as(User.class);


        Assert.assertEquals(userResponse.email, user.email);
    }
}
