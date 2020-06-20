package br.com.buscadevapi.repository;

import br.com.buscadevapi.model.Link;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LinkRepository extends JpaRepository<Link, Long> {

    @Query(value = "SELECT * FROM LINK " +
            "WHERE USER_USER_ID = :userId", nativeQuery = true)
    Page<Link> findPagedLinksByUser(Pageable pageable, @Param("userId") Long userId);

    @Query(value = "SELECT EXISTS( " +
            "SELECT 1 FROM LINK WHERE LINK = :link " +
            "AND LINK_TYPE = :linkType " +
            "AND USER_USER_ID = :userId " +
            "LIMIT 1)", nativeQuery = true)
    boolean findIfLinkExists(@Param("link") String link, @Param("linkType") String linkType, @Param("userId") Long userId);

    @Query(value = "SELECT EXISTS( " +
            "SELECT 1 FROM LINK WHERE LINK_ID = :linkId " +
            "LIMIT 1)", nativeQuery = true)
    boolean findIfLinkExistsById(@Param("linkId") Long linkId);
}
