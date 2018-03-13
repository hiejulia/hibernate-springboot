package com.project.hibernate.controller;


import com.project.hibernate.captcha.CaptchaVerifier;
import com.project.hibernate.entity.User;
import com.project.hibernate.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/users")
public class UserController {

    private CaptchaVerifier verifier = new CaptchaVerifier();

    @Autowired
    private IUserRepository userRepository;



    // find User by user name
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public User getUserByUserName(@PathVariable("name") String name) {


        return userRepository.findByUserName(name);
    }

    // get all
    @GetMapping
    public Iterable<User> findAll() {

        return userRepository.findAll();
    }

//    @Autowired
//    private UserDao userDao;
//
//
//    @RequestMapping(value="/users")
//    public String user(Model model, HttpSession session) {
//
//        return "users";
//    }
//
//    /* Create a new User */
//    @RequestMapping(value="/createNewUser", method = RequestMethod.GET)
//    @ResponseBody
//    public String createNewUser(@RequestParam String userName,@RequestParam String userMail) {
//        try {
//            User user = new User(userMail, userName);
//            userDao.create(user);
//        }
//        catch (Exception ex) {
//            return "";
//        }
//        return "User succesfully created!";
//    }
//    /* Update a new User */
//    @RequestMapping(value="/updateTheUser", method = RequestMethod.GET)
//    @ResponseBody
//    public String updateTheUser(@RequestParam int userId,@RequestParam String userName,@RequestParam String userMail) {
//        try {
//            User user = userDao.getById(userId);
//            user.setUsername(userMail);
//            user.setName(userName);
//            userDao.update(user);
//        }
//        catch (Exception ex) {
//            return "";
//        }
//        return "User succesfully updated!";
//    }
//
//    /* Delete the User */
//    @RequestMapping(value="/deleteTheUser", method = RequestMethod.GET)
//    @ResponseBody
//    public String getAllTasks(@RequestParam int userId) {
//        try {
//            User user = new User(userId);
//            userDao.delete(user);
//        }
//        catch (Exception ex) {
//            return "";
//        }
//        return "User succesfully deleted!";
//    }
//
//    //Get All Users
//    @RequestMapping(value = "/getAllUserList")
//    @ResponseBody
//    public java.lang.Object getAllUserList() {
//
//        return userDao.getAllUserList();
//    }
//
//
//    /** ------
//     * Delete the user with the passed id.
//     */
//    @RequestMapping(value="/delete")
//    @ResponseBody
//    public String delete(long id) {
//        try {
//            User user = new User(id);
//            userDao.delete(user);
//        }
//        catch (Exception ex) {
//            return "Error deleting the user: " + ex.toString();
//        }
//        return "User succesfully deleted!";
//    }
//
//
//
//    /**
//     * Update the username and the name for the user indentified by the passed id.
//     */
//    @RequestMapping(value="/update")
//    @ResponseBody
//    public String updateName(long id, String username, String name) {
//        try {
//            User user = userDao.getById(id);
//            user.setUsername(username);
//            user.setName(name);
//            userDao.update(user);
//        }
//        catch (Exception ex) {
//            return "Error updating the user: " + ex.toString();
//        }
//        return "User succesfully updated!";
//    }
//


//
//    @Autowired
//    EmployeeRepository employeeRepository;
//
//    @PostMapping(value = "/employees")
//    public Employee createEmployee(@Valid @RequestBody Employee employee) {
//        return employeeRepository.save(employee);
//    }
//
//    @GetMapping("/employees")
//    public List<Employee> listEmployee() {
//        return employeeRepository.findAll();
//    }
//
//    @GetMapping("/employees/{id}")
//    public ResponseEntity<?> getEmployee(@PathVariable(value = "id")  Long id) {
//        Employee employee = employeeRepository.findOne(id);
//
//        if(employee == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok().body(employee);
//    }
//
//    @PutMapping("/employees/{id}")
//    public ResponseEntity<?> updateEmployee(@PathVariable(value = "id")  Long id,
//                                            @Valid @RequestBody Employee updateData) {
//        Employee employee = employeeRepository.findOne(id);
//
//        if(employee == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        employee.setManagerId(updateData.getManagerId());
//        employee.setName(updateData.getName());
//
//        Employee updatedEmployee = employeeRepository.save(employee);
//
//        return ResponseEntity.ok(updatedEmployee);
//    }
//
//    @DeleteMapping("/employees/{id}")
//    public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id")  Long id) {
//        Employee employee = employeeRepository.findOne(id);
//
//        if(employee == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        employeeRepository.delete(employee);
//
//        return ResponseEntity.ok().build();
//    }

    // validate user with captcha

    private SimpleResponse validateSaveBook(Book book, String captchaResponse) {
        SimpleResponse simpleResponse = new SimpleResponse();

        // Not allowed empty string book name or author
        if(book.getName() == null || book.getName().length() < 1 ||
                book.getAuthor() == null || book.getAuthor().length() < 1) {
            simpleResponse.setType(ResponseType.FAIL.getText());
            simpleResponse.setMessage("Book info should be provided.");
        }
        if(!verifier.verifyCaptcha(captchaResponse)){
            simpleResponse.setType(ResponseType.FAIL.getText());
            simpleResponse.setMessage("Captcha should be selected.");
        }
        return simpleResponse;
    }
}
