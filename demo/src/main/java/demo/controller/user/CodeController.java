package demo.controller.user;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import demo.VO.CaptchaImageVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class CodeController {

    //kapcha验证码生成
    @Resource
    DefaultKaptcha captchaProducer;

    @RequestMapping("/kaptcha")
    public void getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        // 禁止服务器缓存
        response.setDateHeader("Expires",0);
        // 设置标准的 HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // 设置IE扩展 HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // 设置标准 HTTP/1.0 不缓存图片
        response.setHeader("Pragma", "no-cache");
        // 返回一个 jpeg图片, 默认是text/html
        response.setContentType("image/jpeg");

        // 生成验证码
        String capText = captchaProducer.createText(); // 为图片创建文本
        //创建验证码对象----验证码，过期时间
        CaptchaImageVO captchaImageVO = new CaptchaImageVO(capText,2 * 60);
        //将验证码存到session
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, captchaImageVO);
        //将图片返回给前端
        try(ServletOutputStream out = response.getOutputStream();) {
            BufferedImage bi = captchaProducer.createImage(capText);
            ImageIO.write(bi, "jpg", out);
            out.flush();
        }//使用try-with-resources不用手动关闭流

    }
}