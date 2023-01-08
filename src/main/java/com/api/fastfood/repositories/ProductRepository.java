package com.api.fastfood.repositories;

import com.api.fastfood.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {
    @Query(
            value = """
SELECT `r`.*
FROM (
SELECT `p`.`id`, `p`.`name`
FROM `product` `p`
WHERE
        (
        (:id IS NULL)
        OR
        (:id = `p`.`id`)
    )
    AND (
        (:name IS NULL)
        OR
        (UPPER(`p`.`name`) LIKE UPPER(CONCAT('%', :name, '%')))
    )
    AND (
        (:classifications IS NULL)
        OR
        EXISTS (
            SELECT 1
            FROM `product_classification` `pc`
            WHERE
                    `pc`.`classification_id` IN :classifications
                AND `pc`.`product_id` = `p`.`id`
        )
    )
    AND (
        (:last_id = 0)
        OR
        (`p`.`id` > :last_id)
    )
ORDER BY `p`.`id` DESC
) r
LIMIT :limit
""",
            nativeQuery = true
    )
    List<ProductModel> findProduct(@Param("limit") Integer limit, @Param("last_id") Integer last_id, @Param("id") Integer id, @Param("name") String name, @Param("classifications")ArrayList<Integer> classifications);
}
