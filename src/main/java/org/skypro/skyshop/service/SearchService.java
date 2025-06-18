package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.springframework.stereotype.Service;
import java.util.Collection;



@Service
public class SearchService {


    private final StorageService storageService;


    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }


    public Collection<SearchResult> search(String pattern) {
        return storageService.getAllSearchable().stream()
                .filter(s -> s.getSearchName().toLowerCase().contains(pattern.toLowerCase()))
                .map(SearchResult::fromSearchable)
                .toList();
    }

}
