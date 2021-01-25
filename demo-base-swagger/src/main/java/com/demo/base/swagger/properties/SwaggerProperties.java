package com.demo.base.swagger.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Vince Yuan
 * @date 01/25/2021
 */
@Data
@ConfigurationProperties(prefix = "demo.swagger")
public class SwaggerProperties {

    /**
     *  The base package for Swagger's documentation
     */
    private String scanPackage = "";

    /**
     *  The title of the project where current project is introduced as a dependency
     */
    private String title = "";

    /**
     *  If the APIs that satisfy configured conditions will be displayed on Swagger's documentation
     */
    private String display = "yes";

    /**
     *  The description of the project where current project is introduced as a dependency
     */
    private String description = "";

    /**
     *  The contact name of the project where current project is introduced as a dependency
     */
    private String contactName = "";

    /**
     *  The contact URL of the project where current project is introduced as a dependency
     */
    private String contactUrl = "";

    /**
     *  The contact email of the project where current project is introduced as a dependency
     */
    private String contactEmail = "";

    /**
     *  The version of the project where current project is introduced as a dependency
     */
    private String version = "1.0";

    /**
     *  The license URL of the project where current project is introduced as a dependency
     */
    private String licenseUrl = "";
}
