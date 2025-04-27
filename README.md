## Many To Many JPA Relationship

### 1. Student API Endpoints:

```java
# Create a new student
curl -X POST http://localhost:8080/api/students -H "Content-Type: application/json" -d '{"name":"John Doe"}'

# Get a student by ID (replace 1 with the actual student ID)
curl -X GET http://localhost:8080/api/students/1

# Get all students
curl -X GET http://localhost:8080/api/students

# Update a student (replace 1 with the actual student ID)
curl -X PUT http://localhost:8080/api/students/1 -H "Content-Type: application/json" -d '{"name":"Jane Doe"}'

# Delete a student (replace 1 with the actual student ID)
curl -X DELETE http://localhost:8080/api/students/1

# Enroll a student in a course (replace 1 and 2 with actual student and course IDs)
curl -X POST http://localhost:8080/api/students/1/enroll/2

# Unenroll a student from a course (replace 1 and 2 with actual student and course IDs)
curl -X POST http://localhost:8080/api/students/1/unenroll/2
```

### 2. Course API Endpoints:

```java
# Create a new course
curl -X POST http://localhost:8080/api/courses -H "Content-Type: application/json" -d '{"title":"Introduction to Computer Science"}'

# Get a course by ID (replace 1 with the actual course ID)
curl -X GET http://localhost:8080/api/courses/1

# Get all courses
curl -X GET http://localhost:8080/api/courses

# Update a course (replace 1 with the actual course ID)
curl -X PUT http://localhost:8080/api/courses/1 -H "Content-Type: application/json" -d '{"title":"Advanced Computer Science"}'

# Delete a course (replace 1 with the actual course ID)
curl -X DELETE http://localhost:8080/api/courses/1
```
