package com.yura.iam.model;

import java.util.List;

public class Role {
    private String name;
    private List<String> permissions;

    public Role() {}

    public Role(String name, List<String> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<String> getPermissions() { return permissions; }
    public void setPermissions(List<String> permissions) { this.permissions = permissions; }
}

