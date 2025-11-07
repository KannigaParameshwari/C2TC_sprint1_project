package com.tnsif.adminservices.controller;

import com.tnsif.adminservices.entity.Admin;
import com.tnsif.adminservices.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    private final AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    // 🧾 1️⃣ Get all admins
    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = service.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

    // 🔍 2️⃣ Get admin by ID
    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        Admin admin = service.getAdminById(id);
        if (admin != null) {
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ➕ 3️⃣ Add new admin
    @PostMapping
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
        Admin saved = service.saveAdmin(admin);
        return ResponseEntity.ok(saved);
    }

    // ✏️ 4️⃣ Update existing admin
    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin updatedAdmin) {
        Admin existing = service.getAdminById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        // Update the fields
        existing.setUsername(updatedAdmin.getUsername());
        existing.setEmail(updatedAdmin.getEmail());
        existing.setPassword(updatedAdmin.getPassword());
        existing.setPhoneNumber(updatedAdmin.getPhoneNumber());
        existing.setRole(updatedAdmin.getRole());
        existing.setDepartment(updatedAdmin.getDepartment());

        Admin saved = service.saveAdmin(existing);
        return ResponseEntity.ok(saved);
    }

    // ❌ 5️⃣ Delete admin by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        service.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }
}
