package com.arfaouiKallebi.JournalWeb.controller.api;

import com.arfaouiKallebi.JournalWeb.dto.ManuscriptDTO;
import com.arfaouiKallebi.JournalWeb.services.ManuscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/authors/{idauth}")
@CrossOrigin(origins = "*")
public class AuthorController {
    @Autowired
    private ManuscriptService manuscriptService ;

    @GetMapping("manuscripts")
    public List<ManuscriptDTO> getManuscripts(@PathVariable Long idauth){
        return manuscriptService.findManuscripts(idauth) ;
    }
    @DeleteMapping("manuscripts/delete/{id}")
    public ManuscriptDTO deleteManuscriptById(@PathVariable Long idauth , @PathVariable Long id){
        return manuscriptService.deleteManuscriptById(idauth, id);
    }
    @PostMapping("manuscripts/save")
    public ManuscriptDTO saveManuscript(@PathVariable Long idauth , @RequestBody ManuscriptDTO manuscript){
        return manuscriptService.saveManuscript(idauth , manuscript);
    }
    @GetMapping("manuscripts/processed")
    public List<ManuscriptDTO> getProcessedManuscripts(@PathVariable Long idauth){
        return manuscriptService.getProcessedManuscripts(idauth);
    }
    @GetMapping("manuscripts/sentBack")
    public List<ManuscriptDTO> getSentBackManuscripts(@PathVariable Long idauth){
        return manuscriptService.getSentBackManuscripts(idauth);
    }
    @GetMapping("manuscripts/incomplete")
    public List<ManuscriptDTO> getIncompleteManuscripts(@PathVariable Long idauth){
        return manuscriptService.getIncompleteManuscripts(idauth);
    }
    @GetMapping("manuscripts/waiting")
    public List<ManuscriptDTO> getWaitingManuscripts(@PathVariable Long idauth){
        return manuscriptService.getWaitingManuscripts(idauth);
    }

}
