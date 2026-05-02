# GitHub Profile Explorer

A Spring Boot web application that allows users to search GitHub profiles and explore repository insights such as languages used, repository stars, and trending languages.

---

## Features

* Search GitHub users by username
* View user profile details (avatar, username, profile link)
* Fetch and display repositories
* View repository details (name, language, stars)
* Analyze language usage across repositories
* Show most used programming language
* Filter repositories by language
* Sort repositories by stars

---

## Tech Stack

* Java
* Spring Boot
* Spring WebFlux (WebClient)
* Thymeleaf
* HTML, CSS
* GitHub REST API

---

## Project Structure

```
github-project/
│
├── controller/
│   └── ViewController.java
│
├── service/
│   ├── UserService.java
│   └── RepoService.java
│
├── dto/
│   ├── UserDTO.java
│   ├── RepoDTO.java
│   └── UserSearchResponse.java
│
├── config/
│   └── WebClientConfig.java
│
├── templates/
│   ├── index.html
│   ├── search.html
│   └── dashboard.html
│
├── static/
│   └── css/style.css
│
└── GithubProjectApplication.java
```

---

## How It Works

1. User enters a GitHub username
2. Application calls GitHub API using WebClient
3. User data and repositories are fetched
4. Backend processes data (filtering, sorting, aggregation)
5. Thymeleaf renders the UI dynamically

---

## API Used

* GitHub Users API
  `https://api.github.com/users/{username}`

* GitHub Search API
  `https://api.github.com/search/users?q={query}`

* GitHub Repos API
  `https://api.github.com/users/{username}/repos`

---

## Key Features Implementation

* **DTO Pattern** used for clean data mapping
* **WebClient** for API communication
* **Service Layer** for business logic separation
* **Aggregation logic** for language statistics
* **Sorting & Filtering** for repository insights

---

## How to Run

1. Clone the repository

```bash
git clone https://github.com/your-username/github-project.git
```

2. Open in IntelliJ IDEA or Eclipse

3. Build the project using Maven

4. Run the Spring Boot application

5. Open in browser

```
http://localhost:8081
```

---

## Future Improvements

* Pagination for search results
* Repository search filters (stars, forks, date)
* UI improvements with charts (language visualization)
* API rate limit handling
* User comparison feature

---

## Author

Built by Khushnuma Parween.

---
