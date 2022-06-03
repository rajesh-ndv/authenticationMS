package controller;

import Documents.ERole;
import Documents.Role;
import Dto.RoleDto;
import Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/getAllRoles")
    public ResponseEntity<List<Role>> getAllRoles(){
        try{
            return ResponseEntity.accepted().body(roleRepository.findAll());
        }catch (Exception exception){
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @PostMapping("/addRole")
    public ResponseEntity<?> addRole(@Valid @RequestBody RoleDto roleDto){

        if(roleDto.getRole()==null){
            return ResponseEntity.badRequest().body("Invalid Request");
        }
        Role role = new Role();
        switch (roleDto.getRole()){
            case "admin":
                role.setName(ERole.ROLE_ADMIN);
                break;
            case "user":
                role.setName(ERole.ROLE_USER);
                break;
            case "mod":
                role.setName(ERole.ROLE_MODERATOR);
                break;
            default:
                ResponseEntity.badRequest().body("Role Code Not Available In Backend");
        }

        Optional<Role> currRole = roleRepository.findByName(role.getName());
        if(currRole.isPresent()){
            return ResponseEntity.badRequest().body("Role Already Exists");
        }
        //role.setId(UUID.randomUUID().toString());
        roleRepository.save(role);
        return ResponseEntity.accepted().body("Role Creation Successful");

    }

}
