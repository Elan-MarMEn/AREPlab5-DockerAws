# AWS-Docker: Spark persistence service

This project focuses on the mountage of a docker container that have 4 diferents image on AWS, the firts(App_RounRobin) image is a service that make diferents request for insert or get information to the restant three images(Log_service) using a balancer to choose one of them and the other three images are a service that make a request directly to mongoDB and sending to the firts service.

## Continuous Integration

[![CircleCI](https://circleci.com/gh/circleci/circleci-docs.svg?style=svg)](https://app.circleci.com/pipelines/github/Elan-MarMEn/AREPNanoSaprk)

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/13b1c8c14c5f469ca46d1f3e492fb825)](https://www.codacy.com/gh/Elan-MarMEn/AREPlab5-DockerAws/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Elan-MarMEn/AREPlab5-DockerAws&amp;utm_campaign=Badge_Grade)

## Getting Started

Open your comand console or cmd and write or copy the comand below.

```
git clone https://github.com/Elan-MarMEn/AREPlab5-DockerAws.git
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

Once you run the project you can use the URI´s below to access to all allowed(Existing) get requests:

```
.../dataset(Round_robin)

.../datastore(Log_service)
``` 

## Docker Local Running

For see a local running you must to use the command below
to create a image for the Dockerfile

```
docker build -t {NameOfImage} .
```
then use the same command to generate a second image or you can modify the file docker-compose.yml 
to resume this process and build the images and containers in just one comand like this:

* with images previously created:
![](/img/local/build/image.png)

* to build images:
![](/img/local/build/build.png)

after this configuration for running the image in a container using:
```
docker-compose up -d
```
Now you can put in the URI " http://localhost:34005/ " and you will see this:
* Normal view:
![](/img/aws/normal.png)
* If you click on the button "Show Info", you´ll see the store information like this:
![](/img/aws/ingreso1.png)
* Then you can add information using the input and the button "Save":
![](/img/aws/ingreso2.png)
* Once you clicked the button, click again on "Show info" to verify that your data was saved:
![](/img/local/docker/data.png)

## AWS Running

In this case the local image must be load in DockerHub and then you will pull them on 
the virtual machine (Note: you should install docker and docker-compose on the AWS machine), you will see just two images:
![](/img/aws/imagesAWs.png)
 
then with images you just have to create a new directory for create and store your docker-compose.yml
(The docker-compose.yml could be the same of this repository you only have to change the name of the image). 
Now you have all tools just left to run the docker compose command:
```
docker-compose up -d
```
then verify the port of the containers and the succesfully creation:
![](/img/aws/awsContainers.png)
After this you can see on AWS web direction:
* Normal view:
![](/img/aws/awsnormal.png)
* If you click on the button "Show Info", you´ll see the store information like this:
![](/img/aws/awsFuncional.png)
* Then you can add information using the input and the button "Save":
![](/img/aws/awingreso.png)
* Once you clicked the button, click again on "Show info" to verify that your data was saved:
![](/img/aws/awsFuncaAlmacenado.png)

Remember to enable the ports that you need to use for running the Aplication:



## Local Running

If you want to run the appweb on a local port 
you must use the comand below for windows:
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
