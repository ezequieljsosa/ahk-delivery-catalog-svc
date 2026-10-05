# 001 · Consultar el catálogo de restaurantes

- **Estado:** Implementado
- **Servicio:** catalog-svc
- **Requisitos de sistema:** RS-01, RS-04

## Historia de usuario

Como servicio de pedidos, quiero consultar un restaurante con su menú, para validar los platos de un pedido y conocer su ubicación y tiempo de preparación.

## Requisitos funcionales

- **RF-1** `GET /restaurants` devuelve todos los restaurantes, cada uno con su menú embebido.
- **RF-2** `GET /restaurants/{id}` devuelve un restaurante: `id`, `name`, `lat`, `lon`, `prepMinutes` y `menu` (lista de `sku`, `name`, `price`).
- **RF-3** Si el `id` no existe, responde 404.

## Escenarios de aceptación

1. **Dado** que hay datos iniciales, **cuando** se pide `GET /restaurants`, **entonces** responde 200 con al menos 3 restaurantes.
2. **Dado** el restaurante `rest-pizza`, **cuando** se pide `GET /restaurants/rest-pizza`, **entonces** responde 200 con su menú y `prepMinutes = 15`.
3. **Dado** un id inexistente, **cuando** se pide `GET /restaurants/nope`, **entonces** responde 404.

## Fuera de alcance / notas

- Persistencia: colección `restaurants` de MongoDB; el menú vive dentro del documento.
