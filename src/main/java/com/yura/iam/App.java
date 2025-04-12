package com.yura.iam;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yura.iam.model.User;
import com.yura.iam.model.Role;
import com.yura.iam.service.ProvisioningService;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            // Charger les rôles
            List<Role> roles = mapper.readValue(
                new File("config/roles.json"),
                new TypeReference<List<Role>>() {}
            );
            Map<String, Role> roleMap = roles.stream()
                    .collect(Collectors.toMap(Role::getName, r -> r));

            // Charger les utilisateurs
            List<User> users = mapper.readValue(
                new File("config/users.json"),
                new TypeReference<List<User>>() {}
            );

            // Provisioning
            ProvisioningService provisioningService = new ProvisioningService(roleMap);
            for (User user : users) {
                provisioningService.provision(user);
            }

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}

