# WebServices Demo app

This is a simple and stupid app to demonstrate a basic web service in action.

## To run:

Run with docker compose:
```
docker-compose up -d
```
Or in dev mode with:
```
mvn clean package && docker-compose -f compose.dev.yml up -d
```

The service is going to be available on localhost:8080

By all means feel free to look at it, analyse how it works, and write something
BETTER! This was just a quick mock up for a presentation about WebServices.

## To use:

There is a *.http, and a postman collection in the requests folder to play around
with.
