package com.arfaouiKallebi.JournalWeb.controller.api;

import com.arfaouiKallebi.JournalWeb.dto.ArticleDTO;
import com.arfaouiKallebi.JournalWeb.dto.AuthorDTO;
import com.arfaouiKallebi.JournalWeb.dto.CommentDTO;
import com.arfaouiKallebi.JournalWeb.dto.ManuscriptDTO;
import com.arfaouiKallebi.JournalWeb.services.AuthorService;
import com.arfaouiKallebi.JournalWeb.services.CommentService;
import com.arfaouiKallebi.JournalWeb.services.ManuscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService ;
    @Autowired
    private ManuscriptService manuscriptService ;
    @Autowired
    private CommentService commentService ;
    @GetMapping
    public List<AuthorDTO> getAuthors(){
        return authorService.findAll();
    }
    @GetMapping("/{id}")
    public AuthorDTO getAuthorById(@PathVariable Long id){
        return authorService.findById(id);
    }
    @DeleteMapping("delete/{id}")
    public AuthorDTO deleteAuthorById(@PathVariable Long id){
        return authorService.deleteById(id);
    }
    @PostMapping("save")
    public AuthorDTO saveAuthor( @RequestBody AuthorDTO author){
        return authorService.save(author);
    }
    @GetMapping("manuscripts")
    public List<ManuscriptDTO> getManuscripts(){
        return manuscriptService.findAll() ;
    }
    @GetMapping("manuscripts/{id}")
    public ManuscriptDTO getManuscriptById(@PathVariable Long id){
        return manuscriptService.findById(id) ;
    }
    @DeleteMapping("manuscripts/delete/{id}")
    public ManuscriptDTO deleteManuscriptById(@PathVariable Long id){
        return manuscriptService.deleteById(id);
    }
    @PostMapping("manuscripts/save")
    public ManuscriptDTO saveManuscript(@RequestBody ManuscriptDTO manuscript){
        return manuscriptService.save(manuscript);
    }
    @GetMapping("manuscripts/processed")
    public List<ManuscriptDTO> getProcessedManuscripts(){
        return manuscriptService.getProcessedManuscripts();
    }
    @GetMapping("manuscripts/sentBack")
    public List<ManuscriptDTO> getSentBackManuscripts(){
        return manuscriptService.getSentBackManuscripts();
    }
    @GetMapping("manuscripts/incomplete")
    public List<ManuscriptDTO> getIncompleteManuscripts(){
        return manuscriptService.getIncompleteManuscripts();
    }
    @GetMapping("manuscripts/waiting")
    public List<ManuscriptDTO> getWaitingManuscripts(){
        return manuscriptService.getWaitingManuscripts();
    }
    @GetMapping("manuscripts/{idman}/comments")
    public List<CommentDTO> getComments(){
        return commentService.findAll() ;
    }
    @DeleteMapping("manuscripts/{idman}/comments/delete/{id}")
    public CommentDTO deleteCommentById(@PathVariable Long idman ,@PathVariable Long id){
        return commentService.deleteById(id);
    }
    @PostMapping("manuscripts/{idman}/comments/save")
    public CommentDTO saveComment(@RequestBody CommentDTO comment){
        return commentService.save(comment) ;
    }
}
