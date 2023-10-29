# Hito 1 :pushpin:
> Versión 0.0.1

## Contenidos
Los contenidos de este hito serán los siguientes:
- [Historias de usuario](#historias-de-usuario)
- [Milestones](#milestones)
- [Instalación](#instalación)
- [Justificación de lenguajes, frameworks y arquitectura](#justificación-de-lenguajes-frameworks-y-arquitectura)

## Historias de usuario

## Milestones

## Instalación
En primer lugar para llevar a cabo la instalación, hay que dirigirse a la página de [Spring Initializr](https://start.spring.io/), la cual nos permitirá generar la estructura inicial de nuestro proyecto.

![Creating project](../imgs/creating-project.png)

Como se puede apreciar en la anterior imagen, hemos ajustado los parámetros correctos con algunas dependencias necesarias, aunque son modificables a posteriori.

Para generar el archivo .zip que contiene el proyecto, hay que pulsar el botón *Generate*.

A continuación, abrimos/descargamos el IDE que vayamos a utilizar e importamos el proyecto creado anteriormente. En mi caso, [IntelliJ IDEA](https://www.jetbrains.com/idea/).

![Importing project](../imgs/importing-project.png)

Una vez importado el proyecto, el IDE nos identificará Maven, que es el gestor de paquetes que vamos a utilizar, e instalará todas las dependencias necesarias para la ejecución del proyecto. También añadirá un Servidor Tomcat para lanzar la aplicación y debemos asegurarnos que el JDK es el correcto para evitar errores.

![Project Imported](../imgs/project-imported.png)

## Justificación de lenguajes, frameworks y arquitectura
En este apartado se va a justificar la elección de cada lenguaje, framework y arquitectura general del sistema.

### Justificación de lenguajes
En primer lugar, los lenguajes que vamos a utilizar para el desarrollo de este sistema son Java y TypeScript, de forma respectiva para el back-end y el front-end.

La utilización de Java como lenguaje para la implementación del back-end viene dada por ser el lenguaje más usado y popular actualmente. Hay una serie de características fundamentales que le hacen consagrarse en la cúspide:

- **Simplicidad:** Su forma de codificar es limpia y de fácil entendimiento.
- **Compilado e interpretado:** Ofrece el poder de los lenguajes compilados junto con la
flexibilidad que aportan los interpretados.
- **Orientado a objetos:** Facilita la reutilización de código.
- **Robusto:** Un gran manejo de errores en tiempo de ejecución y de las excepciones.

Debido a estas características y a la versatilidad que ofrece para realizar cualquier tipo de aplicación, es la principal herramienta a utilizar para el desarrollo de este proyecto.

Para el desarrollo de la parte frontal del sistema, vamos a utilizar TypeScript. Este lenguaje está construido a un nivel superior de JavaScript. Por tanto ofrece una serie de características adicionales que lo hace más limpio y sólido. El uso de este lenguaje también nos permitirá hacer un código seguro, escalable.

### Justificación de frameworks


### Arquitectura 