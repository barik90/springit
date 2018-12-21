package pl.evolution.springit.service;

import org.springframework.stereotype.Service;
import pl.evolution.springit.domain.Role;
import pl.evolution.springit.repository.RoleRepository;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findByname(String name){
        return roleRepository.findByName(name);
    }

}
