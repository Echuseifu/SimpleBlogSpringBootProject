package com.tts.simplewebproject.controller;


import com.tts.simplewebproject.model.Sneaker;
import com.tts.simplewebproject.service.SneakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// localhost:8080 is not working bcs of the repo if I can put inservice is my project


//@RestController

//// @Controller you have to put RespondBody but on the @RestController you don't need
//@Controller
//public class SneakerController {
//
//    @GetMapping("/")
//    // @ResponseBody help to be print on the web otherwise no print on web
//    // or we need template to be print on the web we need thymeleaf for this work then
//    @ResponseBody
//    public String returnHellowWorld(){
//        System.out.println("this will work");
//        return "Hello World";
//    }


@RestController
@RequestMapping("/api/sneakers")
public class SneakerController {

//    @Autowired
//    SneakerRepository sneakerRepository;

    @Autowired
    SneakerService sneakerService;

//    @GetMapping("/")
////    @ResponseBody
//    public String returnHelloWorld() {
//        System.out.println("This will work");
//        return "Hello world";
//    }

    //
    @GetMapping("/sneaker")
    public Sneaker returnNewSneaker() {
        return new Sneaker("blue");
    }
//
//    @GetMapping("/all")
//    public Iterable<Sneaker> getAllSneakers() {
//        return sneakerRepository.findAll();
//    }
    //

    // not working
//    @GetMapping("/all")
//    public Iterable<Sneaker> getAllSneakers() {
//        return sneakerService.listAllSneaker(getSneakerById());
//    }


    @GetMapping("/get/{id}")
    public Sneaker getSneakerById(@PathVariable Long id) {
        return sneakerService.readSneakerById(id);
    }

    @PutMapping("/put/{id}")
    public Sneaker updateSneakerById(@PathVariable Long id,
                                     @RequestBody Sneaker sneaker) {
        return sneakerService.updateSneakerById(id, sneaker);
    }

//    @GetMapping("/get/color/{color}")
//    public Optional<Sneaker> getSneakerByColor(@PathVariable String color) {
//        return sneakerRepository.findFirstByColor(color);
//    }

    @PostMapping("/post")
    public Sneaker addSneaker(@RequestBody Sneaker sneaker) {
        return sneakerService.createSneaker(sneaker);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSneaker(@PathVariable Long id) {
        return sneakerService.deleteSneakerById(id);
    }



//    @DeleteMapping("/delete/color/{color}")
////    @RequestMapping(value="/delete/color/{color}", method=RequestMethod.DELETE)
//    public void deleteSneakersByColor(@PathVariable String color) {
//        sneakerRepository.deleteByColor(color);
//    }



}