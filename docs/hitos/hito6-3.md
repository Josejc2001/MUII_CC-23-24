## Configuración de los contenedores
En este apartado se justificará la configuración del [fichero de composición del cluster](../../docker-compose.yml) y su estructra.

Se exponen los tres servicios principales de la aplicación:
- **rf-backend**: Royal Fantasy Backend será el servicio encargado de gestionar el backend del sistema.
- **rf-frontend**: Royal Fantasy Frontend será el servicio encargado de gestionar el frontend del sistema.
- **rf-db**: Royal Fantasy DB será el servicio encargado de alojar la base de datos del sistema.

En cada uno de estos servicios se específica a partir de que Dockerfile han de ser compuestos y las variables de entorno que tienen que tener en cuenta en su lanzamiento. Además se especifican los puertos a través de los cuales se podrá acceder a través de la máquina host.

Por último, se específica el volumen el cual nos permite garantizar la persistencia de los datos generados en el sistema.

```
# Docker Compose file Reference (https://docs.docker.com/compose/compose-file/)
version: '3'

#Define services
services:
  #Back-end Spring Boot Application
  rf-backend:
    build: ./backend

    environment:
      SQL_HOST: 'rf-db'
      SQL_PORT: '3306'
      SQL_DATABASE: 'db_royal_fantasy'
      SQL_USERNAME: 'root'
      SQL_PASSWORD: 'jose'
    ports:
      - 8080:8080
    links:
      - rf-db

  #Front-end Angular Application
  rf-frontend:
    build: ./frontend

    ports:
      - 4200:4200
    links:
      - rf-backend

  #MySQL Database for the application
  rf-db:
    image: mysql:5.7
    environment:
      MYSQL_DATABASE: 'db_royal_fantasy'
      MYSQL_ROOT_PASSWORD: 'jose'
    ports:
      - '3307:3307'
    expose:
      - '3307'
    volumes:
      - my-db:/var/lib/mysql

volumes:
  my-db:
```