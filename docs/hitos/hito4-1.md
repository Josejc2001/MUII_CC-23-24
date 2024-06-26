## Integración continua
La **Integración Continua (CI)** es una práctica en el desarrollo de software que implica la integración frecuente de cambios realizados por los desarrolladores en un repositorio compartido. El objetivo principal de la integración continua es detectar y solucionar problemas de integración temprano, mejorando así la calidad del software y reduciendo los riesgos.

En este hito, se toma como objetivo la preparación de nuestro proyecto para la integración continua. Para ello, se han valorado distintas alternativas que sean compatibles con el lenguaje utilizado (Java), que sea sencillo de implementar y que ofrezca la rapidez necesaria a la hora de ejecución de los test.

Las distintas alternativas tomadas en consideración para implementar un proceso de CI son las siguientes:

- [Jenkins](#jenkins)
- [Travis CI](#travis-ci)
- [Circle CI](#circle-ci)
- [GitHub Actions](#github-actions)

### Jenkins
**Jenkins** permite la automatización de código abierto para la integración continua en el desarrollo de software. Su principal objetivo es automatizar los procesos repetitibos en el ciclo de vida del desarrollo de software, permitiendo la construcción, prueba y despliegue automáticos de aplicaciones.

Jenkins es versátil y puede integrarse con una amplia gama de tecnologías y lenguajes de programación, incluye Java, que es en el lenguaje que nos interesa principalmente. También permite la integración con GitHub a través de plugings.

A pesar de estas ventajas, se ha optado por otra herramienta que posee una curva de aprendizaje más suavizada y no es necesario lidiar con los problemas que pueden generar los plugins.

### Travis CI
**Travis CI** es un servicio de Integración Continua (CI) en la nube que se integra con repositorios alojados en plataformas como GitHub. Su principal función es automatizar el proceso de construcción y prueba de software cada vez que se realizan cambios en el repositorio.

La configuración de este servicio se hace mediante archivos YAML, que simplifica la definición de flujos de trabajo. Al igual que Jenkins, ofrece una gran versátilidad y además proporciona notificaciones en tiempo real sobre las construcciones.

Es una herramienta bastante potente, pero tampoco va a ser elegido como el sistema implementado ya que es un servicio de pago y el plan gratuito tiene ciertas limitaciones que no benefician a la implementación de integración continua sobre este proyecto.

### Circle CI
**Circle CI** es un servicio de Integración Continua (CI) y despliegue continuo (CD) en la nube que permite a los equipos automatizar el proceso de construcción, prueba y despliegue de sus aplicaciones.

Al igual que Travis CI, la configuración de flujos de trabajo ser realiza a través de archivos YAML en el repositorio, que nos permite una forma sencilla y estructurada de definir las tareas de construcción y despliegue. Como las anteriores mostradas, ofrece un soporte multiplataforma extenso junto con la integración sencilla de GitHub.

Este será el primer sistema CI que utilizaremos porque además de ser sencillo, con fácil integración y eficiente, ofrece una característica que el resto no ofrecen, la cual son los "orbs" que son paquetes reutilizables de configuración que simplifican la implementación de tareas comunes y mejoran la modularidad del trabajo.

Para comenzar con la implementación de Circle CI, debemos registrarnos en el servicio y realizar la conexión con el repositorio de GitHub que contiene nuestro proyecto.

Para que esta conexión se haga correctamente hemos creado un fichero llamado **config.yml** , disponible a continuación. A este fichero también se puede acceder pulsando [aqui](../../.circleci/config.yml).

```
version: 2.1

jobs:
  test:
    docker:
      - image: josejc01/contenedor-test-alpine:latest
    steps:
      - checkout
      - run: cd backend && chmod +x mvnw
      - run: cd backend && ./mvnw test
workflows:
  run_test:
    jobs:
      - test
```
Este fichero se compone del trabajo que se realiza cada vez que se realiza un push en cualquier rama. Primero se obtiene la imagen que queremos emplear, disponible en DockerHub. Después, se llevan a cabo los pasos específicados en el fichero como **steps**. Los pasos son hacer checkout, ejecutar el primer comando deseado que nos permitirá darle permisos de ejecución al fichero que nos interesa y ejecutar el segundo comando para ejecutar los tests.

Como podremos apreciar en las siguientes imágenes, se ha conseguido el objetivo de ejecutar los tests cada vez que realizamos cambios en el repositorio.

![circle-ci-workflows](../imgs/circle-ci-1.png)

![circle-ci-test](../imgs/circle-ci-2.png)

A modo de curiosidad, para evitar cargar este mecanismo en cada commit que hagamos en nuestro repositorio, existe la opción **[skip ci]** la cual nos permite no ejecutar este sistema de integración continua.

![skip-circle-ci](../imgs/skip-circleci.png)

### GitHub Actions
Para complementar la herramienta anterior, se ha usado **GitHub Actions** como servicio de integración continua y entrega continua integrado directamente en la plataforma GitHub.

La configuración de esta herramienta se hace mediante archivos YAML, donde se definen los flujos de trabajo. Como ventaja de usar esta herramienta, es el marketplace que ofrece donde podemos encontrar una serie de acciones predefinidas y personalizadas creadas por la comunidad.

En el hito anterior ya usamos esta herramienta para automatizar la subida del contenedor de pruebas a DockerHub y a GitHub Container Registry. El objetivo de usarla en este hito es que nos permita, además de seguir con las buenas prácticas del hito anterior, tener un control total del proceso de integración continua.

Para ello, se ha definido el workflow que se puede ver a continuación o pulsando [aquí](../../.github/workflows/github-actions.yml).

```
name: Run Tests

on:
  workflow_run:
    workflows: ["GitHub Container Registry"]
    branches: [main]
    types:
      - completed

jobs:
  run_test:
    runs-on: ubuntu-latest
    if: ${{ github.event.workflow_run.conclusion == 'success' }}
    steps:
      - uses: actions/checkout@v2
      - name: Lanzar Tests CI
        run:
          docker run -t -v `pwd`:/app/test josejc01/contenedor-test-alpine
```

Este fichero se ha hecho de forma similar a los anteriores, lo único que se ha hecho que el workflow de lanzar los tests depende de la action que nos permite subir el contenedor a DockerHub y a GitHub Container Registry.

Y solo será ejecutada esta actión de lanzar los test, en el caso de que la subida del contenedor de pruebas se haya hecho correctamente, como buena práctica.

![run-test-gha](../imgs/run-test-gha.png)

