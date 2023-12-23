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
        //addProduct();
        //addUser();
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

    private void addProduct() {
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
            productInfo.setNxb("NXB Văn Học");
            productInfo.setNgayxb("8/2/2023");
            productInfo.setNhaphathanh("NXB Văn Học");
            productInfo.setSize("13.5 x 20,5 cm");
            productInfo.setNumberPage("768 trang");
            productInfo.setWeight("656 gram");
            productInfo.setParagraph("“Hai số phận” (Kane & Abel) là câu chuyện về hai người đàn ông đi tìm vinh quang. William Kane là con một triệu phú nổi tiếng trên đất Mỹ, lớn lên trong nhung lụa của thế giới thượng lưu. Wladek Koskiewicz là đứa trẻ không rõ xuất thân, được gia đình người bẫy thú nhặt về nuôi. Một người được ấn định để trở thành chủ ngân hàng khi lớn lên, người kia nhập cư vào Mỹ cùng đoàn người nghèo khổ. Trải qua hơn sáu mươi năm với biết bao biến động, hai con người giàu hoài bão miệt mài xây dựng vận mệnh của mình...");
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

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Hội Nhà Văn");
            productInfo.setNgayxb("10/22/2023");
            productInfo.setNhaphathanh("NXB Hội Nhà Văn");
            productInfo.setSize("14,5 x 20,5 cm");
            productInfo.setNumberPage("404 trang");
            productInfo.setWeight("300 gram");
            productInfo.setParagraph("Tìm mình trong thế giới hậu tuổi thơ dẫn người đọc vào thế giới của người trẻ trên dưới hai mươi tuổi, lứa tuổi không còn trẻ con, nhưng cũng chưa thực sự là người lớn. Trong thế giới đó có những run rẩy của va chạm thân thể lần đầu, có lấp lánh của tình yêu, có những đêm dài, những chuyến đi xa, những hoang mang và băn khoăn hiện sinh. Nhưng bao trùm lên tất cả, như một tấm màn lớn, là nỗi đau. Nỗi đau từ sự cô đơn của đứa con vẫn được xã hội khen là “trưởng thành” và “ngoan,” từ sự trống rỗng nội tâm của đứa trẻ lớn lên trong một gia đình lạnh lẽo, từ sự tuyệt vọng của người trẻ bị giam cầm trong nhà tù mang tên tình yêu cha mẹ...");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
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

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Trẻ");
            productInfo.setNgayxb("9/3/2023");
            productInfo.setNhaphathanh("NXB Trẻ");
            productInfo.setSize("14,5 x 20,5 cm");
            productInfo.setNumberPage("304 trang");
            productInfo.setWeight("400 gram");
            productInfo.setParagraph("Cảm ơn người lớn – một áng văn lãng mạn trong giọng hài hước đặc biệt “dành cho trẻ em, và những ai từng là trẻ em”. Bạn sẽ gặp lại Mùi, Tủn, Tí sún, Hải cò… của Cho tôi xin một vé đi tuổi thơ, cùng chơi những trò chơi quen thuộc, và được đắm mình vào những ước mơ điên rồ, ngốc nghếch nhưng trong veo của tuổi mới lớn hồn nhiên và đầy ắp dự định. Và cả khi họ đã trưởng thành, bạo chúa thời gian đã vùng vẫy thế nào trong cuộc đời của những nhân vật mà bạn yêu quý...");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
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

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Kim Đồng");
            productInfo.setNgayxb("6/4/2018");
            productInfo.setNhaphathanh("NXB Kim Đồng");
            productInfo.setSize("11,5 x 15 cm");
            productInfo.setNumberPage("108 trang");
            productInfo.setWeight("100 gram");
            productInfo.setParagraph("Có bao giờ bạn cảm thấy cô đơn? Như thể không ai hiểu mình? Như thể bạn là kẻ duy nhất còn tồn tại của một giống loài? Vui lên đi, những tâm hồn mong manh dễ vỡ! Đã có bạn bè tôi vẫn ngỏm cả rồi giúp bạn tiêu sầu đây. Lần này, để giải khuây cho bạn, chúng tôi đã dẫn thêm những vấn đề sinh tồn nan giải của rô bốt, cá vàng, vé số, chỉ nha khoa, pin, và nhiều kẻ khác nữa. Hi vọng nỗi buồn của họ khiến cuộc đời bạn đỡ xám xịt...");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
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

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Trẻ");
            productInfo.setNgayxb("8/2/2021");
            productInfo.setNhaphathanh("NXB Trẻ");
            productInfo.setSize("13 x 19 cm");
            productInfo.setNumberPage("300 trang");
            productInfo.setWeight("150 gram");
            productInfo.setParagraph("Mắt biếc là một tác phẩm được nhiều người bình chọn là hay nhất của nhà văn Nguyễn Nhật Ánh. Tác phẩm này cũng đã được dịch giả Kato Sakae dịch sang tiếng Nhật để giới thiệu với độc giả Nhật Bản. “Tôi gửi tình yêu cho mùa hè, nhưng mùa hè không giữ nổi. Mùa hè chỉ biết ra hoa, phượng đỏ sân trường và tiếng ve nỉ non trong lá. Mùa hè ngây ngô, giống như tôi vậy. Nó chẳng làm được những điều tôi ký thác. Nó để Hà Lan đốt tôi, đốt rụi. Trái tim tôi cháy thành tro, rơi vãi trên đường về... Bởi sự trong sáng của một tình cảm, bởi cái kết thúc buồn, rất buồn khi xuyên suốt câu chuyện vẫn là những điều vui, buồn lẫn lộn...");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
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

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Dân Trí");
            productInfo.setNgayxb("2/2/2022");
            productInfo.setNhaphathanh("NXB Dân Trí");
            productInfo.setSize("14,5 x 20,5 cm");
            productInfo.setNumberPage("232 trang");
            productInfo.setWeight("250 gram");
            productInfo.setParagraph("Trong cuộc sống sẽ luôn có những người với những nỗi lo sợ khi tới ngưỡng trưởng thành. Sợ bởi ngoài kia giông tố biết bao, sợ bởi những nỗi cô đơn hằng đêm che lấp chính mình. Bởi vì muốn xua tan nỗi sợ đó mà chọn cách mở toang cánh cửa trái tim để những người khác dễ dàng bước vào. Cố gắng cho mỗi một lần gặp mặt lớn lao ấy để có thể nhiều hơn những người gần bên mình. Nhưng rồi tới một lúc nào đó họ cũng kiệt sức, họ kiệt sức bởi cái “tôi” bị che lấp đi chỉ còn lại sự mù quáng thuận theo ý người khác. Rốt cuộc họ nhận ra họ đã chọn sai cách bởi những mối quan hệ chỉ được xuất hiện bằng cách cắt gọt “tôi” cho tới khi nó chìm nghỉm chẳng còn bóng dáng thì chẳng có ý nghĩa gì đối với cuộc đời mình.");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
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

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Tổng hợp TP.HCM");
            productInfo.setNgayxb("6/4/2022");
            productInfo.setNhaphathanh("PHANBOOK");
            productInfo.setSize("14,5 x 20,5 cm");
            productInfo.setNumberPage("182 trang");
            productInfo.setWeight("200 gram");
            productInfo.setParagraph("“Cố định một đám mây” là tập truyện ngắn với 10 truyện mới, dày hơn 180 trang. Nhà văn đưa độc giả bước vào một không gian mới trong chuyến viễn hành văn chương âm thầm nhưng đầy dấu ấn cá nhân. Ở đó, độc giả sẽ nhận ra Nguyễn Ngọc Tư không còn ở lại trong vùng quan sát thực tế quen thuộc đã làm nên sự ổn định của một phong cách văn chương và đồng thời “đóng đinh” một cái tên trong lòng người đọc, mà đặt mình vào một cuộc ra đi thú vị và không kém thử thách...");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
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

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Thế Giới");
            productInfo.setNgayxb("10/4/2022");
            productInfo.setNhaphathanh("Skybooks");
            productInfo.setSize("13 x 19 cm");
            productInfo.setNumberPage("260 trang");
            productInfo.setWeight("300 gram");
            productInfo.setParagraph("Sau khi lên cấp ba, bằng tinh thần chính nghĩa vốn có của mình, Kawahara Aoi đã ra mặt giúp đỡ một người bạn cùng lớp bị bắt nạt, kết cục cô lại trở thành nạn nhân tiếp theo thay thế cho người bạn đó. Quá tuyệt vọng khi phải trải qua những ngày bị giày vò cả về thể xác lẫn tinh thần ở trường, Aoi đi tới bờ sông, nơi có cây cầu bắc qua hai khu phố và chuẩn bị kết thúc cuộc đời mình ở đó. Tuy nhiên Midori, một chàng trai có phong thái kỳ lạ đã bất ngờ xuất hiện và ngăn cô lại. Kể từ đó, sau mỗi ngày hẹn gặp nhau ở bờ sông, trò chuyện và lắng nghe những lời khuyên của Midori, Aoi dần lấy lại được lòng dũng cảm và sự tự tin để đối mặt với mọi chuyện. Tuy nhiên, đó cũng chính là lúc sự thật về Midori được phơi bày, mở ra đoạn hồi ức đau buồn thời thơ ấu của hai người mà cô đã vô tình lãng quên...");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
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

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Thế Giới");
            productInfo.setNgayxb("5/4/2022");
            productInfo.setNhaphathanh("NXB Thế Giới");
            productInfo.setSize("14,5 x 20,5 cm");
            productInfo.setNumberPage("312 trang");
            productInfo.setWeight("350 gram");
            productInfo.setParagraph("Mỗi ngày bạn đều đưa ra hàng ngàn quyết định, có những quyết định lớn, cũng có những quyết định nhỏ. Một số quyết định định có tác động lớn đến cuộc sống của bạn, chẳng hạn như nên chọn công việc nào. Nhưng cũng có một số quyết định không tạo ra quá nhiều ảnh hưởng, ví dụ như nên ăn gì cho bữa sáng. Bất kể bạn đang phải đối mặt với loại quyết định nào, bạn vẫn cần phải tạo lập một quy trình ra quyết định. Quy trình này không chỉ cải thiện chất lượng quyết định của bạn mà còn giúp bạn phân loại quyết định theo quy mô lớn – nhỏ.");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
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

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Hội Nhà Văn");
            productInfo.setNgayxb("4/29/2022");
            productInfo.setNhaphathanh("NXB Hội Nhà Văn");
            productInfo.setSize("14,5 x 20,5 cm");
            productInfo.setNumberPage("324 trang");
            productInfo.setWeight("200 gram");
            productInfo.setParagraph("Mùa mưa đó, tôi tác ý sẽ nhập định 3 ngày 3 đêm để tri ân Tam Bảo. Một tháng trước khi nhập định, tôi bắt đầu nhịn ăn. Lúc đầu, tôi chỉ uống nước quả cả ngày. Sau đó chỉ uống nước lọc. Từ ngày nhập định thì dừng tất cả. Tôi bắt đầu nhập định như thường lệ bằng quan sát và nhận biết hơi thở. Rồi hơi thở trở nên vi tế, không nhận biết được hơi thở nữa. Chỉ còn cái biết thuần khiết. Tiếp đó thì không biết gì nữa. Giống như tôi đã biến mất trogn 3 ngày. Trong thời gian này, người từ Bangkok và nhiều nơi đến xem. Khi tôi bất động 3 ngày 3 đêm, nhiều người khóc. Họ nghĩ tôi đã chết. Khi tôi xuất định, họ cũng khóc. Nhưng đây là sự thật. Định chỉ là Định. Định không phải Niết Bàn. Định nghĩa là vẫn trong luân hồi. Vẫn khổ. Niết Bàn không phải là không biết cái gì cả. Thấu triệt hoàn toàn nhưng không dính mắc với bất kỳ cái gì...");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
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

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB RIO Book");
            productInfo.setNgayxb("6/5/2022");
            productInfo.setNhaphathanh("NXB RIO Book");
            productInfo.setSize("14,5 x 20,5 cm");
            productInfo.setNumberPage("304 trang");
            productInfo.setWeight("350 gram");
            productInfo.setParagraph("Quảng Cáo Không Nói Láo – Sự Thật Về Quảng Cáo Dưới Góc Nhìn Khoa Học, Toàn Diện Và Thực Tiễn ‘Quảng cáo không nói nói láo – Sự thật về quảng cáo dưới góc nhìn khoa học, toàn diện và thực tiễn’ không chỉ dành cho tất cả những người làm quảng cáo mà còn cho cả những ai tin rằng quảng cáo nói láo ăn tiền. Cuốn sách mở ra một thế giới quảng cáo với góc nhìn chân thực mang tính khoa học chiến lược, từ đó giúp bạn hiểu và biết cách tạo ra những quảng cáo chân chính nhưng vẫn lôi cuốn người xem.");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
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

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Kim Đồng");
            productInfo.setNgayxb("8/7/2022");
            productInfo.setNhaphathanh("NXB Kim Đồng");
            productInfo.setSize("13 x 19 cm");
            productInfo.setNumberPage("208 trang");
            productInfo.setWeight("250 gram");
            productInfo.setParagraph("Giữa những tháng ngày cao điểm của đại dịch Covid-19, cậu bé Trần Cơ Bản – một “thần đồng” văn chương học lớp năm, bị mắc kẹt trong nhà là một căn chung cư chật hẹp tại Hà Nội, bận rộn vừa học online vừa sáng tác vè để phụ mẹ bán hàng. Nhưng rồi, một cơ hội được “tự do” đã tới, khi bố Cơ Bản đưa cậu về quê nội để nghỉ hè. Tại vùng núi giàu bản sắc văn hóa truyền thống, Cơ Bản đã được học và trải nghiệm nhiều điều thú vị, không thể tìm thấy trong...");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
        }
        if (!productRepository.existsByName("Dù cho không có phép màu")) {
            Product product = new Product();
            product.setName("Dù cho không có phép màu");
            product.setAuthor("Kii Kanna");
            product.setPrice(2300.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/du-cho-khong- co-phep-mau.jpg");
            product.setCreate_time(productService.convertToDate("1/7/2022"));
            product.setUpdate_time(productService.convertToDate("1/7/2022"));
            productRepository.save(product);

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Hà Nội");
            productInfo.setNgayxb("1/7/2022");
            productInfo.setNhaphathanh("AMAK BOOKS");
            productInfo.setSize("14,5 x 20,5 cm");
            productInfo.setNumberPage("222 trang");
            productInfo.setWeight("200 gram");
            productInfo.setParagraph("Tuổi trẻ chỉ tới một lần trong đời, nó là một vở kịch thanh xuân khó quên mà đôi khi gióng lên những hồi trống trong trái tim bạn, đôi khi lại giống như vuốt ve một tấm đệm mềm mại. Một Kishi luôn miệng nói muốn bỏ việc đến cả trăm lần, một Chiyo lạnh lùng nơi công sở nhưng lại dịu dàng với người bạn ở chung, một Tamaki cởi mở và được tất cả mọi người mến mộ,hay một Kiki bị cuốn hút bởi một thần tượng chưa nổi tiếng, 6 con người, họ vật lộn qua những tháng ngày có lẽ sẽ trở thành những kỷ niệm đẹp vào một ngày nào đó, để rồi đã vượt qua chúng lúc nào không hay...");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
        }
        if (!productRepository.existsByName("Câu chuyện ngôn ngữ")) {
            Product product = new Product();
            product.setName("Câu chuyện ngôn ngữ");
            product.setAuthor("David Crystal");
            product.setPrice(1900.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/cau-chuyen-ngon-ngu_116412_1.jpg");
            product.setCreate_time(productService.convertToDate("4/7/2022"));
            product.setUpdate_time(productService.convertToDate("4/7/2022"));
            productRepository.save(product);

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Thế Giới");
            productInfo.setNgayxb("4/7/2022");
            productInfo.setNhaphathanh("NXB Thế Giới");
            productInfo.setSize("24,5 x 15,5 cm");
            productInfo.setNumberPage("336 trang");
            productInfo.setWeight("500 gram");
            productInfo.setParagraph("“Crystal tóm gọn một cách mượt mà lượng kiến thức lớn của ông về những điểm dị biệt trong cách đánh vần, ngữ pháp, chính tả, và ảnh hưởng của những phong cách ngôn ngữ mới (ngôn ngữ máy tính, tin nhắn) đối với sự phát triển của ngôn ngữ. Đây là cuốn sách nhập môn hoàn hảo cho bất kỳ ai hứng thú với chủ đề này.” – Publishers Weekly. Là phương cách giao tiếp chính của loài người, ngôn ngữ là một phần vô cùng phong phú và đa dạng trong đời sống của chúng ta. Có khoảng 6.000 ngôn ngữ trên thế giới, tuy rất nhiều trong số đó cũng đang biến mất nhanh chóng...");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
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

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Hội Nhà Văn");
            productInfo.setNgayxb("1/7/2022");
            productInfo.setNhaphathanh("Hội Nhà Văn");
            productInfo.setSize("14 x 20,5 cm");
            productInfo.setNumberPage("206 trang");
            productInfo.setWeight("250 gram");
            productInfo.setParagraph("“Trong lỗ tai chứa bóng tối lùng bùng của những lời bí mật, có vô vàn câu chuyện. Trong vô vàn câu chuyện, có chuyện này. Chuyện này hoang vắng nhưng vẫn còn bóng dáng một con người, người ấy đứng giữa khung cảnh mơ mờ nhuẫn nhuyễn, nổi hằn lên hệt như cái hình bị cắt dán vào đó. Một hình cắt dán chơi vơi, không nguồn gốc, không lí lịch. Câu mở đầu viết rằng: Năm ấy, thành phố lại rùng rùng biến loạn bởi vàng...”");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
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

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Trẻ");
            productInfo.setNgayxb("11/3/2022");
            productInfo.setNhaphathanh("NXB Trẻ");
            productInfo.setSize("14,5 x 20,5 cm");
            productInfo.setNumberPage("188 trang");
            productInfo.setWeight("200 gram");
            productInfo.setParagraph("Saving a Hour a Day là cuốn sách quản lý thời gian của Michael Heppell với cách tiếp cận đơn giản và dễ hiểu. Có thể nói trong cuốn sách này chỉ có thực hành, thực hành và thực hành, vì hầu như các ý tưởng từ đầu đến cuối đều là những ý tưởng đã được chính tác giả tìm hiểu, tổng hợp và thử nghiệm, hoặc đã được các độc giả khác tự mình thử nghiệm. Các chương của mỗi cuốn sách là tập hợp của nhiều ý tưởng và công cụ hữu ích để tiết kiệm thời gian, được tác giả chia thành các chủ đề rất gần gũi với bất kỳ ai trong chúng ta trong cuộc sống hàng ngày...");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
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

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Thanh Niên");
            productInfo.setNgayxb("2/1/2021");
            productInfo.setNhaphathanh("NXB Thanh Niên");
            productInfo.setSize("13 x 20,5 cm");
            productInfo.setNumberPage("296 trang");
            productInfo.setWeight("200 gram");
            productInfo.setParagraph("THANH XUÂN LÀ GÌ EM NHỈ? Tiếp nối nỗi lòng khắc khoải của tập thơ “Có điều gì sao không nói cùng anh” của tác giả Trần Việt Anh. Cuốn sách là sự kết hợp ngọt ngào giữa thơ và tản văn, dành tặng cho những ai đã và đang trải qua thời thanh xuân tươi đẹp, hoặc tìm kiếm câu trả lời “Thanh xuân là gì?...");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
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

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Lao Động");
            productInfo.setNgayxb("3/4/2022");
            productInfo.setNhaphathanh("1980 Books");
            productInfo.setSize("13 x 19 cm");
            productInfo.setNumberPage("328 trang");
            productInfo.setWeight("310 gram");
            productInfo.setParagraph("Việc trở thành một người lắng nghe tốt hơn có ý nghĩa thế nào đối với bạn? Cuộc đời bạn sẽ thay đổi ra sao nếu bạn biết lắng nghe hơn? Trong thế giới hiện đại ngày nay, dường như chúng ta đã quá quen với việc chạy theo những lợi ích cá nhân và dần quên đi sự quan trọng của việc dừng lại và lắng nghe. Khả năng lắng nghe người khác thực sự có thể được coi là kỹ năng quan trọng nhất, giúp thay đổi cuộc đời của bạn và những người xung quanh bạn. Trong giao tiếp đời thường, kỹ năng lắng nghe sẽ giúp bạn xây dựng các mối quan hệ dựa trên nền tảng tiếp nhận thông tin; trong công việc, lắng nghe không chỉ giúp bạn tiếp nhận kiến thức, kinh nghiệm từ những người có chuyên môn, mà còn giúp bạn thấu hiểu đồng nghiệp hơn và từ đó có thể giúp đỡ nhau cùng phát triển, đạt hiệu suất cao...");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
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

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Thế Giới");
            productInfo.setNgayxb("7/7/2022");
            productInfo.setNhaphathanh("AZ Việt Nam");
            productInfo.setSize("14,5 x 20 cm");
            productInfo.setNumberPage("224 trang");
            productInfo.setWeight("250 gram");
            productInfo.setParagraph("Kể cho tôi nghe giống như một hành trình tuổi trẻ tua nhanh, có an ủi, có thách đố, có lặng thinh, có vỡ òa, nhưng đọng lại sau cùng là những chia sẻ rất thật, rất gần từ chính những người trẻ đang học cách lắng nghe chính mình, đang đắp xây cho riêng mình một niềm vui sống, đang tha thiết hòa mình vào dòng chảy rạng ngời của cuộc đời và thong thả bước qua một thời loay hoay của tuổi trẻ...");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
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

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Phụ Nữ Việt Nam");
            productInfo.setNgayxb("3/1/2022");
            productInfo.setNhaphathanh("Skybooks");
            productInfo.setSize("17 x 11 cm x 0.8 cm");
            productInfo.setNumberPage("206 trang");
            productInfo.setWeight("200 gram");
            productInfo.setParagraph("Đối với những người trẻ được sống như ý không phải lúc nào cũng dễ dàng, đặc biệt với những người đã phải trải qua một quãng thời gian khó khăn rồi mới có thể tìm được con người thật của mình, là chính mình. Những câu chuyện tình của họ có nhiều dang dở vì những mặc cảm, rào cản, khao khát được làm điều mình muốn, gắn bó với người mình yêu thương cả đời là các mong ước nhỏ trong lòng. Để rồi khi không thể giãi bày cùng ai, họ mang những điều thầm kín thổi vào những vần thơ nơi chỉ có những “câu chuyện về nàng và tôi”...");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
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

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Phụ Nữ");
            productInfo.setNgayxb("1/7/2019");
            productInfo.setNhaphathanh("PhanBook");
            productInfo.setSize("13 x 20.5 cm");
            productInfo.setNumberPage("272 trang");
            productInfo.setWeight("300 gram");
            productInfo.setParagraph("Cuốn sách là những câu chuyện của riêng Khải Đơn – kể với bạn đọc về niềm vui được sống mỗi ngày, mỗi tuần, mỗi tháng, mỗi năm, mỗi khoảnh khắc tươi mới và sống động trong đời. Khi bạn đọc tác phẩm đầy cảm hứng này, có thể tác giả vẫn đang dấn bước trên một cung đường xa xôi. Ở Khải Đơn, mỗi cuốn sách sẽ vẽ ra một hành trình và hứa hẹn một hành trình tiếp nối. Điều đó truyền cảm hứng cho những người đọc ở thế hệ cô lên đường với hành trang rất gọn nhẹ của riêng mình. Khải Đơn tên thật là Phạm Lan Phương. Là phóng viên tự do tại Sài Gòn. Cô tác nghiệp trong khu vực Đông Nam Á cho một số báo, hãng tin tại Việt Nam và viết văn toàn thời gian...");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
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

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Trẻ");
            productInfo.setNgayxb("1/1/2018");
            productInfo.setNhaphathanh("NXB Trẻ");
            productInfo.setSize("13 x 20 cm");
            productInfo.setNumberPage("364 trang");
            productInfo.setWeight("308 gram");
            productInfo.setParagraph("Tình yêu cuộc sống và đạo lý ở đời trong câu chuyện bếp lửa, chuyện gia đình, chuyện của mọi người mà thấy đó chuyện của mình... Hạnh phúc thay, ai yêu, và trong đêm tối thẳm Đi tìm lòng tin và gặp được yêu thương Vẫn với giọng văn triết nhẹ nhàng của Chuyện trò, Sợi tơ nhện,... cuốn tản văn tiếp theo của GS. Cao Huy Thuần viết về tình yêu và cuộc sống trong đạo lý ở đời, mở rộng giao lộ liên tưởng với nhiều chiều kích mới mẻ và thấu đáo: “đạo đức Phật giáo không đặt trên tiêu chuẩn Thiện Ác, mà đặt trên an vui và đau khổ (...) Lựa chọn ít đau khổ hơn là đạo đức. Nhiều an vui hơn, là đạo đức”...");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
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

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Hội Nhà Văn");
            productInfo.setNgayxb("10/18/1982");
            productInfo.setNhaphathanh("Nhã Nam");
            productInfo.setSize("14 x 25 cm");
            productInfo.setNumberPage("480 trang");
            productInfo.setWeight("600 gram");
            productInfo.setParagraph("Trong bóng đen khủng khiếp của các trại diệt chủng thời Đệ nhị Thế chiến, có một nhà công nghiệp Đức đã trở thành cứu tinh của người Do Thái. Oskar Schindler, con người ham lạc thú, kẻ còn lâu mới được coi là mẫu mực, cũng đồng thời là kẻ đã mạo hiểm cả mạng sống của mình để bảo vệ những đồng loại khác chủng tộc mà nếu không có ông thì hẳn đã kết thúc cuộc đời trong lò thiêu. Danh sách của Schindler đã kể một câu chuyện có thật khác thường như vậy, một câu chuyện tự nó đã có thể làm người đọc choáng váng mà không cần đến một phương tiện văn chương cầu kỳ nào. Nó có thể làm ta khóc, như bộ phim kinh điển dựng từ chính nó của Steven Spielberg đã làm cho hàng triệu người khóc, nhưng trên hết nó làm ta hiểu hơn về những gì đã xảy ra, những sự kiện, những con số, những chân dung chi tiết hơn của cả nạn nhân, thủ phạm và người cứu nạn...");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
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

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Đà Nẵng");
            productInfo.setNgayxb("5/1/2019");
            productInfo.setNhaphathanh("NXB Đà Nẵng");
            productInfo.setSize("14,5 x 20,5 cm");
            productInfo.setNumberPage("455 trang");
            productInfo.setWeight("440 gram");
            productInfo.setParagraph("Năm 2008 tác phẩm này đã được tặng giải thưởng của Viện Hàn lâm Pháp. Tác giả David Haziot, một nhà văn được đào tạo chuyên ngành triết học, đã xuất bản khoảng một tá đầu sách gồm nhiều thể loại: Tiểu thuyết, tiểu sử, truyện tranh… Năm 2012, ông đã đoạt giải thưởng danh giá Goncourt về thể loại tiểu sử và Van Gogh là thể loại tiểu sử. David Haziot cũng cho ta thấy “tác phẩm của Van Gogh không phải bao giờ cũng buồn và bi thảm (mà) đôi khi nó toát ra một hạnh phúc được hiện hữu không gì sánh tày”. Ánh sáng ấy rọi tỏ một tính nhân bản mênh mông trong trái tim Van Gogh. “Càng nghĩ – viết cho người em trai Théo – anh càng cảm thấy không gì thật sự nghệ thuật hơn yêu người”. Không tham vọng xóa đi những khoảng bóng tối trong cuộc đời đầy biến cố của Van Gogh, người đọc theo chân nhà văn David Haziot bước vào thế giới của thiên tài ngoài mọi chuẩn mực này trong cái mà André Breton gọi là “cái cốt lõi tối tăm không thể đập vỡ” của ông...");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
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

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Hội Nhà Văn");
            productInfo.setNgayxb("3/1/2022");
            productInfo.setNhaphathanh("Tao Đoàn");
            productInfo.setSize("13 x 20,5 cm");
            productInfo.setNumberPage("320 trang");
            productInfo.setWeight("300 gram");
            productInfo.setParagraph("Lối tự sự táo bạo, chủ nghĩa hiện thực hiện đại cùng thủ pháp kinh điển, chỉ thông qua một cây ngô, một ông già, một con chó mù và một thôn trang hoang vu, nhà văn Diêm Liên Khoa đã vẽ nên một bức tranh tuyệt mỹ về sự tồn sinh của con người, đưa câu chuyện thành một bản tụng ca sự sống cùng ý chí ngoan cường của nhân loại...");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
        }
        if (!productRepository.existsByName("Nghiệt tử")) {
            Product product = new Product();
            product.setName("Nghiệt tử");
            product.setAuthor("Bạch Tiên Dũng");
            product.setPrice(1900.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/nghiet-tu.jpg");
            product.setCreate_time(productService.convertToDate("1/1/2022"));
            product.setUpdate_time(productService.convertToDate("1/1/2022"));
            productRepository.save(product);

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Phụ Nữ");
            productInfo.setNgayxb("1/1/2022");
            productInfo.setNhaphathanh("Huy Hoang Bookstore");
            productInfo.setSize("13.5 x 20.5 x 2.6 cm");
            productInfo.setNumberPage("536 trang");
            productInfo.setWeight("550 gram");
            productInfo.setParagraph("Tác phẩm kể về một cộng đồng người đồng tính nam, tụ tập và hoạt động một cách âm thầm trong công viên Mới Đài Bắc, với bối cảnh là Đài Loan vào thập kỷ 80. Nhân vật chính là những người vừa chớm bước vào tuổi thanh niên, bị đuổi khỏi gia đình, sống lang thang hè phố, mỗi người mang theo một câu chuyện buồn thảm về thân thế và cuộc đời. Viết cho những đứa trẻ, trong những đêm đen thẳm sâu, thẳm sâu nhất, một mình bơ vơ ngoài phố, không một chốn về... Mỗi một tình tiết… đều hoàn mỹ đến mức như thể đã đem vô số đau thương nghiền vỡ thành những vụn vàng. Nghiệt tử giống như một vở ca kịch Baroque, mỹ hoá bóng đêm, treo một vầng trăng đỏ bầm lơ lửng trên bầu không đen kịt như than ướt. Bộ mặt bị che giấu của màn đêm thành phố, dưới ngòi bút của Bạch Tiên Dũng, đã được tái hiện một cách hoàn mỹ lạ lùng, khiến người ta như quên bẵng mất trên thế gian này vẫn còn có bình minh...");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
        }
        if (!productRepository.existsByName("Hai vạn dặm dưới đáy biển")) {
            Product product = new Product();
            product.setName("Hai vạn dặm dưới đáy biển");
            product.setAuthor("Jules Verne");
            product.setPrice(2300.0);
            product.setQuantity(10);
            product.setNote("");
            product.setImageUrl("/img/sanpham/hai-van-dam-duoi-day-bien-huy-hoang__96562.jpg");
            product.setCreate_time(productService.convertToDate("1/2/2022"));
            product.setUpdate_time(productService.convertToDate("1/2/2022"));
            productRepository.save(product);

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Văn Học");
            productInfo.setNgayxb("1/2/2022");
            productInfo.setNhaphathanh("Văn Hóa Minh Lâm");
            productInfo.setSize("20.5 x 13.5 x 1.7 cm");
            productInfo.setNumberPage("411 trang");
            productInfo.setWeight("352 gram");
            productInfo.setParagraph("Hai vạn dặm dưới đáy biển là một tiểu thuyết khoa học viễn tưởng kinh điển của nhà văn người Pháp – Jules Verne xuất bản vào năm 1870. Câu chuyện kể về Thuyền trưởng Nê-mô – một người thù ghét đất liền và con tàu ngầm Nau-ti-lux có một không hai của ông ta, từ quan điểm của giáo sư A-rô-nắc. Trong một chuyến đi khảo sát sinh vật biển bí ẩn trên chiếc tàu Lin-côn, giáo sư A-rô-nắc - một giáo sư giàu kiến thức ham mê tìm tòi; trợ lý Công-xây - anh phụ tá điềm tĩnh đến lạ thường, chung thành tuyệt đối, ham thích phân loại giống vật; và chàng thợ đánh bắt cá voi cừ khôi, nóng tính nhưng cũng trượng nghĩa - Nét Len, tất cả bị rơi khỏi tàu và vô tình bị bắt vào tàu ngầm Nau-ti-lux của thuyền trưởng Nê-mô. Từ đây họ bắt đầu một hành trình khám phá thế giới đại dương huyền ảo với thuyền trưởng Nê-Mô và các thủy thủ trên tàu Nau-ti-lux...");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
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

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Hồng Đức");
            productInfo.setNgayxb("02/08/2019");
            productInfo.setNhaphathanh("Bách Việt");
            productInfo.setSize("14,5 x 20,5 cm");
            productInfo.setNumberPage("380 trang");
            productInfo.setWeight("250 gram");
            productInfo.setParagraph("Kẻ Đoạt Hồn cuốn sách nói về: Một ông giáo sư mời các sinh viên của ông tham gia một thí nghiệm khác thường. Những người tham gia thí nghiệm cần phải đọc một tập hồ sơ bệnh án mà người ta tìm thấy trong số đồ vật còn để lại của một bác sĩ tâm lý. Tập hồ sơ bệnh án này được viết giống như một quyển tiểu thuyết, thuật lại sự việc đã xảy ra tại một bệnh viện tâm thần trước đây, cũng là nơi mà các sinh viên phải ngồi đọc.Câu chuyện thuật về ba người phụ nữ – trẻ trung, xinh đẹp, hoạt bát – mất tích không để lại một dấu vết...");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
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

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Thanh Niên");
            productInfo.setNgayxb("1/5/2022");
            productInfo.setNhaphathanh("Alpha Books");
            productInfo.setSize("20.5 x 13 x 0.5 cm");
            productInfo.setNumberPage("176 trang");
            productInfo.setWeight("150 gram");
            productInfo.setParagraph("‘’Mũi Hếch’’ – có một tình yêu mang tên là đậm sâu. Cuốn truyện dài Mũi Hếch của tác giả Trần Quỳnh Diệp như những đốm lửa nhỏ, đủ sức sưởi ấm trái tim cô độc của bất kỳ ai. Câu chuyện không kể về nhân vật chính với cuộc đời đầy bão tố, nhưng cô nàng Mũi Hếch (biệt danh đáng yêu của nhân vật Lê Hà Anh trong truyện) đã sống một đời thật trọn vẹn. Trọn vẹn với lựa chọn của mình, trọn vẹn với những điều mình yêu thương và tin tưởng. Câu chuyện bắt đầu khi Hà Anh vừa tốt nghiệp đại học và đi phỏng vấn xin việc tại một công ty du lịch ở Sài Gòn. Trong lúc đứng chờ xe buýt, trời bỗng đổ mưa to. Chiếc sơ mi trắng ướt nước mưa làm lộ thịt da khiến cô bối rối trước những ánh mắt săm soi. Bất ngờ một chiếc áo khoác được khoác lên người cô. Chàng trai không nhìn cô, nhưng khi xuống xe, anh cất tiếng chào: ‘’Chào Mũi Hếch nhé!’’. Hóa ra, giữa thành phố Sài Gòn rộng lớn này, đến một ngày Mũi Hếch cũng gặp được người con trai cô đã thương thầm bấy lâu...");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
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

            ProductInfo productInfo = new ProductInfo();
            productInfo.setNxb("NXB Dân Trí");
            productInfo.setNgayxb("3/17/2023");
            productInfo.setNhaphathanh("ZGROUP");
            productInfo.setSize("18 x 13 x 1 cm");
            productInfo.setNumberPage("212 trang");
            productInfo.setWeight("220 gram");
            productInfo.setParagraph("Đến ngày gặp anh là câu chuyện tình với đủ các cung bậc hỉ nộ ái ố của một chàng trai trong hành trình chông gai đi tìm định mệnh của đời mình, từ mối tình đầu khi còn là sinh viên, trang web hẹn hò đầu tiên đến quãng ngày chung sống dưới một mái nhà với người mà cậu yêu...");
            productInfo.setProduct(product);
            productInfoRepository.save(productInfo);
        }
    }
}
