A RESTful API created with Spring Boot for PetsPalette 
- Implements OAuth 2.0 with AWS Cognito
- Provides endpoint to send messages to AWS SQS
- Connects to MYSQL database

Endpoints:

Base path for Post controller: /api/v1/posts
- GET returns list of postDTOs
- POST with valid postDTO in body returns postDTO of created/saved post
- GET /{id} increments number of likes of Post with specified ID in url path
- GET /send/{id} sends message to SQS with the specified ID

Base path for User controller: /api/v1/user
- GET /{cognitoUsername} returns UserDTO if user with specified cognitoUsername isn't a new user
- POST with valid UserDTO in body returns username of newly created/saved user


Link to frontend repo which contains more info about the project(architecture, configuration, etc.)[https://github.com/MikeDePacina/PetsPalette]
