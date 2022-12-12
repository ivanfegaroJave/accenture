package com.accenture.accenture.entryPoint.controller;

import com.accenture.accenture.crosscuting.constants.Constants;
import com.accenture.accenture.crosscuting.constants.ResourceEndpoint;
import com.accenture.accenture.domain.Comment;
import com.accenture.accenture.entryPoint.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = Constants.CROSS_ORIGIN)
@RequestMapping(value = ResourceEndpoint.COMMENT)
public class CommentController {

    private final CommentService commentService;

    @GetMapping(value = ResourceEndpoint.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Comment>> getAllComments() {
        return new ResponseEntity<>(commentService.getAllComments(), HttpStatus.OK);
    }

    @GetMapping(value = ResourceEndpoint.COMMENTS_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Comment>> getCommentsById(@PathVariable Long id) {
        return new ResponseEntity<>(commentService.getCommentsByID(id), HttpStatus.OK);
    }


    @GetMapping(value = ResourceEndpoint.FILTER, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Comment>> getCommentsByUserIdOrName(@RequestParam(value = Constants.USERID, required = false) Long id,
                                                             @RequestParam(value = Constants.NAME, required = false) String name) {
        return new ResponseEntity<>(commentService.getCommentsByUserIdOrName(id, name), HttpStatus.OK);
    }




}
