## Avance del código Hito 2 :climbing:
### Tareas desarrolladas
En este hito se han llevado a cabo las siguientes tareas de desarrollo (referenciadas a su correpondiente issue):
- Conexión del backend con la base de datos MySql [#14](https://github.com/Josejc2001/MUII_CC-23-24/issues/14)
- Implementación de la capa de dominio de los jugadores [#15](https://github.com/Josejc2001/MUII_CC-23-24/issues/15)
- Implementación de la capa de aplicación de los jugadores [#16](https://github.com/Josejc2001/MUII_CC-23-24/issues/16)
- Implementación de la capa de puertos de los jugadores [#17](https://github.com/Josejc2001/MUII_CC-23-24/issues/17)
- Implementación de la capa de infraestructura de los jugadores [#18](https://github.com/Josejc2001/MUII_CC-23-24/issues/18)

Estas tareas se han implementado siguiendo la metodología TDD, anteriormente explicada, generando así unos ficheros de Test disponibles [aquí](../../backend/src/test/java/com/royalfantasy/backend/).

Dando lugar también a la finalización del [Hito 2: Gestión de jugadores](https://github.com/Josejc2001/MUII_CC-23-24/milestone/2) y la [[HU-1] Organizador de jugadores](https://github.com/Josejc2001/MUII_CC-23-24/issues/1).

### Endpoints
Se han definido, como resultado de crear las operaciones CRUD de los jugadores, una serie de endpoints, disponibles a continuación.

- [Añadir Jugador](#end-point-añadir-jugador)
- [Consultar jugadores](#end-point-consultar-jugadores)
- [Consultar jugador](#end-point-consultar-jugador)
- [Modificar jugador](#end-point-modificar-jugador)
- [Borrar jugador](#end-point-borrar-jugador)

#### End-point: Añadir jugador

##### Método: POST
>```
>http://localhost:8080/api/players
>```
##### Body Petición
``` json
{
    "name": "Joselito",
    "position": "MC",
    "age": 22,
    "height": 1.72,
    "weight": 65.3,
    "value": 15000000,
    "clause": 30000000,
    "points": 50,
    "team": "Real Madrid CF"
}
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
#### End-point: Consultar jugadores

##### Método: GET
>```
>http://localhost:8080/api/players
>```
##### Respuesta
``` json
{
    "playersRetrieveByIdResponse": [
        {
            "id": 1,
            "name": "Joselito",
            "position": "MC",
            "age": 22,
            "height": 1.72,
            "weight": 65.3,
            "value": 15000000,
            "clause": 30000000,
            "points": 50,
            "team": "Real Madrid CF"
        }
    ]
}
```
⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
### End-point: Consultar jugador

#### Método: GET
>```
>http://localhost:8080/api/players/{playerId}
>playerId es de tipo Long
>```
#### Respuesta
``` json
{
    "id": 1,
    "name": "Joselito",
    "position": "MC",
    "age": 22,
    "height": 1.72,
    "weight": 65.3,
    "value": 15000000,
    "clause": 30000000,
    "points": 50,
    "team": "Real Madrid CF"
}
```
⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
#### End-point: Modificar jugador

##### Método: PATCH
>```
>http://localhost:8080/api/players/{playerId}
>playerId es de tipo Long
>```
##### Body Petición
``` json
{
    "name": "Joselito Modificado",
    "position": "DC",
    "age": 22,
    "height": 1.72,
    "weight": 65.3,
    "value": 15000000,
    "clause": 30000000,
    "points": 50,
    "team": "Real Madrid CF"
}
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
#### End-point: Borrar jugador

##### Método: DELETE
>```
>http://localhost:8080/api/players/{playerId}
>playerId es de tipo Long
>```