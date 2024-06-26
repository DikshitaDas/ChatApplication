# Java Chat Application

This project implements a simple chat application using Java Swing for the graphical user interface and sockets for networking communication between a server and multiple clients.

## Features

- **Server Application:**
  - Accepts multiple client connections simultaneously.
  - Sends and receives messages between connected clients.
  - Displays messages in a graphical user interface using Java Swing.

- **Client Application:**
  - Connects to the server.
  - Sends messages to the server.
  - Receives messages from other connected clients via the server.
  - Displays received messages in a graphical user interface using Java Swing.

## Prerequisites

- Java Development Kit (JDK) installed
- IDE (e.g.,VS-Code, IntelliJ IDE) for Java development
- Basic understanding of Java, Swing, and networking concepts

## Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/javachat.git
   cd javachat
   ```

2. **Compile and run:**

   - **Server:**
     ```bash
     javac Server.java
     java Server
     ```

   - **Client:**
     ```bash
     javac Client.java
     java Client
     ```

3. **Usage:**

   - Run the server application first.
   - Then, run one or more client applications to connect to the server.
   - Start chatting!

## Contributing

Contributions are welcome! Feel free to fork the repository, create pull requests, or open issues for any bugs or feature requests.

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).

---

Feel free to customize the sections and add more details specific to your project. Screenshots can provide visual context, and additional sections like "Troubleshooting", "Known Issues", or "Future Enhancements" can be useful depending on the scope and development stage of your application.
