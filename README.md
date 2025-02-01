# REST Sandbox Project for Spring Boot

## Reference

[John Ngai. "Tutorial: Spring Web and PostgreSQL". GitHub.](https://github.com/john-ngai/spring-web-postgres-tutorial/)

## Dependencies

- JDK 17
- Docker or Podman

## Getting Started

If using Podman, replace all `docker` keywords with `podman`.

### PostgreSQL Database

1. Download the latest postgres image:

   ```shell
   docker pull postgres
   ```

2. Create and run the postgres container:

   ```shell
   docker run --name spring-boot-sandbox-rest-db -e POSTGRES_PASSWORD=password -e PGPORT=6410 -p 6410:6410 -d postgres
   ```

3. Connect to the postgres server:

   ```shell
   docker exec -it spring-boot-sandbox-rest-db psql -U postgres
   ```

4. Create the new database:

   ```psl
   CREATE DATABASE sandboxrestdb OWNER postgres;
   ```

5. Connect to the database:

   ```psql
   \c sandboxrestdb
   ```

### Spring Boot Web Service

1. From another terminal, start the web service using:

   ```shell
   mvn spring-boot:run
   ```

2. Test the connection by sending a GET request using curl:

   ```shell
   curl -s localhost:8100/employees
   ```

3. Create an employee by sending a POST request:

   ```shell
   curl -s -X POST localhost:8100/employee \
   -H "Content-Type: application/json" \
   -d '{"firstName": "foo", "lastName": "bar", "dateOfBirth": "2023-05-04"}'
   ```

4. Verify using curl:

   ```shell
   curl -s localhost:8100/employees
   ```

5. Switch to the postgres terminal and verify again using psql:

   ```psql
   SELECT * FROM employees;
   ```
