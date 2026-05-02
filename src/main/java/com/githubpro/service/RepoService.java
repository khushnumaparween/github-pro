package com.githubpro.service;

import com.githubpro.dto.RepoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Service
public class RepoService {

    private final WebClient webClient;

    public RepoService(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<RepoDTO> getRepos(String username) {

        List<RepoDTO> repos = webClient.get()
                .uri("/users/" + username + "/repos?per_page=100")
                .retrieve()
                .bodyToFlux(RepoDTO.class)
                .collectList()
                .block();

        return repos != null ? repos : Collections.emptyList();
    }

    public Map<String, Integer> countLanguages(List<RepoDTO> repos) {

        Map<String, Integer> map = new HashMap<>();

        for (RepoDTO repo : repos) {
            String lang = repo.getLanguage();

            if (lang != null) {
                map.put(lang, map.getOrDefault(lang, 0) + 1);
            }
        }

        return map;
    }
//by stars

    public List<RepoDTO> sortByStars(List<RepoDTO> repos) {
        repos.sort((a, b) -> b.getStargazers_count() - a.getStargazers_count());
        return repos;
    }

    //filtering by users

    public List<RepoDTO> filterByLanguage(List<RepoDTO> repos, String language) {

        if (language == null || language.isEmpty()) {
            return repos;
        }

        List<RepoDTO> filtered = new ArrayList<>();

        for (RepoDTO repo : repos) {
            if (repo.getLanguage() != null &&
                    repo.getLanguage().equalsIgnoreCase(language)) {
                filtered.add(repo);
            }
        }

        return filtered;
    }

//top language
    public String getTopLanguage(Map<String, Integer> map) {

        String topLang = null;
        int max = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                topLang = entry.getKey();
            }
        }

        return topLang;
    }
}
