package com.examen.Examen1.service;

import com.examen.Examen1.domain.Tag;
import com.examen.Examen1.domain.User;
import com.examen.Examen1.repository.TagRepository;
import com.examen.Examen1.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public void createTag(Tag tag) {

        tagRepository.save(tag);
    }

    @Transactional(readOnly = true)
    public List<Tag> findAll() {

        return tagRepository.findAll();
    }

    public Tag findExisting(String name) {
        String str = name.toLowerCase().substring(0,1).toUpperCase() + name.toLowerCase().substring(1);

        if (tagRepository.findByName(str) != null ) {
            return tagRepository.findByName(str);
        } else {
            Tag tag = new Tag();
            tag.setName(name);
            createTag(tag);
            return tagRepository.findByName(name);
        }
    }

}
