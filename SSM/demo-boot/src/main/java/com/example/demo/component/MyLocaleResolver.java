package com.example.demo.component;

import com.sun.corba.se.spi.orbutil.closure.Closure;
import com.sun.corba.se.spi.resolver.LocalResolver;
import org.omg.CORBA.Object;
import org.springframework.cglib.core.Local;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Set;

/**
 * 区域解析信息--实现 国际化的语言转换
 */
public class MyLocaleResolver  implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        final String l = httpServletRequest.getParameter("l");//获取请求参数l的值l=en_US
        Locale aDefault = Locale.getDefault();//如果 local为空 使用系统默认的值
        if(!StringUtils.isEmpty(l)){
            final String[] s = l.split("_");//等到数组{en,US}
            aDefault=new Locale(s[0],s[1]);//
        }

        return  aDefault;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
