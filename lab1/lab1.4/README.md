
## Some useful docker commands:
Check docker version
```
$ docker --version
```

Test Docker installation
```
$ docker run hello-world
```

List the Docker images on computer
```
$ docker image ls
```

Remove Docker image
```
$ docker image rm <image id>
```

List the existing Docker containers
```
$ docker ps 
```

Close and remove docker container
```
$ docker stop <container id>
$ docker rm <container id>
```

## Dockerfile
A **Dockerfile** describes how to assemble a private filesystem for a container, and can also contain some metadata describing how to run a container based on this image.

## Portainer
Portainer is a lightweight management UI which allows you to easily manage your different Docker environments. Portainer allows you to manage all your Docker resources (containers, images, volumes, networks and more) 

```
$ docker volume create portainer_data
```
```
$ docker run -d -p 8000:8000 -p 9000:9000 --name=portainer --restart=always -v /var/run/docker.sock:/var/run/docker.sock -v portainer_data:/data portainer/portainer
```

Opening a web browser and go to https://localhost:9443 .


## Docker Compose
Docker Compose is a tool that was developed to help define and share multi-container applications. With Compose, we can create a YAML file to define the services and with a single command, can spin everything up or tear it all down.

Full tutorial: https://docs.docker.com/compose/gettingstarted/

Start docker-compose:
```
$ docker-compose up
```

Stop docker-compose:
```
$ docker-compose stop
```