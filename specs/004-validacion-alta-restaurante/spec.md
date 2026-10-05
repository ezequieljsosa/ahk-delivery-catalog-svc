# 004 · Validar el alta de restaurantes

- **Estado:** Propuesto
- **Servicio:** catalog-svc
- **Requisitos de sistema:** RS-04

## Historia de usuario

Como administrador, quiero que el alta rechace datos inválidos, para no tener restaurantes que rompan los pedidos.

## Requisitos funcionales

- **RF-1** `name` obligatorio y no vacío.
- **RF-2** `lat` entre -90 y 90, `lon` entre -180 y 180.
- **RF-3** `prepMinutes` mayor que 0.
- **RF-4** El menú no puede estar vacío, los `sku` no se repiten y `price` es mayor que 0.
- **RF-5** Ante un body inválido responde 400 con un mensaje que indique qué campo falla.

## Escenarios de aceptación

1. **Dado** un restaurante sin nombre, **cuando** se hace `POST`, **entonces** responde 400 y no se guarda.
2. **Dado** un menú con dos platos con el mismo `sku`, **cuando** se hace `POST`, **entonces** responde 400.

## Fuera de alcance / notas

- Pista: `spring-boot-starter-validation`, anotaciones en el record y un `@RestControllerAdvice` para el formato del error.
