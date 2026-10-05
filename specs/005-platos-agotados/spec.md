# 005 · Marcar platos como agotados

- **Estado:** Propuesto
- **Servicio:** catalog-svc
- **Requisitos de sistema:** RS-04

## Historia de usuario

Como restaurante, quiero marcar un plato como agotado, para no recibir pedidos que no puedo cumplir.

## Requisitos funcionales

- **RF-1** Cada plato tiene un campo `available` (por defecto `true`).
- **RF-2** `PUT /restaurants/{id}/menu/{sku}/availability` con `{"available": false}` actualiza el plato; 404 si el restaurante o el plato no existen.
- **RF-3** `order-svc` rechaza con 400 los pedidos que incluyan platos no disponibles (cambio coordinado: ver spec 007 de `order-svc`).

## Escenarios de aceptación

1. **Dado** un plato agotado, **cuando** se consulta el restaurante, **entonces** el plato figura con `available = false`.
2. **Dado** un plato agotado, **cuando** se crea un pedido que lo incluye, **entonces** el pedido se rechaza con 400.

## Fuera de alcance / notas

- Es una feature que cruza dos servicios: actualizar también [`docs/requirements.md` de ahk-delivery-infra](https://github.com/ezequieljsosa/ahk-delivery-infra/blob/main/docs/requirements.md).
