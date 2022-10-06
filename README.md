# TaskApi
Task management API that allows you allows you to manage your tasks.
The API base url is `http://taskapi-env.eba-nvskuape.us-east-1.elasticbeanstalk.com`

## Endpoints ##
### List of tasks ###
GET `/api/v1/tasks`

This request returns a list of tasks.The response looks like this
```
[
    {
        "id": 2,
        "title": "finish up foodApp readme",
        "completed": false
    },
    {
        "id": 3,
        "title": "make android app for task api",
        "completed": true
    },
    {
        "id": 4,
        "title": "weeding my garden",
        "completed": false
    },
    {
        "id": 6,
        "title": "Repair the fridge",
        "completed": true
    }
]
```
### Save new task ###
POST `/api/v1/task/save`

Enables you to save a new task.

The request requires a body with the following attributes:


 - `title` - String - Required
 - `compeleted` - String - Required

The response is a Json object that looks like this

```
{
    "id": 6,
    "title": "Repair the fridge",
    "completed": true
}
```
### Update existing task ###
PUT `/api/v1/id`

The request requires either of the following parameters:

 - `title` - String 
 - `compeleted` - String

The response is a Json object with attributes of the updated task
```
{
    "id": 5,
    "title": "cleaning the garage",
    "completed": true
}
```

### Delete task ###
DELETE `/api/v1/id`

The response is a 200 OK status code

The API is still undergoing development.Feel free to make a pull request.Please don't do something I wouldn't do with it😄





