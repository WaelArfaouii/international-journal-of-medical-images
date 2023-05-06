package com.arfaouiKallebi.JournalWeb.controller.api;

import com.arfaouiKallebi.JournalWeb.dto.CommentDTO;
import com.arfaouiKallebi.JournalWeb.dto.ItemDTO;
import com.arfaouiKallebi.JournalWeb.model.Item;
import com.arfaouiKallebi.JournalWeb.services.CommentService;
import com.arfaouiKallebi.JournalWeb.services.ItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController
@RequestMapping("/manusccripts/{idman}")
public class ManuscriptController {
    @Autowired
    private CommentService commentService ;
    @Autowired
    private ObjectMapper objectMapper ;
    @Autowired
    private ItemService itemService ;
    @GetMapping("items")
    public List<ItemDTO> getItems(){
        return itemService.findAll() ;
    }
    @GetMapping("items/{id}")
    public ItemDTO getItemById(@PathVariable Long id){
        return itemService.findById(id) ;
    }
    @DeleteMapping("items/delete/{id}")
    public ItemDTO deleteItemById(@PathVariable Long id){
        return itemService.deleteById(id);
    }
    @PostMapping("items/save")
    public Long saveItem( @PathVariable Long idman , @RequestParam("model") String item , @RequestParam("file") MultipartFile file) throws Exception {
        Item itemObj = objectMapper.readValue(item ,Item.class) ;
        ItemDTO itemDTO = ItemDTO.fromEntity(itemObj) ;
        return itemService.save( idman,  itemDTO , file); }
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
