package com.tnsif.adminservices.service;

import com.tnsif.adminservices.entity.Admin;
import com.tnsif.adminservices.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepository repo;

    public AdminService(AdminRepository repo) {
        this.repo = repo;
    }

    public List<Admin> getAllAdmins() {
        return repo.findAll();
    }

    public Admin getAdminById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Admin saveAdmin(Admin admin) {
        return repo.save(admin);
    }

    public void deleteAdmin(Long id) {
        repo.deleteById(id);
    }
}
