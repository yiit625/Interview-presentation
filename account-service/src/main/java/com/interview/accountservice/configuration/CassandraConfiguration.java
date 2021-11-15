package com.interview.accountservice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import javax.annotation.Nonnull;

@Configuration
@EnableCassandraRepositories
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Value("${spring.data.cassandra.contact.points}")
    private String keySpaceName;

    @Value("${spring.data.cassandra.port}")
    private int port;

    @Value("${spring.data.cassandra.keyspace.name}")
    private String contactPoint;

    @Nonnull
    @Override
    protected String getKeyspaceName() {
        return keySpaceName;
    }
    
    @Override
    protected int getPort() {
        return port;
    }

    @Nonnull
    @Override
    protected String getContactPoints() {
        return contactPoint;
    }

    @Nonnull
    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Nonnull
    @Override
    public String[] getEntityBasePackages() {
        return new String[] {"com.interview.accountservice"};
    }
}
