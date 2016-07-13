package com.gifisan.nio.component.protocol.future;

import java.io.OutputStream;
import java.nio.charset.Charset;

import com.gifisan.nio.component.BufferedOutputStream;
import com.gifisan.nio.component.IOEventHandle;

public interface ReadFuture extends Future {
	
	public abstract String getServiceName();
	
	public abstract boolean hasOutputStream();

	public abstract boolean flushed();

	public abstract void write(byte b);

	public abstract void write(byte[] bytes);

	public abstract void write(byte[] bytes, int offset, int length);

	public abstract void write(String content);

	public abstract void write(String content, Charset encoding);
	
	public abstract BufferedOutputStream getWriteBuffer();
	
	public abstract IOEventHandle getIOEventHandle() ;

	public abstract void setIOEventHandle(IOEventHandle ioEventHandle) ;

	public abstract OutputStream getOutputStream();
}
