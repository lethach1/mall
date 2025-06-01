package com.ecom.mall.common.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Redis操作Service
 * Created by macro on 2020/3/3.
 */
public interface RedisService {

    /**
     * Lưu giá trị kèm thời gian hết hạn
     */
    void set(String key, Object value, long time);

    /**
     * Lưu giá trị không có thời gian hết hạn
     */
    void set(String key, Object value);

    /**
     * Lấy giá trị theo key
     */
    Object get(String key);


    /* Xoá key */
    Boolean del(String key);

    /**
     *  Xoá hàng loạt key
     */
    Long del(List<String> keys);

    /**
     * Thiết lập thời gian hết hạn
     */
    Boolean expire(String key, long time);

    /**
     * Lấy thời gian còn lại đến khi key hết hạn
     */
    Long getExpire(String key);

    /**
     * Kiểm tra key có tồn tại không
     */
    Boolean hasKey(String key);

    /**
     * Tăng giá trị số nguyên lên delta
     */
    Long incr(String key, long delta);

    /**
     * Giảm giá trị số nguyên xuống delta
     */
    Long decr(String key, long delta);

    /**
     * Lấy giá trị của một trường trong Hash
     */
    Object hGet(String key, String hashKey);

    /**
     * Ghi giá trị vào Hash + set TTL
     */
    Boolean hSet(String key, String hashKey, Object value, long time);

    /**
     * Ghi giá trị vào Hash không TTL
     */
    void hSet(String key, String hashKey, Object value);

    /**
     * Lấy toàn bộ trường và giá trị trong Hash
     */
    Map<Object, Object> hGetAll(String key);

    /**
     * Set toàn bộ Hash kèm TTL
     */
    Boolean hSetAll(String key, Map<String, Object> map, long time);

    /**
     * Set toàn bộ Hash không TTL
     */
    void hSetAll(String key, Map<String, ?> map);

    /**
     * Xoá một hoặc nhiều trường trong Hash
     */
    void hDel(String key, Object... hashKey);

    /**
     * Kiểm tra tồn tại của trường trong Hash
     */
    Boolean hHasKey(String key, String hashKey);

    /**
     * Tăng giá trị số nguyên trong Hash
     */
    Long hIncr(String key, String hashKey, Long delta);

    /**
     * Giảm giá trị số nguyên trong Hash
     */
    Long hDecr(String key, String hashKey, Long delta);

    /**
     * Lấy toàn bộ phần tử trong Set
     */
    Set<Object> sMembers(String key);

    /**
     * Thêm phần tử vào Set
     */
    Long sAdd(String key, Object... values);

    /**
     * Thêm phần tử + TTL
     */
    Long sAdd(String key, long time, Object... values);

    /**
     * Kiểm tra phần tử có trong Set không
     */
    Boolean sIsMember(String key, Object value);

    /**
     * Lấy số lượng phần tử trong Set
     */
    Long sSize(String key);

    /**
     * Xoá một hoặc nhiều phần tử khỏi Set
     */
    Long sRemove(String key, Object... values);

    /**
     * Lấy danh sách con từ List (theo index)
     */
    List<Object> lRange(String key, long start, long end);

    /**
     * Lấy độ dài của List
     */
    Long lSize(String key);

    /**
     *  Lấy giá trị tại một index cụ thể
     */
    Object lIndex(String key, long index);

    /**
     *  Đẩy phần tử vào đầu List
     */
    Long lPush(String key, Object value);

    /**
     * Đẩy phần tử + TTL
     */
    Long lPush(String key, Object value, long time);

    /**
     * Đẩy nhiều phần tử vào đầu List
     */
    Long lPushAll(String key, Object... values);

    /**
     *  Đẩy nhiều phần tử + TTL
     */
    Long lPushAll(String key, Long time, Object... values);

    /**
     * Xoá phần tử theo giá trị (count: số lần xoá)
     */
    Long lRemove(String key, long count, Object value);
}
