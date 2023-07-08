
# Reward Points Calculator

## WebAPI Developer
A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every
dollar spent between $50 and $100 in each transaction.
(e.g., a $120 purchase = 2x$20 + 1x$50 = 90 points).
Given a record of every transaction during a three-month period, calculate the reward points earned for
each customer per month and total.

## Running the project
#### 1. git clone https://github.com/roshanrazz/reward-points
#### 2. Open in editor like eclipse, spring-tool-suite,intelliJ IDEA, preferably spring-tool-suite as I have used for creation.
#### 3. Right click on project. Goto -> Run As -> Maven Build.
#### 4. In Goals type spring-boot:run and run the project.
#### Alternatively run the project from command prompt using mvn spring-boot:run command.

#### 5. Also project can be run from Dockerfile provided in project.
#### 6. You can also run project from docker image pushed in my docker hub repository by using ->  docker pull roshanrazz/reward-points
#### 7. Lastly you can use live link as it is deployed on server. Just replace localhost with 129.146.132.231. Cannot gurantee if it works all the time

## Note for Developers
#### 1. I have used H2 as a database which can be accessed from browser by using url http://localhost:8080/h2-console with JDBC url jdbc:h2:mem:testdb and default username: sa and no password.

#### 2. There is a file data.sql in resources which contain dummy data for user and transaction entity which gets populated automatically when running the project.
#### 3. For testing purpose transaction can be created from controller endpoint also as provided below.
#### 4. Port 8080 should not be used by other service as it runs on port 8080.
#### 5. All the test case passes.

## Endpoints
### You can use live link as it is deployed on server. Just replace localhost with 129.146.132.231. Cannot gurantee if it works all the time.
### List all users
GET -> http://localhost:8080/api/v1/users
### Get a single user
GET -> http://localhost:8080/api/v1/users/{userId}
eg. userId -> U001, U002, U003
### Create a transaction
POST -> http://localhost:8080/api/v1/users/{userId}/transaction
eg. sample data

{
  "amount": 180
}

--> It will return with all the data including points rewarded like 
{
"transactionId": "T033",
"userId": "U001",
"date": "2023-07-08",
"amount": 180,
"points": 210
}

### Get Total points of a user
GET -> http://localhost:8080/api/v1/users/{userId}/points

### Get Total points in a month by a user
GET -> http://localhost:8080/api/v1/users/{userId}/points/{month}
eg. month -> 2023-07, 2023-06, 2022-07


