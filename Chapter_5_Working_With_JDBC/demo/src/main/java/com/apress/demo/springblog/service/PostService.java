package com.apress.demo.springblog.service;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.repository.PostJdbcDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostJdbcDataRepository postRepository;

    public void addPost(Post post){
        post.setCreatedOn(LocalDate.now());
        post.setUpdatedOn(LocalDate.now());
        postRepository.save(post);
    }

    public Set<PostDto> findAllPosts() {
        return StreamSupport.stream(postRepository.findAll().spliterator(), false)
                .map(PostDto::toPostDto).collect(Collectors.toSet());
    }


    public boolean postExistsWithTitle(String title) {
        return postRepository.findByTitle(title).isPresent();
    }
}
