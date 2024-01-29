## Integración continua
La **Integración Continua (CI)** es una práctica en el desarrollo de software que implica la integración frecuente de cambios realizados por los desarrolladores en un repositorio compartido. El objetivo principal de la integración continua es detectar y solucionar problemas de integración temprano, mejorando así la calidad del software y reduciendo los riesgos.

En este hito, se toma como objetivo la preparación de nuestro proyecto para la integración continua. Para ello, se han valorado distintas alternativas que sean compatibles con el lenguaje utilizado (Java), que sea sencillo de implementar y que ofrezca la rapidez necesaria a la hora de ejecución de los test.

Las distintas alternativas tomadas en consideración para implementar un proceso de CI son las siguientes:

- [Jenkins](#jenkins)
- [Travis CI](#travis-ci)
- [Circle CI](#circle-ci)
- [GitHub Actions](#github-actions)

### Jenkins
Esta herramienta permite la automatización de código abierto para la integración continua en el desarrollo de software. Su principal objetivo es automatizar los procesos repetitibos en el ciclo de vida del desarrollo de software, permitiendo la construcción, prueba y despliegue automáticos de aplicaciones.

Jenkins es versátil y puede integrarse con una amplia gama de tecnologías y lenguajes de programación, incluye Java, que es en el lenguaje que nos interesa principalmente. También permite la integración con GitHub a través de plugings.

A pesar de estas ventajas, se ha optado por otra herramienta que posee una curva de aprendizaje más suavizada y no es necesario lidiar con los problemas que pueden generar los plugins.

### Travis CI
Travis CI es un servicio de Integración Continua (CI) en la nube que se integra con repositorios alojados en plataformas como GitHub. Su principal función es automatizar el proceso de construcción y prueba de software cada vez que se realizan cambios en el repositorio.

La configuración de este servicio se hace mediante archivos YAML, que simplifica la definición de flujos de trabajo. Al igual que Jenkins, ofrece una gran versátilidad y además proporciona notificaciones en tiempo real sobre las construcciones.

Es una herramienta bastante potente, pero tampoco va a ser elegido como el sistema implementado ya que es un servicio de pago y el plan gratuito tiene ciertas limitaciones que no benefician a la implementación de integración continua sobre este proyecto.

### Circle CI
Circle CI es un servicio de Integración Continua (CI) y despliegue continuo (CD) en la nube que permite a los equipos automatizar el proceso de construcción, prueba y despliegue de sus aplicaciones.

Al igual que Travis CI, la configuración de flujos de trabajo ser realiza a través de archivos YAML en el repositorio, que nos permite una forma sencilla y estructurada de definir las tareas de construcción y despliegue. Como las anteriores mostradas, ofrece un soporte multiplataforma extenso junto con la integración sencilla de GitHub.

Este será el primer sistema CI que utilizaremos porque además de ser sencillo, con fácil integración y eficiente, ofrece una característica que el resto no ofrecen, la cual son los "orbs" que son paquetes reutilizables de configuración que simplifican la implementación de tareas comunes y mejoran la modularidad del trabajo.

Para comenzar con la implementación de Circle CI, debemos registrarnos en el servicio y realizar la conexión con el repositorio de GitHub que contiene nuestro proyecto.



### GitHub Actions

