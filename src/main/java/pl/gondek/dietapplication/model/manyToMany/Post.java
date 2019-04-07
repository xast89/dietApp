package pl.gondek.dietapplication.model.manyToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Entity(name = "Post")
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue
    private Long post_id;

    private String title;

//    @OneToMany(
//            mappedBy = "post",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private List<PostTag> tags = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "tag_id"))
    private List<Tag> tags = new ArrayList<>();

    public Post() {
    }

    public Post(String title) {
        this.title = title;
    }

    public Long getPost_id()
    {
        return post_id;
    }

    public void setPost_id(Long post_id)
    {
        this.post_id = post_id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setTags(List<Tag> tags)
    {
        this.tags = tags;
    }

    public List<Tag> getTags()
    {
        return tags;
    }

//    public void setTags(List<PostTag> tags)
//    {
//        this.tags = tags;
//    }
//
//    public void addTag(Tag tag) {
//        PostTag postTag = new PostTag(this, tag);
//        tags.add(postTag);
//        tag.getPosts().add(postTag);
//    }
//
//    public void removeTag(Tag tag) {
//        for (Iterator<PostTag> iterator = tags.iterator();
//             iterator.hasNext(); ) {
//            PostTag postTag = iterator.next();
//
//            if (postTag.getUser().equals(this) &&
//                    postTag.getMeal().equals(tag)) {
//                iterator.remove();
//                postTag.getMeal().getPosts().remove(postTag);
//                postTag.setUser(null);
//                postTag.setMeal(null);
//            }
//        }
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Post post = (Post) o;
        return Objects.equals(title, post.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}