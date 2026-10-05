# ahk-delivery-catalog-svc

Catálogo de restaurantes y menús. Guarda los restaurantes con su menú embebido en MongoDB. Lo consulta `order-svc` para validar los platos de un pedido.

Forma parte de la maqueta de delivery **ahk-delivery**. La arquitectura, los requisitos del sistema y cómo levantar todo con Docker Compose están en [ahk-delivery-infra](https://github.com/ezequieljsosa/ahk-delivery-infra).

- **Stack:** Java 21, Spring Boot 4.1, Spring Data MongoDB
- **Datos:** MongoDB (base `catalog`)
- **Imagen:** `ezequieljsosa/ahk-delivery-catalog-svc`

## API

| Método | Ruta | Descripción |
|---|---|---|
| GET | `/restaurants` | Lista los restaurantes |
| GET | `/restaurants/{id}` | Un restaurante con su menú (404 si no existe) |
| POST | `/restaurants` | Da de alta un restaurante |

## Ejecutar localmente

Dependencias: MongoDB: `docker run -d -p 27017:27017 mongo:7`.

Configuración (variables de entorno): `MONGO_URI` (default `mongodb://localhost:27017/catalog`).

```bash
./mvnw spring-boot:run
```

El servicio escucha en el puerto **8081**.

Imagen de Docker:

```bash
docker build -t ezequieljsosa/ahk-delivery-catalog-svc .
```

## Specs

Las features están descritas en [`specs/`](specs/README.md) (desarrollo guiado por specs). Las marcadas *Propuesto* son tareas para los alumnos.

## Calidad de código

```bash
pre-commit install                                  # una sola vez: los hooks corren en cada commit
pre-commit run --all-files                          # formato + análisis estático
mvn checkstyle:check pmd:check spotbugs:check       # solo el análisis estático
```

Necesita un JDK 21 declarado en `~/.m2/toolchains.xml` (plugin de toolchains).

## Licencia

[MIT](LICENSE)
