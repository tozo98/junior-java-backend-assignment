README
======

[Requirements](Requirements.md)

According to the Requirements document, the following REST endpoints were implemented:

### `/api/v1/messages/save`
* This endpoint can accept JSON payloads via a POST request, and store the received data in the database. The valid messages are forwarded to the WebSocket clients.
* The endpoint answers _400 Bad Request_ if there is a missing attribute, or the timestamp is not in the correct format.
* According to the sample payload, the timestamp should follow this pattern: `yyyy-MM-dd HH:mm:ssZ`.

### `/api/v1/messages/all`
* This GET endpoint can retrieve all the stored messages with the required longest_palindrom_size attribute.
* If the message doesn't contain a palindrome, or contains only non-alphabetic/whitespace characters, the longest_palindrom_size will be 0.
* The longest_palindrom_size attribute will never be null.

### `/websocketdemo`
* I created a really simple html page to demonstrate the WebSocket functionality.
* It can connect to the websocket server, subscribe to the defined topic and present the incoming messages.
* The messages are presented in a simple table.

To run the application you may perform the following steps:
1. `mvn clean package`
2. `docker compose up`

The application is available on the 8080 port, so you can visit the `http://localhost:8080/websocketdemo` page and use Postman to inspect the REST endpoints.

