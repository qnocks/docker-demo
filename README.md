# Docker demo

## Build

`$ ./mvnw clean install`\
`$ docker build -t fedotov-docker-demo .`\
`$ docker run -d --name fedotov-docker-demo -p 8080:8080 fedotov-docker-demo`

## Usage

After successful build go to http://localhost:8080

Test credentials are:
* admin/admin for ADMIN role
* user/user for USER role

User with USER role cannot delete entities and create `Show` entity


