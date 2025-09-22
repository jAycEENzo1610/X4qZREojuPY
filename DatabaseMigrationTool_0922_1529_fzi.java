// 代码生成时间: 2025-09-22 15:29:30
package com.example.migrations;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import java.util.Scanner;
import javax.sql.DataSource;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.service.spi.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import org.hibernate.tool.schema.TargetType;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import io.quarkus.hibernate.orm.panache.Panache;

/**
 * A command-line tool to perform database migrations.
 */
@QuarkusMain
public class DatabaseMigrationTool {

    private static DataSource dataSource;
    private static SessionFactoryImplementor sessionFactory;

    public static void main(String... args) {
        try {
            // Obtain the datasource and session factory from the Quarkus application.
            dataSource = Panache.datasource();
            sessionFactory = (SessionFactoryImplementor) dataSource.
                createEntityManagerFactory("QuarkusEntityManagerFactory").getSessionFactory();
            
            // Perform the migration.
            performMigration();
        } catch (Exception e) {
            // Handle any exceptions that occur during migration.
            e.printStackTrace();
        }
    }

    /**
     * Performs the database migration.
     */
    private static void performMigration() {
        // Create a SchemaExport instance to handle the migration.
        SchemaExport export = new SchemaExport();
        
        // Set properties for the SchemaExport instance.
        export.setHbm2ddlAuto(sessionFactory.getProperties().getProperty("hibernate.hbm2ddl.auto"));
        export.setFormat(true);
        export.setDelimiter(";");
        
        // Set the database type to use.
        export.setDatabaseAction(TargetType.CLEAN);
        
        // Execute the migration.
        try {
            export.execute(true, sessionFactory.getServiceRegistry().getService.jdbcConnectionAccess());
            System.out.println("Database migration completed successfully.");
        } catch (Exception e) {
            // Handle any exceptions that occur during the migration execution.
            System.err.println("An error occurred during the migration: " + e.getMessage());
        }
    }
}
