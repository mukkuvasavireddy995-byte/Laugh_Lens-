# LaughLens 📸😂

Funny Camera full-stack application using Java 17, Spring Boot, JDBC/JdbcTemplate, H2, HTML, CSS and vanilla JavaScript.

## Run
1. Extract the ZIP.
2. Open the `LaughLens` folder in IntelliJ IDEA.
3. Use Java 17 and let Maven download dependencies.
4. Run `src/main/java/com/laughlens/LaughLensApplication.java`.
5. Open `http://localhost:8080`.

Terminal:
```bash
mvn spring-boot:run
```

Build:
```bash
mvn clean package
java -jar target/laughlens-1.0.0.jar
```

## JDBC + H2
JDBC URL:
`jdbc:h2:file:./data/laughlens;AUTO_SERVER=TRUE`

H2 console:
`http://localhost:8080/h2-console`

User: `sa`
Password: empty

The project uses Spring `JdbcTemplate`; it does not use JPA/Hibernate.

## API
`GET /api/effects`
`GET /api/snapshots`
`POST /api/snapshots`

Example POST:
```json
{"nickname":"Harsha","effectCode":"party","caption":"Too much fun!"}
```

## Camera
Allow browser camera permission. The live camera stays in the browser; only nickname/effect/caption/timestamp are stored in H2. Public deployment should use HTTPS for camera access.

## Structure
```text
LaughLens/
├── pom.xml
├── README.md
├── database/laughlens.sql
└── src/
    ├── main/java/com/laughlens/
    │   ├── LaughLensApplication.java
    │   ├── controller/ApiController.java
    │   ├── model/Effect.java
    │   ├── model/Snapshot.java
    │   └── repository/EffectRepository.java
    │       repository/SnapshotRepository.java
    └── main/resources/
        ├── application.properties
        ├── schema.sql
        ├── data.sql
        └── static/
            ├── index.html
            ├── style.css
            └── app.js
```
