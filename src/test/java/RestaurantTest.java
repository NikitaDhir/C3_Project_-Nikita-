import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {
    Restaurant restaurant;
    //REFACTOR ALL THE REPEATED LINES OF CODE

    LocalTime openingTime = LocalTime.parse("10:00:00");
    LocalTime closingTime = LocalTime.parse("23:00:00");

    //>>>>>>>>>>>>>>>>>>>>>>>>>OPEN/CLOSED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    //-------FOR THE 2 TESTS BELOW, YOU MAY USE THE CONCEPT OF MOCKING, IF YOU RUN INTO ANY TROUBLE
    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time(){
        //WRITE UNIT TEST CASE HERE
        restaurant = Mockito.spy(new Restaurant("Sky High Cafe","Pune",openingTime,closingTime));
        LocalTime currentMockedTime = LocalTime.parse("14:00:00");
        Mockito.when(restaurant.getCurrentTime()).thenReturn(currentMockedTime);
        assertEquals(true, restaurant.isRestaurantOpen());
    }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){
        //WRITE UNIT TEST CASE HERE
        restaurant = Mockito.spy(new Restaurant("Sky High Cafe","Pune",openingTime,closingTime));
        LocalTime currentMockedTime = LocalTime.parse("23:30:00");
        Mockito.when(restaurant.getCurrentTime()).thenReturn(currentMockedTime);
        assertEquals(false, restaurant.isRestaurantOpen());

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<OPEN/CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void adding_number_of_items_to_order_and_display_total_value_as_zero() throws itemNotFoundException {
        restaurant =new Restaurant("cafe1","Delhi",openingTime,closingTime);
        restaurant.addToMenu("Item1",100);
        restaurant.addToMenu("Item2", 200);

        List<String> itemNames = new ArrayList<String>();

        int totalPrice = restaurant.calculateTotalPrice(itemNames);
        assertEquals(0, totalPrice);
    }

    
    //<<<<<<<<<<<<<<<<<<<<<<<MENU>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
}