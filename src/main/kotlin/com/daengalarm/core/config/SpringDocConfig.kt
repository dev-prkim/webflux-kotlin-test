package com.daengalarm.core.config

//import io.swagger.v3.oas.models.OpenAPI
//import io.swagger.v3.oas.models.info.Info
//import org.slf4j.Logger
//import org.slf4j.LoggerFactory
//import org.springdoc.core.utils.SpringDocUtils
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.context.annotation.Profile
//import org.springframework.web.server.WebSession

//@Configuration
//@Profile("dev")
//class SpringDocConfig() {
//    private val logger: Logger = LoggerFactory.getLogger(SpringDocConfig::class.java)
//
//    init {
//        SpringDocUtils.getConfig().addRequestWrapperToIgnore(
//            WebSession::class.java,
//        )
//    }
//
//    @Bean
//    fun openApi(): OpenAPI {
//        logger.debug("Starting Swagger")
//
//        return OpenAPI()
//            .info(
//                Info()
//                    .title("core rest api")
//                    .version("v0.0.1")
//                    .description("Core Rest API")
//            )
//    }
//}