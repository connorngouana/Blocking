package ie.atu.week5blockingappication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Excersize-Feign", url = "https://jsonplaceholder.typicode.com")
public interface FeignEXServiceClient
{
    @GetMapping("/todos/196")
    TodoResponse getMoreData();
}
