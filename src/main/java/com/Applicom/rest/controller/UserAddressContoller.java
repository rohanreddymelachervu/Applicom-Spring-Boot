package com.Applicom.rest.controller;


import com.Applicom.rest.entity.Address;
import com.Applicom.rest.entity.User;
import com.Applicom.rest.repository.AddressRepository;
import com.Applicom.rest.repository.UserRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users/address")
public class UserAddressContoller {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @PostMapping
    public User saveUserWithAddress(@RequestBody User user){
        if(userRepository.existsByName(user.getName())){
            return null;
        }
        for(Address address : user.getAddresses()){
            addressRepository.deleteDuplicateAddress(address.getAddr());
        }
        return userRepository.save(user);
    }
    @GetMapping
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/{userId}")
    public User findUser(@PathVariable Long userId){
        return userRepository.findById(userId).orElse(null);
    }
    @GetMapping("/find/{name}")
    public List<User> findUserContainingByName(@PathVariable String name){
        return userRepository.findByNameContaining(name);
    }
    @GetMapping("/search/address/{name}")
    public List<Address> findByAddrContaining(@PathVariable String name){
        return addressRepository.findByAddrContaining(name);
    }
    @PutMapping
    public User updateUserWithAddress(@RequestBody User user){
        if(!userRepository.existsByName(user.getName())){
            saveUserWithAddress(user);
        }
        User userFromDb = userRepository.findByNameContaining(user.getName()).get(0);
        Set<Address> addressesFromDb = userFromDb.getAddresses();
        for(Address addr : addressesFromDb){
            addressRepository.deleteDuplicateAddress(addr.getAddr());
        }
        userFromDb.setName(user.getName());
        userFromDb.setAddresses(user.getAddresses());
        return userRepository.save(userFromDb);
    }
}
