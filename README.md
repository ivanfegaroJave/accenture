# accenture

Se desarrolló un MicroServicio con Spring-boot con DB h2 en memoria y JPA para la persistencia de la misma.
Se observa la documentacion de los servicios por medio de la API swagger http://localhost:9086/swagger-ui/index.html#/
se utilizo la interfaz FeignClient para el consumo del cliente.
Junit (MOckito) para pruebas unitarias.
JAcoco Reporte de Pruebas unitarias PAth build/reports/tests/test/index.html
Gradle para repositorio de librerias.
Archivo yml para configuracion en difentes abmientes.


Información del servicio se tiene que poder acceder a través de nuestra API a:
1. Los usuarios.
- La solucion se puede encontrar en el siguiente endPoint
GET http://localhost:9086/api/v1/users/

2. Las fotos.
- La solucion se puede encontrar en el siguiente endPoint
GET http://localhost:9086/api/v1/photos/

3. Los álbumes del sistema y de cada usuario.
- La solucion se puede encontrar en el siguiente endPoint
GET http://localhost:9086/api/v1/albums/albumsByUser/{id}

4. Plus: Las fotos de un usuario.
- La solucion se puede encontrar en el siguiente endPoint
GET http://localhost:9086/api/v1/photos/users/{userId}/photos

Para persistir y consumir esta información nueva el sistema debe permitir:
1. Registrar un álbum compartido con un usuario y sus permisos.
- La solucion se puede encontrar en el siguiente endPoint
POST http://localhost:9086/api/v1/permission/create

2. Cambiar los permisos de un usuario para un álbum determinado.
- La solucion se puede encontrar en el siguiente endPoint
PUT http://localhost:9086/api/v1/permission/{id}

3. Traer todos los usuarios que tienen un permiso determinado respecto a un
álbum específico.
- La solucion se puede encontrar en el siguiente endPoint
GET http://localhost:9086/api/v1/users/albums/{id}/permission

En cuanto a los comentarios, se espera que la aplicación pueda traerlos del
servicio externo brindando la posibilidad de filtrar por el campo “name” o por el
usuario que realizó dicho comentario.
- La solucion se puede encontrar en el siguiente endPoint
GET http://localhost:9086/api/v1/comment/filter

# Despliegue

Gradle build
$ java -jar target/accenture-0.0.1-SNAPSHOT.jar
