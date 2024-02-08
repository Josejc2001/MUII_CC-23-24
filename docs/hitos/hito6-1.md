## Configuración de los contenedores
En este apartado se justificará la configuración de cada uno de los contenedores que componen el clúster.

### Contenedor front-end
En dicho Dockerfile se hace uso de la imagen `node:alpine`, la cual es una imagen oficial de Docker que contiene una versión de Node.js ejecutándose en Alpine Linux, un sistema operativo de Linux de tamaño reducido y altamente seguro. Alpine Linux se utiliza comúnmente como base para las imágenes de Docker debido a su tamaño pequeño, lo que permite que las imágenes se descarguen y se ejecuten más rápido. Posteriormente, se crea un nuevo directorio de trabajo y se copian los archivos `package.json` en dicho directorio. Además, se instalan las depedencias del proyecto y se copian todos los archivos y directorios del directorio actual a la ruta de destino, y se especifica que el contenedor se mantenga escuchando por el puerto 4200. Por último, se creará la carpeta `dist` con el despligue de la aplicación en producción mediante `npm run build` y se lanzará el servidor usando la construcción de producción anterior, todo ello mediante el `CMD [ "npm", "run", "start" ]`.

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
