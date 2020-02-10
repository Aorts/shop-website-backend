package com.dziksklep.dzikserv;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {
    public ImageModel findById(long id);
    public ImageModel findByProduct(Product product);
}