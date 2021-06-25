package com.cognizant.ptaedgeservice.controller;

import com.cognizant.ptaedgeservice.service.ServiceLayer;
import com.cognizant.ptaedgeservice.viewModel.ResourcePlusComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResourcePlusCommentController {
    @Autowired
    private ServiceLayer serviceLayer;

    @RequestMapping(value = "/resource", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResourcePlusComments createPostPlusComment(@RequestBody ResourcePlusComments viewModel) {
        return serviceLayer.savePost(viewModel);
    }

    @RequestMapping(value = "/resource", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<ResourcePlusComments> getAllPosts() {
        return serviceLayer.getAllPosts();
    }

    @RequestMapping(value = "/resource/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResourcePlusComments getPostById(@PathVariable int id) {
        return serviceLayer.findResource(id);
    }


    @RequestMapping(value = "/resource/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteResource(@PathVariable int id) {
        serviceLayer.removePost(id);
    }


    @RequestMapping(value = "/resource/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(@PathVariable int id, @RequestBody ResourcePlusComments viewModel) {
        if (viewModel.getId() != id) {
            throw new RuntimeException("What are you tryin to do?!??!?!");
        }
        serviceLayer.updatePost(viewModel);
    }

    @RequestMapping(value = "/testNonJson", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String doAStringThing(@RequestBody Integer inputInteger) {
        return "You passed the number " + inputInteger + ". it is very nice.";
    }

}
