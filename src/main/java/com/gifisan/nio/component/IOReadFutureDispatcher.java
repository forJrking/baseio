package com.gifisan.nio.component;

import com.gifisan.nio.common.Logger;
import com.gifisan.nio.common.LoggerFactory;
import com.gifisan.nio.component.protocol.IOReadFuture;

public class IOReadFutureDispatcher implements IOReadFutureAcceptor {

	private final Logger	logger	= LoggerFactory.getLogger(IOReadFutureDispatcher.class);

	public void accept(Session session, IOReadFuture future) throws Exception {

		if (future.isBeatPacket()) {

			if (!session.getContext().isAcceptBeat()) {
				
				logger.debug("收到心跳回报!");
				
				return;
			}
			
			logger.debug("收到心跳请求!");

			session.flush(future);

			return;
		}

		NIOContext context = session.getContext();

		IOEventHandle eventHandle = context.getIOEventHandleAdaptor();

		eventHandle.accept(session, future);
	}
}
