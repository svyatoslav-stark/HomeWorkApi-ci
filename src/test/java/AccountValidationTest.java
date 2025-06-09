import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class AccountValidationTest {

    @Test
    void validateAccountResponse() {
        // Укажите URL вашего сервиса
        String url = "http://localhost:9999/api/v1/demo/accounts";

        // Выполняем запрос и проверяем ответ
        RestAssured.given()
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"));
    }
}