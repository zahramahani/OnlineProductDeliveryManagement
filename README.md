# OnlineProductDeliveryManagement
java spring project 

Online Product Delivery Management
-
-
-
-
User management
o Access level for admin and users
o Authentication method is Token based
o Add/Update/Remove users for Admin
o Webservice :
 /users (list, add, update, remove)
 /users/{id}/products
 /users/{id}/orders
Product management
o Each product have tags for categorizing
o Each user can manage his/her products
o Each product has amount in stock
o Webservices
 /products (list, add, update, remove, addamount)
 /products/search?tag=xx or name=xx
 /products/{id}/orders
Order for delivery
o Users can order his/her products
o Each order have status (waiting, packing, delivering, delivered, canceled)
o User can only order products that exists in the stock
o Webservices:
 /orders (list, add, update, remove)
 /orders/{id}/status (list, change)
Overall notes
o Removes must be logical
o Admin have access to all operations on everything
o Admin can only view removed items
o categorized Postman collection for all webservices
o Choosing a database is not important but your connection must able to connect to
MySQL, H2, PostgreSQL or any RDBMS.
o All webservices must be documented with Swagger
