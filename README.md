Creating Default Roles
We’ll have a fixed set of predefined roles in our application. Whenever a user logs in, we’ll assign ROLE_STAFF to it by default.

For assigning the roles, they have to be present in the database. So let’s create the two default roles in the database by executing the following insert statements -

Query to be run to provide the result below in the image.
```bash
INSERT INTO roles(name) VALUES('ROLE_STAFF');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```
![image](https://github.com/DaphineKamusiime/bookstore-inventory-system/assets/107240847/c96145cf-166a-476b-9a38-7208045dd7b6)
