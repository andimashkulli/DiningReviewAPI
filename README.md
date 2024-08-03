
# Dining Review API Project

This project is developed using Java programming language, Spring Data JPA for creating the RESTfulAPIs, and H2 Database.

The structure of this project is made using the Controller, Model and Repository structure and it is divided into three main components:

1. User API:
User can create a new account,
They can update their account,
They can submit a dining review.

2. Dining Review API:
You can submit a dining review,
You can fetch all of them and specifically by their ID too.
A dining review cannot be submited if the user and restaurant doesn't exist (API VALIDATION).

3. Restaurant API
A new restaurant can be created, they can be fetched by their specific id and can be fetched with the zip code if already one user has created their account with the same zip code.

## How to start:

Clone this repository and write the following code in your terminal:

```shell
./mvnw spring-boot:run
```

After the server has started successfully, use curl to test the API. For example:

POST REQUEST FOR SUBMITTING A NEW DINING REVIEW:

```shell
 curl -X POST -H "Content-Type: application/json" -d "{\"reviewerName\":\"agimbytyqi\", \"restaurantId\":\"1\", \"rate\":\"4\", \"comment\":\"Nice\", \"adminReviewStatus\":\"PENDING\"}" http://localhost:8080/diningReview/newReviewDining
 ```

 
