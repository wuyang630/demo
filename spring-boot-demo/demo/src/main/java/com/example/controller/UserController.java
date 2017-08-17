package com.example.controller;

import com.example.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

	static Map<Long,User> users = Collections.synchronizedMap(new HashMap<>());

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> getUserList() {
		List<User> r = new ArrayList<>(users.values());
		return r;
	}

	@RequestMapping(value = "/",method = RequestMethod.POST)
	public String postUser(@ModelAttribute User user) {
		users.put(user.getId(),user);
		return "success";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
	    return users.get(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id) {
		users.remove(id);
		return "success";
	}

}
