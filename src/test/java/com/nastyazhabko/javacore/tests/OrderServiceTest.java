package com.nastyazhabko.javacore.tests;

import com.nastyazhabko.javacore.tests.testshomework.Order;
import com.nastyazhabko.javacore.tests.testshomework.OrderRepository;
import com.nastyazhabko.javacore.tests.testshomework.OrderService;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    @Test
    public void shouldReturnSuccessMessageWhenSaveReturnsId() {
        OrderRepository orderRepositoryMock = mock(OrderRepository.class);
        Order order = TestHelper.createDefaultOrder(1, "Milk", 2, 100.0);
        when(orderRepositoryMock.saveOrder(order)).thenReturn(1);

        OrderService orderService = new OrderService(orderRepositoryMock);

        String result = orderService.processOrder(order);

        assertEquals("Order processed successfully", result);

        verify(orderRepositoryMock, times(1)).saveOrder(order);
    }


    @Test
    public void shouldReturnFailureMessageWhenSaveReturnsFalse() {
        OrderRepository orderRepositoryMock = mock(OrderRepository.class);

        when(orderRepositoryMock.saveOrder(null)).thenReturn(0);

        OrderService orderService = new OrderService(orderRepositoryMock);

        String result = orderService.processOrder(null);

        assertEquals("Order processing failed", result);

        verify(orderRepositoryMock, times(1)).saveOrder(null);
    }


    @Test
    public void shouldReturnCorrectTotalIfOrderExists() {
        OrderRepository orderRepositoryMock = mock(OrderRepository.class);
        Order order = TestHelper.createDefaultOrder(1, "Milk", 3, 100.0);

        when(orderRepositoryMock.getOrderById(1)).thenReturn(Optional.of(order));

        OrderService orderService = new OrderService(orderRepositoryMock);

        double result = orderService.calculateTotal(1);

        assertEquals(300.0, result, 0.0);

        verify(orderRepositoryMock, times(1)).getOrderById(1);

    }

    @Test
    public void shouldReturnExceptionIfOrderForCalculatingTotalDoesNotExists() {
        OrderRepository orderRepositoryMock = mock(OrderRepository.class);

        when(orderRepositoryMock.getOrderById(2)).thenReturn(Optional.empty());

        OrderService orderService = new OrderService(orderRepositoryMock);

        Exception exception = assertThrows(Exception.class, () -> orderService.calculateTotal(2));

        assertEquals("Order id not found", exception.getMessage());

        verify(orderRepositoryMock, times(1)).getOrderById(2);

    }

    @Test
    public void shouldCorrectTotalForOrderWithZeroPriceAndQuantity() {
        OrderRepository orderRepositoryMock = mock(OrderRepository.class);
        Order order = TestHelper.createDefaultOrder(3, "Banana", 0, 0.0);

        when(orderRepositoryMock.getOrderById(3)).thenReturn(Optional.of(order));

        OrderService orderService = new OrderService(orderRepositoryMock);

        double result = orderService.calculateTotal(3);

        assertEquals(0.0, result, 0.0);

        verify(orderRepositoryMock, times(1)).getOrderById(3);
    }


}
