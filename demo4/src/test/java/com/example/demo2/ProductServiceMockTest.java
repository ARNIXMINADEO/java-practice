// package com.example.demo2;

// import java.util.Date;
// import java.util.Optional;

// import org.assertj.core.api.Assertions;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.Mock;
// import org.mockito.Mockito;
// import org.mockito.MockitoAnnotations;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;

// import com.example.demo3.Entity.Category;
// import com.example.demo3.Entity.Product;
// import com.example.demo3.Repository.ProductRepository;
// import com.example.demo3.Service.ProductService;
// import com.example.demo3.Service.ProductServiceImp;

// @SpringBootTest
// public class ProductServiceMockTest {
    
//     @Mock
//     private ProductRepository productRepository;

//     private ProductService productService;

//     @BeforeEach
//     public void setup() throws Exception{
//         MockitoAnnotations.openMocks(productRepository).close();
//         productService = new ProductServiceImp(productRepository);

//         Product computer = Product.builder()
//                             .id(1L)
//                             .name("Pc gamer")
//                             .category(Category.builder().id(1L).build())
//                             .description("asd")
//                             .stock(Double.parseDouble("10"))
//                             .price(Double.parseDouble("1200.99"))
//                             .status("Created")
//                             .createAt(new Date()).build();
//         Mockito.when(productRepository.findById(1L))
//         .thenReturn(Optional.of(computer));
//         Mockito.when(productRepository.save(computer))
//         .thenReturn(computer);
//     }

//     @Test
//     public void whenValidGetId_thenReturnProduct(){
//         Product found = productService.getProductById(1L);
//         Assertions.assertThat(found.getName()).isEqualTo("Pc gamer");
//     }

//     @Test
//     public void whenValidUpdateStock_thenReturnNewStock(){
//         Product newStock = productService.updateStock(1L, Double.parseDouble("8"));
//         Assertions.assertThat(newStock.getStock()).isEqualTo(18);
//     }
// }
