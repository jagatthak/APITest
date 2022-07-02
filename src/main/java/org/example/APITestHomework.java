package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITestHomework {
    @BeforeClass
    public static void Setup()
    {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
    }

    @Test
    public void baseUrlReturnsSuccess(){

        Response response = given()
                .when()
                .get()
                .then()
                .extract()
                .response();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    // Scenario get All
    @Test
    public void it_should_return_valid_data1() {
        Response response = given()
                .when()
                .get("todos")
                .then()
                .extract()
                .response();

        System.out.println(response.jsonPath().get("[2].title").toString());

        JsonPath jsonPath = response.jsonPath();
        String title = jsonPath.getString("[2].title");
        Assert.assertEquals(title, "fugiat veniam minus");
    }
    // Scenario get by parameter
    @Test
    public void when_passing_id_then_it_should_only_return_data_for_that_id1() {
        Response response = given()
                .when()
                .get("todos/5")
                .then()
                .extract()
                .response();

        JsonPath jsonPath = response.jsonPath();
        String title = jsonPath.getString("title");
        Assert.assertEquals(title, "laboriosam mollitia et enim quasi adipisci quia provident illum");
    }
    // Scenario Put to create
    @Test
    public void it_should_create_new_put1() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body("{\n" +
                        "    \"userId\": 1,\n" +
                        "    \"title\": \"jkt\",\n" +
                        "    \"completed\": \"njt\"\n" +
                        "}")
                .put("todos/8")
                .then()
                .extract()
                .response();
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);

        JsonPath jsonPath = response.jsonPath();
        String title = jsonPath.getString("title");
        String id= jsonPath.getString("id");
        String completed = jsonPath.getString("completed");

        Assert.assertEquals(id, "8");
        Assert.assertEquals(title, "jkt");
        Assert.assertEquals(completed, "njt");
    }
    // Scenario Post to create
    @Test
    public void it_should_create_new_post1() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body("{\n" +
                        "        \"userId\": 1,\n" +
                        "        \"title\": \"joyous\",\n" +
                        "        \"completed\": \"proud\"\n" +
                        "    }")
                .post("todos/")
                .then()
                .extract()
                .response();
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 201);

        JsonPath jsonPath = response.jsonPath();
        String title = jsonPath.getString("title");
        String completed = jsonPath.getString("completed");
        String id =jsonPath.getString("id");
        Assert.assertEquals(title, "joyous");
        Assert.assertEquals(completed, "proud");
        Assert.assertEquals(id, "201");
    }
    @Test
    public void it_should_return_valid_data2() {
        Response response = given()
                .when()
                .get("users")
                .then()
                .extract()
                .response();

        System.out.println(response.jsonPath().get("[2].address.city").toString());

        JsonPath jsonPath = response.jsonPath();
        String title = jsonPath.getString("[2].address.city");
        Assert.assertEquals(title, "McKenziehaven");
    }
    // Scenario get by parameter
    @Test
    public void when_passing_id_then_it_should_only_return_data_for_that_id2() {
        Response response = given()
                .when()
                .get("users/2")
                .then()
                .extract()
                .response();
        response.prettyPrint();
        System.out.println(response.jsonPath().get("address.geo.lat").toString());
        JsonPath jsonPath = response.jsonPath();
        String title = jsonPath.getString("address.geo.lat");
        Assert.assertEquals(title, "-43.9509");
    }
    // Scenario Put to create
    @Test
    public void it_should_create_new_put2() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body("{\n" +
                        "    \"id\": 9,\n" +
                        "    \"name\": \"joykt\",\n" +
                        "    \"username\": \"jkt\",\n" +
                        "    \"email\": \"Chaim_McDermott@dana.io\",\n" +
                        "    \"address\": {\n" +
                        "        \"street\": \"dk Park\",\n" +
                        "        \"suite\": \"Suite 333\",\n" +
                        "        \"city\": \"Bartholomebury\",\n" +
                        "        \"zipcode\": \"76495-3109\",\n" +
                        "        \"geo\": {\n" +
                        "            \"lat\": \"25.6463\",\n" +
                        "            \"lng\": \"-268.8889\"\n" +
                        "        }\n" +
                        "    },\n" +
                        "    \"phone\": \"(775)977-6794 x41206\",\n" +
                        "    \"website\": \"conrad.com\",\n" +
                        "    \"company\": {\n" +
                        "        \"name\": \"Yost and Sons\",\n" +
                        "        \"catchPhrase\": \"Switchable contextually-based project\",\n" +
                        "        \"bs\": \"aggregate real-time technologies\"\n" +
                        "    }\n" +
                        "}")
                .put("users/9")
                .then()
                .extract()
                .response();
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);

        JsonPath jsonPath = response.jsonPath();
        String name = jsonPath.getString("name");
        String street= jsonPath.getString("address.street");
        String companyname = jsonPath.getString("company.name");

        Assert.assertEquals(name, "joykt");
        Assert.assertEquals(street, "dk Park");
        Assert.assertEquals(companyname, "Yost and Sons");
    }
    // Scenario Post to create
    @Test
    public void it_should_create_new_post2() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body("{\n" +
                        "        \"id\": 1,\n" +
                        "        \"name\": \"tomandjerry\",\n" +
                        "        \"username\": \"t&j\",\n" +
                        "        \"email\": \"Sincere@april.biz\",\n" +
                        "        \"address\": {\n" +
                        "            \"street\": \"Kulas Light\",\n" +
                        "            \"suite\": \"Apt. 556\",\n" +
                        "            \"city\": \"london\",\n" +
                        "            \"zipcode\": \"92998-3874\",\n" +
                        "            \"geo\": {\n" +
                        "                \"lat\": \"-37.3159\",\n" +
                        "                \"lng\": \"81.1496\"\n" +
                        "            }\n" +
                        "        },\n" +
                        "        \"phone\": \"1-770-736-8031 x56442\",\n" +
                        "        \"website\": \"hildegard.org\",\n" +
                        "        \"company\": {\n" +
                        "            \"name\": \"Romaguera-Crona\",\n" +
                        "            \"catchPhrase\": \"cartoon\",\n" +
                        "            \"bs\": \"harness real-time e-markets\"\n" +
                        "        }\n" +
                        "    }")
                .post("users/")
                .then()
                .extract()
                .response();
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 201);

        JsonPath jsonPath = response.jsonPath();
        String username = jsonPath.getString("username");
        String city = jsonPath.getString("address.city");
        String catchPhrase =jsonPath.getString("company.catchPhrase");
        Assert.assertEquals(username, "t&j");
        Assert.assertEquals(city, "london");
        Assert.assertEquals(catchPhrase, "cartoon");
    }

}
