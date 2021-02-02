package com.demo.base.swagger.config;

import com.demo.base.swagger.enums.ApiDisplayOrNotEnum;
import com.demo.base.swagger.properties.SwaggerProperties;
import com.google.common.base.Predicate;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vince Yuan
 * @date 12/30/2020
 */
@EnableSwagger2
@Configuration
@EnableConfigurationProperties({ SwaggerProperties.class })
public class SwaggerConfig {

    @Autowired
    private SwaggerProperties swaggerProperties;

    @Bean
    public Docket createRestApi() {
        // Get an API selector
        ApiSelectorBuilder selector = new Docket(DocumentationType.SWAGGER_2)
                // Parameters for global use of the project
                .globalOperationParameters(globalOperationParameters())
                // Information for the project
                .apiInfo(apiInfo())
                .select();
        // Create Swagger documentation
        Docket docket = selector
                /*
                 *  The conditions that APIs satisfy for Swagger to process
                 *  -- The APIs under specific base package
                 *  -- The APIs annotated with "@ApiOperation"
                 */
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getScanPackage()))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                /*
                 *  The APIs that satisfy above conditions to be documented or not by Swagger
                 *  -- PathSelectors.any(): The APIs that satisfy above conditions will be displayed on Swagger's documentation
                 *  -- PathSelectors.none(): The APIs that satisfy above conditions will never be displayed on Swagger's documentation
                 */
                .paths(paths())
                .build();
        return docket;
    }

    /**
     *  Specify parameters for global use of the project <br/>
     *  -- The global operation parameters can be used for debugging and testing, etc.
     *
     * @return
     */
    private List<Parameter> globalOperationParameters() {
        List<Parameter> globalOperationParameters = new ArrayList<Parameter>();
        Parameter demoParameter = new ParameterBuilder()
                // Parameter name
                .name("operatorId")
                // Default value of the parameter
                .defaultValue("1")
                // Description of the parameter
                .description("操作人ID")
                // The data type of the parameter
                .modelRef(new ModelRef("long"))
                /*
                 *  The use type of the parameter
                 *  -- header: the parameter will be used as request parameter in request header
                 */
                .parameterType("header")
                // Specify if the parameter is necessary
                .required(false)
                .build();
        globalOperationParameters.add(demoParameter);
        return globalOperationParameters;
    }

    /**
     *  Specify the information for the project
     *
     * @return
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                // The title of the project
                .title(swaggerProperties.getTitle())
                // The description of the project
                .description(swaggerProperties.getDescription())
                // The contact information of the project
                .contact(new Contact(swaggerProperties.getContactName(),swaggerProperties.getContactUrl(), swaggerProperties.getContactEmail()))
                // The version of the project
                .version(swaggerProperties.getVersion())
                // The license URL of the project
                .termsOfServiceUrl(swaggerProperties.getLicenseUrl())
                .build();
    }

    /**
     *  Specify if the APIs that satisfy the configured conditions are displayed on Swagger's documentation or not
     *
     * @return
     */
    private Predicate<String> paths() {
        ApiDisplayOrNotEnum displayEnum = ApiDisplayOrNotEnum.find(swaggerProperties.getDisplay());
        switch (displayEnum) {
            case YES:
                return PathSelectors.any();
            case NO:
                return PathSelectors.none();
            default:
                // Here will be centrally modified to throw a customized exception
                return PathSelectors.none();
        }
    }

//    @Bean
//    public Docket createRestApi() {
//        Docket docket = new Docket(DocumentationType.SWAGGER_2)
//                // 是否启用swagger
//                // .enable(false)
//                .apiInfo(apiInfo())
//                .securitySchemes(createSecuritySchemeList())
//                // .pathMapping("/")
//                .select()
//                // 指定当前包路径，这里就添加了两个包，注意方法变成了basePackage，中间加上成员变量splitor
//                // .apis(basePackage("com.XX.api.controller.broad;com.XX.api.controller.village"))
//                // .apis(RequestHandlerSelectors.basePackage("com.example.lwp.validatordemo.controller"))
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//        return docket;
//    }
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("SpringBoot整合Swagger")
//                .description("SpringBoot整合Swagger，详细信息......")
//                .version("9.0")
//                .contact(new Contact("张三", "blog.csdn.net", "zhangsan@gmail.com"))
//                .contact(new Contact("李四", "blog.csdn.net", "zhangsan@gmail.com"))
//                .termsOfServiceUrl("http://localhost111:9090/")
//                // .license("The Apache License")
//                // .licenseUrl("http://www.baidu.com")
//                .build();
//    }
//    private List<SecurityScheme> createSecuritySchemeList(){
//        List<SecurityScheme> list = new ArrayList<>();
//        list.add(new ApiKey("access_token", "access_token鉴权值", "header"));
//        // list.add(new ApiKey("access_token1", "access_token1鉴权值", "query"));
//        return list;
//    }
}
