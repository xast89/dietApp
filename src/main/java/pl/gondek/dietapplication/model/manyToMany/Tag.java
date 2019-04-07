package pl.gondek.dietapplication.model.manyToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.util.*;

@Entity(name = "Tag")
@Table(name = "tag")
@NaturalIdCache
@Cache(
        usage = CacheConcurrencyStrategy.READ_WRITE
)
public class Tag {

    @Id
    @GeneratedValue
    private Long tag_id;

    private String name;

//    @OneToMany(
//            mappedBy = "tag",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private List<PostTag> posts = new ArrayList<>();


    public Set<Post> getPosts()
    {
        return posts;
    }

    public void setPosts(Set<Post> posts)
    {
        this.posts = posts;
    }

    @ManyToMany(mappedBy = "tags")
    private Set<Post> posts = new HashSet<>();

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    public Long getTag_id()
    {
        return tag_id;
    }

    public void setTag_id(Long tag_id)
    {
        this.tag_id = tag_id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }


    //Getters and setters omitted for brevity

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(name, tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}