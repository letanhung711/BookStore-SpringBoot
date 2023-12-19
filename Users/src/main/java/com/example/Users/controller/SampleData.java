package com.example.Users.controller;

import com.example.Library.model.Product;
import com.example.Library.model.ProductInfo;
import com.example.Library.model.Users;
import com.example.Library.repository.ProductInfoRepository;
import com.example.Library.repository.ProductRepository;
import com.example.Library.repository.UserRepository;
import com.example.Library.service.Impl.ProductServiceImpl;
import com.example.Library.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class SampleData implements CommandLineRunner {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public void run(String... args) throws Exception {
        addProduct();
        addUser();
    }
    private void addUser() throws ParseException {
        if (!userRepository.existsByFullname("Lê Văn A")) {
            // Định dạng của chuỗi ngày tháng
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Users users = new Users();
            users.setFullname("Lê Văn A");
            users.setAddress("Tiền Giang");
            users.setPhone("0123456789");
            users.setEmail("levana@gmail.com");
            users.setBirthdate(dateFormat.parse("2023-11-30"));
            users.setUsername("admin");
            users.setPassword(passwordEncoder.encode("123456"));
            users.setCreate_time(userService.convertToDate("8/2/2023"));
            userRepository.save(users);
        }
    }
    private void addProduct(){
        if (!productRepository.existsByName("Hai số phận")) {
            Product product = new Product();
            product.setName("Hai số phận");
            product.setAuthor("Jeffrey Archer");
            product.setPrice(1600.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/hai-so-phan.jpg");
            product.setCreate_time(productService.convertToDate("8/2/2023"));
            product.setUpdate_time(productService.convertToDate("8/2/2023"));
            productRepository.save(product);

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Thế Giới");
            productInfo.setNgayxb("29/3/2023");
            productInfo.setNhaphathanh("AZ Việt Nam");
            productInfo.setSize("13.0 x 19.0 x 1.5 cm");
            productInfo.setNumberPage("160 trang");
            productInfo.setWeight("530 gram");
            productInfo.setParagraph("1 đoạn ngắn");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
        }
        if (!productRepository.existsByName("Tìm mình trong thế giới hậu tuổi thơ")) {
            Product product = new Product();
            product.setName("Tìm mình trong thế giới hậu tuổi thơ");
            product.setAuthor("Đặng Hoàng Giang");
            product.setPrice(1400.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/tim-minh-trong-the-gioi-hau-tuoi-tho_104835_1.png");
            product.setCreate_time(productService.convertToDate("10/22/2023"));
            product.setUpdate_time(productService.convertToDate("10/22/2023"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Cảm ơn người lớn")) {
            Product product = new Product();
            product.setName("Cảm ơn người lớn");
            product.setAuthor("Nguyễn Nhật Ánh");
            product.setPrice(1500.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/cam-on-nguoi-lon_.png");
            product.setCreate_time(productService.convertToDate("9/3/2023"));
            product.setUpdate_time(productService.convertToDate("9/3/2023"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Bạn bè tôi vẫn ngỏm cả rồi")) {
            Product product = new Product();
            product.setName("Bạn bè tôi vẫn ngỏm cả rồi");
            product.setAuthor("Avery Monsen & Jory John");
            product.setPrice(2100.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/ban-be-toi-van-ngom-ca-roi.jpg");
            product.setCreate_time(productService.convertToDate("6/4/2018"));
            product.setUpdate_time(productService.convertToDate("6/4/2018"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Mắt Biếc")) {
            Product product = new Product();
            product.setName("Mắt Biếc");
            product.setAuthor("Nguyễn Nhật Ánh");
            product.setPrice(1500.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/mat-biec-ban-dac-biet-_100101_2.jpeg");
            product.setCreate_time(productService.convertToDate("8/2/2021"));
            product.setUpdate_time(productService.convertToDate("8/2/2021"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Trưởng thành đôi khi cũng khóc")) {
            Product product = new Product();
            product.setName("Trưởng thành đôi khi cũng khóc");
            product.setAuthor("Twoego");
            product.setPrice(2000.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/truong-thanh-doi-khi-cung-khoc.jpg");
            product.setCreate_time(productService.convertToDate("2/2/2022"));
            product.setUpdate_time(productService.convertToDate("2/2/2022"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Cố định một đám mây")) {
            Product product = new Product();
            product.setName("Cố định một đám mây");
            product.setAuthor("Nguyễn Ngọc Tư");
            product.setPrice(1900.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/co-dinh-mot-dam-may_93567_1.jpg");
            product.setCreate_time(productService.convertToDate("6/4/2022"));
            product.setUpdate_time(productService.convertToDate("6/4/2022"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Tạm biệt trời xanh")) {
            Product product = new Product();
            product.setName("Tạm biệt trời xanh");
            product.setAuthor("Misaki");
            product.setPrice(2100.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/tam-biet-troi-xanh.jpg");
            product.setCreate_time(productService.convertToDate("10/4/2022"));
            product.setUpdate_time(productService.convertToDate("10/4/2022"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Lựa chọn đúng quan trọng hơn ở nỗ lực")) {
            Product product = new Product();
            product.setName("Lựa chọn đúng quan trọng hơn ở nỗ lực");
            product.setAuthor("Annie Duke");
            product.setPrice(2000.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/lua-chon-dung-quan-trong-hon-no-luc_116876_1.png");
            product.setCreate_time(productService.convertToDate("5/4/2022"));
            product.setUpdate_time(productService.convertToDate("5/4/2022"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Trái tim không")) {
            Product product = new Product();
            product.setName("Trái tim không");
            product.setAuthor("Phan Việt");
            product.setPrice(1400.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/trai-tim-khong_116235_1.jpg");
            product.setCreate_time(productService.convertToDate("4/29/2022"));
            product.setUpdate_time(productService.convertToDate("4/29/2022"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Quảng cáo không nói láo")) {
            Product product = new Product();
            product.setName("Quảng cáo không nói láo");
            product.setAuthor("Hồ Công Hoài Phương");
            product.setPrice(1800.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/quang-cao-khong-noi-lao_117422_1.jpg");
            product.setCreate_time(productService.convertToDate("6/5/2022"));
            product.setUpdate_time(productService.convertToDate("6/5/2022"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Cơ bản là cơ bản")) {
            Product product = new Product();
            product.setName("Cơ bản là cơ bản");
            product.setAuthor("Huy Thông");
            product.setPrice(1500.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/co-ban-la-co-ban.png");
            product.setCreate_time(productService.convertToDate("8/7/2022"));
            product.setUpdate_time(productService.convertToDate("8/7/2022"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Dù cho không có phép màu")) {
            Product product = new Product();
            product.setName("Dù cho không có phép màu");
            product.setAuthor("Kii Kanna");
            product.setPrice(2300.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/du-cho-khong- co-phep-mau.jpg");
            product.setCreate_time(productService.convertToDate("3/7/2022"));
            product.setUpdate_time(productService.convertToDate("3/7/2022"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Câu chuyện ngôn ngữ")) {
            Product product = new Product();
            product.setName("Câu chuyện ngôn ngữ");
            product.setAuthor("David Crystal");
            product.setPrice(1900.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/cau-chuyen-ngon-ngu_116412_1.jpg");
            product.setCreate_time(productService.convertToDate("3/7/2022"));
            product.setUpdate_time(productService.convertToDate("3/7/2022"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Một ví dụ xoàng")) {
            Product product = new Product();
            product.setName("Một ví dụ xoàng");
            product.setAuthor("Nguyễn Bình Phương");
            product.setPrice(1300.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/mot-vi-du-xoang_117227_1.png");
            product.setCreate_time(productService.convertToDate("1/7/2021"));
            product.setUpdate_time(productService.convertToDate("1/7/2021"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Mỗi ngày tiết kiệm một giờ")) {
            Product product = new Product();
            product.setName("Mỗi ngày tiết kiệm một giờ");
            product.setAuthor("Michael Heppell");
            product.setPrice(2300.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/moi-ngay-tiet-kiem-mot-gio_117895_1.jpg");
            product.setCreate_time(productService.convertToDate("11/3/2022"));
            product.setUpdate_time(productService.convertToDate("11/3/2022"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Thanh xuân là gì em nhỉ")) {
            Product product = new Product();
            product.setName("Thanh xuân là gì em nhỉ");
            product.setAuthor("Việt Anh tuấn");
            product.setPrice(1400.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/thanh-xuan-la-gi-em-nhi-_117879_1.jpg");
            product.setCreate_time(productService.convertToDate("2/1/2021"));
            product.setUpdate_time(productService.convertToDate("2/1/2021"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Đọc vị tâm lý bất cứ ai")) {
            Product product = new Product();
            product.setName("Đọc vị tâm lý bất cứ ai");
            product.setAuthor("Dale Carnegie");
            product.setPrice(2300.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/doc-vi-tam-ly-bat-cu-ai_117891_1.jpg");
            product.setCreate_time(productService.convertToDate("3/4/2022"));
            product.setUpdate_time(productService.convertToDate("3/4/2022"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Kể cho tôi nghe")) {
            Product product = new Product();
            product.setName("Radio Người Giữ Kỉ Niệm");
            product.setAuthor("Kể cho tôi nghe");
            product.setPrice(1700.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/ke-cho-toi-nghe_117873_1.jpg");
            product.setCreate_time(productService.convertToDate("7/7/2021"));
            product.setUpdate_time(productService.convertToDate("7/7/2021"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Chuyện kể rằng có nàng và tôi")) {
            Product product = new Product();
            product.setName("Chuyện kể rằng có nàng và tôi");
            product.setAuthor("Nhiều tác giả");
            product.setPrice(1900.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/chuyen-ke-rang-co-nang-va-toi.png");
            product.setCreate_time(productService.convertToDate("3/1/2022"));
            product.setUpdate_time(productService.convertToDate("3/1/2022"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Đi thật xa trên một chiếc Camper")) {
            Product product = new Product();
            product.setName("Đi thật xa trên một chiếc Camper");
            product.setAuthor("Khải Đơn");
            product.setPrice(1600.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/di-that-xa-tren-mot-chiec-camper.png");
            product.setCreate_time(productService.convertToDate("10/1/2019"));
            product.setUpdate_time(productService.convertToDate("10/1/2019"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Người khuân Đá")) {
            Product product = new Product();
            product.setName("Người khuân đá");
            product.setAuthor("Cao Huy Thuần");
            product.setPrice(1800.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/nguoi-khuan-da_.png");
            product.setCreate_time(productService.convertToDate("1/1/2018"));
            product.setUpdate_time(productService.convertToDate("1/1/2018"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Danh sách của Schindler")) {
            Product product = new Product();
            product.setName("Danh sách của Schindler");
            product.setAuthor("Thomas Keneally");
            product.setPrice(2500.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/danh-sach-cua-schindler_91159_1.jpg");
            product.setCreate_time(productService.convertToDate("10/18/1982"));
            product.setUpdate_time(productService.convertToDate("10/18/1982"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Van Gohn")) {
            Product product = new Product();
            product.setName("Van Gohn");
            product.setAuthor("David Haziot");
            product.setPrice(2300.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/van-gogh_75252_1.gif");
            product.setCreate_time(productService.convertToDate("5/1/2019"));
            product.setUpdate_time(productService.convertToDate("5/1/2019"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Ngày tháng năm")) {
            Product product = new Product();
            product.setName("Ngày tháng năm");
            product.setAuthor("Diêm Liên Khoa");
            product.setPrice(1500.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/ngay-thang-nam_117824_1.jpg");
            product.setCreate_time(productService.convertToDate("3/1/2022"));
            product.setUpdate_time(productService.convertToDate("3/1/2022"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Nghiệt tử")) {
            Product product = new Product();
            product.setName("Nghiệt tử");
            product.setAuthor("Bạch Tiên Dũng");
            product.setPrice(1900.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/nghiet-tu.jpg");
            product.setCreate_time(productService.convertToDate("1/1/2018"));
            product.setUpdate_time(productService.convertToDate("1/1/2022"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Hai vạn dặm dưới đáy biển")) {
            Product product = new Product();
            product.setName("Hai vạn dặm dưới đáy biển");
            product.setAuthor("Jules Verne");
            product.setPrice(2300.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/hai-van-dam-duoi-day-bien-huy-hoang__96562.jpg");
            product.setCreate_time(productService.convertToDate("1/2/2016"));
            product.setUpdate_time(productService.convertToDate("1/2/2022"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Kẻ đoạt hồn")) {
            Product product = new Product();
            product.setName("Kẻ đoạt hồn");
            product.setAuthor("Sebastian Fitzek");
            product.setPrice(2400.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/ke-doat-hon.jpg");
            product.setCreate_time(productService.convertToDate("02/08/2019"));
            product.setUpdate_time(productService.convertToDate("02/08/2019"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Mũi Hếch")) {
            Product product = new Product();
            product.setName("Mũi Hếch");
            product.setAuthor("Dan Buettner");
            product.setPrice(2100.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/mui-hech.jpg");
            product.setCreate_time(productService.convertToDate("1/5/2022"));
            product.setUpdate_time(productService.convertToDate("1/5/2022"));
            productRepository.save(product);
        }
        if (!productRepository.existsByName("Đến ngày gặp anh")) {
            Product product = new Product();
            product.setName("Đến ngày gặp anh");
            product.setAuthor("Ryousuke Nanasaki");
            product.setPrice(1900.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/den-ngay-gap-anh.jpg");
            product.setCreate_time(productService.convertToDate("3/17/2023"));
            product.setUpdate_time(productService.convertToDate("3/17/2022"));
            productRepository.save(product);
        }
    }
}
