package com.example.Library.service.Impl;

import com.example.Library.dto.CartItem;
import com.example.Library.model.Customer;
import com.example.Library.model.Order;
import com.example.Library.service.DateTimeService;
import com.example.Library.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
public class MailServiceImpl implements MailService {
    @Value("${spring.mail.username}")
    private String fromEmail;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private DateTimeService dateTimeService;

    @Override
    public String sendMail(Customer customer, Order order, List<CartItem> cartItem) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(fromEmail);
            mimeMessageHelper.setTo(customer.getEmail());
            mimeMessageHelper.setSubject("Xác nhận đơn hàng từ Nhasach247");

            String products = "";
            int total = 0;

            for(CartItem cart : cartItem){
                long id = cart.getProductId();
                String product_name = cart.getProductName();
                int product_quantity = cart.getSold();
                double product_price = cart.getPrice();
                total += (int) (cart.getSold() * cart.getPrice());
                products += "ID: "+ id + " - " + product_name + "- Giá: " + product_price + "đ, Số lượng: " + product_quantity +"\n";

            }

            String body = "Chào bạn " + customer.getFullName() +",\n"
                    + "Chúng tôi xin chân thành cảm ơn bạn đã mua sắm tại Nhasach247. Đơn hàng của bạn đã đang chờ duyệt.\n"
                    + "Dưới đây là thông tin chi tiết của đơn hàng: \n"
                    + "Mã Đơn Hàng: " + order.getId()+ " \n"
                    + "Ngày đặt hàng: " + dateTimeService.DateFormatTime(order.getCreate_time().toString()) +"\n\n"
                    + "Sản phẩm đã đặt: \n"
                    + products +"\n"
                    +"Tổng cộng: " + total + "\n"
                    +"Địa chỉ giao hàng: " + customer.getAddress() + "\n\n"
                    +"Chúng tôi sẽ thông báo cho bạn khi đơn hàng của bạn đã được gửi đi. Nếu có bất kỳ câu hỏi hoặc yêu cầu nào, vui lòng liên hệ chúng tôi tại contactnhasach247@gmail.com hoặc số điện thoại 0818385099.\n\n"
                    +"Chúng tôi rất hân hạnh được phục vụ bạn và mong bạn có trải nghiệm mua sắm thú vị tại Nhasach247.\n"
                    +"Trân trọng,\n"
                    +"Nhasach247";


            mimeMessageHelper.setText(body);

            javaMailSender.send(mimeMessage);

            return "mail send";

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
