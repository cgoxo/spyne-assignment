# spyne-assignment
I've completed the following and exposed the endpoints. It needs to get more polished and need to add more features. The codebase is implemented in java using springboot. The Postman docs are located in the folder itself, `spine assignment.postman_collection.json`. I've created the following `create user`, `update_user`, `delete_user`, `List of users`, `search based on name`.

For discussions I've implemented `create_discussion`, `update_discussion`, `delete_discussion`

## Database Setup (Postgres)
`psql -U postgres`

`create role fs with LOGIN password 'dev@123';`

`alter role fs createdb;`

`Exit;`

`psql postgres -U fs`

`create database spyne;`
