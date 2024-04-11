## Quiz application

#### Back-end application that serves Quiz application using Spring boot and MySQL.

Technologies used:

- Spring boot
- MySQL
- JPA
- IntelliJ IDEA

### Endpoints

- /quiz - Parent endpoint to serve all the functionalities for Quiz application.
- /questions(POST) - To create the database. Only used for development purposes.
- /questions(GET) - To get all the questions.
- /questions/next - To get the next question.
- /questions/lifeline - To have lifeline option of 50/50 wherein two wrong answers are removed.
- /questions/answer/submit - To submit an answer.

### Procedure to run the application:

- Set up the DB with the correct configuration.
- Update DB URL and credentials into application.properties.
- Run ./build_run.sh

### Future features

* Constrain the endpoint /next to give out only 10 questions.
* Submission of 10 questions with answers.