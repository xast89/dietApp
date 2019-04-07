package pl.gondek.dietapplication.model.manyToMany;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.Objects;
//
//@Entity(name = "PostTag")
//@Table(name = "post_tag")
public class PostTag {
//
//    @EmbeddedId
//    private PostTagId id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("postId")
//    private Post post;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("tagId")
//    private Tag tag;
//
//    @Column(name = "created_on")
//    private Date createdOn = new Date();
//
//    private PostTag() {}
//
//    public PostTag(Post post, Tag tag) {
//        this.post = post;
//        this.tag = tag;
//        this.id = new PostTagId(post.getTag_id(), tag.getTag_id());
//    }
//
//    public PostTagId getTag_id()
//    {
//        return id;
//    }
//
//    public void setTag_id(PostTagId id)
//    {
//        this.id = id;
//    }
//
//    public Post getUser()
//    {
//        return post;
//    }
//
//    public void setUser(Post post)
//    {
//        this.post = post;
//    }
//
//    public Tag getMeal()
//    {
//        return tag;
//    }
//
//    public void setMeal(Tag tag)
//    {
//        this.tag = tag;
//    }
//
//    public Date getCreatedOn()
//    {
//        return createdOn;
//    }
//
//    public void setCreatedOn(Date createdOn)
//    {
//        this.createdOn = createdOn;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//
//        if (o == null || getClass() != o.getClass())
//            return false;
//
//        PostTag that = (PostTag) o;
//        return Objects.equals(post, that.post) &&
//                Objects.equals(tag, that.tag);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(post, tag);
//    }
}
