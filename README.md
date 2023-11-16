# Documentation

## Prerequisites

- Java 20

## Initial start

When starting this application for the first time the database schema should be created and database also must be seeded using SQL migration script (`data.sql`). Follow these steps:

1. Setup connection to the `MySql` database by opening `application.properties` and setting these values to your specific environment:

```
spring.datasource.url=jdbc:mysql://localhost:3306/WhatsForDinnerAiDb
spring.datasource.username=your_username
spring.datasource.password=your_password
```

2. To enable the migration edit the values below in `application.properties`:

```
spring.jpa.hibernate.ddl-auto=create
spring.sql.init.mode=always
```
5. Setup OpenAI API key in (`Templates/WeavyAiRestTemplateConfig.java`) and enter your key as shown here:

```
private static final String openaiApiKey = "your_API_key";
```
PS. Additionally, the API accepts a number of optional parameters to modify the response. (`ChatRequest.java`) class has these parameters.
```
n – to increase the number of responses to generate. The default value is 1.

temperature – controls the randomness of the response. The default value is 1 (most random).

max_tokens – is used to limit the maximum number of tokens in the response. The default value is infinity.
```

4. Start the application.

4. Database should be created and seeded. Now change these values back if you don't want your database to be recreated on every startup:

```
spring.jpa.hibernate.ddl-auto=none
spring.sql.init.mode=never
```

## Example API call

The application is accessible calling this URL: `http://localhost:8080/chat`.

You can chose from different meal types

```
    MAINCOURSE
    SIDEDISH
    BREAKFAST
    BEVERAGE
    SOUP
```

And different dietary types

```
    VEGETERIAN
    VEGAN
    CARNIVORE
```

Products are not preset.

Request body example:

```JSON
{
    "mealType": "MAINCOURSE",
    "diet": "VEGAN",
    "products":[
        {
            "productName":"potato"
        },
        {
            "productName":"beans"
        }
    ]        
}
```
Program will return a couple of different meal options depending on listed products, meal type and dietary type.
