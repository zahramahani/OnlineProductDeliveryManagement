# OnlineProductDeliveryManagement
java spring project 

Online Product Delivery Management
-
-
-
-
# User management
### Access level for admin and users
### Authentication method is Token based
### Add/Update/Remove users for Admin
### Webservice :
#### /users (list, add, update, remove)
#### /users/{id}/products
#### /users/{id}/orders
# Product management
### Each product have tags for categorizing
### Each user can manage his/her products
### Each product has amount in stock
### Webservices
#### /products (list, add, update, remove, addamount)
#### /products/search?tag=xx or name=xx
#### /products/{id}/orders
# Order for delivery
### Users can order his/her products
### Each order have status (waiting, packing, delivering, delivered, canceled)
### User can only order products that exists in the stock
### Webservices:
### /orders (list, add, update, remove)
### /orders/{id}/status (list, change)
# Overall notes
### Removes must be logical
### Admin have access to all operations on everything
### Admin can only view removed items
### categorized Postman collection for all webservices
### Choosing a database is not important but your connection must able to connect to
MySQL, H2, PostgreSQL or any RDBMS.
### All webservices must be documented with Swagger
