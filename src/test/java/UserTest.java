import constans.Urls;
import org.testng.annotations.Test;
import pojo.User;
import service.Specification;

public class UserTest {

    @Test
    public void creatUserTest() {

        User user = new User(1, "areg98", "Areg", "Hovakimyan", "areg@mail.com", "1234", "+8123456", 1);

        Specification.requestSpec(Urls.BASEURL)
                .when()
                .body(user)
                .post("user")
                .then()
                .log().all();

    }


    @Test
    public void getUserByUserNameTest() {
        Specification.requestSpec(Urls.BASEURL)
                .when()
                .get("user/areg98")
                .then()
                .log().all();
    }

    @Test
    public void updateUserTest() {
        User user = new User(1, "areg98", "Areg", "Hovakimyan", "hov@mail.com", "1234", "+8123456", 1);

        Specification.requestSpec(Urls.BASEURL)
                .when()
                .body(user)
                .put("user/areg98")
                .then()
                .log().all();
    }
}
