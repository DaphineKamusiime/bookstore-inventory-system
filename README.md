Requirements
Java 21
Maven 3.x

Implementing a Book store REST API using Spring Framework for Company XYZ.

Frontend should be able to display a list of books which contain the Name and Author's name
Book has fields such as: ID, ISBN, Name, Author, Categories
Frontend should be able to show, all the details of each book.
An admin in the XYZ company should be able to add books to the store.
The XYZ company should have the ability to know when the book was inserted and updated in the system.
The API should be able to handle Unexpected scenarios and return to the clients.
Creating Default Roles
We’ll have a fixed set of predefined roles in our application. Whenever a user logs in, we’ll assign ROLE_STAFF to it by default.

For assigning the roles, they have to be present in the database. So let’s create the two default roles in the database by executing the following insert statements -

Query to be run to provide the result below in the image.
```bash
INSERT INTO roles(name) VALUES('ROLE_STAFF');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```
![image](https://github.com/DaphineKamusiime/bookstore-inventory-system/assets/107240847/c96145cf-166a-476b-9a38-7208045dd7b6)
