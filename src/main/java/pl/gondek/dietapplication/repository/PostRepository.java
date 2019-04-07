package pl.gondek.dietapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gondek.dietapplication.model.manyToMany.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
