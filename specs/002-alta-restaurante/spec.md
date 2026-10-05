# 002 · Dar de alta un restaurante

- **Estado:** Implementado
- **Servicio:** catalog-svc
- **Requisitos de sistema:** RS-10

## Historia de usuario

Como administrador, quiero agregar un restaurante con su menú, para que pueda recibir pedidos.

## Requisitos funcionales

- **RF-1** `POST /restaurants` guarda el documento recibido y responde 201 con el restaurante guardado.
- **RF-2** Si el body no trae `id`, Mongo genera uno. Si trae un `id` que ya existe, el documento se reemplaza (comportamiento de `save`).

## Escenarios de aceptación

1. **Dado** un restaurante sin `id`, **cuando** se hace `POST /restaurants`, **entonces** responde 201 con un `id` generado y el restaurante queda disponible en `GET /restaurants/{id}`.
2. **Dado** un restaurante con `id` ya existente, **cuando** se hace `POST`, **entonces** el documento anterior queda reemplazado.

## Contrato

```http
POST /restaurants
{"name": "Heladería Polo", "lat": -34.6, "lon": -58.4, "prepMinutes": 10,
 "menu": [{"sku": "HELADO-1K", "name": "1 kg de helado", "price": 12000}]}
```

## Fuera de alcance / notas

- Hoy no se valida nada (campos vacíos, precios negativos, skus repetidos). Ver 004.
