#🧩 Java Client-Server Name Manager
This is a simple Java networking project that demonstrates how a client and a server can communicate using sockets.

The client sends a list of names to the server once (using a single ADD: command).

After that, the client can search for any name in the list by sending a SEARCH: command.

The server responds with FOUND if the name exists, or NOT_FOUND otherwise.

⚙️ How it works

Run the NameServer class — it listens for incoming client connections on port 5000.

Run the NameClient class — it connects to the server.

Enter a list of names separated by commas, for example:
