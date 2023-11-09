# Hito 2 :pushpin:
> Versión 2.0.0

## Contenidos
Los contenidos de este hito serán los siguientes:
- [Gestores de tareas](#gestores-de-tareas)

## Gestores de tareas
Para llevar a cabo la realización de este proyecto, se escogerá [Maven](https://maven.apache.org/) como gestor de tareas del backend y [NPM](https://www.npmjs.com/) como gestor de tareas del frontend. Estos gestores de tareas han sido escogidos por su facilidad de uso y su integración en los frameworks utilizados.

### Maven
Apache Maven es una potente herramienta de gestión de proyectos que se utiliza para gestión de dependencias, herramienta de compilación y para documentación. Un aspecto importante es que es de código abierto y gratuita.

Se puede usar con diversos lenguajes pero principalmente se usa en proyectos Java. De hecho, el framework que se va a utilizar para el desarrollo del backend, Spring Boot, utilizan esta herramienta por defecto.

Por ejemplo, para automatizar la ejecución de test podemos usar el siguiente comando:
```
$ mvn test
```

### NPM
NPM significa Node Package Manager o Gestor de Paquetes de Node. Es una herramienta que te permite instalar, actualizar y administrar fácilmente los paquetes de Node.js.

Se va a utilizar npm ya que permite instalar todos los paquetes necesarios para nuestro framework Angular, que se va a utilizar para la implementación del front-end.

El archivo package.json es crucial ya que contiene los metadatos y las dependencias de tu proyecto. Por ejemplo, nos permite ajustar y lanzar los test utilizando el siguiente comando:
```
$ npm run test
```

### Metodología TDD

