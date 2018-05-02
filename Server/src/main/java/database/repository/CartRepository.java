package database.repository;

import entity.Book;
import entity.Cart;
import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query("from Cart where userid= :userId")
    List<Cart> getCartByUserId(@Param("userId") User userId);

    @Query("from Cart where userid= :userId and bookid = :bookId")
    Cart getCartByKey(@Param("userId") User userId, @Param("bookId") Book bookId);

}
