# proyecto-solar-code-backend
Prueba despliegue aplicaciones en railway
## Api endpoint: https://stupendous-adjustment-production.up.railway.app/api/v1/categoria/obtenerCategorias

# application.properties

```
spring.datasource.url = jdbc:mysql://${DB_HOST}:${DB_PORT}/${DB_NAME}

spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
# Show or not log for each sql query
spring.jpa.show-sql=true
# Hibernate ddl auto (create, create-drop, update): with "create-drop" the database
# schema will be automatically created afresh for every start of application
spring.jpa.hibernate.ddl-auto=update
# Allows Hibernate to generate SQL optimized for a particular DBMS
spring.user.datasource.driver-class-name=com.mysql.jdbc.driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.properties.hibernate.format_sql=true
```

### CORS

```Java
@Configuration
	public static class Myconfiguration{
		@Bean
		public WebMvcConfigurer corsConfigurer(){
			return new WebMvcConfigurer() {
				@Override
				public void addCorsMappings(CorsRegistry registry) {
					registry.addMapping("/**")
							.allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
				}
			};
		}
	}
```
