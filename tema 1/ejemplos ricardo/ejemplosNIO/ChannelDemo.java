import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelDemo {
	public static void main(String args[]) throws IOException {
		RandomAccessFile file = new RandomAccessFile("temp.txt", "r");
		FileChannel fileChannel = file.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(512);
		while (fileChannel.read(byteBuffer) > 0) {
			// flip the buffer to prepare for get operation
			byteBuffer.flip();
			while (byteBuffer.hasRemaining())
				System.out.print((char) byteBuffer.get());
            //byteBuffer.rewind(); // o byteBuffer.clear();
		}
		file.close();
	}
}
