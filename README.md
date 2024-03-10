# Spring Security with Json Web Token (JWT)

[![JWT SVG](https://jwt.io/img/badge.svg)](https://jwt.io/)

## Sequence

<img src="https://imgbed.codingkelvin.fun/uPic/IMG_0025aslkdfjwqergijergi3u42oiejgerwf.jpg" alt="Sequence Diagram" style="zoom:40%;" />

## Architecture

<img src="https://imgbed.codingkelvin.fun/uPic/wfwkjefkwjhwkjhdkjqwe.jpg" alt="Srping Security Architecure" style="zoom:40%;" />

# Getting Started

```shell
$ ./mvnw spring-boot:run
```

# API

## Register

```http
POST /api/auth/register HTTP/1.1
Host: localhost:8080
Content-Length: 100

{
    "userName": "Kelvin",
    "password": "my_password",
    "email": "kelvinqiu802@outlook.com"
}
```

## Login

```http
POST /api/auth/login HTTP/1.1
Host: localhost:8080
Content-Length: 59

{
    "userName": "Kelvin",
    "password": "my_password"
}
```

***Response:***

```json
{
    "userName": "Kelvin",
    "jwt": "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJrZWx2aW5xaXUudGVjaCIsInN1YiI6IktlbHZpbiIsImV4cCI6MTcxMDA3ODI1OCwiaWF0IjoxNzEwMDc4MTk4fQ.18kv0hko5pW8DW_YmOI766CzGts_x-aS4tPXGRP5fN0"
}
```

## Hello World

```http
GET /api/home HTTP/1.1
Host: localhost:8080
Authentication: Bearer <token>
```

## Resources

- **Docs: **[jwt.io](https://jwt.io/)

- **Tutorial: **[medium](https://medium.com/code-with-farhan/spring-security-jwt-authentication-authorization-a2c6860be3cf)