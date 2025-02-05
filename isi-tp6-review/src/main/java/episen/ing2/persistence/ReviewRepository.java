package episen.ing2.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import java.util.Collection;


@RepositoryRestResource(path = "reviews", collectionResourceRel = "reviews")
public interface ReviewRepository extends JpaRepository<Review, Long> {

    public Collection<Review> findByEmail(String email);

    @Query(value = "select rev from Review rev where rev.author like :author")
    public Page<Review> reviewByAuthor(@Param("author") String author, Pageable pageable);

}
