package com.da.SpringBootExample;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.da.SpringBootExample.models.Employee;

public class HibernateUtil {
	// static ApplicationContext context = new
	// AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	// private static AppProperties app = (AppProperties)
	// context.getBean("appProperties");

	private static final SessionFactory sessionFactory;

	static {
		try {
			System.out.println(System.getenv("DB_URL"));
			Properties prop = new Properties();
			// Thay Driver class tuỳ theo CSDL bạn đang sử dụng

			// prop.put("hibernate.connection.driver_class", app.getDriver_class_name());
			// prop.put("hibernate.connection.url", app.getUrl());
			// prop.put("hibernate.connection.username", app.getUsername());
			// prop.put("hibernate.connection.password", app.getPassword());

			prop.put("hibernate.connection.driver_class", "org.mariadb.jdbc.Driver");
			prop.put("hibernate.connection.url", "jdbc:mariadb://nt71li6axbkq1q6a.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/wyrox3akrgwz5xnr");
			prop.put("hibernate.connection.username", "r87mtpmjfpibvi6w");
			prop.put("hibernate.connection.password", "x0a8pqxqzxudq0oi");

			prop.put("hibernate.current_session_context_class", "thread");
			prop.put("hibernate.query.factory_class", "org.hibernate.hql.internal.ast.ASTQueryTranslatorFactory");
			prop.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
			prop.put("hibernate.show_sql", "true");

			sessionFactory = new Configuration().addPackage("com.da.SpringBootExample.models").addProperties(prop)
					.addAnnotatedClass(Employee.class).buildSessionFactory();
		} catch (Exception ex) {
			// Log the exception.
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
