package com.concurrent.future;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * 异步future实现
 */
public class AsyncFutures {

    private static Logger logger;

    public static <CustomerEventEntity> void main(String[] args) {
        Long entId = 122L;
        List<Long> cids = Arrays.asList(10L, 11L, 12L);
        List<CompletableFuture<CustomerEventEntity>> futures = new ArrayList<>();

        for (long cid : cids) {
            CompletableFuture<CustomerEventEntity> future = CompletableFuture.supplyAsync(
                    () -> getCustomerRecentEvent(cid, entId));
            futures.add(future);
        }
        CompletableFuture<CustomerEventEntity>[] futureArr = futures.stream().toArray(CompletableFuture[]::new);

        List<CustomerEventEntity> res = CompletableFuture.allOf(futureArr).thenApply(v -> {
            List<CustomerEventEntity> customerEvents = futures.stream().map(item -> {
                try {
                    return item.get();
                } catch (Exception e) {
                    logger.info("get customer event failed ");
                    return null;
                }
            }).collect(Collectors.toList());
            return customerEvents;
        }).join();

        List<CustomerEventEntity> collect = res.stream().filter(item -> item != null).collect(Collectors.toList());
        //return collect;
    }

    private static <U> U getCustomerRecentEvent(long cid, Long entId) {

        return null;
    }

}
