package com.apress.demo.springblog.domain;


import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    private Integer id;
    private String title;
    private String description;
    private String body;
    private String slug;
    private PostStatus postStatus;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private List<Comment> comments;

}
