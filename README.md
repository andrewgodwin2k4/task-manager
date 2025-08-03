✅ GODWIN Task Manager API 🛠️
A clean and efficient Task Management REST API built with Spring Boot (Java backend). This project allows users to manage tasks with support for priorities and statuses, full CRUD operations, and input validation.

✨ Features
📝 Add, update, delete, and view tasks
🔍 Search tasks by ID or Title
🎯 Set task Priority (LOW, MEDIUM, HIGH)
📌 Update task Status (PENDING, IN_PROGRESS, COMPLETED)
🛡️ Input validation with proper error messages
⚠️ Graceful handling of missing or invalid inputs
📖 Swagger UI support for API testing

🛠️ Tech Stack
Backend: Spring Boot, Java

Database: PostgresSQL (can be swapped)

Tools: Maven, Git, Swagger-UI

🔄 API Endpoints
Method	Endpoint	Description
POST	/addTask	Create a new task
GET	/tasks/{id}	Fetch task by ID
GET	/tasks/title/{title}	Fetch task(s) by title
PUT	/update/{id}	Update task by ID
DELETE	/delete/{id}	Delete task by ID

⚙️ How to Run
Step 1: Clone the repo

Step 2: Open in your favorite IDE (IntelliJ, Eclipse, etc.)

Step 3: Run the application (main() method)

Step 4: Visit Swagger UI: http://localhost:8080/swagger-ui/index.html

un the application (main() method)

Visit Swagger UI: http://localhost:8080/swagger-ui/index.html
