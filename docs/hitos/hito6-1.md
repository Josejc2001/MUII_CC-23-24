## Configuración de los contenedores
En este apartado se justificará la configuración de cada uno de los contenedores que componen el clúster.

### Contenedor back-end
Dicho [Dockerfile](../../backend/Dockerfile) consiste en cargar la imagen base, establecer el directorio de trabajo, copiar los archivos relacionados con Maven, descargar las dependencias de Maven necesarias, copiar el código fuente de la aplicación y por último, ejecutar el comando para lanzar la aplicación de Spring Boot.

Es similar al que ya se hizo en el [hito 3](../hitos/hito3.md) para ejecutar los tests, pero ahora cambia el comando de ejecución, como se puede apreciar en la última línea del Dockerfile

```
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /backend

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN chmod +x mvnw

RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]
```

### Contenedor front-end
En dicho [Dockerfile](../../frontend/Dockerfile) se hace uso de la imagen `node:alpine`, la cual es una imagen oficial de Docker que contiene una versión de Node.js ejecutándose en Alpine Linux, un sistema operativo de Linux de tamaño reducido y altamente seguro. Alpine Linux se utiliza comúnmente como base para las imágenes de Docker debido a su tamaño pequeño, lo que permite que las imágenes se descarguen y se ejecuten más rápido. Posteriormente, se crea un nuevo directorio de trabajo y se copian los archivos `package.json` en dicho directorio. Además, se instalan las depedencias del proyecto y se copian todos los archivos y directorios del directorio actual a la ruta de destino, y se especifica que el contenedor se mantenga escuchando por el puerto 4200. Por último, se creará la carpeta `dist` con el despligue de la aplicación en producción mediante `npm run build` y se lanzará el servidor usando la construcción de producción anterior, todo ello mediante el `CMD [ "npm", "run", "start" ]`.

```
FROM node:19-alpine

# Set the working directory
WORKDIR /app

# Copy the package.json and package-lock.json
COPY package*.json ./

# Install the dependencies
RUN npm install

# Copy the rest of the application files
COPY . .

# Build the Angular application
RUN npm run build

# Expose the port where the application will run
EXPOSE 4200

# Start the application
CMD ["npm", "run", "start"]
```

### Contenedor base de datos
Este contenedor se obtiene de la [imagen oficial de MySQL en DockerHub](https://hub.docker.com/_/mysql), la cual a su vez nos provee una interfaz para poder administrar y gestionar nuestra base de datos. En esta ocasión, se realizará una configuración adicional estableciendo el nombre de nuestra base de datos (mediante `MYSQL_DATABASE: 'db_royal_fantasy'`), la contraseña para acceder al root (mediante `MYSQL_ROOT_PASSWORD: 'jose'`) así como los puertos que estarán expuestos y donde correrá el servicio de MySQL, en este caso en el puerto `3307` (normalmente es sobre el 3306 pero a mi me daba problemas en local), tal y como se puede observar a continuación:

```
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