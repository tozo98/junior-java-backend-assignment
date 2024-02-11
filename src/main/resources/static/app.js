
let sock = new SockJS("http://localhost:8080/websocket-app");
let client = Stomp.over(sock);
client.connect({}, frame => {
    client.subscribe("/topic/messages", payload => {
        addMessage(JSON.parse(payload.body));
    });
});

function addMessage(message) {
  let messagesTable = document.getElementById("messagesTable");
  let formattedRow =
    "<tr><td>" +
    message.content +
    "</td><td>" +
    message.timestamp +
    "</td></tr>";
  messagesTable.innerHTML += formattedRow;
}
