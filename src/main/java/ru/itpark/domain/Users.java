package ru.itpark.domain;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Users {
    private String id;
    private String login;
    private String name;
    private String image;

    public Users(String id, String login, String name, String image) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
