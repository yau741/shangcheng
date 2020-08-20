import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

import java.util.Date;

public class JwtTest {

    /***

     * 解析Jwt令牌数据

     */

    @Test
    public void testParseJwt(){

        String compactJwt="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLlsI_nmb0iLCJpYXQiOjE1NjIwNjI5MjUsImV4cCI6MTU2MjA2MjkyNX0._vs4METaPkCza52LuN0-2NGGWIIO7v51xt40DHY1U1Q";

        Claims claims = Jwts.parser().

                setSigningKey("itcast").

                parseClaimsJws(compactJwt).

                getBody();

        System.out.println(claims);

    }


    /****

     * 创建Jwt令牌

     */

    @Test

    public void testCreateJwt(){

        JwtBuilder builder= Jwts.builder()

                .setId("888")             //设置唯一编号

                .setSubject("小白")       //设置主题  可以是JSON数据

                .setIssuedAt(new Date())  //设置签发日期

                .signWith(SignatureAlgorithm.HS256,"itcast");//设置签名 使用HS256算法，并设置SecretKey(字符串)

        //构建 并返回一个字符串

        System.out.println( builder.compact() );

    }

}