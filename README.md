# Arquitectura hexagonal  — Java 11
- Endpoint demo: `GET /prices/apply?brandId=1&productId=35455&applicationDate=2020-06-14T16:00:00`

## Aviso
Faltaría agregar:

* Trazas
* Seguridad

Build & Run:
```
mvn -q clean install
cd bootstrap
mvn spring-boot:run
```

### Precio el 14/06/2020 a las 10:00

```
- Bash
curl "http://localhost:8080/prices/apply?brandId=1&productId=35455&applicationDate=2020-06-14T10:00:00"

- PowerShell
Invoke-RestMethod "http://localhost:8080/prices/apply?brandId=1&productId=35455&applicationDate=2020-06-14T10:00:00"
```

### Precio el 14/06/2020 a las 16:00

```
- Bash
curl "http://localhost:8080/prices/apply?brandId=1&productId=35455&applicationDate=2020-06-14T16:00:00"

- PowerShell
Invoke-RestMethod "http://localhost:8080/prices/apply?brandId=1&productId=35455&applicationDate=2020-06-14T16:00:00"
```

### Precio el 14/06/2020 a las 21:00

```
- Bash
curl "http://localhost:8080/prices/apply?brandId=1&productId=35455&applicationDate=2020-06-14T10:00:00"

- PowerShell
Invoke-RestMethod "http://localhost:8080/prices/apply?brandId=1&productId=35455&applicationDate=2020-06-14T21:00:00"
```

### Precio el 15/06/2020 a las 10:00

```
- Bash
curl "http://localhost:8080/prices/apply?brandId=1&productId=35455&applicationDate=2020-06-15T10:00:00"

- PowerShell
Invoke-RestMethod "http://localhost:8080/prices/apply?brandId=1&productId=35455&applicationDate=2020-06-15T10:00:00"
```

### Precio el 16/06/2020 a las 21:00

```
- Bash
curl "http://localhost:8080/prices/apply?brandId=1&productId=35455&applicationDate=2020-06-16T21:00:00"

- PowerShell
Invoke-RestMethod "http://localhost:8080/prices/apply?brandId=1&productId=35455&applicationDate=2020-06-16T21:00:00"
```
