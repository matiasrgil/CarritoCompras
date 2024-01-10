package com.matias.CarritoCompras.Servicies;

import com.matias.CarritoCompras.Entities.Dtos.ProductDto;
import com.matias.CarritoCompras.Entities.Product;
import com.matias.CarritoCompras.Entities.User;
import com.matias.CarritoCompras.Exceptions.NotFoundException;
import com.matias.CarritoCompras.Exceptions.Products.AmountInvalid;
import com.matias.CarritoCompras.Mappers.ProductMapper;
import com.matias.CarritoCompras.Mappers.UserMapper;
import com.matias.CarritoCompras.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductDto> getProducts() {
        return repository.findAll().stream()
                .map(ProductMapper::productToDto)
                .collect(Collectors.toList());
    }

    public ProductDto getProductById(Long id) {
        Product product = repository.findById(id).orElseThrow(() -> new NotFoundException("El producto con id: " + id + " no ha sido encontrado"));
        return ProductMapper.productToDto(product);
    }

    public ProductDto createProduct(ProductDto product) {
        Product entity = ProductMapper.dtoToProduct(product);
        entity.setPriceTotal(calculateFinalPrice(entity));

        Product entitySaved = repository.save(entity);
        product = ProductMapper.productToDto(entitySaved);
        return product;
    }

    public ProductDto updateProduct(Long id, ProductDto product) {
        if (repository.existsById(id)) {
            Product productToModify = repository.findById(id).get();

            if (!(Objects.isNull(product.getName()))) {
                productToModify.setName(product.getName());
            }
            if (!(Objects.isNull(product.getSize()))) {
                productToModify.setSize(product.getSize());
            }
            if (!(Objects.isNull(product.getPriceUnit()))) {
                productToModify.setPriceUnit(product.getPriceUnit());
                productToModify.setPriceTotal(calculateFinalPrice(productToModify));
            }
            if (!(Objects.isNull(product.getAmount()))) {
                if (noMoreTwelveProducts(ProductMapper.dtoToProduct(product))) {
                    productToModify.setAmount(product.getAmount());
                    productToModify.setPriceTotal(calculateFinalPrice(productToModify));
                } else {
                    throw new AmountInvalid("Se excedió del límite de 12 productos");
                }
            }

            Product productModify = repository.save(productToModify);

            return ProductMapper.productToDto(productModify);
        } else {
            throw new NotFoundException("El product con id: " + id + " no ha sido encontrado");
        }
    }

    public String deleteProduct(Long id) {
        Product product = repository.findById(id).orElseThrow(() -> new NotFoundException("El producto con id: " + id + " no ha sido encontrado"));
        String name = product.getName();
        repository.deleteById(id);
        return "Se ha eliminado " + name + " de su carrito";
    }

    public static BigDecimal calculateFinalPrice(Product product) {
        return product.getPriceUnit()
                .multiply(new BigDecimal(product.getAmount()))
                .setScale(2, RoundingMode.HALF_EVEN);
    }

    public static boolean noMoreTwelveProducts(Product product) {
        return product.getAmount() <= 12;
    }

}
