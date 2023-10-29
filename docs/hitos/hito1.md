# Hito 1 :pushpin:
> Versión 0.0.1

## Contenidos
Los contenidos de este hito serán los siguientes:
- [Historias de usuario](#historias-de-usuario)
- [Milestones](#milestones)
- [Instalación](#instalación)
- [Justificación de lenguajes y frameworks](#justificación-de-lenguajes-y-frameworks)

## Historias de usuario

## Milestones

## Instalación
En primer lugar para llevar a cabo la instalación, hay que dirigirse a la página de [Spring Initializr](#https://start.spring.io/), la cual nos permitirá generar la estructura inicial de nuestro proyecto.

![Creating project](../imgs/creating-project.png)

Como se puede apreciar en la anterior imagen, hemos ajustado los parámetros correctos con algunas dependencias necesarias, aunque son modificables a posteriori.

Para generar el archivo .zip que contiene el proyecto, hay que pulsar el botón *Generate*.

A continuación, abrimos/descargamos el IDE que vayamos a utilizar e importamos el proyecto creado anteriormente. En mi caso, [IntelliJ IDEA](https://www.jetbrains.com/idea/).

![Importing project](../imgs/importing-project.png)

Una vez importado el proyecto, el IDE nos identificará Maven, que es el gestor de paquetes que vamos a utilizar, e instalará todas las dependencias necesarias para la ejecución del proyecto. También añadirá un Servidor Tomcat para lanzar la aplicación y debemos asegurarnos que el JDK es el correcto para evitar errores.
![Project Imported](../imgs/project-imported.png)

## Justificación de lenguajes y frameworks