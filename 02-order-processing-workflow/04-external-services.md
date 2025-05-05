# **External Services**

To simplify development and let us focus only on the `order-service`, all other supporting services have been packaged into a single executable JAR `external-services.jar`.

Running this JAR will expose mocked API endpoints for:

- `customer-service`
- `product-service`
- `payment-service`
- `billing-service`
- `shipping-service`

These services are **heavily mocked and hardcoded**, and are **not part of the exercise**. They are provided to support integration and allow us to test our `order-service` end-to-end.

## How To Run

- Ensure that you have Java 21 or anything above installed
- Please download [this jar](downloads/external-services.jar)
- Keep the downloaded jar somewhere in your machine
- Open terminal/command line and navigate to the path where you have the jar.
- Run this below command.

```bash
java -jar external-services.jar
```
- It uses port `7070` by default.
- You can access the Swagger-UI using this URL - http://localhost:7070/swagger-ui.html

## Docker

If you do not want to run the jar directly on your machine, You can use docker. Build your image and run by doing the port mapping.
```Dockerfile
FROM bellsoft/liberica-openjdk-alpine:21
WORKDIR app
ADD https://github.com/vinsguru/data-oriented-programming-course/raw/master/02-order-processing-workflow/downloads/external-services.jar external-services.jar
CMD java -jar external-services.jar
```

## To change the port

```bash
java -jar external-services.jar --server.port=8080
```


