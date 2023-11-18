package org.aaim.unittest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.AdditionalAnswers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {
  @Mock
  private OrderRepository orderRepository;
  @Mock
  private PaymentRepository paymentRepository;
  @InjectMocks
  private OrderService orderService;

  @Test
  void pay() throws IOException {
//    Order order = new ObjectMapper().readValue(new ClassPathResource("Order_1L.json").getFile(), Order.class);
    Order order = new Order(1L, false);

    when(orderRepository.findById(1L))
      .thenReturn(Optional.ofNullable(order));

    when(paymentRepository.save(any()))
      .then(returnsFirstArg());

    Payment payment = orderService.pay(1L, "1234567890123456");
    assertThat(payment.getOrder().isPaid()).isTrue();
    assertThat(payment.getCreditCardNumber()).isEqualTo("1234567890123456");
  }
}