## Diseño general API REST
### Arquitecura
Para el diseño de la API REST, nos hemos decantado por utilizar la **Arquitectura Hexagonal** ya que la he utilizado para otros sistemas y creo que es la mejor opción para este desarrollo.

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

### Endpoints