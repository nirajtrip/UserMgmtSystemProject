# UserMgmtSystemProject
The User CRUD APIs

## Entity User: CRUD Operations:
1. Get a specific User, based on a unique id (e.g. Id)
```console
GET: <BASE_URL>/user/{id} 
```

2. Get all Users

```console
GET: <BASE_URL>/user
```

3. Create User
HTTP Request Headers:

| Name        | Value | Remarks |
|:----------- |:------------| :-------|
| Content-Type | application/json |   Required for the POST API call only.|  

```console
POST: <BASE_URL>/person       
```

4. Update a specific User using Id

HTTP Request Headers:

| Name        | Value | Remarks |
|:----------- |:------------| :-------|
| Content-Type | application/json |   Required for the POST API call only.|  

```console
PUT: <BASE_URL>/user/{id}  
```

5. Delete User
```console
DELETE: <BASE_URL>/user/{id}  
```

6. Login using email and password
```console
GET: <BASE_URL>/user/email/:email/password/:password  
```


## Build & Compile

### Maven Build & Compile:
```console
$mvn clean compile package
```

To Run the Test (MUnit and JUnit):
```console
$mvn test
```
