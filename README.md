# Publisher-Hex-Arch
 A service built with Hexagonal Architecture, combining a REST API and Event-Driven Architecture to send event objects to a Solace event broker.

## Summary

* [Publisher-Hex-Arch](#publisher-hex-arch)
* [Summary](#summary)
* [Setup and Pre-requisites](#setup-and-pre-requisites)
* [Running the Microservice](#running-the-microservice)
* [Verifying our solution](#verifying-our-solution)
    * [Using the API with Postman](#using-the-api-with-postman)
    * [Viewing our sent event](#viewing-our-sent-event)
* [Stopping the container](stopping-the-container)

## Setup and Pre-requisites

1. If not already installed:

- Install the latest version of OpenJDK 17 on your device (The following page has a complete catalogue of OpenJDK downloads: [https://www.openlogic.com/openjdk-downloads](https://www.openlogic.com/openjdk-downloads))
- Install Docker on your device (you can use the following link for a guide: [https://docs.docker.com/get-docker/](https://docs.docker.com/get-docker/))
- Install Postman on your device

2. Clone this repository or download the .zip file from GitHub (extract the downloaded zip file )

## Running the Microservices

1. Using a Command Line Interface of your choosing, change directory to the downloaded/cloned repository


2. To build the publisher application, run the following command:  

    ```
    <# Linux/MacOs #>
    ./mvnw clean package

    <# Windows #>
    .\mvnw clean package
    ```


3. Once the build is successful, run this command to deploy it as a docker container:

    ```
    docker-compose up -d --build
    ```

4. A single docker container should now be running:
    * `publisher`: where a spring-boot api image, built using a Dockerfile, is containerized. This container is responsible for sending events contaning personal information to the event broker with an exposed API.

5. The event publisher is now ready for use


## Verifying our Solution

To verify our solution, we need to send a request to the API exposed by the `publisher-microservice`. Then, we can verify that our request has been published and received as an event by checking the database container with pgAdmin.

### Using the API with Postman

Using Postman:

1. Select `Import` on the `My Workspace` left-hand side window, then import the [Publisher-Hex-Arch.postman_collection.json](https://github.com/mpirotaiswilton-IW/publisher-hex-arch/blob/master/Publisher-Hex-Arch.postman_collection.json)

2. Select the `Send Person` Post request. In the `Body` tab, there is a json object with 3 fields that looks like this:
    ```json
    {
        "topic": "test/topic",
        "payloadStrings": [
            "payload1",
            "Payload2"
        ],
        "interval": 10
    }
    ``` 

    You can change these fields as you see fit.

3. Send the request. You should receive a 200 OK response and a response body echoing your request body's parameters: 
    ```
    new Message:[payload1, Payload2] | to send to topic: test/topic | with interval: 10.0
    ``` 

### Viewing our sent event

This functionality is currently unavailable. At this time, once a message is sent, the application only logs the following message to the container console:
```
Publisher yet to be implemented. Echoing message payload(s): [payload1, Payload2]
```

## Stopping the container

To stop the docker container, run the following command: 
```
docker-compose down
```