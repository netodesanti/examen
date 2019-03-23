package com.examen.Examen1.web;

import com.examen.Examen1.domain.Tag;
import com.examen.Examen1.domain.User;
import com.examen.Examen1.service.TagService;
import com.examen.Examen1.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tag")
@CrossOrigin
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping
    public void createTag(@RequestBody Tag tag) {
        tagService.createTag(tag);
    }

    @GetMapping
    public List<Tag> findAll() {
        return tagService.findAll();
    }

    @GetMapping("find-existing")
    public Tag findExisting(@RequestParam String name) {
        return tagService.findExisting(name);
    }

}
