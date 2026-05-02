package com.githubpro.service;

import com.githubpro.dto.UserDTO;
import com.githubpro.dto.UserSearchResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    private final WebClient webClient;

    public UserService(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<UserDTO> searchUsers(String query) {

        UserSearchResponse response = webClient.get()
                .uri("/search/users?q=" + query)
                .retrieve()
                .bodyToMono(UserSearchResponse.class)
                .block();

        return response != null ? response.getItems() : Collections.emptyList();
    }

    public UserDTO getUser(String username) {
        return webClient.get()
                .uri("/users/" + username)
                .retrieve()
                .bodyToMono(UserDTO.class)
                .block();
    }
}