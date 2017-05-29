

## Validation for the request parameters

```
$ curl -s -v :8080 
> GET / HTTP/1.1
> Host: :8080
> User-Agent: curl/7.43.0
> Accept: */*
> 
< HTTP/1.1 400 
< Content-Type: application/json;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Mon, 29 May 2017 07:59:26 GMT
< Connection: close
< 

{
  "errors": [
    {
      "entity": "searchCriteria",
      "property": "keyWordOrEmail",
      "invalidValue": false,
      "message": "keyword or email is required"
    }
  ]
}
```

```
$ curl -s -v :8080?keyword=a 
> GET /?keyword=a HTTP/1.1
> Host: :8080
> User-Agent: curl/7.43.0
> Accept: */*
> 
< HTTP/1.1 400 
< Content-Type: application/json;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Mon, 29 May 2017 08:00:00 GMT
< Connection: close
< 

{
  "errors": [
    {
      "entity": "searchCriteria",
      "property": "keyword",
      "invalidValue": "a",
      "message": "size must be between 2 and 2147483647"
    }
  ]
}
```


```
$ curl -s -v :8080?email=a
> GET /?email=a HTTP/1.1
> Host: :8080
> User-Agent: curl/7.43.0
> Accept: */*
> 
< HTTP/1.1 400 
< Content-Type: application/json;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Mon, 29 May 2017 08:00:42 GMT
< Connection: close
< 

{
  "errors": [
    {
      "entity": "searchCriteria",
      "property": "email",
      "invalidValue": "a",
      "message": "not a well-formed email address"
    }
  ]
}
```

```
$ curl -s -v ":8080?email=a&keyword=a"
> GET /?email=a&keyword=a HTTP/1.1
> Host: :8080
> User-Agent: curl/7.43.0
> Accept: */*
> 
< HTTP/1.1 400 
< Content-Type: application/json;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Mon, 29 May 2017 08:01:18 GMT
< Connection: close
< 

{
  "errors": [
    {
      "entity": "searchCriteria",
      "property": "keyword",
      "invalidValue": "a",
      "message": "size must be between 2 and 2147483647"
    },
    {
      "entity": "searchCriteria",
      "property": "email",
      "invalidValue": "a",
      "message": "not a well-formed email address"
    }
  ]
}
```

## Validation for the request body

```
$ curl -v -XPOST :8080 -H "Content-Type: application/json" -d '{}'
> POST / HTTP/1.1
> Host: :8080
> User-Agent: curl/7.43.0
> Accept: */*
> Content-Type: application/json
> Content-Length: 2
> 
< HTTP/1.1 400 
< Content-Type: application/json;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Mon, 29 May 2017 08:02:44 GMT
< Connection: close
< 

{
  "errors": [
    {
      "entity": "searchCriteria",
      "property": "keyWordOrEmail",
      "invalidValue": false,
      "message": "keyword or email is required"
    }
  ]
}
```

```
$ curl -v -XPOST :8080 -H "Content-Type: application/json" -d '{"keyword":"a"}' 
> POST / HTTP/1.1
> Host: :8080
> User-Agent: curl/7.43.0
> Accept: */*
> Content-Type: application/json
> Content-Length: 15
> 
< HTTP/1.1 400 
< Content-Type: application/json;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Mon, 29 May 2017 08:03:28 GMT
< Connection: close
< 
{
  "errors": [
    {
      "entity": "searchCriteria",
      "property": "keyword",
      "invalidValue": "a",
      "message": "size must be between 2 and 2147483647"
    }
  ]
}
```

```
$ curl -v -XPOST :8080 -H "Content-Type: application/json" -d '{"email":"a"}'
> POST / HTTP/1.1
> Host: :8080
> User-Agent: curl/7.43.0
> Accept: */*
> Content-Type: application/json
> Content-Length: 13
> 
< HTTP/1.1 400 
< Content-Type: application/json;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Mon, 29 May 2017 08:04:03 GMT
< Connection: close
< 
{
  "errors": [
    {
      "entity": "searchCriteria",
      "property": "email",
      "invalidValue": "a",
      "message": "not a well-formed email address"
    }
  ]
}
```

```
$ curl -v -XPOST :8080 -H "Content-Type: application/json" -d '{"email":"a","keyword":"a"}'
> POST / HTTP/1.1
> Host: :8080
> User-Agent: curl/7.43.0
> Accept: */*
> Content-Type: application/json
> Content-Length: 27
> 
< HTTP/1.1 400 
< Content-Type: application/json;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Mon, 29 May 2017 08:05:04 GMT
< Connection: close
< 
{
  "errors": [
    {
      "entity": "searchCriteria",
      "property": "keyword",
      "invalidValue": "a",
      "message": "size must be between 2 and 2147483647"
    },
    {
      "entity": "searchCriteria",
      "property": "email",
      "invalidValue": "a",
      "message": "not a well-formed email address"
    }
  ]
}
```