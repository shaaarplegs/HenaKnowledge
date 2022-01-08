package moee.henaknowledge;

import moee.henaknowledge.controller.AuthenticationRequest;
import moee.henaknowledge.controller.AuthenticationResponse;
import moee.henaknowledge.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;


import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("prod")
//NOTE: I am using Admin profile that is in the production database, because I only read from it
//and perform typical actions that happen between a frontend and this backend that is connected to the actual database.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    AdminService adminService;

    @Test
    public void TestingAuthentication() throws Exception {
        //Send a request to authenticate containing an object that has username and password
        HttpEntity httpEntity = new HttpEntity(new AuthenticationRequest("ADMIN", "ADMIN"));

        String authenticateRequestURL = "http://localhost:" + port + "/authenticate";
        ResponseEntity<AuthenticationRequest> authenticationresponse = restTemplate.exchange(authenticateRequestURL,HttpMethod.POST,httpEntity,
                AuthenticationRequest.class);

        assertThat(authenticationresponse.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    @Test
    public void TestingGettingJsonWebToken() throws Exception {
        //Send a request to authenticate containing an object that has username and password
        HttpEntity httpEntity = new HttpEntity(new AuthenticationRequest("ADMIN", "ADMIN"));

        String authenticateRequestURL = "http://localhost:" + port + "/authenticate";
        var res = restTemplate.exchange(authenticateRequestURL,HttpMethod.POST,httpEntity,AuthenticationResponse.class);

        String generatedJWT = res.getBody().getJwt();
        //Note that when debugging this test you could see the actual JWT, however it is hashed differently
        //everytime. However, with ever different hash there is always a dot
        assertThat(generatedJWT).contains(".");
    }

    @Test
    public void TestingAdminControllerConfirmation() throws Exception {
        //Send a request to authenticate containing an object that has username and password
        HttpEntity httpEntity = new HttpEntity(new AuthenticationRequest("ADMIN", "ADMIN"));

        String authenticateRequestURL = "http://localhost:" + port + "/authenticate";
        var res = restTemplate.exchange(authenticateRequestURL,HttpMethod.POST,httpEntity,AuthenticationResponse.class);

        //get the generated json web token for the admin
        String generatedJWT = res.getBody().getJwt();


        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + generatedJWT);

        HttpEntity entity = new HttpEntity(headers);

        String mainTestingURL = "http://localhost:" + port + "/Admin/testing/confirmed";


        assertThat(this.restTemplate.exchange(mainTestingURL, HttpMethod.GET, entity, String.class)
        ).toString().contains("This message is returned by the admin controller.");
    }

    @Test
    public void TestingStudentControllerConfirmation() throws Exception {
        //I am using the admin profile to access the other controllers ex StudentController
        // because Admin account is the only account that is hard coded
        // in the database, in addition in the security configuration class I basically let Admin have access to all URLS.

        //Send a request to authenticate containing an object that has username and password
        HttpEntity httpEntity = new HttpEntity(new AuthenticationRequest("ADMIN", "ADMIN"));

        String authenticateRequestURL = "http://localhost:" + port + "/authenticate";
        var res = restTemplate.exchange(authenticateRequestURL,HttpMethod.POST,httpEntity,AuthenticationResponse.class);

        //get the generated json web token for the admin
        String generatedJWT = res.getBody().getJwt();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + generatedJWT);

        HttpEntity entity = new HttpEntity(headers);

        String mainTestingURL = "http://localhost:" + port + "/Student/testing/confirmed";

        assertThat(this.restTemplate.exchange(mainTestingURL, HttpMethod.GET, entity, String.class)
        ).toString().contains("This message is returned by the student controller.");
    }

    @Test
    public void TestingTeacherControllerConfirmation() throws Exception {
        //I am using the admin profile to access the other controllers ex TeacherController
        // because Admin account is the only account that is hard coded
        // in the database, in addition in the security configuration class I basically let Admin have access to all URLS.

        //Send a request to authenticate containing an object that has username and password
        HttpEntity httpEntity = new HttpEntity(new AuthenticationRequest("ADMIN", "ADMIN"));

        String authenticateRequestURL = "http://localhost:" + port + "/authenticate";
        var res = restTemplate.exchange(authenticateRequestURL,HttpMethod.POST,httpEntity,AuthenticationResponse.class);

        //get the generated json web token for the admin
        String generatedJWT = res.getBody().getJwt();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + generatedJWT);

        HttpEntity entity = new HttpEntity(headers);

        String mainTestingURL = "http://localhost:" + port + "/Teacher/testing/confirmed";

        assertThat(this.restTemplate.exchange(mainTestingURL, HttpMethod.GET, entity, String.class)
        ).toString().contains("This message is returned by the teacher controller.");
    }
}
