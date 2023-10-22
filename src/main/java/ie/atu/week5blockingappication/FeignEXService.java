package ie.atu.week5blockingappication;

import org.springframework.stereotype.Service;
@Service
public class FeignEXService
{
        private final FeignEXServiceClient feignEXServiceClient;

        public FeignEXService(FeignEXServiceClient feignEXServiceClient)
        {
            this.feignEXServiceClient = feignEXServiceClient;
        }

        public TodoResponse getMoreData()
        {
            TodoResponse td = feignEXServiceClient.getMoreData();
            System.out.println(td);
            try
            {
                Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return td;
        }
    }


