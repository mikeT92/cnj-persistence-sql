package edu.hm.cs.fwp.cloudtrain.adapter.persistence.migration;

import org.flywaydb.core.Flyway;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.sql.DataSource;

@Startup
@Singleton
public class AutoMigrator {

    @Resource(lookup = "java:global/cnj-postgres-datasource")
    private DataSource dataSource;

    @PostConstruct
    public void migrateDatabase() {
        Flyway flyway = Flyway.configure().dataSource(this.dataSource).load();
        flyway.migrate();
    }
}
