package test.front;

import java.io.IOException;

import test.ClientUtil;

import com.gifisan.nio.component.IOEventHandleAdaptor;
import com.gifisan.nio.component.Session;
import com.gifisan.nio.component.future.ReadFuture;
import com.gifisan.nio.connector.TCPConnector;
import com.gifisan.nio.extend.configuration.ServerConfiguration;
import com.gifisan.nio.front.FrontContext;

public class TestLoad {

	public static void main(String[] args) throws IOException {

		IOEventHandleAdaptor eventHandleAdaptor = new IOEventHandleAdaptor() {

			public void acceptAlong(Session session, ReadFuture future) throws Exception {

				if (FrontContext.FRONT_CHANNEL_LOST.equals(future.getServiceName())) {
					System.out.println("客户端已下线：" + future.getText());
				} else {
					System.out.println("~~~~~~收到报文：" + future.toString());
					String res = "(***" + future.getText() + "***)";
					System.out.println("~~~~~~处理报文：" + res);
					future.write(res);
					session.flush(future);
				}
			}
		};

		ServerConfiguration configuration = new ServerConfiguration();

		configuration.setSERVER_TCP_PORT(8800);

		TCPConnector connector = ClientUtil.getTCPConnector(eventHandleAdaptor, configuration);

		connector.connect();
	}

}
