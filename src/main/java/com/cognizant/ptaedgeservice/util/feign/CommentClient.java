package com.cognizant.ptaedgeservice.util.feign;


import com.cognizant.ptaedgeservice.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "pta-resource-commenting-service")
public interface CommentClient {

        @GetMapping("/comment")
        public List<Comment> getAllComments();

        @PostMapping("/comment")
        public Comment createComment(@RequestBody Comment comment);

        @GetMapping("/comment/{id}")
        @ResponseStatus(HttpStatus.OK)
        public Comment getById(@PathVariable Integer id);

        @GetMapping("/get-by-resource-id")
        @ResponseStatus(HttpStatus.OK)
        public List< Comment> getCommentByResourceId(@RequestParam Integer id);

        @PutMapping
        @ResponseStatus(HttpStatus.OK)
        public void editComments(@RequestBody Comment comment, @PathVariable Integer id);

}
