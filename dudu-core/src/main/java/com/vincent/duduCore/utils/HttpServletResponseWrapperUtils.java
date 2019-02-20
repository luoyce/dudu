package com.vincent.duduCore.utils;


import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class HttpServletResponseWrapperUtils extends HttpServletResponseWrapper {
    private PrintWriter printWriter;
    //
    private CharArrayWriter cacheWriter;
    private ByteArrayOutputStream cacheStream;

    public HttpServletResponseWrapperUtils(HttpServletResponse res) {
        super(res);
        cacheWriter = new CharArrayWriter();
        cacheStream = new ByteArrayOutputStream();
        printWriter = new PrintWriter(cacheWriter);
    }

    //读取正常返回
    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return new ServletOutputStream(){
            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setWriteListener(WriteListener writeListener) {
            }

            @Override
            public void write(int b) throws IOException {
                cacheStream.write(b);
            }

            @Override
            public void write(byte[] b) throws IOException {
                cacheStream.write(b);
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                cacheStream.write(b, off, len);
            }
        };
    }

    //读取拦截器返回值
    @Override
    public PrintWriter getWriter() throws IOException {
        return printWriter;
    }

    public String getResponseBody()throws IOException  {
        return cacheWriter.toString() + cacheStream.toString(StandardCharsets.UTF_8.name());
    }
}
