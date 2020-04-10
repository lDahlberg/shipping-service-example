# Quick Start

## Introduction
This shipping service introduces a new regional shipping program to serve buyers and sellers in remote locations. 
This service promotes inventory eligible for a new shipping program, 
resulting in changes which range from altering search rankings,
to modifying recommendation algorithms,
to changing the way eligible items are visually displayed.

## Developer set up
This is a Spring Boot project built with maven on top mongodb. It should be downloaded from this repo, and
it can be run in multiple ways.


### Running with a local mongo installation
Mongo should be installed locally before continuing with the installation.
`https://docs.mongodb.com/manual/installation/`

When it is installed and running, open up a terminal to mongo and insert seed data.
Default prices and categories are provided in the application.yml, but they can be updated
at this time.

For a seller:
`
db.seller.insertOne({ name: 'John Smith', isSellerEnrolled: true })
`
If you wish to insert a category.
`
db.category.insertOne({ values: [1, 4, 9], current: true })
`
If you wish to set a price:
`
db.price.insertOne({ value: 9.99, current: true })
`

From the terminal, navigate to the root directory of the shipping-service-example and use the command
UNIX / POSIX
`./mvnw spring-boot:run`

Windows:
`mvnw spring-boot:run`

If you are using an IDE, set up a Spring Boot profile and set the default class to:

`ShippingServiceExampleApplication`

After the service is started, you may now access its REST APIs from localhost:8080.

### Endpoints
The main endpoint URI is a POST at:
`/shipping-eligiblity`

An example payload that can be delivered through a program like Postman is:
`
{
	"seller": "John Smith",
	"title": "Pocahontas",
	"category": 9,
	"price": 26.99
}
`
The response will be the item and an eligible boolean of true or false

(Swagger will be added soon to simplify this use)

There also exist admin endpoints to change the price and to add to the categories
They can be found at

`
/admin/price
`
`/admin/category`

The payload to update the price follows a PUT with body:
` { "value": 10.99 }`

The payload to update the categories is a PUT with body:
` { "values": [ 7, 8, 9] }`

Note: No credentials are yet required as the verification service was not yet complete