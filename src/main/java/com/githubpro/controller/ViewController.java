package com.githubpro.controller;
import com.githubpro.dto.RepoDTO;
import com.githubpro.dto.UserDTO;
import com.githubpro.service.RepoService;
import com.githubpro.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class ViewController {

    private final UserService userService;
    private final RepoService repoService;

    public ViewController(UserService userService, RepoService repoService) {
        this.userService = userService;
        this.repoService = repoService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam String query, Model model) {

        List<UserDTO> users = userService.searchUsers(query);
        model.addAttribute("users", users);

        return "search";
    }

//    @GetMapping("/user/{username}")
//    public String dashboard(@PathVariable String username, Model model) {
//
//        UserDTO user = userService.getUser(username);
//        List<RepoDTO> repos = repoService.getRepos(username);
//        Map<String, Integer> languages = repoService.countLanguages(repos);
//
//        model.addAttribute("user", user);
//        model.addAttribute("repos", repos);
//        model.addAttribute("languages", languages);
//
//        return "dashboard";
//    }
//}

    @GetMapping("/user/{username}")
    public String dashboard(@PathVariable String username,
                            @RequestParam(required = false) String language,
                            Model model) {

        UserDTO user = userService.getUser(username);

        List<RepoDTO> repos = repoService.getRepos(username);

        // filter
        repos = repoService.filterByLanguage(repos, language);

        // sort
        repos = repoService.sortByStars(repos);

        Map<String, Integer> languages = repoService.countLanguages(repos);

        String topLanguage = repoService.getTopLanguage(languages);

        model.addAttribute("user", user);
        model.addAttribute("repos", repos);
        model.addAttribute("languages", languages);
        model.addAttribute("topLanguage", topLanguage);

        return "dashboard";
    }
}