package com.arfaouiKallebi.JournalWeb.services.impl;

import com.arfaouiKallebi.JournalWeb.dto.ItemDTO;
import com.arfaouiKallebi.JournalWeb.dto.ManuscriptDTO;
import com.arfaouiKallebi.JournalWeb.model.Attachment;
import com.arfaouiKallebi.JournalWeb.model.Item;
import com.arfaouiKallebi.JournalWeb.model.Manuscript;
import com.arfaouiKallebi.JournalWeb.repository.ItemRepository;
import com.arfaouiKallebi.JournalWeb.services.AttachmentService;
import com.arfaouiKallebi.JournalWeb.services.ItemService;
import com.arfaouiKallebi.JournalWeb.services.ManuscriptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
//Logger
@Slf4j
public class ItemServiceImpl implements ItemService {
    @Autowired
    private AttachmentService attachmentService ;
    @Autowired
    private ManuscriptService manuscriptService ;
    @Autowired
    private ItemRepository itemRepository ;
    @Override
    public List<ItemDTO> findAll() {
        return itemRepository.findAll().stream()
                .map(ItemDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ItemDTO findById(Long id) {
        return null;
    }

    @Override
    public ItemDTO deleteById(Long id) {

        return ItemDTO.fromEntity(itemRepository.deleteItemById(id));
    }



    @Override
    public Long save(Long idman , ItemDTO dto , MultipartFile file) throws Exception{
        Attachment attachment = attachmentService.saveAttachment(file) ;
        Manuscript manuscript = ManuscriptDTO.toEntity(manuscriptService.findById(idman))  ;
        Item item = ItemDTO.toEntity(dto) ;
        item.setAttachment(attachment);
        List<Item> items = manuscript.getItems() ;
        items.add(item) ;
        manuscript.setItems(items);
        ManuscriptDTO man = manuscriptService.save(ManuscriptDTO.fromEntity(manuscript)) ;
        item.setManuscript(ManuscriptDTO.toEntity(man));
        Item itemSaved = itemRepository.save(item) ;
        return itemSaved.getId() ;
    }
}
