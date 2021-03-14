# AWS-Docker: Spark persistence service

This project focuses on the mountage of a docker container that have 4 diferents image on AWS, the firts(App_RounRobin) image is a service that make diferents request for insert or get information to the restant three images(Log_service) using a balancer to choose one of them and the other three images are a service that make a request directly to mongoDB and sending to the firts service.

## Continuous Integration

[![CircleCI](https://circleci.com/gh/circleci/circleci-docs.svg?style=svg)](https://app.circleci.com/pipelines/github/Elan-MarMEn/AREPNanoSaprk)

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/6b9784449796496f86c63926d7cc6a14)](https://www.codacy.com/gh/Elan-MarMEn/AREPNanoSaprk/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Elan-MarMEn/AREPNanoSaprk&amp;utm_campaign=Badge_Grade)

## Getting Started

Open your comand console or cmd and write or copy the comand below.

```
git clone 
```

### Prerequisites

Make sure that you already have install Maven,java kit Development and GIT correctly. in he case that you don`t konow how to install use the links below:

* [How to install Maven](https://www.youtube.com/watch?v=RfCWg5ay5B0)
* [How to install JDK 11](https://www.youtube.com/watch?v=IJ-PJbvJBGs)
* [How to install GIT](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
* [How to install herokuCLI](https://co.video.search.yahoo.com/search/video?fr=mcafee&ei=UTF-8&p=how+to+install+heroku+cli&type=E211CO885G91370#id=1&vid=85b4e7e52251aea122733ac858dfb9bf&action=click)
* [How to install Docker to Windows](https://docs.docker.com/docker-for-windows/install/)
* [How to install Docker to Linux](https://docs.docker.com/engine/install/ubuntu/)
* [How to install Docker-compose to Linux](https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-compose-on-ubuntu-20-04-es)

## Compile and Running
Get in to your cmd and use the commands below

```
mvn clean install

mvn package
```

For get the javadoc use:

```
mvn javadoc:javadoc
```

Once you run the project you can use the URI´s below to access to all allowed(Existing) requests:

For static files:
```
.../Arep/index.html

.../Arep/styles.css

.../Arep/app.js
```

For lambda functions:
```
.../Apps/customers
```
the rest of the request will be access to a default response. 

## Docker Local Running

For see a local running you must to use the command below
to create a image for the Dockerfile

```
docker build -t {NameOfImage} .
```
then use the same command to generate a second image or you can modify the file docker-compose.yml 
to resume this process and build the images and containers in just one comand like this:

* with images:

* to build images:

after this configuration for running the image in a container run:
```
docker-compose up -d
```
Now you can put in the URI " http://localhost:34005/ " and you will see this:

## AWS Running

In this case the local image must be load in DockerHub and then you will pull them on 
the virtual machine (Note: you should install docker and docker-compose on the AWS machine), then with 
images you just have to create a new directory for create and store your docker-compose.yml. 
Now you have tools just left to run the docker compose command:
```
docker-compose up -d
```
After this you can see on AWS web direction:


Remember to enable the ports that you need to use for running the Aplication:



## Local Running

If you want to run the appweb on a local port, you migth install herokuCli and then use the comand below.

```
heroku local web
```
or for windows:
```
java  -cp target/classes;target/dependency/* edu.escuelaing.arep.heroku.app.SparkWebApp
```
for Unix:
```
java $JAVA_OPTS -cp target/classes:target/dependency/* edu.escuelaing.arep.heroku.app.SparkWebApp
```

Use the next comand to know the result of the tests

```
mvn test
```

## Built With

* [Heroku](https://dashboard.heroku.com/apps) - Deployment
* [Java 8](https://www.java.com/es/about/whatis_java.jsp) 
* [Maven](https://maven.apache.org/) - Dependency Management
* [Docker](https://www.docker.com/) - Image Container


## Authors

* **Alan Marin** - *Initial work* - [Elan-MarMEn](https://github.com/Elan-MarMEn)


## License

This project is licensed under the General Public License (GNU) - see the [LICENSE.md](LICENSE.md) file for details