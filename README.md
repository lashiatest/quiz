# quiz

## A springboot application running on Render with postgreSQL as the database. This is for a project I am working on. The website will bring you to the spring web application. However, this website will be down for most of the time.

### Commands\
Add the root after the url to make a request.\
Then input the command you want to execute.\
URL accessible means you can make the request through the url.\
Requires API development app such as Postman or Hoppscotch.

QuestionController: /question - root\
/questions - Get all questions (URL Accessible)\

/get/{id} - Get a specific question (Replace "{id}" with question id)(URL Accessible).\

/add - Create a question on the database (Requires API Development App).\
Create a post request.\
Requires JSON body to make the request.\
Example:\
{\
  "question": "insert question",\
  "option1": "insert option1",\
  "option2": "insert option2",\
  "option3": "insert option3",\
  "option4": "insert option4",\
  "answer": "insert answer"\
}\

/delete - Delete a question on the database (Requires API Development App).\
Create a delete request.\
Requires question id to make the request.\
Example:\
insert question id\

/update - Update a question on the database (Requires API Development App).\
Create a put request.\
Requires JSON body to make the request.\
Example:\
{\
  "id": insert question id,\
  "question": "insert question",\
  "option1": "insert option1",\
  "option2": "insert option2",\
  "option3": "insert option3",\
  "option4": "insert option4",\
  "answer": "insert answer"\
}\

Quiz Controller: /quiz - root\
/get/{id} - Get a specific quiz (Replace "{id}" with quiz id)(URL Accessible).\

/submit/{id} - Submit a response to the quiz (Replace "{id}" with quiz id)(Requires API Development App).\
Create a post request.\
Requires JSON body to make the request.\
Example:\
[{\
  "id": insert question id,\
  "response": "insert response"\
}]\

/create - Creates a quiz on the database (Requires API Development App).\
Create a post request.\
Requires url paramaters to make the request.\
Example:\
/create?name="insert name"&num="insert number of questions"\
