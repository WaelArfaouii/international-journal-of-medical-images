package com.arfaouiKallebi.JournalWeb.controller.api;

import com.arfaouiKallebi.JournalWeb.dto.CommentDTO;
import com.arfaouiKallebi.JournalWeb.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/manusccripts/{idman}")
public class ManuscriptController {
    @Autowired
    private CommentService commentService ;

    @GetMapping("comments")
    public List<CommentDTO> getComments(@PathVariable Long idman ){
        return commentService.findAll() ;
    }
    @DeleteMapping("comments/delete/{id}")
    public CommentDTO deleteCommentById(@PathVariable Long idman , @PathVariable Long id){
        return commentService.deleteById(id);
    }
    @PostMapping("comments/save")
    public CommentDTO saveComment(@PathVariable Long idman ,@RequestBody CommentDTO comment){
        return commentService.save(comment) ;
    }
}
