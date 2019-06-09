package com.ing.springboot.config;

import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

/**
 *<h1>ApiDocumentationConfig</h1>
 *<h3>Swagger API Documentation configuration</h3>
 *  
 * 
* @version 1.0
* @since   2019-06-07
* @author Venkat
 */
@SwaggerDefinition(
        info = @Info(
                description = "SpringBoot Rest Application Demo",
                version = "V1.0.1",
                title = "SpringBoot Rest Application",
                contact = @Contact(
                   name = "Venkat", 
                   email = "sample@gmail.com", 
                   url = "www.cognizant.com"
                ),
                license = @License(
                   name = "Apache 2.0", 
                   url = "http://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS}
)
public interface ApiDocumentationConfig {

}