package com.daengalarm.core.config

import io.r2dbc.h2.H2ConnectionConfiguration
import io.r2dbc.h2.H2ConnectionFactory
import io.r2dbc.h2.H2ConnectionOption
import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.r2dbc.connection.R2dbcTransactionManager
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator
import org.springframework.transaction.ReactiveTransactionManager


@Configuration
@EnableR2dbcRepositories
class R2dbcConfig {
//    @Bean
//    override fun connectionFactory() = H2ConnectionFactory(
//        H2ConnectionConfiguration.builder()
//            .inMemory("testdb")
//            .build()
//    )

    @Bean
    fun initializer(connectionFactory: ConnectionFactory): ConnectionFactoryInitializer {
        val initializer = ConnectionFactoryInitializer()
        initializer.setConnectionFactory(connectionFactory)
        val populator = CompositeDatabasePopulator()
        populator.addPopulators(ResourceDatabasePopulator(ClassPathResource("sql/schema.sql")))
        populator.addPopulators(ResourceDatabasePopulator(ClassPathResource("sql/data.sql")))
        initializer.setDatabasePopulator(populator)
        return initializer
    }

    @Bean
    fun transactionManager(connectionFactory: ConnectionFactory?): ReactiveTransactionManager? {
        return R2dbcTransactionManager(connectionFactory!!)
    }

}