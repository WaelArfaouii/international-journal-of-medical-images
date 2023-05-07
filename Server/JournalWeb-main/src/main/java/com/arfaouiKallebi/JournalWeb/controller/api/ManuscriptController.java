package com.arfaouiKallebi.JournalWeb.controller.api;

import com.arfaouiKallebi.JournalWeb.dto.CommentDTO;
import com.arfaouiKallebi.JournalWeb.dto.ItemDTO;
import com.arfaouiKallebi.JournalWeb.model.Attachment;
import com.arfaouiKallebi.JournalWeb.model.Item;
import com.arfaouiKallebi.JournalWeb.services.AttachmentService;
import com.arfaouiKallebi.JournalWeb.services.CommentService;
import com.arfaouiKallebi.JournalWeb.services.ItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController
@RequestMapping("/manusccripts/{idman}")
public class ManuscriptController {
    @Autowired
    private CommentService commentService ;
    @Autowired
    private AttachmentService attachmentService ;
    @Autowired
    private ObjectMapper objectMapper ;
    @Autowired
    private ItemService itemService ;
    @GetMapping("items")
    public List<ItemDTO> getItems(@PathVariable Long idman){
        return itemService.getItems(idman) ;
    }
    @GetMapping("items/{id}")
    public ItemDTO getItemById(@PathVariable Long id){
        return itemService.findById(id) ;
    }
    @DeleteMapping("items/delete/{id}")
    public ResponseEntity<?> deleteItemById(@PathVariable Long id){
        return itemService.deleteById(id);
    }
    @PostMapping("items/save")
    public ItemDTO saveItem( @PathVariable Long idman , @RequestParam("model") String item , @RequestParam("file") MultipartFile file) throws Exception {
        Item itemObj = objectMapper.readValue(item ,Item.class) ;
        ItemDTO itemDTO = ItemDTO.fromEntity(itemObj) ;
        return itemService.save( idman,  itemDTO , file); }
    @GetMapping("items/{iditem}/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long iditem , @PathVariable String fileId) throws Exception {
        Attachment attachment = null;

        attachment = itemService.findById(iditem).getAttachment() ;
        return  ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(attachment.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + attachment.getFileName()
                                + "\"")
                .body(new ByteArrayResource(attachment.getData()));
    }
    @GetMapping("comments")
    public List<CommentDTO> getComments(@PathVariable Long idman ){
        return commentService.getComments(idman) ;
    }
    @DeleteMapping("comments/delete/{id}")
    public ResponseEntity<?> deleteCommentById( @PathVariable Long id){
        return commentService.deleteById(id);
    }
    @PostMapping("comments/save")
    public CommentDTO saveComment(@PathVariable Long idman ,@RequestBody CommentDTO comment){
        return commentService.saveComment(idman , comment) ;
    }
}
