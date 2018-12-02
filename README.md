# Yummy backend


## Prerequisites

To run the application locally, you will need:
* Java 8+
* Gradle 4.4
* Postgres 9+

### Installing

To build project: 

```
gradle clean build
```

To run the application:
```
java -jar /build/libs/yummy-backend-service.jar
```

# Mock data

### Users:
| User | Password | restaurant |
| ---  | --- |  --- |
|user1@user.com| user1| |
|user2@user.com| user2| |
|user3@user.com| user3| |
|user11@restaurant.com| user11| Restaurant 1(Georgia Taste)|
|user12@restaurant.com| user12| Restaurant 2(Baba Burger)|
|user13@restaurant.com| user13| Restaurant 3(Ching Ye)|
|user14@restaurant.com| user14| Restaurant 4(Ukraine Tastee)|
        
### Offers(IDs):

Restaurant 1(Georgia Taste):
* 1-7

Restaurant 2(Baba Burger)
* 8-12

Restaurant 3(Ching Ye)
* 13-18

Restaurant 4(Ukraine Tastee)     
* 19-22
      
      
### Transactions:

To mock some transactions(for restaurant 3), use request:
```
curl -X GET \
  http://localhost:9999/yummy/api/mock/transactions \
  -H 'authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMkByZXN0YXVyYW50LmNvbSIsImV4cCI6MTUyODQzNDE2MX0.XnecIQ7fhJ_AyKed1D8nHlQaM9rHuN1MDZCvKMUvx63uX4ONr0e__tzBl9a6WvSguM21ci3y4ShPkwL_xCSWww' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{
  "email":"user6@restaurant.com",
  "password": "user6"
}'
```

### DB Migrations:
To migrate database on heroku from local environment, ensure that the actual credentials are valid(heroku rotation), then execute:

```gradle flywayMigrate -Pprofile=heroku```
