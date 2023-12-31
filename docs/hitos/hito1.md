# Hito 1 :pushpin:
> Versión 1.0.0

## Contenidos
Los contenidos de este hito serán los siguientes:
- [Historias de usuario](#historias-de-usuario)
- [Milestones](#milestones)
- [Instalación](#instalación)
- [Justificación de lenguajes y frameworks](#justificación-de-lenguajes-y-frameworks)
- [Arquitecturas](#arquitecturas)
- [Estructura Inicial](#estructura-inicial)

## Historias de usuario
A continuación, se detallan las historias de usuario definidas:
- [HU-1. Organizador de jugadores ](https://github.com/Josejc2001/MUII_CC-23-24/issues/1)
- [HU-2. Gestor de ligas ](https://github.com/Josejc2001/MUII_CC-23-24/issues/2)
- [HU-3. Visualización de plantilla ](https://github.com/Josejc2001/MUII_CC-23-24/issues/3)
- [HU-4. Autenticación de usuarios](https://github.com/Josejc2001/MUII_CC-23-24/issues/4)
- [HU-5. Seguimiento de clasificación](https://github.com/Josejc2001/MUII_CC-23-24/issues/5)

## Milestones
El proyecto se ha planificado mediante el establecimiento de los siguientes milestones o hitos:
- [Hito 1: Definición y creación del proyecto](https://github.com/Josejc2001/MUII_CC-23-24/milestone/1)
- [Hito 2: Gestión de jugadores](https://github.com/Josejc2001/MUII_CC-23-24/milestone/2)
- [Hito 3: Gestión de ligas](https://github.com/Josejc2001/MUII_CC-23-24/milestone/3)
- [Hito 4: Identificación de los usuarios](https://github.com/Josejc2001/MUII_CC-23-24/milestone/4)
- [Hito 5: Evolución de la clasificación](https://github.com/Josejc2001/MUII_CC-23-24/milestone/5)
- [Hito 6: Seguimiento noticias del mundo del fútbol](https://github.com/Josejc2001/MUII_CC-23-24/milestone/6)

## Instalación
En primer lugar para llevar a cabo la instalación, hay que dirigirse a la página de [Spring Initializr](https://start.spring.io/), la cual nos permitirá generar la estructura inicial de nuestro proyecto del lado del servidor (back-end).

![Creating project](../imgs/creating-project.png)

Como se puede apreciar en la anterior imagen, hemos ajustado los parámetros correctos con algunas dependencias necesarias, aunque son modificables a posteriori.

Para generar el archivo .zip que contiene el proyecto, hay que pulsar el botón *Generate*.

A continuación, abrimos/descargamos el IDE que vayamos a utilizar e importamos el proyecto creado anteriormente. En mi caso, [IntelliJ IDEA](https://www.jetbrains.com/idea/).

![Importing project](../imgs/importing-project.png)

Una vez importado el proyecto, el IDE nos identificará Maven, que es el gestor de paquetes que vamos a utilizar, e instalará todas las dependencias necesarias para la ejecución del proyecto. También añadirá un Servidor Tomcat para lanzar la aplicación y debemos asegurarnos que el JDK es el correcto para evitar errores.

![Project Imported](../imgs/project-imported.png)

A continuación, vamos a llevar a cabo la instalación de todo el software necesario para la implementación del front-end del sistema.

Para comenzar, necesitaremos tener instalado [Node.js](https://nodejs.org/en). En esta página, se puede descargar de forma sencilla.

Una vez descargado, pasamos a la instalación de [Angular CLI](https://angular.io/guide/setup-local) para crear los proyectos, generar aplicaciones y librerias de código. Será necesario introducir el siguiente comando para realizar la instalación.
```
npm install -g @angular/cli
```
Solo queda crear nuestro proyecto introduciendo el siguiente comando.
```
ng new frontend
```
Si el proceso de instalación ha ido como se esperaba, debemos tener en nuestro IDE la siguiente estructura de carpetas.

![Project Imported Frontend](../imgs/project-imported-frontent.png)

## Justificación de lenguajes y frameworks
En este apartado se va a justificar la elección de cada lenguaje, framework y arquitectura general del sistema.

### Justificación de lenguajes
En primer lugar, los lenguajes que vamos a utilizar para el desarrollo de este sistema son [Java](https://www.java.com/es/) y [TypeScript](https://www.typescriptlang.org/), de forma respectiva para el back-end y el front-end.

La utilización de Java como lenguaje para la implementación del back-end viene dada por ser el lenguaje más usado y popular actualmente. Hay una serie de características fundamentales que le hacen consagrarse en la cúspide:

- **Simplicidad:** Su forma de codificar es limpia y de fácil entendimiento.
- **Compilado e interpretado:** Ofrece el poder de los lenguajes compilados junto con la
flexibilidad que aportan los interpretados.
- **Orientado a objetos:** Facilita la reutilización de código.
- **Robusto:** Un gran manejo de errores en tiempo de ejecución y de las excepciones.

Debido a estas características y a la versatilidad que ofrece para realizar cualquier tipo de aplicación, es la principal herramienta a utilizar para el desarrollo de este proyecto.

Para el desarrollo de la parte frontal del sistema, vamos a utilizar TypeScript. Este lenguaje está construido a un nivel superior de JavaScript. Por tanto ofrece una serie de características adicionales que lo hace más limpio y sólido. El uso de este lenguaje también nos permitirá hacer un código seguro, escalable.

### Justificación de frameworks
En cuanto a los frameworks que vamos a utilizar para el desarrollo de Royal Fantasy, tenemos [Spring](https://spring.io/) para la implementación del backend junto con el lenguaje Java, anteriormente mencionado, y [Angular](https://angular.io/) para el desarrollo del front-end.

Con respecto a Spring, es un framework desarrollado para el trabajo con Java como lenguaje de programación. Está en pleno crecimiento de popularidad ya que hay muchos desarrolladores que lo usan para el backend de sus proyectos. Además es una herramienta que busca que los programadores se centren más en el propio código que en cualquier paso de configuración y/o despliegue.

En cuanto a la configuración, ofrece la posibilidad de definir las necesidades del proyecto que quieres realizar durante el proceso de inicialización, mediante las dependencias de iniciador también llamadas Spring Starters.

Junto con la facilidad de configuración y que está basado en Java, se convierte en la herramienta ideal para implementar el back-end de este sistema.

Por otro lado, Angular junto con el lenguaje en el que se basa, TypeScript, ofrecen un rápido y eficiente proceso de desarrollo, compatibilidad de navegadores y sistemas
operativos y modularidad.

Además, es un sistema que posee enlace bidireccional de datos, directivas, pruebas junto con un futuro próspero, debido a su funcionalidad y popularidad.

## Arquitecturas
Para el diseño de este sistema, se van a utilizar dos arquitecturas muy conocidas las cuales vienen detalladas a posteriori.

### Arquitectura Hexagonal
Para el diseño del back-end, nos hemos decantado por utilizar la **Arquitectura Hexagonal** ya que la he utilizado para otros sistemas y creo que es la mejor opción para este desarrollo.

Esta arquitectura propone dividir el sistema en diversas capas, las cuales tendrán su propia responsabilidad junto con una evolución aislada y facilidad de testear.

Para lograr esta independencia entre las capas surgen dos conceptos importantes, que también dan nombre a esta arquitectura diseñada por Alistair Cockburn, y son los puertos y adaptadores. Un **puerto** se define como el punto de entrada y salida de la aplicación, mientras que un **adaptador** es el que implementa la conexión con el puerto y otros servicios.

Podemos diferenciar entre dos clases de puertos y adaptadores: primarios y secundarios. Los primarios son aquellos en los que el usuario desencadena su acción, es decir, mediante una interfaz de usuario, se realiza una solicitud al sistema. En cuanto a los puertos y adaptadores secundarios, son los responsables de atender peticiones del sistema.

A continuación, se muestra un diagrama que representa los puertos y adaptadores primarios y secundarios que puede tener un sistema junto con sus tres capas fundamentales explicadas seguidamente.

![Arquitectura Hexagonal](../imgs/arquitectura-hexagonal.png)

Como se puede apreciar en el diagrama hexagonal, tenemos tres capas claramente
diferenciadas:

- **Capa de dominio:** Es la capa central del hexágono y su función es alojar la lógica de negocio. En ella se encuentran los modelos de datos y sus restricciones. Esta capa es independiente del resto de capas y de las tecnologías utilizadas. Su forma de comunicación es a través de las interfaces definidas en ella.
- **Capa de aplicación:** Por encima de la capa de dominio se encuentra la capa de aplicación, en la cual se encuentra la lógica de la aplicación. Se coordinan las acciones y los servicios del dominio con el objetivo de cumplir con casos de uso específicos.
- **Capa de infraestructura:** Es la capa más exterior del hexágono y es en la que se hallan las implementaciones o adaptaciones de los puertos de las demás capas. Los adaptadores son los encargados de conectar la lógica de negocio y de la aplicación con los servicios externos a nuestra aplicación. En el caso de mi implementación, aquí se encuentran el servicio REST, la base de datos y algunos archivos de configuración que permiten el correcto funcionamiento de los frameworks.
- **Capa de puertos:** Como ya se ha mencionado anteriormente, esta capa define las interfaces a través de las cuáles el sistema se comunica con el exterior.

> Este resumen de la arquitectura hexagonal ha sido previamente mencionado en mi TFG: Sistema de Control de Autoridades en datos bibliométricos.

### Arquitectura MVC
Angular, el framework que utilizaremos para la implementación del front-end, utiliza la **Arquitectura MVC** o también conocida como Arquitectura Modelo-Vista-Controlador. Esta arquitectura es muy utilizada para el desarrollo de aplicaciones web y consta de las siguientes partes:

- **Modelo:** Parte donde se encuentra la lógica de negocio de la aplicación, es decir, las reglas de negocio que determinan como la información va a ser creada, almacenada o modificada.
- **Vista:** Esta parte contiene la visualización de la interfaz de usuario. Requiere de la información que ofrece el modelo para expresarla como salida.
- **Controlador:** Controla y decide como se deben mostrar los datos, haciendo de intermediario entre el modelo y la vista.

![MVC](../imgs/mvc.png)
> La imagen ha sido extraida de la siguiente página: https://www.linkedin.com/pulse/modelo-vista-controlador-precognis/?originalSubdomain=es

## Estructura Inicial
En este apartado, se explica la estructura inicial de clases del proyecto:
- **Jugador:** Esta [clase](../../backend/src/main/java/com/royalfantasy/backend/domain/model/Player.java) guarda la información relativa a un futbolista en concreto, junto con sus funcionalidades. La explicación de cada atributo a continuación:
    - *Id:* Identificador único de jugador. Permite identificar unívocamente los jugadores del sistema.
    - *Nombre:* Nombre del jugador.
    - *Posición:* Posición que ocupa en el terreno de juego el jugador.
    - *Edad:* Edad del jugador.
    - *Altura:* Altura del jugador (en metros).
    - *Peso:* Peso del jugador (en kilogramos).
    - *Valor:* Valor de mercado del jugador (en millones).
    - *Cláusula*: Cláusula de rescisión del jugador (en millones).
    - *Puntos*: Puntos que lleva el jugador.
