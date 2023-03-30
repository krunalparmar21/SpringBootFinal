package com.SpringBoot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.dao.AddressDao;
import com.SpringBoot.dao.UserDao;
import com.SpringBoot.model.Address;
import com.SpringBoot.model.User;

@Service
public class userServiceImpl implements userService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private AddressDao addressDao;



	public boolean saveUser(User user) {
		int i = 0;
		while (user.getAddress().size() - 1 != i) {
			String h = user.getAddress().get(i).getCity();
			if (h != null) {
				i++;
			} else {
				user.getAddress().remove(i);
			}
		}

		for (Address address : user.getAddress()) {
			address.setUser(user);
		}

		List<Integer> addIdArr = new ArrayList<Integer>();
		if (user.getId() != 0) {
			for (Address address : user.getAddress()) {
				addIdArr.add(address.getId());
				System.out.println(address.getId());
			}
			// Delete the address before update user.
			addressDao.deleteByIdIn(addIdArr, user);
		}
		userDao.save(user);
		return true;

	}

	public boolean userCheck(String email, String password) {
		if (userDao.existsByEmailAndPassword(email, password)) {
			System.out.println("User email and password matched.");
			return true;
		} else {
			System.out.println("User email and password not matched.");
			return false;
		}
	}

	public User userGet(String email) {
		List<User> userData = userDao.findByEmail(email);
		if (!userData.isEmpty()) {
			return userData.get(0);
		} else {
			System.out.println("User not Find");
			return null;
		}
	}

	public List getAllEmployee() {
		Iterable<User> findAll = userDao.findAll();
		List<User> result = new ArrayList();
		findAll.forEach(result::add);
		return result;

	}

	public void deleteById(int id) {
		userDao.deleteById(id);
	}

}
