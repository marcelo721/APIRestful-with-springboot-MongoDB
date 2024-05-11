package com.marcelohsousa.courseSpringboot.resources;


import com.marcelohsousa.courseSpringboot.dto.UserDTO;
import com.marcelohsousa.courseSpringboot.entities.User;
import com.marcelohsousa.courseSpringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping(value = "/users")
public class UserResources {


    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {

        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(UserDTO::new).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById( @PathVariable String id) {
        User obj = service.findById(id);
        System.out.println(obj.getId());
        return ResponseEntity.ok().body(new UserDTO(obj));

    }
}
