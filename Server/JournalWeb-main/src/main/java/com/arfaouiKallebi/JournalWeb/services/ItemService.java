package com.arfaouiKallebi.JournalWeb.services;

import com.arfaouiKallebi.JournalWeb.dto.ItemDTO;

import java.util.List;

import com.arfaouiKallebi.JournalWeb.dto.ItemDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ItemService {
    List<ItemDTO> findAll() ;
    ItemDTO findById(Long id) ;
    ItemDTO deleteById(Long id) ;

    Long save(Long idman , ItemDTO dto , MultipartFile file) throws Exception ;
}
