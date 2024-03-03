# Práctica 6: Facturas

## Funciones
### Menú principal
1. Datos fiscales de empresa
  * Mostrar datos fiscales
  * Modificar datos fiscales
2. Catálogo de personas fiscales
  * Listar personas fiscales
  * Agregar persona fiscal
  * Modificar persona fiscal
3. Gestión de facturas recibidas
  * Listar facturas recibidas
  * Guardar nueva factura recibida
  * Borrar factura recibida
4. Gestión de facturas emitidas
  * Listar facturas emitidas
  * Guardar nueva factura emitida
  * Cancelar factura emitida
5. Mostrar detalles de factura


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
