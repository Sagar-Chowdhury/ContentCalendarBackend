package dev.SagarChowdhury.contentcalendar.controller;


import dev.SagarChowdhury.contentcalendar.model.Content;
import dev.SagarChowdhury.contentcalendar.repository.ContentCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private  final ContentCollectionRepository repository;

    @Autowired
    public ContentController(ContentCollectionRepository repository)
    {
        this.repository=repository;
    }

    @GetMapping("")
    public List<Content> findAll()
    {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not Found "));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Content content)
    {
       repository.save(content);
    }






}
