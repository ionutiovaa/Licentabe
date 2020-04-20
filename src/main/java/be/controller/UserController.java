/*
package be.controller;

import be.dto.ChangePasswordDTO;
import be.dto.UserDTO;
import be.exceptions.BusinessException;
import be.manager.remote.UserManagerRemote;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.core.Response;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController extends HttpServlet {

    @Autowired
    public UserManagerRemote userManagerRemote;

    */
/*public UserController() {
    }*//*


    public UserController(UserManagerRemote userManagerRemote){
        this.userManagerRemote = userManagerRemote;
    }

    @GetMapping(path = "/", produces = "application/json")
    public String get(){return "HI"; }

    @PostMapping(path = "/changePassword", produces = "application/json")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO){
        try{
            UserDTO updateUser = userManagerRemote.changePassword(changePasswordDTO);
            return ResponseEntity.ok(updateUser);
        } catch (BusinessException e){
            e.printStackTrace();
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping(path = "/getUsers", produces = "application/json")
    public String getUsers() throws IOException{
        List<UserDTO> listOfAllUsers = this.userManagerRemote.findAllUsers();
        ObjectMapper jsonTranformer = new ObjectMapper();
        return jsonTranformer.writeValueAsString(listOfAllUsers);
    }

    @PostMapping(path = "/createUser", produces = "application/json")
    public ResponseEntity<?> addUser(@RequestBody UserDTO userDTO){
        try {
            UserDTO user = userManagerRemote.insertUser(userDTO);
            return ResponseEntity.ok(user);
        } catch (BusinessException e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping(path = "/getUser/{id}", produces = "application/json")
    public String getUser(@PathVariable("id") Integer id){
        try {
            UserDTO userDTO = userManagerRemote.findUser(id);
            ObjectMapper jsonTransformer = new ObjectMapper();
            return jsonTransformer.writeValueAsString(userDTO);
        } catch (BusinessException | JsonProcessingException e){
            return null;
        }
    }

}
*/
