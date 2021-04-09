package com.dchristofolli;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
    tags = {
        @Tag(name = "api", description = "Quarkus POC")
    },
    info = @Info(
        title = "Users CRUD",
        version = "1.0",
        contact = @Contact(
            name = "Daniel",
            email = "daniel.christofolli@ilia.digital"),
        license = @License(
            name = "Apache 2.0",
            url = "https://www.apache.org/licenses/LICENSE-2.0.html")
    )
)
public class ApiDefinition extends Application {
}
