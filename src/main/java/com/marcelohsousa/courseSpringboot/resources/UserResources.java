package com.marcelohsousa.courseSpringboot.resources;


import com.marcelohsousa.courseSpringboot.dto.UserDTO;
import com.marcelohsousa.courseSpringboot.entities.Post;
import com.marcelohsousa.courseSpringboot.entities.User;
import com.marcelohsousa.courseSpringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
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
        return ResponseEntity.ok().body(new UserDTO(obj));

    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO) {

        User obj = service.fromDTO(userDTO);
        obj = service.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete( @PathVariable String id) {
       service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public  ResponseEntity<Void> update(@RequestBody UserDTO userDTO, @PathVariable String id ){

        User obj = service.fromDTO(userDTO);
        obj.setId(id);
        obj = service.update(obj);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}/posts", method=RequestMethod.GET)
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj.getPosts());
    }
}
