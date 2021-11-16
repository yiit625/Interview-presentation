package com.interview.accountservice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Value("${spring.cassandra.contact.point}")
    private String contactPoint;

    @Value("${spring.cassandra.port}")
    private int port;

    @Value("${spring.cassandra.keyspace.name}")
    private String keySpaceName;

    @Value("${spring.cassandra.username}")
    private String username;

    @Value("${spring.cassandra.password}")
    private String password;


    @Override
    protected String getKeyspaceName() {
        System.out.println("keySpaceName --> " + keySpaceName);
        return keySpaceName;
    }

    @Override
    protected int getPort() {
        System.out.println("port --> " + port);
        return port;
    }

    @Override
    protected String getContactPoints() {
        System.out.println("contactPoint --> " + contactPoint);
        return contactPoint;
    }

/*    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }*/

    @Override
    public String[] getEntityBasePackages() {
        return new String[] {"com.interview.accountservice"};
    }

    @Override
    public CassandraClusterFactoryBean cluster() {
        System.out.println("username --> " + username);
        System.out.println("password --> " + password);
        CassandraClusterFactoryBean clusterFactoryBean = super.cluster();
        clusterFactoryBean.setUsername(username);
        clusterFactoryBean.setPassword(password);
        return clusterFactoryBean;
    }
}
