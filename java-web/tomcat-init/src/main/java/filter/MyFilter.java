package filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("before filter code");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("after filter code");
    }

    @Override
    public void destroy() {
    System.out.println("filter destroyed");
    }
}
