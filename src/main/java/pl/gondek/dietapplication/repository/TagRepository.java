package pl.gondek.dietapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gondek.dietapplication.model.manyToMany.Post;
import pl.gondek.dietapplication.model.manyToMany.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
