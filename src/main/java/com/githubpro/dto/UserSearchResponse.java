package com.githubpro.dto;

import java.util.List;

public class UserSearchResponse {

    private List<UserDTO> items;

    public List<UserDTO> getItems() {
        return items;
    }

    public void setItems(List<UserDTO> items) {
        this.items = items;
    }
}