package com.kingpra;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") // this re-routes our api end point to /api/...
public class AddressBookResource {

	ConcurrentMap<String, Contact> contacts = new ConcurrentHashMap<>();

	@GetMapping("/{id}")
	public Contact getContact(@PathVariable String id) {
		return contacts.get(id);
	}

	@GetMapping("/")
	public List<Contact> getAllContacts() {
		return new ArrayList<Contact>(contacts.values());
	}

	@PostMapping("/")
	public Contact addContacts(@RequestBody Contact contact) {
		contacts.put(contact.getId(), contact);
		return contact;
	}

}
