# Práctica 6: Facturas

## Funciones

1. Guardar personas fiscales
2. Guardar datos fiscales del usuario.
3. Modificar datos de personas fiscales
4. Guardar factura recibida
5. Borrar factura recibida
6. Emitir factura
7. Cancelar factura emitida
8. Listar facturas recibidas de un año-mes específico
9. Listar facturas emitidas de un año-mes específico
10. Consultar factura(detalle) por su identificador fiscal

## Objetos

**1. Persona fiscal:**

- Nombre
- Apellido
- RFC
- Dirección fiscal
- Email
- EsPersonaMoral (bool)

> NOTA: Si una persona fiscal es *personaMoral* sólo tiene nombre, no apellido.

**2. Factura:**

- Concepto
- Monto
- IVA
- Monto total
- Identificador fiscal GUID/UUID
- Fecha
- RFC

**3. RFC:**

- RFC:
  - Nombre completo del emisor
  - Dirección fiscal emisor
  - Email emisor
  - Tipo(emisor/receptor)
