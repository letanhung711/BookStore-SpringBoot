package com.example.Library.service.Impl;

import com.example.Library.dto.ProductDto;
import com.example.Library.dto.ProductInfoDto;
import com.example.Library.model.Product;
import com.example.Library.model.ProductInfo;
import com.example.Library.repository.ProductInfoRepository;
import com.example.Library.repository.ProductRepository;
import com.example.Library.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;
import java.time.LocalDate;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public Optional<Product> getProductInformation(long id) {
        return productRepository.findById(id);
    }

    @Override
    public String addProduct(ProductDto productDto, ProductInfoDto productInfoDto, MultipartFile file) throws IOException {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(productInfoDto.getNgayxb(), inputFormatter);
        String formattedDate = localDate.format(outputFormatter);

        long dateNow = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(dateNow);

        Product product =new Product();
        product.setName(productDto.getName());
        product.setAuthor(productDto.getAuthor());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        product.setNote(productDto.getNote());
        product.setCreate_time(timestamp);
        product.setUpdate_time(timestamp);
        // Lưu ảnh vào thư mục static
        String uploadDir = "E:\\Workspace\\WebSale\\Users\\src\\main\\resources\\static\\img\\sanpham";
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        // Lưu tệp ảnh vào thư mục static
        Path filePath = Paths.get(uploadDir, file.getOriginalFilename());
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }
        // Lưu thông tin về ảnh vào cơ sở dữ liệu
        product.setImageUrl("/img/sanpham/" + file.getOriginalFilename());
        productRepository.save(product);

        ProductInfo productInfo = new ProductInfo();
        productInfo.setNhaphathanh(productInfoDto.getNhaphathanh());
        productInfo.setNxb(productInfoDto.getNxb());
        productInfo.setWeight(productInfoDto.getWeight());
        productInfo.setSize(productInfoDto.getSize());
        productInfo.setNumberPage(productInfoDto.getNumberPage());
        productInfo.setNgayxb(formattedDate);
        productInfo.setParagraph(productInfoDto.getParagraph());
        productInfo.setProduct(product);
        productInfoRepository.save(productInfo);
        return "Create product successful!!!";
    }

    @Override
    public String updateProduct(long id, ProductDto productDto) {
        return null;
    }

    @Override
    public String deleteProduct(long id) {
        return null;
    }

    @Override
    public Optional<ProductInfo> getInfoOfProduct(long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(Product::getProductInfo);
    }

    public Timestamp convertToDate(String date){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dateObject = dateFormat.parse(date);
            Timestamp timestamp = new Timestamp(dateObject.getTime());
            return timestamp;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
