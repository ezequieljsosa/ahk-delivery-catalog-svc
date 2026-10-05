# 003 · Datos iniciales

- **Estado:** Implementado
- **Servicio:** catalog-svc
- **Requisitos de sistema:** RS-10

## Historia de usuario

Como docente, quiero que el catálogo arranque con restaurantes de ejemplo, para poder hacer pedidos sin cargar nada a mano.

## Requisitos funcionales

- **RF-1** Al arrancar, si la colección está vacía, se cargan tres restaurantes: `rest-pizza` (prep 15), `rest-sushi` (prep 25) y `rest-parrilla` (prep 30), con 2 o 3 platos cada uno.
- **RF-2** Si la colección ya tiene datos, no se agrega ni modifica nada.

## Escenarios de aceptación

1. **Dado** una base vacía, **cuando** arranca el servicio, **entonces** existen los 3 restaurantes.
2. **Dado** una base con datos, **cuando** se reinicia el servicio, **entonces** no se duplican restaurantes.
