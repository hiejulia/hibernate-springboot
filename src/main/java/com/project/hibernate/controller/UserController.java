package com.project.hibernate.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/v1/api/users")
public class UserController {

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

}
