# Configuración de Base de Datos en Línea

Para configurar la base de datos en línea, sigue los siguientes pasos:

1. **Datasource y Pool de Conexiones**

   Agrega la siguiente configuración a tu archivo `persistence.xml`:

   ```xml
   <persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence" version="2.0">
       <persistence-unit name="miUnidadDePersistencia">
           <jta-data-source>java:jboss/datasources/miDatasource</jta-data-source>
           <properties>
               <property name="javax.persistence.jdbc.url" value="jdbc:postgresql://hostname:5432/database" />
               <property name="javax.persistence.jdbc.user" value="username" />
               <property name="javax.persistence.jdbc.password" value="password" />
               <property name="javax.persistence.jdbc.driver" value="org.postgresql.Driver" />
           </properties>
       </persistence-unit>
   </persistence>
