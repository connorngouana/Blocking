package ie.atu.week5blockingappication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class FeignController
{
    private final FeignService feignService;
    private final FeignEXService feignEXService;

    public FeignController(FeignService feignService, FeignEXService feignEXService)
    {
        this.feignService = feignService;
        this.feignEXService = feignEXService;
    }

    @GetMapping("/feign")
    public String getFeignData() throws Exception, InterruptedException
    {
        long startTime = System.currentTimeMillis();

        List<CompletableFuture<TodoResponse>> futures = new ArrayList<>();


        for (int i = 0; i < 10; i++)
        {
            CompletableFuture<TodoResponse> future = CompletableFuture.supplyAsync(() -> feignService.fetchData());
            futures.add(future);
        }
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOf.get();
        long endTime = System.currentTimeMillis();
        return "Total time: " + (endTime - startTime) + "ms";
    }
    @GetMapping("/Id")
    public String getBlockingData()
    {
        long startTime = System.currentTimeMillis();
        for(int i = 0; i<10; i++)
        {
            feignEXService.getMoreData();
        }
        long endTime = System.currentTimeMillis();
        return "Total time: " + (endTime - startTime) + "ms";
    }

}
