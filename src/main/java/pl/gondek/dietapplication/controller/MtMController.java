package pl.gondek.dietapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.gondek.dietapplication.model.manyToMany.Post;
import pl.gondek.dietapplication.model.manyToMany.Tag;
import pl.gondek.dietapplication.repository.PostRepository;
import pl.gondek.dietapplication.repository.TagRepository;

import java.util.List;

@Controller
public class MtMController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TagRepository tagRepository;

    @GetMapping("/mtm")
    public String method()
    {

        List<Post> allPosts = postRepository.findAll();

        List<Tag> allTags = tagRepository.findAll();

        return "test";
    }
}
