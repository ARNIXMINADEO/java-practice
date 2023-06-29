// package com.example.demo2;

// import java.util.Date;
// import java.util.List;

// import org.assertj.core.api.Assertions;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// import com.example.demo3.Entity.Category;
// import com.example.demo3.Entity.Product;
// import com.example.demo3.Repository.ProductRepository;



// @DataJpaTest
// public class ProductRepositoryMockTest {

//     @Autowired
//     private ProductRepository productRepository;

//     @Test
//     public void whenFindByCategory_thenReturnListProducts(){
//         Product product01 = Product.builder()
//                             .name("Pc gamer")
//                             .category(Category.builder().id(1L).build())
//                             .description("asd")
//                             .stock(Double.parseDouble("10"))
//                             .price(Double.parseDouble("1200.99"))
//                             .status("Created")
//                             .createAt(new Date()).build();

//         productRepository.save(product01);

//         List<Product> founds = productRepository.findByCategory(product01.getCategory());

//         Assertions.assertThat(founds.size()).isEqualTo(3);
//     };
// }