package com.yura.iam.service;

import com.yura.iam.model.User;
import com.yura.iam.model.Role;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

public class ProvisioningService {

    private final Map<String, Role> roleMap;

    public ProvisioningService(Map<String, Role> roleMap) {
        this.roleMap = roleMap;
    }

    public void provision(User user) {
        if (!user.isActive()) {
            System.out.println("User " + user.getName() + " is inactive. Skipping provisioning.");
            return;
        }

        Role role = roleMap.get(user.getRole());
        if (role == null) {
            System.out.println("Role not found for user: " + user.getName());
            return;
        }

        String log = String.format("[%s] Provisioned user %s (%s) with role %s → Permissions: %s",
                LocalDateTime.now(),
                user.getName(),
                user.getEmail(),
                role.getName(),
                String.join(", ", role.getPermissions())
        );

        System.out.println(log);

        try (FileWriter writer = new FileWriter("provisioning.log", true)) {
            writer.write(log + "\n");
        } catch (IOException e) {
            System.out.println("Failed to write log: " + e.getMessage());
        }
    }
}

