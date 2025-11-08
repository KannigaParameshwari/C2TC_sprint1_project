package com.tnsif.adminservices.entity;

import jakarta.persistence.*;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // 1️⃣ Admin ID

    private String username;        // 2️⃣ Login name
    private String email;           // 3️⃣ Contact email
    private String password;        // 4️⃣ Password (should be encrypted in real app)
    private String phoneNumber;     // 5️⃣ Admin’s contact number
    private String role;            // 6️⃣ Role (e.g., SUPER_ADMIN / MANAGER)
    private String department;      // 7️⃣ Department (e.g., Operations, Finance)

    // --- Getters and Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}
