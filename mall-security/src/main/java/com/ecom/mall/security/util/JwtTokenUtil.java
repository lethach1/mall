package com.ecom.mall.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /**
     * Tạo JWT token dựa trên thông tin đã cho
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * Lấy payload (nội dung) từ token JWT
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            LOGGER.info("Định dạng JWT không hợp lệ:{}", token);
        }
        return claims;
    }

    /**
     * Tạo thời gian hết hạn cho token.
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     * Lấy tên đăng nhập từ token.
     */
    public String getUserNameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /* Kiểm tra xem token có còn hợp lệ không.
    @param token        Token do client gửi lên.
    @param userDetails  Thông tin người dùng lấy từ cơ sở dữ liệu. */
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * Kiểm tra xem token đã hết hạn hay chưa.
     */
    private boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    /**
     * Lấy thời gian hết hạn từ token.
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    /**
     * Tạo token dựa trên thông tin người dùng.
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * Token cũ nếu chưa hết hạn thì có thể được làm mới.
     *
     * @param oldToken  Token bao gồm phần đầu (tokenHead).
     */
    public String refreshHeadToken(String oldToken) {
        if(oldToken == null || oldToken.isEmpty()){
            return null;
        }
        oldToken.isEmpty();
        String token = oldToken.substring(tokenHead.length());
        if(oldToken == null || oldToken.isEmpty()){
            return null;
        }
        //Xác minh token không thành công
        Claims claims = getClaimsFromToken(token);
        if(claims==null){
            return null;
        }
        //Nếu token đã hết hạn, không hỗ trợ làm mới.
        if(isTokenExpired(token)){
            return null;
        }
        //Nếu token vừa được làm mới trong vòng 30 phút, trả về token gốc.
        if(tokenRefreshJustBefore(token,30*60)){
            return token;
        }else{
            claims.put(CLAIM_KEY_CREATED, new Date());
            return generateToken(claims);
        }
    }

    /**
     * Kiểm tra xem token có vừa mới được refresh trong khoảng thời gian cho phép (tính bằng giây) hay không.
     *
     * @param token     JWT token cần kiểm tra
     * @param time      Khoảng thời gian cho phép (tính bằng giây) kể từ lúc token được tạo
     * @return          true nếu thời điểm hiện tại nằm trong khoảng [created, created + time], ngược lại false
     */
    private boolean tokenRefreshJustBefore(String token, int time) {
        // Trích xuất các claims từ token
        Claims claims = getClaimsFromToken(token);
        Date created = claims.get(CLAIM_KEY_CREATED, Date.class);
        Date now = new Date();
        // thời điểm tạo(milisecond) + time giây * 1000 (milisecond) => convert to Date
        Date expired = new Date(created.getTime() + time * 1000L);
        // Kiểm tra sau time tạo và trc time hết hạn
        return now.after(created) && now.before(expired);
    }
}

