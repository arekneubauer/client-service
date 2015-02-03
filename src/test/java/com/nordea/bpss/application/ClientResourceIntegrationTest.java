package com.nordea.bpss.application;

import com.jayway.restassured.http.ContentType;
import com.nordea.bpss.client.Client;
import com.nordea.bpss.client.ClientService;
import com.nordea.bpss.client.CustomerCountry;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.Response;
import java.io.File;
import java.net.URL;

import static com.jayway.restassured.RestAssured.*;

@RunWith(Arquillian.class)
public class ClientResourceIntegrationTest {

    @Deployment(testable = false)
    public static WebArchive create() {
        File[] libs = Maven.resolver().loadPomFromFile("pom.xml")
                .resolve("ch.qos.logback:logback-classic").withTransitivity()
                .asFile();

        return ShrinkWrap.create(WebArchive.class)
                .addAsLibraries(libs)
                .addClasses(JAXRSConfiguration.class, ClientResource.class)
                .addClasses(Client.class, ClientService.class, CustomerCountry.class)
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF", "weblogic.xml"))
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    @RunAsClient
    public void should_create_fail_on_not_valid_client(@ArquillianResource URL baseUrl) {

        System.out.println(baseUrl);

        given().body("{}").contentType(ContentType.JSON)
            .when()
                .post(baseUrl + "1.0/clients/PL")
            .then()
                .statusCode(Response.Status.BAD_REQUEST.getStatusCode());

    }
}